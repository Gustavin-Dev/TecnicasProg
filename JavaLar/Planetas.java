package JavaLar;

public class Planetas extends Astros{
	
	private String 	 Nome;
	private int 	 velDeslocamento;
	private int 	 limitemaxX;
	private int 	 limiteminX;
	private int 	 limitemaxY;
	private int 	 limiteminY;
	private int 	 movimentosAno;
	private int 	 bugsColididos;
	private int      devsColididos;
	private double   movimentosDados;
	private double   velRotacao;
	private double   anos;
	private double   dias;
	private String   resumoLinguagem;
	
	public Planetas(int X, int Y,String nome) {
		super(X, Y);
		this.Nome = nome;
}
	
	public int getBugsColididos() {
		return bugsColididos;
	}

	public void setBugsColididos(int bugsColididos) {
		this.bugsColididos = bugsColididos;
	}

	public int getDevsColididos() {
		return devsColididos;
	}

	public void setDevsColididos(int devsColididos) {
		this.devsColididos = devsColididos;
	}
	
	public String getResumoLinguagem() {
		return resumoLinguagem;
	}

	public void setResumoLinguagem(String resumoLinguagem) {
		this.resumoLinguagem = resumoLinguagem;
	}

	public String getNome() {
		return Nome;
	}

	public int getVelDeslocamento() {
		return velDeslocamento;
	}

	public void setVelDeslocamento(int velDeslocamento) {
		this.velDeslocamento = velDeslocamento;
	}

	public int getLimitemaxX() {
		return limitemaxX;
	}

	public void setLimitemaxX(int limitemaxX) {
		this.limitemaxX = limitemaxX;
	}

	public int getLimiteminX() {
		return limiteminX;
	}

	public void setLimiteminX(int limiteminX) {
		this.limiteminX = limiteminX;
	}

	public int getLimitemaxY() {
		return limitemaxY;
	}

	public void setLimitemaxY(int limitemaxY) {
		this.limitemaxY = limitemaxY;
	}

	public int getLimiteminY() {
		return limiteminY;
	}

	public void setLimiteminY(int limiteminY) {
		this.limiteminY = limiteminY;
	}

	public int getMovimentosAno() {
		return movimentosAno;
	}

	public void setMovimentosAno(int movimentosAno) {
		this.movimentosAno = movimentosAno;
	}

	public double getMovimentosDados() {
		return movimentosDados;
	}

	public void setMovimentosDados(double movimentosDados) {
		this.movimentosDados = movimentosDados;
	}

	public double getVelRotacao() {
		return velRotacao;
	}

	public void setVelRotacao(double velRotacao) {
		this.velRotacao = velRotacao;
	}

	public double getAnos() {
		return anos;
	}

	public void setAnos(double anos) {
		this.anos = anos;
	}

	public double getDias() {
		return dias;
	}

	public void setDias(double dias) {
		this.dias = dias;
	}
}
