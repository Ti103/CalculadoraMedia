package br.com.tyti.desafio.media.dto;

import java.util.ArrayList;

public class Aluno {
	
	//Atributos
	private String nome;
	private ArrayList<Double> notas = new ArrayList<Double>();
	private ArrayList<Double> pesos = new ArrayList<Double>();
	private double media;
	private String situacao;
	
	public Aluno(String nome) {
		this.nome = nome;
	}

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

	public ArrayList<Double> getPesos() {
		return pesos;
	}

	public void setPesos(ArrayList<Double> pesos) {
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
	
	public void situacao(double corte) {
		if(media>=corte) {
			setSituacao("Aprovado :)");
		}else {
			setSituacao("Reprovado :(");
		}
	}
	
}