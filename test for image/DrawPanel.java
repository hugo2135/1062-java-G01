package test02;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	private Rect rt;
	public DrawPanel() {
		super();
		rt = new Rect(5,290,470,140);
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		rt.draw(g);
	}
	

	
}
