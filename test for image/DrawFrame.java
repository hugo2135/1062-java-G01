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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DrawFrame extends JFrame{
	private JLabel label3;
	private JPanel p1;
	
	private JTextField field;
	private GridBagConstraints gbc;
	
	private Rect RT;
	
//	private JTextArea TA;
	
	private GridBagLayout gb = new GridBagLayout();

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
	    
		RT = new Rect();
		/*
		field = new JTextField();
	   	field.setEditable(false);
	   	field.setBorder(BorderFactory.createLineBorder(Color.black));;
	   	field.setFont(new Font("Arial", Font.PLAIN, 24));
	   	field.setHorizontalAlignment(JTextField.RIGHT);
	   	gbc = new GridBagConstraints();
   		gbc.gridx = 0;
   		gbc.gridy = 0;
   		gbc.gridwidth = 4;
   		gbc.gridheight = 1;
   		gbc.fill = GridBagConstraints.BOTH;
   		gbc.insets = new Insets(2,2,2,2);
   		RT.add(field);
   		*/	
		
	    add(RT);
	    
	}

}
