package Panel¤Á´«;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel2 extends JPanel implements ActionListener{

	private JButton topanel3;
	private GridBagConstraints gbc;
	
	public Panel2() {
		super();
		gbc = new GridBagConstraints();
		
		topanel3 = new JButton("ToPanel2");
		topanel3.addActionListener(this);
		add(topanel3,gbc);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
