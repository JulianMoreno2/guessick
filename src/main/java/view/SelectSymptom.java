package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import core.Initializer;

public class SelectSymptom {

	private JFrame frame;

	public static void NewWindow(Initializer initializer) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSymptom window = new SelectSymptom(initializer);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SelectSymptom(Initializer initializer) {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

}
