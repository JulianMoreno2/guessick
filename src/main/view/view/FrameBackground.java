package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameBackground extends JFrame {

	private static final long  serialVersionUID = 1L;
	private JPanel jContentPane = null;

	public FrameBackground(){
		super();
		intialize();
	}

	private void intialize(){
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Guessick");
	}
	
	private PanelBackground getJContentPane(){
		
		if(jContentPane == null){
			jContentPane = new PanelBackground("../Medicina.jpg");
			jContentPane.setLayout(new BorderLayout());
		}
		
		return (PanelBackground) jContentPane;

	}

}