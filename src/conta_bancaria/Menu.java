package conta_bancaria;

import java.util.Scanner;
import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		//instânciar objetos da classe conta
		
		Conta c1 = new Conta(1,123, 1, "Cintia Dourado", 500000.00f);
		
		System.out.println("o saldo da conta é: " + c1.getSaldo());
		
		c1.setSaldo(600000.00f);
		
		System.out.println("o saldo da conta é: " + c1.getSaldo());
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
			
			opcao = leia.nextInt();
			
			if(opcao == 0) {
				System.out.println("\nBanco do Brasil com Z = O seu começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}
			switch(opcao) {
				case 1:
					System.out.println("Criar conta\n\n");
					break;
				case 2:
					System.out.println("Listar todas as Contas \n\n");
					break;
				case 3:
					System.out.println("Consultar dados da Conta - por numero\n\n");
					break;
				case 4:
					System.out.println("Atualizar os dados da conta\n\n");
					break;
				case 5:
					System.out.println("Apagar a conta\n\n");
					break;
				case 6:
					System.out.println("Saque\n\n");
					break;
				case 7:
					System.out.println("Deposito\n\n");
					break;
				case 8:
					System.out.println("Transferencia de contas\n\n");
					break;
				default:
					System.out.println("\nOpção invalida\n");
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

}
