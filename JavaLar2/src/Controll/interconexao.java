package Controll;

import java.util.ArrayList;

public class interconexao {

	private ArrayList<Integer> PosicoesPlanetas;
	private ArrayList<Integer> PosicoesBugs;
	private ArrayList<Integer> PosicoesDevs;

	public interconexao(SistemaPlanetas sistema) {
		PosicoesPlanetas = new ArrayList<Integer>();
		PosicoesBugs = new ArrayList<Integer>();
		PosicoesDevs = new ArrayList<Integer>();

		for (int i = 0; i < sistema.getPlanetas().size(); i++) {
			PosicoesPlanetas.add(sistema.getPlanetas().get(i).posicaoX);
			PosicoesPlanetas.add(sistema.getPlanetas().get(i).posicaoY);
		}

		for (int i = 0; i < sistema.getBugsList().size(); i++) {
			PosicoesBugs.add(sistema.getBugsList().get(i).posicaoX);
			PosicoesBugs.add(sistema.getBugsList().get(i).posicaoY);
		}

		for (int i = 0; i < sistema.getDevsList().size(); i++) {
			PosicoesDevs.add(sistema.getDevsList().get(i).posicaoX);
			PosicoesDevs.add(sistema.getDevsList().get(i).posicaoY);
		}

	}

	public ArrayList<Integer> getPosicoesBugs() {
		return PosicoesBugs;
	}

	public ArrayList<Integer> getPosicoesDevs() {
		return PosicoesDevs;
	}

	public ArrayList<Integer> getPosicoesPlanetas() {
		return PosicoesPlanetas;
	}
}
