package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
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
		
		//instânciar objetos da classe conta
		
		//Conta c1 = new Conta(1,123, 1, "Cintia Dourado", 500000.00f);
		
		//Conta c2 = new Conta(1,123, 2, "Priscila Lins", 200000.00f);
		
		//System.out.println("o saldo da conta é: " + c1.getSaldo());
		
		//c1.setSaldo(600000.00f);
		
		//ystem.out.println("o saldo da conta é: " + c1.getSaldo());
		
		//encapsulamento -> proteger os atributos da classe 
		
		//c1.visualizar();
		
		//c2.visualizar();
		
		//System.out.println(c1.sacar(1000));
		//System.out.println("o saldo da conta é: " + c1.getSaldo());
		//System.out.println(c2.sacar(1000000000));
		//System.out.println("o saldo da conta é: " + c2.getSaldo());
		
		//c1.depositar(5000);
		//System.out.println("o saldo da conta é: " + c1.getSaldo());

		//instanciar objetos da classe conta corrente
		
		ContaCorrente cc1 = new ContaCorrente(3, 456, 1, "Thuany Silva", 1000000.00f, 100000.00f);
		
		cc1.visualizar();
		
		//sacar da conta corrente
		System.out.println(cc1.sacar(2000000.00f));
		cc1.visualizar();
		
		System.out.println(cc1.sacar(3000.00f));
		cc1.visualizar();
		
		//Depositar
		cc1.depositar(5000.00f);
		cc1.visualizar();
		
		//instanciar objetos da classe conta poupança
		
		ContaPoupanca cp = new ContaPoupanca(3, 456, 2, "Marcia Condarco", 1000.00f, 1);
		cp.visualizar();
		
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
					
					keyPress();
					break;
				case 2:
					System.out.println("Listar todas as Contas \n\n");
					listarContas();
					keyPress();
					break;
				case 3:
					System.out.println("Consultar dados da Conta - por numero\n\n");
					
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar os dados da conta\n\n");
					
					keyPress();
					break;
				case 5:
					System.out.println("Apagar a conta\n\n");
					
					keyPress();
					break;
				case 6:
					System.out.println("Saque\n\n");
					
					keyPress();
					break;
				case 7:
					System.out.println("Deposito\n\n");
					
					keyPress();
					break;
				case 8:
					System.out.println("Transferencia de contas\n\n");
					
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
		System.out.println(Cores.TEXT_GREEN + "Pressione enter para continuar ...");
		leia.nextLine();
	}
	
	private static void criarContasTeste() {
		contaController.cadastrar(new ContaCorrente(1, 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(new ContaPoupanca(2, 456, 1, "Marcia Condarco", 1000000.00f, 10));
	}
	
	private static void listarContas() {
		//executa os metodos de lista da controladora
		contaController.listarTodas();
	}
	

}
