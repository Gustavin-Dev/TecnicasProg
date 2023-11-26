package Controll;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class MenuJavaLar {

	private FuncoesPlanetarias FuncoesPlanetarias;
	private SistemaPlanetas  sistema;
	private LerArquivos Ler;
	
	public MenuJavaLar() {
		sistema   = new SistemaPlanetas();
		FuncoesPlanetarias = new FuncoesPlanetarias();

		C          c          = new C         (0,7, "C");
		PHP        php        = new PHP       (3,7, "Php");
		JAVA       java       = new JAVA();
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
		
		
		PassarPosicoesPlanetas();
		
	}
	
	public void InstanciarLeituraArquivo(int ArquivoInstantes) {
		Ler = new LerArquivos(ArquivoInstantes);
	}
	


	public void ContabilizarDados(SistemaPlanetas sistema, FuncoesPlanetarias FuncoesPlanetarias,LerArquivos ler,
			int quantidadeDevs, int  quantidadeBugs, int LinhaInstantes, ArrayList<ImageIcon> imagens) {
			
			FuncoesPlanetarias.Mover(sistema.getPlanetas(),ler.getInstantesAllPlanets(), LinhaInstantes);
			FuncoesPlanetarias.ContarDiasTodosPlanetas(sistema.getPlanetas(),ler.getInstantesAllPlanets(), LinhaInstantes);
			FuncoesPlanetarias.ContarAnosTodosPlanetas(sistema.getPlanetas(), ler.getInstantesAllPlanets(),LinhaInstantes);
			sistema.CriarBugs(quantidadeBugs);
			sistema.CriarDevs(quantidadeDevs);
			sistema.VerificarColisoes(sistema.getPlanetas());
			sistema.VerificarExplosoes(sistema.getPlanetas(), ler,imagens);
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
	
	public FuncoesPlanetarias getFuncoesPlanetarias() {
		return FuncoesPlanetarias;
	}

	public SistemaPlanetas getSistema() {
		return sistema;
	}

	public LerArquivos getLer() {
		return Ler;
	}
}
		