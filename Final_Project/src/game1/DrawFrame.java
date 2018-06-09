package game1;

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
	private JPanel p1;
	private JButton start,exit;
	
	private DrawPanel p2;
	private JLabel label3;
	private JButton ans1,ans2,music;
	private ImageIcon musicIcon;
	private boolean music_b = false;
	
	String text_str = "測試";
	String ans1_str = "測試";
	String ans2_str = "測試";
//	private JTextArea TA;
	
	private GridBagLayout gb = new GridBagLayout();

	public DrawFrame(){
		
		super("test02");
		//開始畫面
		p1 = new JPanel();
		p1.setLayout(null);
		
		start = new JButton("開始遊戲");
		start.addActionListener(this);
		start.setBounds(50, 100, 100, 50);
		p1.add(start);
		exit = new JButton("離開遊戲");
		exit.addActionListener(this);
		exit.setBounds(50,160,100,50);
		p1.add(exit);
		
		p1.setVisible(true);
		this.add(p1);
		
		//遊戲畫面
		p2 = new DrawPanel();
		p2.setLayout(null);
		
		// 圖片
		/*
		Icon bug = new ImageIcon( getClass().getResource( "daniel.PNG" ) );
		label3 = new JLabel(); // JLabel constructor no arguments
		label3.setBounds(10, 200, 50, 50);
	    label3.setIcon( bug ); // add icon to JLabel
	    p2.add(label3);
	    */
		// 對話框
		JLabel jLabel = new JLabel();
		jLabel.setText(text_str);
		jLabel.setBackground(Color.BLUE);
		jLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		jLabel.setBounds(10, 300, 460, 50);
   		p2.add(jLabel);
   		// 選擇按鈕
   		ans1 = new JButton(ans1_str);
   		ans1.addActionListener(this);
   		ans1.setBounds(10, 355, 80, 30);
   		ans2 = new JButton(ans2_str);
   		ans2.addActionListener(this);
   		ans2.setBounds(10, 390, 80, 30);
   		
   		musicIcon = new ImageIcon(getClass().getResource("musicicon.jpg"));
   		
   		music = new JButton(musicIcon);
   		music.addActionListener(this);
   		music.setBounds(10, 60, 40, 40);
   		
   		
   		p2.add(ans1);
   		p2.add(ans2);
   		p2.add(music);
   		p2.setVisible(true);
   		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==start){
			System.out.println("start");
			this.remove(p1);
			this.add(p2);
			this.revalidate();
			p2.music_start();
		}else if(e.getSource()==ans1) {
			System.out.println("bt1");
			sqrt(1);
		}else if(e.getSource()==ans2) {
			System.out.println("bt2");
			sqrt(2);
		}else if(e.getSource()==music) {
			this.setMusic_b(!music_b);
			p2.music_open_close(music_b);
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

	public boolean isMusic_b() {
		return music_b;
	}

	public void setMusic_b(boolean music_b) {
		this.music_b = music_b;
	}
	
	

}
