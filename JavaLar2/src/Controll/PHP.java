package Controll;

public class PHP extends Planetas {
	public PHP(int X, int Y, String nome) {
		super(X, Y, nome);
	}

	{
		setVelDeslocamento(2);
		setLimiteminX(3);
		setLimitemaxX(11);
		setLimiteminY(3);
		setLimitemaxY(11);
		setVelRotacao(0.4);
		setMovimentosAno(32);
		setMovimentosDados(0); // this.velDeslocamento = 2;
								// this.limiteminX = 6;
								// this.limitemaxX = 14;
								// this.limiteminY = 6;
								// this.limitemaxY = 14;
								// this.velRotacao = 0.4;
								// this.movimentosAno = 32;
								// this.movimentosDados = 0;
		setResumoLinguagem(
				"O PHP (um acrônimo recursivo para PHP: Hypertext Preprocessor ) é uma linguagem de script open source de uso geral,"
				+ "\n" + " muito utilizada, e especialmente adequada para o desenvolvimento web e que pode ser embutida dentro do HTML.");
	}

}
