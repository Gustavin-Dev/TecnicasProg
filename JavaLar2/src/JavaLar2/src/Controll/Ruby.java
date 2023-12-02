package Controll;

public class Ruby extends Planetas {
	public Ruby(int X, int Y, String nome) {
		super(X, Y, nome);
	}

	{
		setVelDeslocamento(2);
		setStatus(true);
		setLimiteminX(4);
		setLimitemaxX(10);
		setLimiteminY(4);
		setLimitemaxY(10);
		setVelRotacao(0.5);
		setMovimentosAno(24);
		setMovimentosDados(0); // this.velDeslocamento = 2;
								// this.limiteminX = 7;
								// this.limitemaxX = 13;
								// this.limiteminY = 7;
								// this.limitemaxY = 13;
								// this.velRotacao = 0.5;
								// this.movimentosAno = 24;
								// this.movimentosDados = 0;
		setResumoLinguagem(
				"A Ruby é uma linguagem de programação orientada principalmente para objetos, mas que também é utilizada de forma funcional. "
				+ "\n" + "Com característica de ser open-source, ela foi criada com base em outras, como Perl, Eiffel e LISP.");
	}

}
