package JavaLar;

public class Phyton extends Planetas {

	public Phyton(int X, int Y, String nome) {
		super(X, Y, nome);
	}

	{
		setVelDeslocamento(4); 				// this.velDeslocamento = 4;
		setLimiteminX(9); 					// this.limiteminX = 9;
		setLimitemaxX(11); 					// this.limitemaxX = 11;
		setLimiteminY(9); 					// this.limiteminY = 9;
		setLimitemaxY(11); 					// this.limitemaxY = 11;
		setVelRotacao(1); 					// this.velRotacao = 1;
		setMovimentosAno(8); 				// this.movimentosAno = 8;
		setMovimentosDados(0); 				// this.movimentosDados = 0;
	
		setResumoLinguagem(
				"O Python é uma linguagem de programação amplamente usada em aplicações da Web, desenvolvimento de software,"
				+"\n" +  "ciência de dados e machine learning (ML). "
				+ "\n" + "Os desenvolvedores usam o Python porque é eficiente e fácil de aprender e pode ser executada em muitas plataformas diferentes.");
	}

}
