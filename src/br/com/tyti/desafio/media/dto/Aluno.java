package br.com.tyti.desafio.media.dto;

import java.util.ArrayList;

public class Aluno {
	
	//Atributos
	private String nome;
	private ArrayList<Double> notas = new ArrayList<Double>();
	private ArrayList<Integer> pesos = new ArrayList<Integer>();
	private double media;
	private String situacao;
	
	

	//Getters e Setter
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public ArrayList<Double> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Double> notas) {
		this.notas = notas;
	}

	public ArrayList<Integer> getPesos() {
		return pesos;
	}

	public void setPesos(ArrayList<Integer> pesos) {
		this.pesos = pesos;
	}
	
	public void setMedia(double media) {
		this.media = media;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		String barrinha = "****************************************************";
		if(pesos.size() > 0) {
			return "| Nome: " + nome + " \n| Notas: " + notas + " \n| Pesos: " + pesos + " \n| Media: " + media + " \n| Situacao: "
					+ situacao + "\n"+barrinha+"\n";
		}else {
			return "| Nome: " + nome + " \n| Notas: " + notas + " \n| Media: " + media + " \n| Situacao: " + situacao + "\n"+barrinha+"\n";
		}
	}
	
	public void situacao() {
		if(media>=6) {
			setSituacao("Aprovado :)");
		}else {
			setSituacao("Reprovado :(");
		}
	}
	
}