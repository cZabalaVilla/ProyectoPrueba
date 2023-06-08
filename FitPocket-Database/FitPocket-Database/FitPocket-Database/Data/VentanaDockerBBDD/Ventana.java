package ventanabd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ventana extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;

	public Ventana() {
		super("FitPocket Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		textArea = new JTextArea(20, 40);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);

		JButton boton1 = new JButton("Iniciar base de datos");
		boton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executeCommand("powershell.exe", "-file", "DockerRun.ps1");
			}
		});
		add(boton1, BorderLayout.NORTH);

		JButton boton2 = new JButton("Pushear y borrar contenedor base de datos");
		boton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executeCommand("powershell.exe", "-file", "DockerPush.ps1");
			}
		});
		add(boton2, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void executeCommand(String... command) {
		try {
			ProcessBuilder pb = new ProcessBuilder(command);
			pb.directory(new File(".\\DockerScripts"));
			Process p = pb.start();
			String output = getOutput(p);
			textArea.setText(output);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar el comando: " + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private String getOutput(Process p) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		StringBuilder builder = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			builder.append(line);
			builder.append(System.getProperty("line.separator"));
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		new Ventana();
	}
}
