package Controll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LerArquivos {

	private  ArrayList<Integer> InstantesPhyton;
	private  ArrayList<Integer> InstantesJavaScript;
	private  ArrayList<Integer> InstantesRuby;
	private  ArrayList<Integer> InstantesPHP;
	private  ArrayList<Integer> InstantesCsharp;
	private  ArrayList<Integer> InstantesCplusplus;
	private  ArrayList<Integer> InstantesC;
	private  ArrayList<Integer> Bugs;
	private  ArrayList<Integer> Devs;
	private  ArrayList<ArrayList<Integer>> InstantesAllPlanets;
	
	private String   line;
	private String[] Conteudo;
	private boolean  verificador = false;

	public LerArquivos(int a) {
		String path;
		
		      if(a==10) {
			path = "C:\\Users\\henri\\faculdade\\tecnicas\\Trabalho2\\arquivosInstantes\\AE_10.csv";
		}else if (a==50) {
			path = "C:\\Users\\henri\\faculdade\\tecnicas\\Trabalho2\\arquivosInstantes\\AE_50.csv";
		}else if (a==100) {
			path = "C:\\Users\\henri\\faculdade\\tecnicas\\Trabalho2\\arquivosInstantes\\AE_100.csv";
		}else if (a==500) {
			path = "C:\\Users\\henri\\faculdade\\tecnicas\\Trabalho2\\arquivosInstantes\\AE_500.csv";
		}else if (a==1500) {
			path = "C:\\Users\\henri\\faculdade\\tecnicas\\Trabalho2\\arquivosInstantes\\AE_1500.csv";
		}else if (a==2000){
			path = "C:\\Users\\henri\\faculdade\\tecnicas\\Trabalho2\\arquivosInstantes\\AE_2000.csv";
		}else {
			path = "";
		}
		
		
		
		InstantesPhyton     = new ArrayList<Integer>();
		InstantesJavaScript = new ArrayList<Integer>();
		InstantesRuby       = new ArrayList<Integer>();
		InstantesPHP        = new ArrayList<Integer>();
		InstantesCsharp     = new ArrayList<Integer>();
		InstantesCplusplus  = new ArrayList<Integer>();
		InstantesC          = new ArrayList<Integer>();
		Bugs                = new ArrayList<Integer>();
		Devs                = new ArrayList<Integer>();
		
		InstantesAllPlanets = new ArrayList<ArrayList<Integer>>();
		
		InstantesAllPlanets.add(InstantesPhyton);
		InstantesAllPlanets.add(InstantesJavaScript);
		InstantesAllPlanets.add(InstantesRuby);
		InstantesAllPlanets.add(InstantesPHP);
		InstantesAllPlanets.add(InstantesCsharp);
		InstantesAllPlanets.add(InstantesCplusplus);
		InstantesAllPlanets.add(InstantesC);
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			line = br.readLine();
			while (line != null) {
				
				if(verificador) {
				Conteudo = line.split(",");
			
				InstantesPhyton.add(Integer.parseInt(Conteudo[1]));
				InstantesJavaScript.add(Integer.parseInt(Conteudo[2]));
				InstantesRuby.add(Integer.parseInt(Conteudo[3]));
				InstantesPHP.add(Integer.parseInt(Conteudo[4]));
				InstantesCsharp.add(Integer.parseInt(Conteudo[5]));
				InstantesCplusplus.add(Integer.parseInt(Conteudo[6]));
				InstantesC.add(Integer.parseInt(Conteudo[7]));
				Bugs.add(Integer.parseInt(Conteudo[8]));
				Devs.add(Integer.parseInt(Conteudo[9]));
				
				}
				
				line = br.readLine();
				verificador = true;
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public ArrayList<ArrayList<Integer>> getInstantesAllPlanets() {
		return InstantesAllPlanets;
	}

	public ArrayList<Integer> getInstantesPhyton() {
		return InstantesPhyton;
	}

	public ArrayList<Integer> getInstantesJavaScript() {
		return InstantesJavaScript;
	}

	public ArrayList<Integer> getInstantesRuby() {
		return InstantesRuby;
	}

	public ArrayList<Integer> getInstantesPHP() {
		return InstantesPHP;
	}

	public ArrayList<Integer> getInstantesCsharp() {
		return InstantesCsharp;
	}

	public ArrayList<Integer> getInstantesCplusplus() {
		return InstantesCplusplus;
	}

	public ArrayList<Integer> getInstantesC() {
		return InstantesC;
	}

	public ArrayList<Integer> getBugs() {
		return Bugs;
	}

	public ArrayList<Integer> getDevs() {
		return Devs;
	}
}
