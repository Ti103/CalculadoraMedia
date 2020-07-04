package br.com.tyti.desafio.media.screen;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.tyti.desafio.media.calculo.Media;
import br.com.tyti.desafio.media.dto.Aluno;
import br.com.tyti.desafio.media.util.file.Arquivo;

public class Principal {

	// Atributos Principal
	public int conf;
	public ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	public ArrayList<Double> notas = new ArrayList<Double>();
	public ArrayList<Integer> pesos = new ArrayList<Integer>();

	// Cadastra notas de alunos

	public void clear() {
		if (!notas.isEmpty()) {
			notas.clear();
		}
		if (!pesos.isEmpty()) {
			pesos.clear();
		}
	}
	
	public void sair() {
		JOptionPane.showMessageDialog(null, "Saindo");
		System.exit(0);
	}

	public void inputNome(Aluno a) {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome do aluno");

		if (nome.equals("")) {
			JOptionPane.showMessageDialog(null, "Saindo!");
			show();
			System.exit(0);
		}
		a.setNome(nome);
	}

	public void inputNota(Aluno a, int i) {
		String nota = JOptionPane.showInputDialog(null, "Digite a nota " + i + " de "+ a.getNome(), "Nota", JOptionPane.INFORMATION_MESSAGE);
		if (nota.equals("")) {
			nota = "0";
		}
		try {
			a.getNotas().add(Double.parseDouble(nota));
		} catch (NumberFormatException e) {
			a.getNotas().add(erroDouble(e, i));
		}
	}

	public void inputPeso(Aluno a, int i, int mod) {
		if (mod == JOptionPane.NO_OPTION) {
			String peso = JOptionPane.showInputDialog(null, "Digite o peso da nota " + i, "Peso",
					JOptionPane.INFORMATION_MESSAGE);

			if (peso.equals("")) {
				peso = "0";
			}

			try {
				a.getPesos().add(Integer.parseInt(peso));
			} catch (NumberFormatException e) {
				a.getPesos().add(erroInt(e, i));
			}
		}
	}

	public boolean outraNota() {
		String confOp[] = { "Sim", "Não" };
		int conf = JOptionPane.showOptionDialog(null, "Deseja adicionar mais uma nota?", "Continuar?",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, confOp, JOptionPane.YES_OPTION);

		return conf == JOptionPane.NO_OPTION;
	}

	public boolean outroAluno() {
		String confOp[] = { "Sim", "Não" };
		conf = JOptionPane.showOptionDialog(null, "Deseja adicionar mais um aluno?", "Continuar?",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, confOp, null);

		return conf == JOptionPane.YES_OPTION;
	}

	public void cadastrarAluno(int mod) {
		do {
			clear();

			Aluno a = new Aluno();
			inputNome(a);

			for (int i = 1; i > 0; i++) {

				inputNota(a, i);
				inputPeso(a, i, mod);

				if (outraNota()) {
					break;
				}
			}

			calcularMedia(mod, a);
			alunos.add(a);

		} while (outroAluno());

	}

	public int erroInt(NumberFormatException e, int i) {
		JOptionPane.showMessageDialog(null, "Valor inválido!");

		String peso = JOptionPane.showInputDialog(null, "Digite um valor numérico válido pro peso " + i, "Peso",
				JOptionPane.INFORMATION_MESSAGE);

		try {
			return Integer.parseInt(peso);
		} catch (NumberFormatException f) {
			return erroInt(f, i);
		}
	}

	public double erroDouble(NumberFormatException e, int i) {
		JOptionPane.showMessageDialog(null, "Valor inválido");

		String peso = JOptionPane.showInputDialog(null, "Digite um valor numérico válido pra nota " + i, "Peso",
				JOptionPane.INFORMATION_MESSAGE);

		try {
			return Double.parseDouble(peso);
		} catch (NumberFormatException f) {
			return erroDouble(f, i);
		}
	}

	// Calcula a media
	public void calcularMedia(int mod, Aluno a) {
		Media media = new Media();
		if (mod == JOptionPane.YES_OPTION) {
			media.aritmetica(a.getNotas(), a);
		} else {
			media.ponderada(a.getNotas(), a.getPesos(), a);
		}
	}

	// Mostra os alunos, suas notas e medias
	public void show() {
		String texto = "";
		for (int i = 0; i < alunos.size(); i++) {
			texto += (alunos.get(i).toString());
		}

		JOptionPane.showMessageDialog(null, texto);

		String options[] = {"Salvar", "Não Salvar"};
		int save = JOptionPane.showOptionDialog(null, "Deseja salvar lista em alunos . txt?", "Salvar", JOptionPane.YES_NO_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, null, options, null);
		
		if(save == JOptionPane.YES_OPTION) {	
			if (Arquivo.write(texto)) {
				JOptionPane.showMessageDialog(null, "Lista de alunos salva com sucesso em alunos.txt");
			} else {
				JOptionPane.showMessageDialog(null, "Erro, otário");
			}
		}else {
			
		}
	}
}