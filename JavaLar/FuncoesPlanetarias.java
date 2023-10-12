package JavaLar;

import java.util.ArrayList;

public class FuncoesPlanetarias implements FuncoesSistema {
	
	public void Mover(Planetas planeta, int unidades) {
		int movimentos = (unidades * planeta.getVelDeslocamento());
		while (movimentos != 0) {
			if (planeta.posicaoY == planeta.getLimitemaxX() && planeta.posicaoX > planeta.getLimiteminX()) {
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
	
	public void Mover(ArrayList<Planetas> planetas, int unidades) {
		for (int i = 0; i < planetas.size(); i++) {
			Mover(planetas.get(i), unidades);
		}
	}

	public void ContarDias(Planetas planeta, int unidades) {
		planeta.setDias(planeta.getVelRotacao() * unidades);
	}

	public void ContarDiasTodosPlanetas(ArrayList<Planetas> planetas, int unidades) {

		for (int i = 0; i < planetas.size(); i++) {
			ContarDias(planetas.get(i), unidades);
		}
	}

	public void ContarAnos(Planetas planeta, int unidades) {
		planeta.setAnos((planeta.getMovimentosDados() / planeta.getMovimentosAno()));
	}

	public void ContarAnosTodosPlanetas(ArrayList<Planetas> planetas, int unidades) {
		for (int i = 0; i < planetas.size(); i++) {
			ContarAnos(planetas.get(i), unidades);
		}
	}

	public void VerificarDistanciaArea(Planetas planeta1, Planetas planeta2) {
		int distancia;
		int altura = (planeta1.posicaoY - planeta2.posicaoY);
		int largura = (planeta1.posicaoX - planeta2.posicaoX);
		distancia = (Math.abs(altura) + 1) * (Math.abs(largura) + 1);

		System.out.println("A distancia em Javametros quadrados de " + planeta1.getNome() + " para "
				+ planeta2.getNome() + " e: " + distancia);
		System.out.println("\n");

	}

	public void VerificarDistanciaAreaPTodos(ArrayList<Planetas> planetas) {

		for (int i = 0; i < planetas.size(); i++) {
			for (int j = 0; j < planetas.size(); j++) {
				if (j == i) {
					continue;
				}
				VerificarDistanciaArea(planetas.get(i), planetas.get(j));
			}
		}
	}

	public void VerificarDistanciaEuclidiana(Planetas planeta1, Planetas planeta2) {
		double numeroInterno;
		double distancia;
		double deltaX = planeta1.posicaoX - planeta2.posicaoX;
		double deltaY = planeta1.posicaoY - planeta2.posicaoY;
		numeroInterno = (Math.abs(deltaX)) * (Math.abs(deltaX)) - (Math.abs(deltaY) * Math.abs(deltaY));
		distancia = Math.sqrt(Math.abs(numeroInterno));
		System.out.println("A distancia javaclidiana de " + planeta1.getNome() + " ate " + planeta2.getNome() + " e: "
				+ distancia);
		System.out.println("\n");
	}

	public void VerificarDistanciaEuclidianaPTodos(ArrayList<Planetas> planetas) {
		for (int i = 0; i < planetas.size(); i++) {
			for (int j = 0; j < planetas.size(); j++) {
				if (j == i) {
					continue;
				}
				VerificarDistanciaEuclidiana(planetas.get(i), planetas.get(j));
			}
		}
	}



	
}
