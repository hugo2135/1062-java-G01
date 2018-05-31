package test02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DrawFrame extends JFrame{
	private JLabel label3;
	private JPanel p1,pcord;
	private JTextField field;
	private GridBagLayout gb = new GridBagLayout();

	String[] cord_name = {
			"1st","2nd"
	};
	public DrawFrame(){
		super("test02");
		
		Icon bug = new ImageIcon( getClass().getResource( "daniel.PNG" ) );
		p1 = new JPanel();
		p1.setLayout(gb);
		GridBagConstraints gbc = new GridBagConstraints();
		label3 = new JLabel(); // JLabel constructor no arguments
	    label3.setIcon( bug ); // add icon to JLabel
	    p1.add(label3);
	    gb.setConstraints(p1, gbc);
	    add(p1,BorderLayout.WEST);
	    
	}

}
