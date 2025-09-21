package conta_bancaria;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		while(true) {
			System.out.println("*****************************");
			System.out.println("	BANCO DO BRASIL COM Z	 ");
			System.out.println("*****************************");
			System.out.println("                             ");
			System.out.println("	1 - Criar conta 		   		");
			System.out.println("	2 - Listar todas as contas	 ");
			System.out.println("	3 - Buscar Conta por Numero 		 ");
			System.out.println("	4 - Atualizar Dados da Conta 		 ");
			System.out.println("	5 - Apagar conta 		 ");
			System.out.println("	6 - Sacar 		 ");
			System.out.println("	7 - Depositar 		 ");
			System.out.println("	8 - Transferir valores entre Contas		 ");
			System.out.println("	0 - Sair	 ");
			System.out.println("										");
			System.out.println("*****************************************");
			System.out.println("Entre com a opção desejada: ");
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
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Marcia Condarco");
		System.out.println("https://github.com/MarciaCondarco");
		System.out.println("*****************************************");
	}

}
