package JavaLar;

import java.util.ArrayList;
import java.util.Random;

public class SistemaPlanetas {
	ArrayList<Planetas>  planetas = new ArrayList<Planetas>();
	ArrayList<Bugs>      bugsList = new ArrayList<>();
	ArrayList<Devs>      devsList = new ArrayList<>();
	Random               gerador  = new Random();

	public boolean VerificarPosicoes(int[] posicoes) {
		for (int i = 0; i < bugsList.size(); i++) {
			if (posicoes[0] == bugsList.get(i).posicaoX && posicoes[1] == bugsList.get(i).posicaoY) {
				return false;
			}
		}
		for (int j = 0; j < devsList.size(); j++) {
			if (posicoes[0] == devsList.get(j).posicaoX && posicoes[1] == devsList.get(j).posicaoY) {
				return false;
			}
		}
		if (posicoes[0] == 10 && posicoes[1] == 10) {
			return false;
		}
		return true;
	}

	public int VerificarExplosoes(ArrayList<Planetas> planetas) {
		int PlanetasExplodidos = 0;
		for (int i = 0; i < planetas.size(); i++) {
			if (planetas.get(i).getVelDeslocamento() == 0) {
				PlanetasExplodidos++;
				planetas.remove(i);
			}
		}
		return PlanetasExplodidos;
	}

	public void ChecarColisoes(ArrayList<Planetas> planeta) {
		for (int i = 0; i < planeta.size(); i++) {
			for (int j = 0; j < bugsList.size(); j++) {
				if (planeta.get(i).posicaoX == bugsList.get(j).posicaoX && planeta.get(i).posicaoY == bugsList.get(j).posicaoY) {
					planeta.get(i).setVelDeslocamento((planeta.get(i).getVelDeslocamento() - 1));
					bugsList.remove(j);
				}
			}
		}
		
		for (int i = 0; i < planeta.size(); i++) {
			for (int j = 0; j < devsList.size(); j++) {
				if (planeta.get(i).posicaoX == devsList.get(j).posicaoX && planeta.get(i).posicaoY == devsList.get(j).posicaoY) {
					planeta.get(i).setVelDeslocamento((planeta.get(i).getVelDeslocamento() - 1));
					devsList.remove(j);
				}
			}
		}

//			for (Planetas planeta01 : planeta) {
//				for(Bugs bug : bugsList) {
//					if(planeta01.posicaoX == bug.posicaoX && planeta01.posicaoY == bug.posicaoY) {
//						bugsList.remove(bug);
//						planeta01.setVelDeslocamento(planeta01.getVelDeslocamento()-1);
//					}
//				}
//				for (Devs devs : devsList) {
//					if(planeta01.posicaoX == devs.posicaoX && planeta01.posicaoY == devs.posicaoY) {
//						devsList.remove(devs);
//						planeta01.setVelDeslocamento(planeta01.getVelDeslocamento()+1);
//					}
//				}
//			}
	}

	public void CriarBugs(int quantidades) {
		for (int i = 0; i < quantidades;) {
			int posicoes[] = new int[2];
			posicoes[0] = gerador.nextInt(15) + 1;
			posicoes[1] = gerador.nextInt(15) + 1;
			if (VerificarPosicoes(posicoes)) {
				Bugs bug = new Bugs(posicoes[0], posicoes[1]);
				bugsList.add(bug);
				i++;
			}
		}
	}

	public void CriarDevs(int quantidades) {
		for (int i = 0; i < quantidades;) {
			int posicoes[] = new int[2];
			posicoes[0] = gerador.nextInt(15) + 1;
			posicoes[1] = gerador.nextInt(15) + 1;
			if (VerificarPosicoes(posicoes)) {
				Devs dev = new Devs(posicoes[0], posicoes[1]);
				devsList.add(dev);
				i++;
			}
		}
	}

	public void ImprimirPlanetas(ArrayList<Planetas> planetas) {
		for (int i = 0; i < planetas.size(); i++) {
			System.out.println(planetas.get(i).getNome() + ": ");
			System.out.println("Posicao: {" + planetas.get(i).posicaoX + "," + planetas.get(i).posicaoY + "}");
			System.out.println("Dias passados: " + planetas.get(i).getDias());
			System.out.println("Anos passados: " + planetas.get(i).getAnos());
			System.out.println("Velocidade de translacao: " + planetas.get(i).getVelDeslocamento());
			System.out.print("\n");
		}
		System.out.println("JAVA:");
		System.out.println("Posicao: " + "{10,10}");
		System.out.println("\n");

	}

	public void ImprimirPlanetasPosicoesIniciais(ArrayList<Planetas> planetas) {
		for (int i = 0; i < planetas.size(); i++) {
			System.out.println(planetas.get(i).getNome() + ": ");
			System.out.println("Posicao: {" + planetas.get(i).posicaoX + "," + planetas.get(i).posicaoY + "}");
			System.out.print("\n");
		}
		System.out.println("JAVA:");
		System.out.println("Posicao: " + "{10,10}");

	}

	public void ImprimirBugsAndDevs(ArrayList<Bugs> bugs, ArrayList<Devs> devs) {
		System.out.println("posicoes dos bugs: ");
		for (int i = 0; i < bugs.size(); i++) {
			System.out.println("{" + bugs.get(i).posicaoX + "," + bugs.get(i).posicaoY + "}");
		}
		System.out.println("posicoes dos devs");
		for (int i = 0; i < devs.size(); i++) {
			System.out.println("{" + devs.get(i).posicaoX + "," + devs.get(i).posicaoY + "}");
		}

	}

	public void MoverTodos(ArrayList<Planetas> planetas, int unidades) {
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

	public void DistanciaArea(Planetas planeta1, Planetas planeta2) {
		int distancia;
		int altura = (planeta1.posicaoY - planeta2.posicaoY);
		int largura = (planeta1.posicaoX - planeta2.posicaoX);
		distancia = (Math.abs(altura) + 1) * (Math.abs(largura) + 1);

		System.out.println("A distancia em Javametros quadrados de " + planeta1.getNome() + " para "
				+ planeta2.getNome() + " e: " + distancia);
		System.out.println("\n");

	}

	public void DistanciaEuclidiana(Planetas planeta1, Planetas planeta2) {
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

	public void DistanciaAreaPTodos(ArrayList<Planetas> planetas) {

		for (int i = 0; i < planetas.size(); i++) {
			for (int j = 0; j < planetas.size(); j++) {
				if (j == i) {
					continue;
				}
				DistanciaArea(planetas.get(i), planetas.get(j));
			}
		}
	}

	public void DistanciaEuclidianaPTodos(ArrayList<Planetas> planetas) {
		for (int i = 0; i < planetas.size(); i++) {
			for (int j = 0; j < planetas.size(); j++) {
				if (j == i) {
					continue;
				}
				DistanciaEuclidiana(planetas.get(i), planetas.get(j));
			}
		}
	}

	public int ChecarPosicaoNorte(ArrayList<Planetas> planetas) {
		int PlanetasNoNorte = 0;
		for (int i = 0; i < planetas.size(); i++) {
			if (planetas.get(i).posicaoY > 10) {
				PlanetasNoNorte++;
			}
		}
		return PlanetasNoNorte;
	}

	public int ChecarPosicaoSul(ArrayList<Planetas> planetas) {
		int PlanetasNoSul = 0;
		for (int i = 0; i < planetas.size(); i++) {
			if (planetas.get(i).posicaoY < 10) {
				PlanetasNoSul++;
			}
		}
		return PlanetasNoSul;
	}
}
