package Lista002;

public class utilidades {
	
	public double Somatorio(double vet[]) {
		double soma = 0;
		for (int i = 2; i <= vet.length - 2; i++) {
			soma += vet[i];
		}
		return soma;
	}

	public void NumerosPares(int a, int b) {
		if (a < b) {
			for (int numero1 = a; numero1 <= b; numero1++) {
				if (numero1 % 2 == 0) {
					System.out.print(numero1 + " ");
				}
			}

		} else if (b < a) {
			for (int numero2 = b; numero2 <= a; numero2++) {
				if (numero2 % 2 == 0) {
					System.out.print(numero2 + " ");
				}
			}
		}
	}

	public double Media(double vet[], double vet2[]) {
		double soma = 0;
		double media = 0;
		for (int i = 0; i < vet.length; i++) {
			vet[i] = i;
			soma += vet[i];
		}
		for (int i = 0; i < vet2.length; i++) {
			vet2[i] = i + 2;
			soma += vet2[i];
		}
		media = soma / (vet.length + vet2.length);
		return media;
	}

	public double Mediaponderaada(double vet[], double vet2[]) {
		int i = 0;
		double soma = 0;
		double media = 0;
		double peso = 0;
		for (i = 0; i < vet2.length; i++) {
			soma += vet[i] * vet2[i];

		}
		for (int j = 0; j < vet2.length; j++) {
			peso += vet2[j];
		}
		media = soma / peso;
		return media;
	}

	public double Contagem(double vet[], double vet2[], double a) {
		int contador = 0;
		for (int i = 0; i < vet.length; i++) {
			if (vet[i] == a)
				contador++;
		}
		for (int i = 0; i < vet2.length; i++) {
			if (vet2[i] == a)
				contador++;
		}
		return contador;
	}

	public void Copia(double vet[]) {
		double vet2[] = new double[vet.length];
		for (int i = 0; i < vet.length; i++) {
			vet2[i] = vet[i];
		}
		for (int i = 0; i < vet2.length; i++) {
			System.out.print(vet2[i] + " ");
		}
		System.out.println("\n");
	}

	public int[] Ordenacao(int vet[]) {
		int guarda = 0;
		for (int i = 0; i < vet.length; i++) {
			for (int j = 0; j < i; j++) {
				if (vet[i] < vet[j]) {
					guarda = vet[i];
					vet[i] = vet[j];
					vet[j] = guarda;
				}
			}
		}
		Printvetor(vet);

		return vet;
	}

	public int KesimoMaiorValor(int vet[], int k) {
		if (k > vet.length)
			System.out.println("numero maior que o tamanho do vetor.Invalido");
		else {
			int guarda = 0;
			for (int i = 0; i < vet.length; i++) {
				for (int j = 0; j < i; j++) {
					if (vet[i] < vet[j]) {
						guarda = vet[i];
						vet[i] = vet[j];
						vet[j] = guarda;
					}
				}
			}
		}
		return vet[(vet.length) - k];
	}

	public int KesimoMenorVelor(int vet[], int k) {
		if (k > vet.length)
			System.out.println("numero maior que o tamanho do vetor.Invalido");
		else {
			int guarda = 0;
			for (int i = 0; i < vet.length; i++) {
				for (int j = 0; j < i; j++) {
					if (vet[i] < vet[j]) {
						guarda = vet[i];
						vet[i] = vet[j];
						vet[j] = guarda;
					}
				}
			}
		}
		return (vet[k - 1]);
	}

	public boolean VerificacaoIgualdade(int vet[], int vet2[]) {
		boolean verificacao = true;
		if (vet.length != vet2.length) {
			verificacao = false;
		} else {
			for (int i = 0; i < vet.length; i++) {
				if (vet[i] != vet2[i])
					verificacao = false;
			}
		}
		return verificacao;
	}

	public double Potenciacao(int a, int b) {
		double resultado = 1;
		if (b == 0) {
			return resultado;
		}
		int numero1 = a;
		int numero2;
		for (numero2 = 1; numero2 < b; numero2++) {
			numero1 *= a;
		}
		resultado = numero1;
		return resultado;
	}

	public String Primo(int a) {
		int numero1 = a;
		int i = 2;
		boolean primo = true;
		do {
			if ((numero1 % i) == 0) {
				primo = false;
			}
			i++;

		} while (i <= numero1 / 2);
		if (primo == false) {
			return "nao eh primo";
		} else {
			return "eh primo";
		}

	}

	public int[] BuscaOcorrencia(int vet1[], int vet2[]) {
		int vet3[] = new int[MenorVetor(vet1, vet2)];
		if(vet1.length < vet2.length) {
		for (int i = 0; i < MenorVetor(vet1, vet2); i++) {
			for (int j = 0; j < MaiorVetor(vet1, vet2); j++) {
				if (vet1[i] == vet2[j]) {
					vet3[i] = vet1[i];
				}
			}
		}
		} else {
			for (int i = 0; i < MenorVetor(vet1, vet2); i++) {
				for (int j = 0; j < MaiorVetor(vet1, vet2); j++) {
					if (vet2[i] == vet1[j]) {
						vet3[i] = vet2[i];
					}
				}
			}
		}
		for (int i = 0; i < vet3.length; i++) {
			for (int j = (i +1); j < vet3.length; j++) {
				if(vet3[i] == vet3[j])
					vet3[i] = 0;
			}
		}
		int vet4[] = OrdenacaoSemPrint(vet3);
		return vet4;

	}

	public int[] RemocaoElemento(int vet[],int num) {
		for (int i = 0; i < vet.length; i++) {
			if(vet[i] == num) {
				vet[i] = 0;
			}
		}
		return vet;
	}

	public boolean palindromo(String string) {
		 String palavra = string;
		 palavra = new StringBuffer(palavra).reverse().toString();
		if(string.equalsIgnoreCase(palavra))
		return true;
		
		return false;
	}

	public boolean Eprimo(int a) {
		
		String verificacao = Primo(a);
		if(verificacao.equals("eh primo"))
			return true;
		
		return false;
	}

	public  String InversaoString(String texto) {
		String palavra;
		palavra = new StringBuffer(texto).reverse().toString();
		
		return palavra;
	}

	public double Juroscompostos(double capital, double taxa, double periodos) {
		
		double montante;
		double somaInterna = (1 + taxa);
		double exponencial = PotenciacaoDouble(somaInterna,periodos);
		montante = capital*exponencial;
		
		return montante;
		
	}

	public boolean NumeroPft(int a) {
		int somatorio=0;
		for (int i = (a-1); i > 0; i--) {
			if(a%i == 0)
				somatorio += i;
		}
		if(somatorio == a)
		return true;
		
		return false;
	}

	public int[]   DecrescimentoVetor(int a) {
		int tam = a;
		for (int i = a; i >= 1; i--) {
			tam = i;
		}
		int vet[] = new int[tam];
		for (int i = 0; i < vet.length; i++) {
			vet[i] = i+21*4;
		}
		return vet;
	}

	public void MatrizA(int num){
		String[][] matriz = new String[num][num];
		int i=0;
		int j=0;
		for ( i = 0; i < num; i++) {
			for ( j = 0; j < num; j++) {
				matriz[i][j] = ""+ i;
			}
		}
		PrintMatriz(matriz);
		
	}
	
	public void MatrizB(int num) {
		String[][] matriz = new String[num][num];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if(i%2==0) {
					if(j%2==0)
						matriz[i][j] = "@";
					else 
						matriz[i][j] = "*";
				}else {
					if(j%2==0)
						matriz[i][j] = "*";
					else 
						matriz[i][j] = "@";
				}
			}
		}
		PrintMatriz(matriz);
	}

	public void MatrizC(int num) {
		String matriz[][] = new String[num][num];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				
//				if(j==2) 
//					matriz[i][j] = "@";
				if(j == 0 || j==4)	
					matriz[i][j] = ""+(j + (num-(j+1)));
				
				if(j == 1 || j==3)
					matriz[i][j] = "" + i;
				if(i==2 || j==2)
					matriz[i][j] = "@";
			}
		}
		
		PrintMatriz(matriz);
	}
	public void PrintMatriz(String[][] matriz) {
		System.out.println("\n");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[j][i] + "  ");
			}
			System.out.print("\n");
		}
	}
	
	public double PotenciacaoDouble(double a, double b) {
		double resultado = 1;
		if (b == 0) {
			return resultado;
		}
		double numero1 = a;
		double numero2;
		for (numero2 = 1; numero2 < b; numero2++) {
			numero1 *= a;
		}
		resultado = numero1;
		return resultado;
	}

	public int[] OrdenacaoSemPrint(int vet[]) {
		int guarda = 0;
		for (int i = 0; i < vet.length; i++) {
			for (int j = 0; j < i; j++) {
				if (vet[i] < vet[j]) {
					guarda = vet[i];
					vet[i] = vet[j];
					vet[j] = guarda;
				}
			}
		}
		return vet;
	}
	
	public void PrintVetSem0(int vet[]) {
		System.out.print("{");
		for (int i = 0; i < vet.length; i++) {
			if (vet[i] == 0)
				continue;
			if (i == (vet.length - 1)) {
				System.out.print(vet[i]);
			} else {
				System.out.print(vet[i]);
				System.out.print(",");
			}

		}
		System.out.print("}" + "\n");
	}

	public void Printvetor(int vet[]) {
		System.out.print("{");
		for (int i = 0; i < vet.length; i++) {
			if (i == (vet.length - 1)) {
				System.out.print(vet[i]);
			} else
				System.out.print(vet[i] + ",");
		}
		System.out.print("}");
	}

	public int MenorVetor(int vet1[], int vet2[]) {
		int a = 0;
		if (vet1.length > vet2.length) {
			a = vet2.length;
		} else {
			a = vet1.length;
		}

		return a;
	}

	public int MaiorVetor(int vet1[], int vet2[]) {
		int a = 0;
		if (vet1.length > vet2.length) {
			a = vet1.length;
		} else {
			a = vet2.length;
		}
		return a;
	}
}
