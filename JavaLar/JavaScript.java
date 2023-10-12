package JavaLar;

public class JavaScript extends Planetas {

	public JavaScript(int X, int Y, String nome) {
		super(X, Y, nome);

	}

	{
		setVelDeslocamento(3);
		setLimiteminX(8);
		setLimitemaxX(12);
		setLimiteminY(8);
		setLimitemaxY(12);
		setVelRotacao(2.4);
		setMovimentosAno(16);
		setMovimentosDados(0); // this.velDeslocamento = 3;
								// this.limiteminX = 8;
								// this.limitemaxX = 12;
								// this.limiteminY = 8;
								// this.limitemaxY = 12;
								// this.velRotacao = 2.4;
								// this.movimentosAno = 16;
								// this.movimentosDados = 0;
		setResumoLinguagem("O JavaScript surgiu como uma tecnologia do lado do navegador para tornar as aplicações Web mais dinâmicas. "
				+ "\n" + "Ao usar JavaScript, os navegadores passaram a ser capazes de responder a interações do usuário e alterar o layout do conteúdo na página.");
	}

}
