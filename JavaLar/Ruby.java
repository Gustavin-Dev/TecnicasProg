package JavaLar;

public class Ruby extends Planetas {

	public Ruby(int X, int Y, String nome) {
		super(X, Y, nome);
	}
	{
		setVelDeslocamento(2);						
		setLimiteminX(7);		   					
		setLimitemaxX(13);							
		setLimiteminY(7);							
		setLimitemaxY(13);							
		setVelRotacao(0.5);						    
		setMovimentosAno(24);							
		setMovimentosDados(0);										//	this.velDeslocamento = 2;
																	//	this.limiteminX = 7;
																	//	this.limitemaxX = 13;
																	//	this.limiteminY = 7;
																	//	this.limitemaxY = 13;
																	//	this.velRotacao = 0.5;
																	//	this.movimentosAno = 24;
																	//	this.movimentosDados = 0;
	}
}
