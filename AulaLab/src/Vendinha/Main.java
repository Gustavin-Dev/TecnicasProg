package Vendinha;

import java.util.Scanner;

public class Main {

	public static boolean decidirAdicional(String adicional) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("voce deseja adicionar " + adicional + "?");
		String decisao = scanner.nextLine();

		if (decisao.equalsIgnoreCase("sim"))
			return true;
		else
			return false;
	}

	public static Aluno criarAluno() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("qual seu nome?");
		String nome = scanner.nextLine();
		System.out.println("qual a sua matricula?");
		int matricula = scanner.nextInt();

		return new Aluno(nome, matricula);
	}

	public static CachorroQuente criarCachorroQuente() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("qual a proteina de sua escolha? (salsisha,frango,linguica ou bacon");
		String proteina = scanner.nextLine();
		System.out.println("qual o queijo? (mussarela,prato,parmesao ou coalho");
		String quiejo = scanner.nextLine();
		System.out.println("qual a bebida? (coca, del rio ou suco do chaves");
		String bebida = scanner.nextLine();
		boolean temMaionese = decidirAdicional("maionese");
		boolean temOvo = decidirAdicional("ovo");
		boolean temKetchup = decidirAdicional("ketchup");
		boolean temBatataFrita = decidirAdicional("batata frita");

		return new CachorroQuente(proteina, quiejo, bebida, temMaionese, temKetchup, temOvo, temBatataFrita);

	}

	public static void imprimirPedido(Pedido pedido) {
		System.out.println("informacoes do cliente:");
		System.out.println("nome: " + pedido.aluno.nome);
		System.out.println("matricula: " + pedido.aluno.matricula);
		System.out.println("\ninformacoes do pedido:");
		for (int i = 0; i < pedido.cachorrosQuentes.length; i++) {
			System.out.println("cachorro quente n: " + (i + 1));
			System.out.println("proteina: " + pedido.cachorrosQuentes[i].proteina);
			System.out.println("queijo: " + pedido.cachorrosQuentes[i].queijo);
			System.out.println("bebida: " + pedido.cachorrosQuentes[i].bebida);
			System.out.print("adicionais: " );
			if(pedido.cachorrosQuentes[i].temMaionese)
				System.out.print("maionese; ");
			if(pedido.cachorrosQuentes[i].temOvo)
				System.out.print("ovo; ");
			if(pedido.cachorrosQuentes[i].temBatataFrita)
				System.out.print("batata frita; ");
			if(pedido.cachorrosQuentes[i].temKetchup)
				System.out.print("ketchup; ");
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("ola! bem-vindo a vendinha");
		Aluno aluno = criarAluno();
		System.out.println("qunatos cachorros quentes voce quer comprar?");
		int quantidadeCachorrosQuentes = scanner.nextInt();
		CachorroQuente cachorrosQuentes[] = new CachorroQuente[quantidadeCachorrosQuentes];
		for (int i = 0; i < cachorrosQuentes.length; i++) {
			System.out.println("cachorro quente n: " + (i + 1));
			cachorrosQuentes[i] = criarCachorroQuente();
		}
		Pedido pedido = new Pedido(aluno,cachorrosQuentes);
		imprimirPedido(pedido);
		System.out.println("encerrando pedido");
	}

}
