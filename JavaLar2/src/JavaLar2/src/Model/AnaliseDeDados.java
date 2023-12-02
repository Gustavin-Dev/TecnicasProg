package Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnaliseDeDados  {

	private String[] planetas = { "python", "javascript", "ruby", "php", "cSharp", "cPlusPlus", "C" };
	private String AlunoMaisInstantes;
	private String PlanetaQueMaisMorreu;
	private String PlanetaMaisVida;
	private String QuadranteMaisBugs;
	private String QuadranteMaisDevs;
	private String QuantidadeInstantesTurma;
	private String[] MediaVelocidadePlanetas = new String[7];
	private String QuantidadeBugs;
	private String QuantidadeDevs;
	private String Allhours;
	private String AllYears;
	private ArrayList<String> Respostas = new ArrayList<String>();

	public AnaliseDeDados(ArrayList<String[]> dados) throws SQLException, IOException {

		AlunoComMaisInserts(dados);
		VerificarPlanetaMaisMorreu(dados);
		VerificarMaiorSobrevivente(dados);
		AnalisarQuandranteBugs(dados);
		AnalisarQuadrantetDevs(dados);
		analisarQuantInserts(dados);
		calcularMediaVelocidade(dados);
		calcularTotalBugs(dados);
		calcularTotalDevs(dados);
		calcularTotalHoras(dados);
		calcularTotalAnos(dados);
		
		Respostas.add(AlunoMaisInstantes);
		Respostas.add(PlanetaQueMaisMorreu);
		Respostas.add(PlanetaMaisVida);
		Respostas.add(QuadranteMaisBugs);
		Respostas.add(QuadranteMaisDevs);
		Respostas.add(QuantidadeInstantesTurma);
		
		for (int i = 0; i < MediaVelocidadePlanetas.length; i++) {
			Respostas.add(MediaVelocidadePlanetas[i]);
		}
		
		Respostas.add(QuantidadeBugs);
		Respostas.add(QuantidadeDevs);
		Respostas.add(Allhours);
		Respostas.add(AllYears);
		
	}
	
	public void ArquivoDeSaida() throws IOException {
		String caminho = "C:\\Users\\henri\\faculdade\\tecnicas\\Trabalho2\\arquivosSaida";
		Path path = Path.of(caminho);
		
		if(Files.notExists(path)) {
		Files.createFile(path);
		}
		for (int i = 0; i < Respostas.size(); i++) {
			Files.writeString(path,Respostas.get(i) + ",");
		}
	}
	
	public void AlunoComMaisInserts(ArrayList<String[]> dados) {
		ArrayList<Integer> matricula = new ArrayList<>();

		for (int i = 0; i < dados.size(); i++) {
			String[] vetorAux = dados.get(i);

			if (vetorAux[1] != null) {
				matricula.add(Integer.parseInt(vetorAux[1]));
			}
		}

		int maxFrequencia = 0;
		int matriculaMaisFrequente = 0;

		for (int i = 0; i < matricula.size(); i++) {
			int matriculaAtual = matricula.get(i);
			int frequenciaAtual = 1;

			for (int j = i + 1; j < matricula.size(); j++) {
				if (matriculaAtual == matricula.get(j)) {
					frequenciaAtual++;
				}
			}

			if (frequenciaAtual > maxFrequencia) {
				maxFrequencia = frequenciaAtual;
				matriculaMaisFrequente = matriculaAtual;
			}
		}

		for (int i = 0; i < dados.size(); i++) {

			String[] vetAux = dados.get(i);

			if (Integer.parseInt(vetAux[1]) == matriculaMaisFrequente) {
				String[] nomeAndMatricula = { vetAux[0], vetAux[1] };
				AlunoMaisInstantes = nomeAndMatricula[0] + nomeAndMatricula[1];
			}
		}
	}
	
	public void VerificarPlanetaMaisMorreu(ArrayList<String[]> dados) {

		int[] QuantidadeMortes = new int[7];
		
		for (int i = 0; i < dados.size(); i++) {

			String[] Aux = dados.get(i);

			for (int j = 0; j < 7; j++) {

				if (Integer.parseInt(Aux[j + 17]) == 0)
					QuantidadeMortes[j]++;
			}
		}

		
		int indice = QuantidadeMortes[0];
		
		for (int i = 1; i < QuantidadeMortes.length; i++) {
			if (QuantidadeMortes[i] > indice) {
				indice =i;
			}
		}

		

		PlanetaQueMaisMorreu = planetas[indice];
	}

	public void VerificarMaiorSobrevivente(ArrayList<String[]> dados) {

		int[] quantidadeMortes = new int[7];
		for (int i = 0; i < dados.size(); i++) {

			String[] vetAux = dados.get(i);

			for (int j = 0; j < 7; j++) {

				if (Integer.parseInt(vetAux[j + 17]) == 0)
					quantidadeMortes[j]++;
			}
		}
		
		int posicaoMenor = 0;

		for (int i = 1; i < quantidadeMortes.length; i++) {
			if (quantidadeMortes[i] < quantidadeMortes[posicaoMenor]) {
				posicaoMenor = i;
			}
		}


		PlanetaMaisVida = planetas[posicaoMenor];

	}

	public void AnalisarQuandranteBugs(ArrayList<String[]> dados) {

		int[] bugsPorQuadrante = new int[4];

		for (int i = 0; i < dados.size(); i++) {

			String[] Aux = dados.get(i);

			for (int j = 0; j < 4; j++) {

				if (Aux[j + 38] != null)
					bugsPorQuadrante[j] += Integer.parseInt(Aux[38 + j]);
			}
		}

		int QuadranteBugs = bugsPorQuadrante[0];

		for (int i = 1; i < bugsPorQuadrante.length; i++) {
			if (bugsPorQuadrante[i] > QuadranteBugs) {
				QuadranteBugs = bugsPorQuadrante[i];
			}
		}
		QuadranteMaisBugs = String.valueOf(QuadranteBugs);
	}

	public void AnalisarQuadrantetDevs(ArrayList<String[]> dados) {

		int[] devsPorQuadrante = new int[4];

		for (int i = 0; i < dados.size(); i++) {

			String[] Aux = dados.get(i);

			for (int j = 0; j < 4; j++) {

				if (Aux[j + 42] != null)
					devsPorQuadrante[j] += Integer.parseInt(Aux[42 + j]);
			}
		}

		int QuadranteDevs = devsPorQuadrante[0];

		for (int i = 1; i < devsPorQuadrante.length; i++) {
			if (devsPorQuadrante[i] > QuadranteDevs) {
				QuadranteDevs = devsPorQuadrante[i];
			}
		}
		QuadranteMaisDevs = String.valueOf(QuadranteDevs);
	}

	public void analisarQuantInserts(ArrayList<String[]> dados) {

		String totalDeInserts = String.valueOf(dados.size());
		QuantidadeInstantesTurma = totalDeInserts;
	}

	public void calcularMediaVelocidade(ArrayList<String[]> dados) {
		
		String VelMediaPhyton;
		String VelMediaJavaScript;
		String VelMediaRuby;
		String VelMediaPhp;
		String VelMediaCsharp;
		String VelMediaCPlus;
		String VelMediaC;
		
		float[] planetas = new float[7];
		for (int i = 0; i < dados.size(); i++) {
			String[] vetAux = dados.get(i);

			for (int j = 0; j < 7; j++) {

				if (vetAux[j + 18] != null)
					planetas[j] += Integer.parseInt(vetAux[38 + j]);
				;
			}
		}

		for (int i = 0; i < planetas.length; i++) {

			planetas[i] = planetas[i] / dados.size();

		}
		
		VelMediaPhyton = String.valueOf(planetas[0]);
		VelMediaJavaScript = String.valueOf(planetas[1]);
		VelMediaRuby = String.valueOf(planetas[2]);
		VelMediaPhp = String.valueOf(planetas[3]);
		VelMediaCsharp = String.valueOf(planetas[4]);
		VelMediaCPlus = String.valueOf(planetas[5]);
		VelMediaC = String.valueOf(planetas[6]);
		
		MediaVelocidadePlanetas[0] = VelMediaPhyton;
		MediaVelocidadePlanetas[1] = VelMediaJavaScript;
		MediaVelocidadePlanetas[2] = VelMediaRuby;
		MediaVelocidadePlanetas[3] = VelMediaPhp;
		MediaVelocidadePlanetas[4] = VelMediaCsharp;
		MediaVelocidadePlanetas[5] = VelMediaCPlus;
		MediaVelocidadePlanetas[6] = VelMediaC;
	}

	public void calcularTotalBugs(ArrayList<String[]> dados) {

		int totalBugs = 0;
		for (int i = 0; i < dados.size(); i++) {

			String[] vetorAux = dados.get(i);

			for (int j = 0; j < 4; j++) {

				if (vetorAux[j + 38] != null)
					totalBugs += Integer.parseInt(vetorAux[38 + j]);
			}
		}
		QuantidadeBugs = String.valueOf( totalBugs);
	}

	public void calcularTotalDevs(ArrayList<String[]> dados) {

		int totalDevs = 0;
		for (int i = 0; i < dados.size(); i++) {

			String[] vetorAux = dados.get(i);

			for (int j = 0; j < 4; j++) {

				if (vetorAux[j + 42] != null)
					totalDevs += Integer.parseInt(vetorAux[42 + j]);
			}
		}

		QuantidadeDevs = String.valueOf(totalDevs);
	}

	public void calcularTotalHoras(ArrayList<String[]> dados) {

		long totalHoras = 0;
		for (int i = 0; i < dados.size(); i++) {
			String[] vetAux = dados.get(i);

			for (int j = 0; j < 7; j++) {

				if (vetAux[j + 25] != null)
					totalHoras += Integer.parseInt(vetAux[25 + j]);

			}
		}
		Allhours = String.valueOf( totalHoras);
	}

	public void calcularTotalAnos(ArrayList<String[]> dados) {

		long totalAnos = 0;
		for (int i = 0; i < dados.size(); i++) {
			String[] vetAux = dados.get(i);

			for (int j = 0; j < 7; j++) {

				if (vetAux[j + 32] != null)
					totalAnos += Integer.parseInt(vetAux[32 + j]);

			}
		}
		AllYears = String.valueOf( totalAnos);
	}
}