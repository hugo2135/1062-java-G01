package test_for_image;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
	private JPanel Sou;
	
	private JTextField field;
	private GridBagConstraints gbc;
	Graphics g;
	private Rect RT;
	
//	private JTextArea TA;
	
	private GridBagLayout gb = new GridBagLayout();

	public DrawFrame(){
		super("test02");
		p1 = new JPanel();
		p1.setLayout(null);
		
		// 圖片
		Icon bug = new ImageIcon( getClass().getResource( "daniel.PNG" ) );
		label3 = new JLabel(); // JLabel constructor no arguments
		label3.setBounds(10, 200, 50, 50);
	    label3.setIcon( bug ); // add icon to JLabel
	    p1.add(label3);
	    
		// 對話框
		JLabel jLabel = new JLabel();
		jLabel.setText("這裡是文字標籤");
		jLabel.setBackground(Color.BLUE);
		jLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		jLabel.setBounds(10, 350, 460, 50);
   		p1.add(jLabel);
//   		g.fillRect(10, 300, 460, 100);
   		RT = new Rect();
   		p1.add(RT);
	    add(p1);
	}

}
