package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	
	//final -> cria constante
	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();
	//criando objeto da classe e obter acesso a todos os metodos da contacontroller
	public static void main(String[] args) {
		
		
		int opcao;
		
		
		criarContasTeste();//chama o metodo
				
		while(true) {
			System.out.println(Cores.TEXT_GREEN + "*****************************************");
			System.out.println("	BANCO DO BRASIL COM Z	 ");
			System.out.println(Cores.TEXT_GREEN + "*****************************************");
			System.out.println("                             ");
			System.out.println(Cores.TEXT_CYAN + "	1 - Criar conta 		   		");
			System.out.println(Cores.TEXT_CYAN + "	2 - Listar todas as contas	 ");
			System.out.println(Cores.TEXT_CYAN + "	3 - Buscar Conta por Numero 		 ");
			System.out.println(Cores.TEXT_CYAN + "	4 - Atualizar Dados da Conta 		 ");
			System.out.println(Cores.TEXT_CYAN + "	5 - Apagar conta 		 ");
			System.out.println(Cores.TEXT_CYAN + "	6 - Sacar 		 ");
			System.out.println(Cores.TEXT_CYAN + "	7 - Depositar 		 ");
			System.out.println(Cores.TEXT_CYAN + "	8 - Transferir valores entre Contas		 ");
			System.out.println(Cores.TEXT_CYAN + "	9 - Procurar pelo titular da Conta		 ");
			System.out.println(Cores.TEXT_CYAN + "	0 - Sair	 ");
			System.out.println(Cores.TEXT_CYAN + "										");
			System.out.println(Cores.TEXT_GREEN + "*****************************************");
			System.out.println(Cores.TEXT_WHITE_BOLD + "Entre com a opção desejada: ");
			System.out.println("										");
			
			try {
				opcao = leia.nextInt();
				leia.nextLine();
			}catch(InputMismatchException e) {
				opcao = -1;
				System.out.println("digite um numero entre 0 e 8");
				leia.nextLine();
			}
			
			
			
			if(opcao == 0) {
				System.out.println("\nBanco do Brasil com Z = O seu começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}
			switch(opcao) {
				case 1:
					System.out.println("Criar conta\n\n");
					cadastrarConta();
					keyPress();
					break;
				case 2:
					System.out.println("Listar todas as Contas \n\n");
					listarContas();
					keyPress();
					break;
				case 3:
					System.out.println("Consultar dados da Conta - por numero\n\n");
					procurarContaPorNumero();
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar os dados da conta\n\n");
					atualizarConta();
					keyPress();
					break;
				case 5:
					System.out.println("Apagar a conta\n\n");
					deletarConta();
					keyPress();
					break;
				case 6:
					System.out.println("Saque\n\n");
					sacar();
					keyPress();
					break;
				case 7:
					System.out.println("Deposito\n\n");
					depositar();
					keyPress();
					break;
				case 8:
					System.out.println("Transferencia de contas\n\n");
					transferir();
					keyPress();
					break;
				case 9:
					System.out.println("Procurar pelo titular da conta\n\n");
					procurarPorTitular();
					keyPress();
					break;
				default:
					System.out.println("\nOpção invalida\n");
					keyPress();
					break;	
				
			}
			
		}

	}
	public static void sobre() {
		System.out.println("*****************************************");
		System.out.println("Projeto Desenvolvido por:");
		System.out.println("Marcia Condarco");
		System.out.println("https://github.com/MarciaCondarco");
		System.out.println("*****************************************");
	}
	
	public static void keyPress() {
		System.out.println(Cores.TEXT_GREEN + "\nPressione enter para continuar ...");
		leia.nextLine();
	}
	
	private static void criarContasTeste() {
		//contaController.gerarNumero -> é para gerar O id do cliente.
		contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 456, 1, "Marcia Condarco", 1000000.00f, 10));
	}
	
	private static void listarContas() {
		//executa os metodos de lista da controladora
		contaController.listarTodas();
	}
	
	private static void cadastrarConta() {
		
		System.out.print("Digite o numero da agência: ");
		int agencia = leia.nextInt();
		
		System.out.print("Digite o nome do titular: ");
		leia.skip("\\R");
		String titular = leia.nextLine();
		
		System.out.print("Digite o tipo da conta(1 - CC | 2 - CP): ");
		int tipo = leia.nextInt();
		
		System.out.print("Digite o saldo inicial: ");
		float saldo = leia.nextFloat();
		
		switch(tipo) {
		case 1 -> {
			
			System.out.print("Digite o limite inicial: ");
			float limite = leia.nextFloat();
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo,limite));
			//chamando o metodo cadastrar, cria o objeto contacorrente que os parametros
		}
		case 2 -> {
			System.out.print("Digite o dia do aniversario da conta: ");
			int aniversario = leia.nextInt();
			leia.nextLine();
			contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo,aniversario));
			
			
		}
		default -> System.out.println("Tipo de conta inválida!");
		}
	}
	
	private static void procurarContaPorNumero() {
		System.out.print("Digite o numero da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		contaController.procurarPorNumero(numero);
	}
	
	private static void deletarConta() {
		System.out.print("Digite o numero da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		//criando o objeto da classe conta
		Conta conta = contaController.buscarNaCollection(numero);
		if(conta != null)
		{
			System.out.print("\nTem certeza que deseja excluir esta conta? (S/N): ");
			String confirmacao = leia.nextLine();
			
			if(confirmacao.equalsIgnoreCase("s")) {
				contaController.deletar(numero);
			}
			else {
				System.out.println("\nOperação cancelada!");
			}
		}else {
			System.out.printf("\na conta %d não foi encontrada", numero);
		}
	}
	
	private static void atualizarConta() {
		//pedir para digitar o numero da conta
		System.out.print("Digite o numero da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		//criando o objeto da classe conta
		Conta conta = contaController.buscarNaCollection(numero);
		if(conta != null) {
			
			int agencia = conta.getAgencia();
			String titular = conta.getTitular();
			int tipo = conta.getTipo();
			float saldo = conta.getSaldo();
			
			System.out.printf("A agência atual é %d\n: Nova agência  (PRESSIONE ENTER PARA MANTER O VALOR ATUAL): ", agencia);
			String entrada = leia.nextLine();
			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);
			// ? -> if operador ternario
			//converter string para inteiro -> converção de dados
			
			System.out.printf("O nome do titular atual: %s\n Novo titular (PRESSIONE ENTER PARA MANTER O VALOR ATUAL): ", titular);
			entrada = leia.nextLine();
			titular = entrada.isEmpty() ? titular : entrada;
			
			System.out.print("Digite o saldo inicial: ");
			entrada = leia.nextLine();
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada);
			
			switch(tipo) {
			case 1 -> {
				//contacorrente é uma herança de conta
				float limite = ((ContaCorrente)conta).getLimite();//casting -> transforma o objeto
				
				System.out.printf("O limite atual é: %.2f\nNovo Limite (Pressione ENTER para manter o valor atual)", limite);
				entrada = leia.nextLine();
				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada);
				contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo,limite));
				//chamando o metodo cadastrar, cria o objeto contacorrente que os parametros
			}
			case 2 -> {
				int aniversario = ((ContaPoupanca)conta).getAniversario();
				System.out.printf("O aniversario atual é %d\n: Novo Aniversario  (PRESSIONE ENTER PARA MANTER O VALOR ATUAL): ", aniversario);
				entrada = leia.nextLine();
				aniversario = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);
				contaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo,aniversario));
				
				
			}
			default -> System.out.println("Tipo de conta inválida!");
			}
		}else {
			System.out.printf("\na conta %d não foi encontrada", numero);
		}
		
	}
	private static void sacar() {
		System.out.print("Digite o numero da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		System.out.print("Digite o valor do saque: ");
		float valor = leia.nextInt();
		leia.nextLine();
		
		contaController.sacar(numero, valor);
		
	}
	private static void depositar() {
		System.out.print("Digite o numero da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		System.out.print("Digite o valor do deposito: ");
		float valor = leia.nextInt();
		leia.nextLine();
		
		contaController.depositar(numero, valor);
	}
	private static void transferir() {
		System.out.print("Digite o numero da conta de origem: ");
		int numeroOrigem = leia.nextInt();
		leia.nextLine();
		System.out.print("Digite o numero da conta de destino: ");
		int numeroDestino = leia.nextInt();
		leia.nextLine();
		
		System.out.print("Digite o valor da transferência: ");
		float valor = leia.nextInt();
		leia.nextLine();
		
		contaController.transferir(numeroOrigem, numeroDestino, valor);
	}
	
	private static void procurarPorTitular() {
		
		System.out.print("Digite o nome do titular da conta: ");
		String titular = leia.nextLine();
		
		contaController.listarPorTitular(titular);
		
	}
}
