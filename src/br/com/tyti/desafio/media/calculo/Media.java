package br.com.tyti.desafio.media.calculo;

import java.util.ArrayList;

import br.com.tyti.desafio.media.dto.Aluno;

public class Media {
	double media = 0, corte;
	int peso = 0;
	
	public Media(double corte) {
		this.corte = corte;
	}

	// Calcula media aritmética
	public void aritmetica(ArrayList<Double> notas, Aluno a) {
		for(int i = 0; i < notas.size(); i++) {
			media += notas.get(i) / notas.size();
		}
		a.setMedia(media);
		a.situacao(corte);
	}

	public void setCorte(double corte) {
		this.corte = corte;
	}

	// Calcula media ponderada
	public void ponderada(ArrayList<Double> notas, ArrayList<Integer> pesos, Aluno a) {
		for(int i = 0; i < notas.size(); i++) {
			media += notas.get(i) * pesos.get(i);
		}
		for(int i = 0; i < pesos.size(); i++) {
			peso += pesos.get(i);
		}
		a.setMedia(media / peso);
		a.situacao(corte);
	}
}