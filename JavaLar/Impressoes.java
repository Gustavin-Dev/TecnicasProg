package JavaLar;

import java.util.ArrayList;

public class Impressoes {
	
	public void ImprimirPlanetas(ArrayList<Planetas> planetas) {
		for (int i = 0; i < planetas.size(); i++) {
			if(planetas.get(i).getVelDeslocamento() != 0) {
			System.out.println(planetas.get(i).getNome() + ": ");
			System.out.println("Posicao: {" + planetas.get(i).posicaoX + "," + planetas.get(i).posicaoY + "}");
			System.out.println("Dias passados: " + planetas.get(i).getDias());
			System.out.println("Anos passados: " + planetas.get(i).getAnos());
			
			System.out.println("Velocidade de translacao: " + planetas.get(i).getVelDeslocamento());
			System.out.print("\n");
			}
		}
		System.out.println("JAVA:");
		System.out.println("Posicao: " + "{10,10}");
		System.out.print("\n");

	}

	public void ImprimirPlanetasPosicoesIniciais(ArrayList<Planetas> planetas) {
		for (int i = 0; i < planetas.size(); i++) {
			System.out.println(planetas.get(i).getNome() + ": ");
			System.out.println("Posicao: {" + planetas.get(i).posicaoX + "," + planetas.get(i).posicaoY + "}");
			System.out.print("\n");
		}
		System.out.println("JAVA:");
		System.out.println("Posicao: " + "{10,10}");
		System.out.println("\n");

	}
	
	public void ImprimirDadosPlanetaRelatorio(ArrayList<Planetas> planetas, SistemaPlanetas sistema) {
		for (int j = 0; j < planetas.size(); j++) {
			System.out.println("Nome: " + planetas.get(j).getNome());
			System.out.println("Bugs colididos: " + planetas.get(j).getBugsColididos());
			System.out.println("Devs colididos: " + planetas.get(j).getDevsColididos());
			System.out.println("Velocidade de rotacao: " + planetas.get(j).getVelRotacao());
			System.out.println("Velocidade media de translacao: " + (planetas.get(j).getMovimentosDados() / sistema.getInstantesTotais()));
			System.out.println("Dias passados: " + planetas.get(j).getDias());
			System.out.println("Anos passados: " + planetas.get(j).getAnos());
			System.out.print("\n");
			System.out.println("Pequeno resumo do planeta linguagem: ");
			System.out.println(planetas.get(j).getResumoLinguagem());
			System.out.print("\n");
		}
	}
	
	public void ImprimirBugsAndDevs(ArrayList<Bugs> bugs, ArrayList<Devs> devs) {
		System.out.print("\n");
		System.out.println("posicoes dos bugs: ");
		for (int i = 0; i < bugs.size(); i++) {
			System.out.println("{" + bugs.get(i).posicaoX + "," + bugs.get(i).posicaoY + "}");
		}
		System.out.print("\n");
		System.out.println("posicoes dos devs");
		for (int i = 0; i < devs.size(); i++) {
			System.out.println("{" + devs.get(i).posicaoX + "," + devs.get(i).posicaoY + "}");
		}
		System.out.print("\n");

	}
}
