package window;

import java.awt.EventQueue;
import javax.swing.JFrame;
import core.ResourceContainer;
import view.FrameBackground;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
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

	public Main() {
		initialize();
	}

	private void initialize() {		
		new ResourceContainer();
		frame = new FrameBackground("Guessick", "../Medicina.jpg");
		frame.setBounds(100, 75, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = btnStart();		
		frame.getContentPane().add(btnStart);
	}

	private JButton btnStart() {
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(485, 234, 89, 23);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				SelectSymptom.NewWindow();				
			}
		});
		return btnStart;
	}

}
