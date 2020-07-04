package br.com.tyti.desafio.media;

import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
	
	public static boolean write(String texto) {
		try {
			FileWriter arq = new FileWriter("alunos.txt");
			arq.write(texto);
			arq.close();
			return true;
		}catch(IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
}
