package JavaLar;

public class CplusPlus extends Planetas{

	public CplusPlus(int X, int Y, String nome) {
		super(X, Y, nome);
	}
	{
		setVelDeslocamento(2);						
		setLimiteminX(4);		   					
		setLimitemaxX(16);							
		setLimiteminY(4);							
		setLimitemaxY(16);							
		setVelRotacao(48);						    
		setMovimentosAno(48);							
		setMovimentosDados(0);										//	this.velDeslocamento = 2;
																	//	this.limiteminX = 4;
																	//	this.limitemaxX = 16;
																	//	this.limiteminY = 4;
																	//	this.limitemaxY = 16;
																	//	this.velRotacao = 48;
																	//	this.movimentosAno = 48;
																	//	this.movimentosDados = 0;
	}
}
