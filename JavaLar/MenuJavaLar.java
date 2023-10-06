package JavaLar;

import java.util.Scanner;

public class MenuJavaLar {

	public MenuJavaLar() {
		SistemaPlanetas sistema = new SistemaPlanetas();
		Scanner scanner = new Scanner(System.in);
		String respostaPosicoesIniciais;
		String respostaMenuNovamente;
		String respostaPosicoesAtuais;
		String respostaDistanciasAtuais;
		String respostaDevsAndBugs;
		String respostaPlanetasNorteSul;
		int instantes;
		int quantidadeDevs;
		int quantidadeBugs;
		int quantidadePlanetasExplodidos=0;
		int i = 0;

//			instanciando os planetas
		C          c          = new C        (10, 17, "C");
		PHP        php        = new PHP      (10, 14, "Php");
		JAVA       java       = new JAVA();
		Ruby       ruby       = new Ruby     (10, 13, "Ruby");
		CplusPlus  cplus      = new CplusPlus(10, 16, "C++");
		Phyton     phyton     = new Phyton   (10, 11, "Phyton");
		CSharp     csharp     = new CSharp   (10, 15, "Csharp");
		
		JavaScript javascript = new JavaScript(10, 12, "JavaScript");

//			adcionando os planetas no ArrayList do sistema
		sistema.planetas.add(c);
		sistema.planetas.add(php);
		sistema.planetas.add(ruby);
		sistema.planetas.add(cplus);
		sistema.planetas.add(phyton);
		sistema.planetas.add(csharp);
		sistema.planetas.add(javascript);

		System.out.println("Ola! Seja bem vindo ao sistema JavaLar!");
		System.out.println("Deseja ver as posicoes iniciais dos planetas em nosso sistema?");
		respostaPosicoesIniciais = scanner.nextLine();
		
		if (respostaPosicoesIniciais.equalsIgnoreCase("sim") || respostaPosicoesIniciais.equalsIgnoreCase("s")) {
			sistema.ImprimirPlanetasPosicoesIniciais(sistema.planetas);
			System.out.println("Ok! Vamos comecar agora!");
		}else {
			System.out.println("Ok! Vamos comecar agora!");
		}
		
		do {
			System.out.println("Rodada " + (i + 1) + "!");
			
			System.out.println("Quantos instantes voce deseja? Detalhe: cada instante corresponde a 24h no sistema JavaLar");
			instantes = scanner.nextInt();
			
			System.out.println("Entendido! E quantos Bugs voce deseja no sistema?");
			quantidadeBugs = scanner.nextInt();
			
			System.out.println("Ok! E agora quantos Devs?");
			quantidadeDevs = scanner.nextInt();
			
			sistema.MoverTodos(sistema.planetas, instantes);
			sistema.ContarDiasTodosPlanetas(sistema.planetas, instantes);
			sistema.ContarAnosTodosPlanetas(sistema.planetas, instantes);
			sistema.CriarBugs(quantidadeBugs);
			sistema.CriarDevs(quantidadeDevs);
			sistema.ChecarColisoes(sistema.planetas);
			quantidadePlanetasExplodidos = sistema.VerificarExplosoes(sistema.planetas);

			System.out.println("Deseja ver a situacao atual dos planetas?");
			respostaPosicoesAtuais = scanner.next();
			if (respostaPosicoesAtuais.equalsIgnoreCase("sim") || respostaPosicoesAtuais.equalsIgnoreCase("s")) {
				sistema.ImprimirPlanetas(sistema.planetas);
				System.out.println("Quantidade de planetas explodidos: " + quantidadePlanetasExplodidos);
			}

			System.out.println("Deseja ver as distancias atuais dos planeta?");
			respostaDistanciasAtuais = scanner.next();
			if (respostaDistanciasAtuais.equalsIgnoreCase("sim") || respostaDistanciasAtuais.equalsIgnoreCase("s")) {

				System.out.println("distancia por area:");
				sistema.DistanciaAreaPTodos(sistema.planetas);
				System.out.println("Agora a distancia javaclidiana:");
				sistema.DistanciaEuclidianaPTodos(sistema.planetas);
				
			}
			
			System.out.println("Deseja ver as posicoes dos bugs e devs?");
			respostaDevsAndBugs = scanner.next();
			if(respostaDevsAndBugs.equalsIgnoreCase("sim") || respostaDevsAndBugs.equalsIgnoreCase("s")) {
				sistema.ImprimirBugsAndDevs(sistema.bugsList, sistema.devsList);
			}
			
			System.out.println("Deseja ver a quantidade de Planetas ao Norte e ao Sul de Java?");
			respostaPlanetasNorteSul =  scanner.next();
			if(respostaPlanetasNorteSul.equalsIgnoreCase("sim") || respostaPlanetasNorteSul.equalsIgnoreCase("s")) {
				System.out.println("Planetas no Norte: " + sistema.ChecarPosicaoNorte(sistema.planetas));
				System.out.println("Planetas no Sul: " + sistema.ChecarPosicaoSul(sistema.planetas));
			}

			System.out.println("Deseja rodar novamente?");
			respostaMenuNovamente = scanner.next();
			if (respostaMenuNovamente.equalsIgnoreCase("sim") || respostaMenuNovamente.equalsIgnoreCase("s")) {
				i++;
			}
		} while (respostaMenuNovamente.equalsIgnoreCase("sim") || respostaMenuNovamente.equalsIgnoreCase("s") );
		
		System.out.println("Obrigado por ter experimentado nosso sistema Javalar!");
	}
}
