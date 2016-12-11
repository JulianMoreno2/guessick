package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameBackground extends JFrame {

	private static final long  serialVersionUID = 1L;
	private JPanel jContentPane = null;

	public FrameBackground(String title, String imageUrl){
		super();
		intialize(title,imageUrl);
	}

	private void intialize(String title, String imageUrl){
		this.setSize(300, 200);
		this.setContentPane(getJContentPane(imageUrl));
		this.setTitle(title);
	}
	
	private PanelBackground getJContentPane(String imageUrl){
		
		if(jContentPane == null){
			jContentPane = new PanelBackground(imageUrl);
			jContentPane.setLayout(new BorderLayout());
		}
		
		return (PanelBackground) jContentPane;

	}

}