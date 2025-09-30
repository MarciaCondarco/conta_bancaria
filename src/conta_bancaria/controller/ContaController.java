package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{

	
	private List<Conta> listaContas = new ArrayList<Conta>();
	
	int numero = 0 ; //controlar o numero das contas
	
	
	
	@Override
	public void listarTodas() {
		for(var conta:listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nConta Cadastrada com sucesso! ");
		
	}

	@Override
	public void atualizar(Conta conta) {
		
		var buscarConta = buscarNaCollection(conta.getNumero());
		
		if(buscarConta != null) {
			//
			listaContas.set(listaContas.indexOf(buscarConta), conta);
			System.out.printf("\nA Conta número: %d foi atualizada com sucesso!!%n", conta.getNumero());
		}
		else {
			System.out.printf("\nA Conta número: %d não foi encontrada%n", conta.getNumero());
		}
		
	}

	@Override
	public void procurarPorNumero(int numero) {
		//variavel conta que vai ser o resultado da collection passando o numero
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.visualizar();
		}
		else {
			System.out.printf("\nA Conta número: %d não foi encontrada%n", numero);
		}
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listaContas.remove(conta) == true) {
				System.out.printf("A conta %d foi deleta com sucesso%n", numero);
			}
		}
		else {
			System.out.printf("\nA Conta número: %d não foi encontrada%n", numero);
		}
		
	}

	@Override
	public void sacar(int numero, float valor) {
		
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(conta.sacar(valor) == true) {
				System.out.printf("\nOsaque no valor de %.2f, na  conta  numeros: %d foi efetuado com successo", valor, numero);
			}
		}
		else {
			System.out.printf("\nA Conta número: %d não foi encontrada%n", numero);
		}
	}

	@Override
	public void depositar(int numero, float valor) {
		
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.depositar(valor) ;
				System.out.printf("\nO deposito"
						+ " no valor de %.2f, na  conta  numeros: %d foi efetuado com successo", valor, numero);
		}
		else {
			System.out.printf("\nA Conta número: %d não foi encontrada%n", numero);
		}
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			if(contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.printf(""
						+ "\nA transferencia no valor de %.2f, na  conta  numeros: %d "
						+ "para a conta numero: %d, foi efetuado com successo"
						,valor, numeroOrigem, numeroDestino);
			}
		}
		else {
			System.out.printf("\nA Conta número origem e/ou conta de destino:  não foi encontrada%n");
		}
	}
	//a classe conta controller vai implementar todos os metodos da classe conta repository
	
	//stream que filtra os dados
	@Override
	public void listarPorTitular(String titular) {
		List<Conta> listaTitulares = listaContas.stream()
				.filter(c -> c.getTitular().toUpperCase().contains(titular.toUpperCase()))
				.collect(Collectors.toList());
		if(listaTitulares.isEmpty()) {
			System.out.printf("\n Nenhuma conta foi encontrada para titulares que possuam o nome"
					+ ": %s", titular);
		}for(var conta : listaTitulares) {
			conta.visualizar();
		}
	}
	//metodos auxiliar
	public int gerarNumero() {
		return ++ numero;
	}
	
	//metodo auxiliar para percorrer toda a coleção
	public Conta buscarNaCollection(int numero) {
		for(var conta: listaContas) { //percorre a conta do vetor listar conta
			if(conta.getNumero() == numero) { //compara com o numero da conta 
				return conta;//returna conta
			}
		}
		return null;//caso não acha nada no for
	}

}
