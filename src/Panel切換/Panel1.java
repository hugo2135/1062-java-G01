package Panel¤Á´«;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel1 extends JPanel implements ActionListener{

	private JButton topanel2;
	private GridBagConstraints gbc;
	
	public Panel1() {
		super();
		gbc = new GridBagConstraints();
		
		topanel2 = new JButton("ToPanel2");
		topanel2.addActionListener(this);
		add(topanel2,gbc);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == topanel2) {
			setVisible(false);
		}
		
	}

}
