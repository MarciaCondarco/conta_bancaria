package conta_bancaria.model;

public class ContaCorrente extends Conta{
	//extends -> herdar da classe conta
	//crie a classe contacorrente com a herança da classe conta
	//java não aceita herança multipla, só permite uma unica classe
	
	private float limite;
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}
	//super -> metodo que chama da super classe para a sub classe44

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	//sobreescrevendo o sacar 
	@Override
	public boolean sacar(float valor) {
		if(this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\n Saldo insuficiente!!!! ");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);//saldo atual menos o valor
		
		return true;
	}
	
	//@Override -> anotação sobre escrita, pegando o metodo que ja existe  e sobre escrevendo ele
	
	@Override
	public void visualizar() {
		super.visualizar();
		//metodo super -> pega/puxa todo o metodo para a classe contacorrente
		System.out.printf("Limite da conta: R$ %.2f%n", this.limite);
		// o limite só acrescenta
	}
	
	
	
}
