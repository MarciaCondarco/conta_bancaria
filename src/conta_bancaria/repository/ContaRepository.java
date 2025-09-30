package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository {

	//metodos das operações do CRUD
	
	//a propria interface ja é abstrata
	//Conta classe abstrata 
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void procurarPorNumero(int numero);
	public void deletar(int numero);
	public void listarPorTitular(String titular);
	
	
	//metodos Operações bancarias
	//parametros do sacar são para identificar o numero da conta e o valor
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);
	
}
