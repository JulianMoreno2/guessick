package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelBackground extends JPanel {
	
	ImageIcon image;
	private static final long serialVersionUID = 1L;

	public PanelBackground(String name) {
		super();
		initialize();
		image = new ImageIcon(getClass().getResource(name));
		setSize(image.getIconWidth(), image.getIconHeight());
	}
	
	protected void paintComponent(Graphics g){
		Dimension d = getSize();
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
	
	private void initialize(){
		this.setSize(300, 200);
		this.setLayout(new GridBagLayout());
	}

}