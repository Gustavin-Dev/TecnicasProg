package Controll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Model.LerArquivos;

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

	private int[] BugsQd = new int[4];
	private int[] DevsQd = new int[4];

	public void VerificarExplosoes(ArrayList<Planetas> planetas, LerArquivos ler, ArrayList<ImageIcon> imagens) {
		for (int i = 0; i < planetas.size(); i++) {
			if (planetas.get(i).getVelDeslocamento() == 0) {
				planetas.get(i).setStatus(false);
			}
		}
	}

	public void VerificarColisoes(ArrayList<Planetas> planeta) {
		for (int i = 0; i < planeta.size(); i++) {
			if (planetas.get(i).isStatus() == true) {
				for (int j = 0; j < bugsList.size(); j++) {
					if (planeta.get(i).posicaoX == bugsList.get(j).posicaoX
							&& planeta.get(i).posicaoY == bugsList.get(j).posicaoY) {
						planeta.get(i).setVelDeslocamento((planeta.get(i).getVelDeslocamento() - 1));
						planeta.get(i).setBugsColididos(planeta.get(i).getBugsColididos() + 1);
						bugsList.remove(j);
					}
				}
			}
		}

		for (int i = 0; i < planeta.size(); i++) {
			if (planetas.get(i).isStatus() == true) {
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

		Arrays.fill(BugsQd, 0);
		Arrays.fill(DevsQd, 0);

		for (int i = 0; i < bugsList.size(); i++) {

			if (bugsList.get(i).posicaoX <= 6 && bugsList.get(i).posicaoY <= 6) {
				BugsQ1++;
			}
			if (bugsList.get(i).posicaoX <= 6 && bugsList.get(i).posicaoY >= 8) {
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
			if (devsList.get(i).posicaoX <= 6 && devsList.get(i).posicaoY >= 8) {
				DevsQ2++;
			}
			if (devsList.get(i).posicaoX >= 8 && devsList.get(i).posicaoY <= 6) {
				DevsQ3++;
			}
			if (devsList.get(i).posicaoX >= 8 && devsList.get(i).posicaoY >= 8) {
				DevsQ4++;
			}

		}

		BugsQd[0] = BugsQ1;
		BugsQd[1] = BugsQ2;
		BugsQd[2] = BugsQ3;
		BugsQd[3] = BugsQ4;

		DevsQd[0] = DevsQ1;
		DevsQd[1] = DevsQ2;
		DevsQd[2] = DevsQ3;
		DevsQd[3] = DevsQ4;

	}

	public void ImprimirDados() {

		for (int i = 0; i < planetas.size(); i++) {
			System.out.println(
					"Bugs colididos pelo " + planetas.get(i).getNome() + ": " + planetas.get(i).getBugsColididos());
		}

		System.out.print("\n");

		for (int i = 0; i < planetas.size(); i++) {
			System.out.println(
					"Devs colididos pelo " + planetas.get(i).getNome() + ": " + planetas.get(i).getDevsColididos());
		}

		System.out.print("\n");

		for (int i = 0; i < planetas.size(); i++) {
			System.out.println("Dias passados no " + planetas.get(i).getNome() + ": " + planetas.get(i).getDias());
		}

		System.out.print("\n");

		for (int i = 0; i < planetas.size(); i++) {
			System.out.println("Anos passados no " + planetas.get(i).getNome() + ": " + planetas.get(i).getAnos());
		}

		System.out.print("\n");

		System.out.println("Quantidade Bugs quadrante 1: " + BugsQd[0]);
		System.out.println("Quantidade Bugs quadrante 2: " + BugsQd[1]);
		System.out.println("Quantidade Bugs quadrante 3: " + BugsQd[2]);
		System.out.println("Quantidade Bugs quadrante 4: " + BugsQd[3]);

		System.out.println("Quantidade Devs quadrante 1: " + DevsQd[0]);
		System.out.println("Quantidade Devs quadrante 2: " + DevsQd[1]);
		System.out.println("Quantidade Devs quadrante 3: " + DevsQd[2]);
		System.out.println("Quantidade Devs quadrante 4: " + DevsQd[3]);
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

	public int[] getBugsQd() {
		return BugsQd;
	}

	public int[] getDevsQd() {
		return DevsQd;
	}

}
