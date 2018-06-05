package Panel¤Á´«;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class Frame extends JFrame implements ActionListener{

	public Frame() {
		super();
		Panel1 panel1 = new Panel1();
		add(panel1, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
