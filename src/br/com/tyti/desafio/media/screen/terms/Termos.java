package br.com.tyti.desafio.media.screen.terms;

import javax.swing.JOptionPane;

public class Termos {
	String s = "<html><h1>...................................LEIA COM ATENÇÃO....................................</h1>"
			+ "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br><br>"
			+ "Ao digitar a nota, NÃO use virgulas pra decimais use o PONTO.<br><br>CUIDADO: pesos de notas e notas" + 
			" que não forem preenchidos serão consideradaos valor 0. <br><br>Se o nome não for preenchido, a operação será finalizada. "
			+ "Confira se o arquivo alunos.txt foi realmente salvo antes de fechar. <br><br>Não nos responsabilizaremos por "
			+ "burrice sua, então presta atenção!!!</html>";	
	
	public boolean termos() {
		String options[] = {"Li e aceito os termos de uso", "Li e não aceito os termos de uso"};
		
		int op = JOptionPane.showOptionDialog(null, s, "Termos de uso", JOptionPane.YES_NO_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, null, options, null);
		return op == JOptionPane.YES_OPTION;
	}
	
	
}
