package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import core.Initializer;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JLabel lbl_presentation;
	private Initializer initializer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initializer = new Initializer();

		frame = new FrameBackground();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_presentation = new JLabel();
		lbl_presentation.setText("¡ Welcome to Guessick !");
		lbl_presentation.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
		lbl_presentation.setForeground(Color.black);
		lbl_presentation.setBounds(30, 0, 500, 250);
		lbl_presentation.setHorizontalTextPosition(JLabel.CENTER);
		frame.add(lbl_presentation);
		
		JButton btnStart = btnStart();		
		frame.getContentPane().add(btnStart);
	}

	private JButton btnStart() {
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(173, 178, 89, 23);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				SelectSymptom.NewWindow(initializer);				
			}
		});
		return btnStart;
	}

}
