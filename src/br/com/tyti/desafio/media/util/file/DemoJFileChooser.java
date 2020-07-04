package br.com.tyti.desafio.media.util.file;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DemoJFileChooser {
//	public String texto;
//	
//	public String getTexto() {
//		return texto;
//	}
//
//	public void setTexto(String texto) {
//		this.texto = texto;
//	}

//	public static void main(String[] args) {
//		DemoJFileChooser d = new DemoJFileChooser();
//		d.createWindow(d.texto);
//	}

	public void createWindow(String texto) {
		JFrame frame = new JFrame("Swing Tester");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createUI(frame, texto);
		frame.setSize(560, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void createUI(final JFrame frame, String texto) {
		JPanel panel = new JPanel();
		LayoutManager layout = new FlowLayout();
		panel.setLayout(layout);

		JButton button = new JButton("Buscar diretório");
		final JLabel label = new JLabel();

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int option = fileChooser.showOpenDialog(frame);
				if (option == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					File file2 = new File(file.getAbsolutePath() + "/alunos.txt");
					FileWriter arq;
					try {
						arq = new FileWriter(file2);
						arq.write(texto);
						arq.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//					label.setText("Folder Selected: " + file.getName());
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
					System.exit(0);
				} else {
					label.setText("Open command canceled");
				}
			}
		});

		panel.add(button);
		panel.add(label);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}
}