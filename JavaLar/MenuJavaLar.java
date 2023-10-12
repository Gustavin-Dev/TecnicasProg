package JavaLar;

import java.util.Scanner;

public class MenuJavaLar {

	public MenuJavaLar() {
		
		SistemaPlanetas    sistema   = new SistemaPlanetas();
		Scanner 		   scanner   = new Scanner(System.in);
		QuestaoBonus       questaoB  = new QuestaoBonus();
		Impressoes         imprimir  = new Impressoes();
		Relatorio          relatorio = new Relatorio();  
		FuncoesPlanetarias FuncoesPlanetarias = new FuncoesPlanetarias();
	
		String respostaEventoEspecial = "";
		String respostaMenuNovamente;
		
		boolean EventoAlinhamentoPlanetas;
		boolean condicaoBugsAndDevs;
		
		int instantes;
		int quantidadeDevs;
		int quantidadeBugs;
		int quantidadeMaximaBugsAndDevs = 210;
		int quantidadeBugsAndDevsUsuario;
		int quantidadeBugsAndDevsUsuarioTotais=0;
		int rodada = 1;

//		instanciando os planetas
		C          c          = new C        (10, 17, "C");
		PHP        php        = new PHP      (10, 14, "Php");
		JAVA       java       = new JAVA();
		Ruby       ruby       = new Ruby     (10, 13, "Ruby");
		CplusPlus  cplus      = new CplusPlus(10, 16, "C++");
		Phyton     phyton     = new Phyton   (10, 11, "Phyton");
		CSharp     csharp     = new CSharp   (10, 15, "Csharp");
		JavaScript javascript = new JavaScript(10, 12, "JavaScript");

//		adcionando os planetas no ArrayList do sistema
		sistema.planetas.add(phyton);
		sistema.planetas.add(javascript);
		sistema.planetas.add(ruby);
		sistema.planetas.add(php);
		sistema.planetas.add(csharp);
		sistema.planetas.add(cplus);
		sistema.planetas.add(c);
		
		System.out.println("Ola! Seja bem vindo ao sistema JavaLar!");
		
		DesejaVerPosicoesIniciais(sistema, scanner, imprimir);
		
		
		do {
			System.out.println("\nRodada " + rodada  + "!");
			
			do {
				System.out.println("Quantos instantes voce deseja? Detalhe: cada instante corresponde a 24h no sistema JavaLar");
				instantes = scanner.nextInt();
			
				if(instantes < 0) {
				System.out.println("Infelizmente nosso sistema Javalar nao consegue voltar no tempo ainda :/ Insira um instante nao negativo por favor!");
				}
			}while(instantes < 0);
			sistema.setInstantesTotais(sistema.getInstantesTotais() + instantes ) ;
			
			do {
			condicaoBugsAndDevs = false;
			quantidadeBugsAndDevsUsuario = 0;
				
			System.out.println("Quantos Bugs voce deseja no sistema?");
			quantidadeBugs = scanner.nextInt();
			quantidadeBugsAndDevsUsuario += quantidadeBugs;
			
			System.out.println("Agora quantos Devs?");
			quantidadeDevs = scanner.nextInt();
			quantidadeBugsAndDevsUsuario += quantidadeDevs;
			
			if(quantidadeBugsAndDevsUsuario + quantidadeBugsAndDevsUsuarioTotais >= quantidadeMaximaBugsAndDevs ) {
				condicaoBugsAndDevs = true;
				System.out.println("numero maximo de bugs e devs atingido! insira novos numeros, por favor!");
			}else{
			quantidadeBugsAndDevsUsuarioTotais += quantidadeBugsAndDevsUsuario;
			}
			
			}while(condicaoBugsAndDevs);
			
			
			ContabilizarDados(sistema, FuncoesPlanetarias, instantes, quantidadeDevs, quantidadeBugs);
			sistema.quantidadePlanetasExplodidos += sistema.VerificarExplosoes(sistema.planetas);
			EventoAlinhamentoPlanetas = sistema.VerificarAlinhamentoPlanetas(sistema.planetas);
			
			
			System.out.println("Okay! Os dados ja foram contabilizados, vamos mostrar os dados agora de acordo com sua preferencia!");
			System.out.print("\n");
			
			
			if(EventoAlinhamentoPlanetas) {
				System.out.println("Temos um evento especial no nosso sistema JavaLar! Deseja ver?");
				respostaEventoEspecial = scanner.next();
			}
			
			AlinhamentoPlanetas(sistema, respostaEventoEspecial);

			VerPosicoesPlanetas(sistema, scanner, imprimir);
			
			QuestaoExtraArea(sistema, scanner, questaoB);

			VerDistanciaAtuaisPlanetas(FuncoesPlanetarias,sistema, scanner);
			
			VerPosicoesBugsAndDevs(sistema, scanner, imprimir);
			
			VerPlanetasNorteSul(sistema, scanner);
			
			
			System.out.println("Deseja rodar novamente?");
			respostaMenuNovamente = scanner.next();
			if (respostaMenuNovamente.equalsIgnoreCase("sim") || respostaMenuNovamente.equalsIgnoreCase("s")) {
				rodada++;
			}
		
		
		}while (respostaMenuNovamente.equalsIgnoreCase("sim") || respostaMenuNovamente.equalsIgnoreCase("s") );
		
		
		System.out.println("Obrigado por ter experimentado nosso sistema Javalar!");
		VerRelatorio(sistema, scanner, relatorio);
		
		
		System.out.println("\nFim do sistema! :)");
		
		}


	private void VerRelatorio(SistemaPlanetas sistema, Scanner scanner, Relatorio relatorio) {
		String respostaRelatorio;
		System.out.println("\nTemos um relatorio com um panorama geral do que rolou, deseja ver?");
		respostaRelatorio = scanner.next();
		if(respostaRelatorio.equalsIgnoreCase("sim") || respostaRelatorio.equalsIgnoreCase("s"));{
				relatorio.ImprimirRelatorio(sistema);
		}
	}

	private void VerPlanetasNorteSul(SistemaPlanetas sistema, Scanner scanner) {
		String respostaPlanetasNorteSul;
		System.out.println("Deseja ver a quantidade de Planetas ao Norte e ao Sul de Java?");
		respostaPlanetasNorteSul =  scanner.next();
		if(respostaPlanetasNorteSul.equalsIgnoreCase("sim") || respostaPlanetasNorteSul.equalsIgnoreCase("s")) {
			System.out.print("\n");
			System.out.println("Planetas no Norte: " + sistema.VerificarQuantidadePlanetasPosicaoNorte(sistema.planetas));
			System.out.println("Planetas no Sul: " + sistema.VerificarQuantidadePlanetasPosicaoSul(sistema.planetas));
			System.out.print("\n");
		}
	}

	private void VerPosicoesBugsAndDevs(SistemaPlanetas sistema, Scanner scanner, Impressoes imprimir) {
		String respostaDevsAndBugs;
		System.out.println("Deseja ver as posicoes dos bugs e devs?");
		respostaDevsAndBugs = scanner.next();
		if(respostaDevsAndBugs.equalsIgnoreCase("sim") || respostaDevsAndBugs.equalsIgnoreCase("s")) {
			imprimir.ImprimirBugsAndDevs(sistema.bugsList, sistema.devsList);
		}
	}

	private void VerDistanciaAtuaisPlanetas(FuncoesPlanetarias FuncoesPlanetarias, SistemaPlanetas sistema, Scanner scanner) {
		String respostaDistanciasAtuais;
		System.out.println("Deseja ver as distancias atuais dos planeta?");
		respostaDistanciasAtuais = scanner.next();
		if (respostaDistanciasAtuais.equalsIgnoreCase("sim") || respostaDistanciasAtuais.equalsIgnoreCase("s")) {
			System.out.print("\n");
			System.out.println("distancia por area:");
			FuncoesPlanetarias.VerificarDistanciaAreaPTodos(sistema.planetas);
			System.out.println("Agora a distancia javaclidiana:");
			FuncoesPlanetarias.VerificarDistanciaEuclidianaPTodos(sistema.planetas);
			
		}
	}

	private void QuestaoExtraArea(SistemaPlanetas sistema, Scanner scanner, QuestaoBonus questaoB) {
		String respostaQuestaoBonus;
		System.out.println("Questao bonus: temos uma funcao a mais em nosso sistema!");
		System.out.println("\nDeseja ver a area da figura que nossos planetas formam usando suas posicoes como vertices dessa figura?");
		respostaQuestaoBonus = scanner.next();
		if (respostaQuestaoBonus.equalsIgnoreCase("sim") || respostaQuestaoBonus.equalsIgnoreCase("s")) {
			System.out.println("Area da figura formada pelos planetas do sistema e: " + questaoB.QuestaoExtra(sistema.planetas) + " JavaMetros quadrados");
		}
		System.out.print("\n");
	}

	private void VerPosicoesPlanetas(SistemaPlanetas sistema, Scanner scanner, Impressoes imprimir) {
		String respostaPosicoesAtuais;
		System.out.println("Deseja ver a situacao atual dos planetas?");
		respostaPosicoesAtuais = scanner.next();
		if (respostaPosicoesAtuais.equalsIgnoreCase("sim") || respostaPosicoesAtuais.equalsIgnoreCase("s")) {
			imprimir.ImprimirPlanetas(sistema.planetas);
			System.out.println("Quantidade de planetas explodidos: " + sistema.quantidadePlanetasExplodidos);
			System.out.print("\n");
		}
	}

	private void DesejaVerPosicoesIniciais(SistemaPlanetas sistema, Scanner scanner, Impressoes imprimir) {
		String respostaPosicoesIniciais;
		System.out.println("\nDeseja ver as posicoes iniciais dos planetas em nosso sistema?");
		respostaPosicoesIniciais = scanner.nextLine();
		if (respostaPosicoesIniciais.equalsIgnoreCase("sim") || respostaPosicoesIniciais.equalsIgnoreCase("s")) {
			imprimir.ImprimirPlanetasPosicoesIniciais(sistema.planetas);
			System.out.println("Ok! Vamos comecar agora!");
		}else {
			System.out.println("Ok! Vamos comecar agora!");
		}
	}
		
	private void ContabilizarDados(SistemaPlanetas sistema, FuncoesPlanetarias FuncoesPlanetarias, int instantes,
			int quantidadeDevs, int quantidadeBugs) {
		
			FuncoesPlanetarias.Mover(sistema.planetas, instantes);
			FuncoesPlanetarias.ContarDiasTodosPlanetas(sistema.planetas, instantes);
			FuncoesPlanetarias.ContarAnosTodosPlanetas(sistema.planetas, instantes);
			sistema.CriarBugs(quantidadeBugs);
			sistema.CriarDevs(quantidadeDevs);
			sistema.VerificarColisoes(sistema.planetas);
	}

	private void AlinhamentoPlanetas(SistemaPlanetas sistema, String respostaEventoEspecial) {
		
			if(respostaEventoEspecial.equalsIgnoreCase("sim") || respostaEventoEspecial.equalsIgnoreCase("s")) {
			
				  if(sistema.isAlinhamentoSuperiorVertical()) {
				System.out.println("Os planetas estao alinhados de maneira vertical acima de Java!");
			}else if(sistema.isAlinhamentoSuperiorEsquerdo()) {
				System.out.println("Os planetas estao alinhados na diagonal principal superior de Java!");
			}else if(sistema.isAlinhamentoInferiorEsquerdo()) {
				System.out.println("Os planetas estao alinhados na diagonal secundaria infeior de Java!");
			}else if(sistema.isAlinhamentoInferiorVertical()) {
				System.out.println("Os planetas estao alinhados de maneira vertical abixo de Java!");
			}else if(sistema.isAlinhamentoInferiorDireito()) {
				System.out.println("Os planetas estao alinhados na diagonal princial inferior de Java!");
			}else if(sistema.isAlinhamentoSuperiorDireito()) {
				System.out.println("Os planetas estao alinhados na diagonal secundaria superior de Java!");
			}
		}
	}
}
