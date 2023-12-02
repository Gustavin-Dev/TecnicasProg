package Controll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Model.*;

public class Controlador {

	private FuncoesPlanetarias FuncoesPlanetarias;
	private SistemaPlanetas  sistema;
	private LerArquivos Ler;
	private PlanetaDAO planetaDAO;
	private AnaliseDeDados AnalisarDados;
	
	public Controlador() throws SQLException {
		sistema   = new SistemaPlanetas();
		FuncoesPlanetarias = new FuncoesPlanetarias();
		planetaDAO = new PlanetaDAO();
		

		C          c          = new C         (0,7, "C");
		PHP        php        = new PHP       (3,7, "Php");
		Ruby       ruby       = new Ruby      (4,7, "Ruby");
		CplusPlus  cplus      = new CplusPlus (1,7, "C++");
		Phyton     phyton     = new Phyton    (6,7, "Phyton");
		CSharp     csharp     = new CSharp    (2,7, "Csharp");
		JavaScript javascript = new JavaScript(5,7, "JavaScript");

		sistema.getPlanetas().add(phyton);
		sistema.getPlanetas().add(javascript);
		sistema.getPlanetas().add(ruby);
		sistema.getPlanetas().add(php);
		sistema.getPlanetas().add(csharp);
		sistema.getPlanetas().add(cplus);
		sistema.getPlanetas().add(c);
		 
		
	}
	
	public void InstanciarLeituraArquivo(int ArquivoInstantes) {
		Ler = new LerArquivos(ArquivoInstantes);
	}
	


	public void ContabilizarDados(int quantidadeDevs, int  quantidadeBugs, int LinhaInstantes, ArrayList<ImageIcon> imagens) {
			
			FuncoesPlanetarias.Mover(sistema.getPlanetas(),Ler.getInstantesAllPlanets(), LinhaInstantes);
			FuncoesPlanetarias.ContarDiasTodosPlanetas(sistema.getPlanetas(),Ler.getInstantesAllPlanets(), LinhaInstantes);
			FuncoesPlanetarias.ContarAnosTodosPlanetas(sistema.getPlanetas(), Ler.getInstantesAllPlanets(),LinhaInstantes);
			sistema.CriarBugs(quantidadeBugs);
			sistema.CriarDevs(quantidadeDevs);
			sistema.VerificarColisoes(sistema.getPlanetas());
			sistema.VerificarExplosoes(sistema.getPlanetas(), Ler,imagens);
			sistema.VerificarQuadrantes();
	}
	

	public ArrayList<Integer> PassarPosicoesPlanetas(){
		interconexao passar = new interconexao(sistema);
		return passar.getPosicoesPlanetas();
	}
	
	public ArrayList<Integer> PassarPosicoesBugs(){
		interconexao passar = new interconexao(sistema);
		return passar.getPosicoesBugs();
	}
	
	public ArrayList<Integer> PassarPosicoesDevs(){
		interconexao passar = new interconexao(sistema);
		return passar.getPosicoesDevs();
	}
	
	public void AnalisarDados() throws SQLException, IOException {
		AnalisarDados = new AnaliseDeDados(planetaDAO.LerDados());
	}
	public void GerarArquivoSaida() throws SQLException, IOException {
		AnalisarDados = new AnaliseDeDados(planetaDAO.LerDados());
		AnalisarDados.ArquivoDeSaida();
	}
	
	public FuncoesPlanetarias getFuncoesPlanetarias() {
		return FuncoesPlanetarias;
	}

	public SistemaPlanetas getSistema() {
		return sistema;
	}

	public LerArquivos getLer() {
		return Ler;
	}

	public PlanetaDAO getPlanetaDAO() {
		return planetaDAO;
	}

	public AnaliseDeDados getAnalisarDados() {
		return AnalisarDados;
	}
	
	
	
	
}
		