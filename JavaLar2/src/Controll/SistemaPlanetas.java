package Controll;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class SistemaPlanetas {

	private ArrayList<Planetas> planetas = new ArrayList<Planetas>();
	private ArrayList<Bugs> bugsList = new ArrayList<Bugs>();
	private ArrayList<Devs> devsList = new ArrayList<Devs>();
	private Random gerador = new Random();
	private int DevsQ1;
	private int DevsQ2;
	private int DevsQ3;
	private int DevsQ4;
	private int BugsQ1;
	private int BugsQ2;
	private int BugsQ3;
	private int BugsQ4;

	public void VerificarExplosoes(ArrayList<Planetas> planetas, LerArquivos ler, ArrayList<ImageIcon> imagens) {
		for (int i = 0; i < planetas.size(); i++) {
			if (planetas.get(i).getVelDeslocamento() == 0) {
				planetas.remove(i);
				ler.getInstantesAllPlanets().remove(i);
				imagens.remove(i);

			}
		}
	}

	public void VerificarColisoes(ArrayList<Planetas> planeta) {
		for (int i = 0; i < planeta.size(); i++) {
			for (int j = 0; j < bugsList.size(); j++) {
				if (planeta.get(i).posicaoX == bugsList.get(j).posicaoX
						&& planeta.get(i).posicaoY == bugsList.get(j).posicaoY) {
					planeta.get(i).setVelDeslocamento((planeta.get(i).getVelDeslocamento() - 1));
					planeta.get(i).setBugsColididos(planeta.get(i).getBugsColididos() + 1);
					bugsList.remove(j);
				}
			}
		}

		for (int i = 0; i < planeta.size(); i++) {
			for (int j = 0; j < devsList.size(); j++) {
				if (planeta.get(i).posicaoX == devsList.get(j).posicaoX
						&& planeta.get(i).posicaoY == devsList.get(j).posicaoY) {
					planeta.get(i).setVelDeslocamento((planeta.get(i).getVelDeslocamento() + 1));
					planeta.get(i).setDevsColididos(planeta.get(i).getDevsColididos() + 1);
					devsList.remove(j);
				}
			}
		}
	}

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
		if (posicoes[0] == 7 && posicoes[1] == 7) {
			return false;
		}

		return true;
	}

	public void CriarBugs(int quantidades) {
		for (int i = 0; i < quantidades;) {
			int posicoes[] = new int[2];
			posicoes[0] = gerador.nextInt(15);
			posicoes[1] = gerador.nextInt(15);
			if (bugsList.size() + devsList.size() == 224) {
				i++;
			} else {
				if (VerificarPosicoes(posicoes)) {
					Bugs bug = new Bugs(posicoes[0], posicoes[1]);
					if (bugsList.size() + devsList.size() < 224) {
						bugsList.add(bug);
					}
					i++;
				}
			}
		}
	}

	public void CriarDevs(int quantidades) {
		for (int i = 0; i < quantidades;) {
			int posicoes[] = new int[2];
			posicoes[0] = gerador.nextInt(15);
			posicoes[1] = gerador.nextInt(15);
			if (bugsList.size() + devsList.size() == 224) {
				i++;
			} else {
				if (VerificarPosicoes(posicoes)) {
					Devs dev = new Devs(posicoes[0], posicoes[1]);
					if (bugsList.size() + devsList.size() < 224) {
						devsList.add(dev);
					}
					i++;
				}
			}
		}
	}

	public void VerificarQuadrantes() {
		
		BugsQ1 = 0;
		BugsQ2 = 0;
		BugsQ3 = 0;
		BugsQ4 = 0;
		DevsQ1 = 0;
		DevsQ2 = 0;
		DevsQ3 = 0;
		DevsQ4 = 0;
		
		for (int i = 0; i < bugsList.size(); i++) {
			
			       if (bugsList.get(i).posicaoX <= 6 && bugsList.get(i).posicaoY <= 6) {
				BugsQ1++;
			} 
			       if (bugsList.get(i).posicaoX >= 8 && bugsList.get(i).posicaoY <= 6) {
				BugsQ2++;
			} 
			       if (bugsList.get(i).posicaoX >= 8 && bugsList.get(i).posicaoY <= 6) {
				BugsQ3++;
			} 
			       if (bugsList.get(i).posicaoX >= 8 && bugsList.get(i).posicaoY >= 8) {
				BugsQ4++;
			}
			       
		}
		for (int i = 0; i < devsList.size(); i++) {
			
			       if (devsList.get(i).posicaoX <= 6 && devsList.get(i).posicaoY <= 6) {
				DevsQ1++;
			} 
			       if (devsList.get(i).posicaoX >= 8 && devsList.get(i).posicaoY <= 6) {
				DevsQ2++;
			} 
			       if (devsList.get(i).posicaoX >= 8 && devsList.get(i).posicaoY <= 6) {
				DevsQ3++;
			} 
			       if (devsList.get(i).posicaoX >= 8 && devsList.get(i).posicaoY >= 8) {
				DevsQ4++;
			}
			       
		}
	}

	public void ImprimirQuadrantes() {
		System.out.println("Quantidade Bugs quadrante 1: " + BugsQ1);
		System.out.println("Quantidade Bugs quadrante 2: " + BugsQ2);
		System.out.println("Quantidade Bugs quadrante 3: " + BugsQ3);
		System.out.println("Quantidade Bugs quadrante 4: " + BugsQ4);
		
		System.out.println("Quantidade Devs quadrante 1: " + DevsQ1);
		System.out.println("Quantidade Devs quadrante 2: " + DevsQ2);
		System.out.println("Quantidade Devs quadrante 3: " + DevsQ3);
		System.out.println("Quantidade Devs quadrante 4: " + DevsQ4);
	}
	
	
	
	public ArrayList<Planetas> getPlanetas() {
		return planetas;
	}

	public ArrayList<Bugs> getBugsList() {
		return bugsList;
	}

	public ArrayList<Devs> getDevsList() {
		return devsList;
	}

}
