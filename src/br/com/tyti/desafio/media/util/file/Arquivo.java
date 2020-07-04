package br.com.tyti.desafio.media.util.file;

public class Arquivo {
	
	public static boolean write(String texto) {
			DemoJFileChooser d = new DemoJFileChooser();
			d.createWindow(texto);
			
			return true;
	}
}