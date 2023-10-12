package JavaLar;

public class Relatorio {

	Impressoes imprimir = new Impressoes();
	int planetasExplodidos=0;
	
	public void ImprimirRelatorio(SistemaPlanetas sistema) {
		imprimir.ImprimirDadosPlanetaRelatorio(sistema.planetas, sistema);
		System.out.print("\n");
		planetasExplodidos = sistema.VerificarExplosoes(sistema.planetas);
		System.out.println("Planetas explodidos durante a excecussao: " + sistema.quantidadePlanetasExplodidos);
		System.out.print("\n");
		System.out.println("instantes totais solicitados pelo usuario: " + sistema.getInstantesTotais());
		System.out.print("\n");
	}
}
