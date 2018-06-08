package test02;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DrawFrame extends JFrame implements ActionListener{
	private JLabel label3;
	private DrawPanel p1;
	private JPanel Sou;
	
	private JButton ans1,ans2;
	
	private JTextField field;
	private GridBagConstraints gbc;
	Graphics g;
	String text_str = "測試";
	String ans1_str = "測試";
	String ans2_str = "測試";
//	private JTextArea TA;
	
	private GridBagLayout gb = new GridBagLayout();

	public DrawFrame(){
		super("test02");
		p1 = new DrawPanel();
		p1.setLayout(null);
		
		// 圖片
		Icon bug = new ImageIcon( getClass().getResource( "daniel.PNG" ) );
		label3 = new JLabel(); // JLabel constructor no arguments
		label3.setBounds(10, 200, 50, 50);
	    label3.setIcon( bug ); // add icon to JLabel
	    p1.add(label3);
	    
		// 對話框
		JLabel jLabel = new JLabel();
		jLabel.setText(text_str);
		jLabel.setBackground(Color.BLUE);
		jLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		jLabel.setBounds(10, 300, 460, 50);
   		p1.add(jLabel);
   		// 選擇按鈕
   		ans1 = new JButton(ans1_str);
   		ans1.addActionListener(this);
   		ans1.setBounds(10, 355, 80, 30);
   		ans2 = new JButton(ans2_str);
   		ans2.addActionListener(this);
   		ans2.setBounds(10, 390, 80, 30);
   		p1.add(ans1);
   		p1.add(ans2);
   		
//   		g.fillRect(10, 300, 460, 100);
	    add(p1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ans1) {
			System.out.println("bt1");
			sqrt(1);
		}else if(e.getSource()==ans2) {
			System.out.println("bt2");
			sqrt(2);
		}
		
	}
	
	public void sqrt(int num) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			// handle the error
		}

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/select_test?"
					+ "user=root&password=0000&serverTimezone=UTC&useSSL=false");

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select ns.id, text, ch1, ch2 from new_scheam ns");

			text_str = rs.getString(1);
			if(rs.getInt(1) == num) {
				text_str = rs.getString(2);
				ans1_str = rs.getString(3);
				ans2_str = rs.getString(4);
			}

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}
