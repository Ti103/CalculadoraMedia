package br.com.tyti.desafio.media.in.scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	//Atributos Principal
	public static String nome, conf;
	public ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	public ArrayList<Double> notas = new ArrayList<Double>();
	public ArrayList<Integer> pesos = new ArrayList<Integer>();
	
	//Cadastra notas de alunos
	public void cadastrarAluno(String metodo) {
		Scanner in = new Scanner(System.in);
		
		do {
			
			if(!notas.isEmpty()) {
				notas.clear();
			}
			if(!pesos.isEmpty()) {
				pesos.clear();
			}
			
			System.out.print("Digite o nome do aluno: ");
			Aluno a = new Aluno();
			a.setNome(in.next());
			for(int i = 0; i >= 0; i++) {
				
				System.out.println("Digite a nota do aluno: ");
				a.getNotas().add(in.nextDouble());
				
				if(metodo.equals("p")) {
					System.out.println("Digite o peso da nota");
					a.getPesos().add(in.nextInt());				
				}
				
				System.out.println("Deseja continuar? (s/n)");
				conf = in.next();
				
				if(conf.equals("n")||conf.equals("N")) {
					break;
				}
				
			}
			
			//Cria aluno e coloca na lista
			
			calcularMedia(metodo, a);
			alunos.add(a);
		
			System.out.println("Deseja cadastrar outro aluno? (s/n)");
			conf = in.next();
			
			
		}while(conf.equals("s")||conf.equals("S"));
		
		in.close();
	}
	
	//Calcula a media
	public void calcularMedia(String modelo, Aluno a) {
		Media media = new Media();
		if(modelo.equals("a")) {
			media.aritmetica(a.getNotas(), a);
		}else {
			media.ponderada(a.getNotas(), a.getPesos(), a);
		}
	}
	
	//Mostra os alunos, suas notas e medias
	public void show(){
		String texto = "";
		for(int i = 0; i < alunos.size(); i++) {
			texto += (alunos.get(i).toString());
		}
		if(Arquivo.write(texto)) {
			System.out.println("Arquivo salvo com sussussussussussucesso");
		}else{
			System.out.println("Fracassou em salvar o arquivo");
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Principal aux = new Principal();
		System.out.println("Aritmetica ou Ponderada?(a/p)");
		String metodo = in.next();
		aux.cadastrarAluno(metodo);
		aux.show();
		in.close();
	}
}