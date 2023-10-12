package JavaLar;

import java.util.ArrayList;
import java.util.Random;

public class SistemaPlanetas {
	ArrayList<Planetas> planetas        = new ArrayList<Planetas>();
	ArrayList<Bugs>     bugsList        = new ArrayList<Bugs>();
	ArrayList<Devs>     devsList        = new ArrayList<Devs>();
	Random              gerador         = new Random();
	
	private int instantesTotais=0;
	int quantidadePlanetasExplodidos=0;
	
	public int getInstantesTotais() {
		return instantesTotais;
	}

	public void setInstantesTotais(int instantesTotais) {
		this.instantesTotais = instantesTotais;
	}

	
	
	private boolean AlinhamentoSuperiorVertical = true;
	private boolean AlinhamentoSuperiorEsquerdo = true;
	private boolean AlinhamentoInferiorEsquerdo = true;
	private boolean AlinhamentoInferiorVertical = true;
	private boolean AlinhamentoInferiorDireito 	= true;
	private boolean AlinhamentoSuperiorDireito 	= true;
	
//	geters and seters
	
	public boolean isAlinhamentoSuperiorVertical() {
		return AlinhamentoSuperiorVertical;
	}

	public void setAlinhamentoSuperiorVertical(boolean alinhamentoSuperiorVertical) {
		AlinhamentoSuperiorVertical = alinhamentoSuperiorVertical;
	}

	public boolean isAlinhamentoSuperiorEsquerdo() {
		return AlinhamentoSuperiorEsquerdo;
	}

	public void setAlinhamentoSuperiorEsquerdo(boolean alinhamentoSuperiorEsquerdo) {
		AlinhamentoSuperiorEsquerdo = alinhamentoSuperiorEsquerdo;
	}

	public boolean isAlinhamentoInferiorEsquerdo() {
		return AlinhamentoInferiorEsquerdo;
	}

	public void setAlinhamentoInferiorEsquerdo(boolean alinhamentoInferiorEsquerdo) {
		AlinhamentoInferiorEsquerdo = alinhamentoInferiorEsquerdo;
	}

	public boolean isAlinhamentoInferiorVertical() {
		return AlinhamentoInferiorVertical;
	}

	public void setAlinhamentoInferiorVertical(boolean alinhamentoInferiorVertical) {
		AlinhamentoInferiorVertical = alinhamentoInferiorVertical;
	}

	public boolean isAlinhamentoInferiorDireito() {
		return AlinhamentoInferiorDireito;
	}

	public void setAlinhamentoInferiorDireito(boolean alinhamentoInferiorDireito) {
		AlinhamentoInferiorDireito = alinhamentoInferiorDireito;
	}

	public boolean isAlinhamentoSuperiorDireito() {
		return AlinhamentoSuperiorDireito;
	}

	public void setAlinhamentoSuperiorDireito(boolean alinhamentoSuperiorDireito) {
		AlinhamentoSuperiorDireito = alinhamentoSuperiorDireito;
	}

	
	
//	metodos
	
	public int  VerificarQuantidadePlanetasPosicaoNorte(ArrayList<Planetas> planetas) {
		int PlanetasNoNorte = 0;
		for (int i = 0; i < planetas.size(); i++) {
			if (planetas.get(i).posicaoY > 10) {
				PlanetasNoNorte++;
			}
		}
		return PlanetasNoNorte;
	}

	public int  VerificarQuantidadePlanetasPosicaoSul(ArrayList<Planetas> planetas) {
		int PlanetasNoSul = 0;
		for (int i = 0; i < planetas.size(); i++) {
			if (planetas.get(i).posicaoY < 10) {
				PlanetasNoSul++;
			}
		}
		return PlanetasNoSul;
	}
	
	public int     VerificarExplosoes(ArrayList<Planetas> planetas) {
		int PlanetasExplodidos = 0;
		for (int i = 0; i < planetas.size(); i++) {
			if (planetas.get(i).getVelDeslocamento() == 0) {
				PlanetasExplodidos++;
				planetas.remove(i);
			}
		}
		return PlanetasExplodidos;
	}

	public void    VerificarColisoes(ArrayList<Planetas> planeta) {
		for (int i = 0; i < planeta.size(); i++) {
			for (int j = 0; j < bugsList.size(); j++) {
				if (planeta.get(i).posicaoX == bugsList.get(j).posicaoX
						&& planeta.get(i).posicaoY == bugsList.get(j).posicaoY) {
					planeta.get(i).setVelDeslocamento((planeta.get(i).getVelDeslocamento() - 1));
					planeta.get(i).setBugsColididos(planeta.get(i).getBugsColididos()+1);
					bugsList.remove(j);
				}
			}
		}

		for (int i = 0; i < planeta.size(); i++) {
			for (int j = 0; j < devsList.size(); j++) {
				if (planeta.get(i).posicaoX == devsList.get(j).posicaoX
						&& planeta.get(i).posicaoY == devsList.get(j).posicaoY) {
					planeta.get(i).setVelDeslocamento((planeta.get(i).getVelDeslocamento() + 1));
					planeta.get(i).setDevsColididos(planeta.get(i).getDevsColididos()+1);
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
		if (posicoes[0] == 10 && posicoes[1] == 10) {
			return false;
		}
		return true;
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

	public boolean VerificarAlinhamentoPlanetas(ArrayList<Planetas> planetas) {
		for (int i = 0; i < planetas.size(); i++) {
			if (planetas.get(i).posicaoX != 10 || planetas.get(i).posicaoY != (10 + (i + 1))) {
				AlinhamentoSuperiorVertical = false;
			}
			if (planetas.get(i).posicaoX != planetas.get(i).getLimiteminX()
					|| planetas.get(i).posicaoY != planetas.get(i).getLimitemaxY()) {
				AlinhamentoSuperiorEsquerdo = false;
			}
			if (planetas.get(i).posicaoX != planetas.get(i).getLimiteminX()
					|| planetas.get(i).posicaoY != planetas.get(i).getLimiteminY()) {
				AlinhamentoInferiorEsquerdo = false;
			}
			if (planetas.get(i).posicaoX != 10 || planetas.get(i).posicaoY != (10 - (i + 1))) {
				AlinhamentoInferiorVertical = false;
			}
			if (planetas.get(i).posicaoX != planetas.get(i).getLimitemaxX()
					|| planetas.get(i).posicaoY != planetas.get(i).getLimiteminY()) {
				AlinhamentoInferiorDireito = false;
			}
			if (planetas.get(i).posicaoX != planetas.get(i).getLimitemaxX()
					|| planetas.get(i).posicaoY != planetas.get(i).getLimitemaxY()) {
				AlinhamentoSuperiorDireito = false;
			}
		}
		if (AlinhamentoSuperiorVertical || AlinhamentoSuperiorEsquerdo || AlinhamentoInferiorEsquerdo
				|| AlinhamentoInferiorVertical || AlinhamentoInferiorDireito || AlinhamentoSuperiorDireito) {
			return true;
		}

			return false;
	}

}
