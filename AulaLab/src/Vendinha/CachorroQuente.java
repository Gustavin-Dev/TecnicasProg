package Vendinha;

public class CachorroQuente {
	public String proteina; 
	public String queijo; 
	public String bebida; 

	boolean temMaionese;
	boolean temKetchup;
	boolean temOvo;
	boolean temBatataFrita;

	public CachorroQuente(String proteina, String queijo, String bebida, boolean temMaionese, boolean temKetchup,
			boolean temOvo, boolean temBatataFrita) {
		
		this.proteina = proteina;
		this.queijo = queijo;
		this.bebida = bebida;
		this.temBatataFrita = temBatataFrita;
		this.temKetchup = temKetchup;
		this.temOvo = temOvo;
		this.temMaionese = temMaionese;
	}

}
