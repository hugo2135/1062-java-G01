package ¦r¤¸©µ¿ð;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TextLate extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4176918923576802250L;
	public JTextField field1;
	public String str = "hello world";
	
	
	public TextLate() {
		
		setLayout(new BorderLayout());
		
		field1 = new JTextField();
	   	field1.setEditable(false);
	   	field1.setSize(100, 50);
	   	field1.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
	   	field1.setFont(new Font("Arial", Font.PLAIN, 24));
	   	field1.setHorizontalAlignment(JTextField.RIGHT);
	   	
	   	add(field1,BorderLayout.NORTH);
	   	
	   	Thread sText = new Thread(new Runnable(){

			public void run() {
				for(int i=0;i<str.length();i++) {
					char c = str.charAt(i);
					field1.setText(field1.getText() + c);
					try {
						Thread.sleep(300);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}});
	   	sText.start();
	   	
	}

	public static void main(String[] args) {
		JFrame app = new JFrame();
		app.setSize(300, 200);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    app.setLayout(new BorderLayout());
	    app.add(new TextLate(), BorderLayout.CENTER);
	    app.setVisible(true);		

	}

}