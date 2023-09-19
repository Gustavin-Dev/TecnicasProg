package Vendinha;

public class Pedido {
	public CachorroQuente cachorrosQuentes[];
	public Aluno aluno;
	
	public Pedido(Aluno aluno , CachorroQuente cachorrosQuentes[]) {
		this.aluno = aluno;
		this.cachorrosQuentes = cachorrosQuentes;
	}
}
