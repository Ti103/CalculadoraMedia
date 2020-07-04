package br.com.tyti.desafio.media.initialzer;

import javax.swing.JOptionPane;

import br.com.tyti.desafio.media.screen.Principal;
import br.com.tyti.desafio.media.screen.terms.Termos;

public class ApplicationInitializar {

	public static void main(String[] args) {
		Principal aux = new Principal();
		Termos t = new Termos();
		
		if (!t.termos()) {
			aux.sair();
		}

		String modOp[] = { "Média Aritmética", "Média Ponderada", "Sair" };

		int mod = JOptionPane.showOptionDialog(null, "Como você deseja calcular a média?", "modelo",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, modOp, null);

		if (mod == JOptionPane.CANCEL_OPTION) {
			aux.sair();
		}

		aux.cadastrarAluno(mod);
		aux.show();
	}
}
