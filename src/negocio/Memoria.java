package negocio;

import java.util.ArrayList;
import java.util.Iterator;

import Apresentacao.Display;

public class Memoria {

	private ArrayList<String> numerosParcela1;
	private ArrayList<String> numerosParcela2;
	private ArrayList<String> numeros;
	private String operador = "vazio";

	public Memoria() {
		numerosParcela1 = new ArrayList<String>();
		numerosParcela2 = new ArrayList<String>();
		numeros         = new ArrayList<String>();

	}

	public String getNumeros() {
		String resultado = "";

		for (String num : numeros) {
			resultado += "" + num;
		}
		return resultado;
	}

	public void setNumero(String numero) {
		numeros.add(numero);
	}

	public String getNumerosResultado() {
		ArrayList<String> resultado1 = new ArrayList<String>();
		ArrayList<String> resultado2 = new ArrayList<String>();
		String resultadoFinal = "0";
		Integer parcela1 = 0;
		Integer parcela2 = 0;
		int expoente = 0;

		for (String num : numerosParcela1) {
			resultado1.add(num);
		}
		
		numerosParcela2.remove(0);
		numerosParcela2.remove(numerosParcela2.size() - 1);

		for (String num2 : numerosParcela2) {
			resultado2.add(num2);
		}

		expoente = resultado1.size() - 1;
		parcela1 = AtribuirParcela(resultado1, parcela1, expoente);
		
		expoente = resultado2.size() - 1;
		parcela2 = AtribuirParcela(resultado2, parcela2, expoente);

		switch (operador) {
		case "+":
			resultadoFinal = "" + (parcela1 + parcela2);
			break;
		case "-":
			resultadoFinal = "" + (parcela1 - parcela2);
			break;
		case "*":
			resultadoFinal = "" + (parcela1 * parcela2);
			break;
		case "/":
			if(parcela2==0) {
				return "infinito :)";
			}else {
			resultadoFinal = "" + (parcela1 / parcela2);
			}
			break;
		}

		return resultadoFinal;
	}

	private Integer AtribuirParcela(ArrayList<String> resultado1, Integer parcela1, int expoente) {
		Double potencia;
		for (int i = 0; i < resultado1.size(); i++) {

			potencia = Math.pow(10, expoente);
			parcela1 += Integer.parseInt(resultado1.get(i)) * potencia.intValue();
			expoente--;
		}
		return parcela1;
	}

	public void setNumeroResultado(String numero) {

		switch (numero) {
		case "+":
			operador = numero;
			break;
		case "-":
			operador = numero;
			break;
		case "*":
			operador = numero;
			break;
		case "/":
			operador = numero;
			break;
		}

		if (operador.equalsIgnoreCase("vazio")) {
			numerosParcela1.add(numero);
		} else {
			numerosParcela2.add(numero);
		}

	}

	public void limpartudo() {
		numerosParcela1.clear();
		numerosParcela2.clear();
		operador = "vazio";
	}
	
}
