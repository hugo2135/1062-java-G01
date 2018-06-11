package game1;

import java.awt.Graphics;

import javax.swing.JPanel;

import audioplayer.MP3;

public class DrawPanel extends JPanel {

	private Rect rt;
	Thread musicThread;
	MP3 mp3;
	
	public DrawPanel() {
		super();
		rt = new Rect(5,290,470,140);
		repaint();
		
		String filename = "rudio/01 永遠同在-神隱少女.mp3";
		mp3 = new MP3(filename);
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		rt.draw(g);
	}
	
	public void music_open_close(boolean bl) {
		if(bl) {
			mp3.stop();
		}else {
			mp3.resume();
		}
	}
	
	public void music_start() {
		musicThread = new Thread() {
			public void run() {
				while(true) {
					mp3.setLoop(false);
					try {
						Thread.sleep(1000/30);
					}catch(InterruptedException ex) {}
				}
			}
		};
		mp3.play();
		musicThread.start();
	}
	

	
}
