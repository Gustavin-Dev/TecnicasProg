package Controll;

import java.util.ArrayList;

public class FuncoesPlanetarias implements FuncoesSistema {

	public void Mover(Planetas planeta, int unidades) {
		int movimentos = (unidades * planeta.getVelDeslocamento());
		if (planeta.isStatus() == true) {
			while (movimentos != 0) {
				if (planeta.posicaoY == planeta.getLimitemaxY() && planeta.posicaoX > planeta.getLimiteminX()) {
					while (planeta.posicaoX > planeta.getLimiteminX() && movimentos != 0) {
						planeta.posicaoX--;
						planeta.setMovimentosDados(planeta.getMovimentosDados() + 1);
						movimentos--;
					}
				}
				if (planeta.posicaoY > planeta.getLimiteminY() && planeta.posicaoX == planeta.getLimiteminX()) {
					while (planeta.posicaoY > planeta.getLimiteminY() && movimentos != 0) {
						planeta.posicaoY--;
						planeta.setMovimentosDados(planeta.getMovimentosDados() + 1);
						movimentos--;
					}
				}
				if (planeta.posicaoY == planeta.getLimiteminY() && planeta.posicaoX < planeta.getLimitemaxX()) {
					while (planeta.posicaoX < planeta.getLimitemaxX() && movimentos != 0) {
						planeta.posicaoX++;
						planeta.setMovimentosDados(planeta.getMovimentosDados() + 1);
						movimentos--;
					}
				}
				if (planeta.posicaoY < planeta.getLimitemaxY() && planeta.posicaoX == planeta.getLimitemaxX()) {
					while (planeta.posicaoY < planeta.getLimitemaxY() && movimentos != 0) {
						planeta.posicaoY++;
						planeta.setMovimentosDados(planeta.getMovimentosDados() + 1);
						movimentos--;
					}
				}

			}
		}
	}

	public void Mover(ArrayList<Planetas> planetas, ArrayList<ArrayList<Integer>> instantes, int linhas) {
		for (int i = 0; i < planetas.size(); i++) {
			Mover(planetas.get(i), instantes.get(i).get(linhas));
		}
	}

	public void ContarDias(Planetas planeta, int instantes) {
		planeta.setDias(planeta.getVelRotacao() * instantes);
	}

	public void ContarDiasTodosPlanetas(ArrayList<Planetas> planetas, ArrayList<ArrayList<Integer>> instantes,
			int linhas) {

		for (int i = 0; i < planetas.size(); i++) {
			ContarDias(planetas.get(i), instantes.get(i).get(linhas));
		}
	}

	public void ContarAnos(Planetas planeta, int unidades) {
		planeta.setAnos((planeta.getMovimentosDados() / planeta.getMovimentosAno()));
	}

	public void ContarAnosTodosPlanetas(ArrayList<Planetas> planetas, ArrayList<ArrayList<Integer>> instantes,
			int linhas) {
		for (int i = 0; i < planetas.size(); i++) {
			ContarAnos(planetas.get(i), instantes.get(i).get(linhas));
		}
	}

}
