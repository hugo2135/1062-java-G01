package test02;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public class Rect extends JPanel{
	
	public void paintComponent( Graphics g )
	   {
	      super.paintComponent( g ); // call superclass's paintComponent
//	      this.setBackground( Color.WHITE );
	      g.setColor( Color.PINK );
	      g.fillRect(10, 300, 460, 100);
	      
	   }
}
/*
	private int x,y,width,height;
	int padding = 10 ;
	int radius = 5 ;
	
	public Rect() {
		this.x = 10;
		this.y = 300;
		this.width = 150;
		this.height = 30;
	}
	
	public void draw(final Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g.setColor(Color.BLUE);
		g2D.fillRect(x,y,width,height);
		RoundRectangle2D.Double rect = new RoundRectangle2D.Double(x, padding, width, height, radius, radius);
		Area area = new Area(rect);
        
	}
*/


/*
@Override
    protected void paintComponent(final Graphics g) {
        final Graphics2D graphics2D = (Graphics2D) g;
        // 1.�]�m�ϧΤ��~�ؽu�����㥭�ƽu��(�D������)
        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(qualityHints);
        // 2.�]�m�ϧΤ��I���C��P�u���ʲ�
        graphics2D.setColor(getBubbleColor());
        graphics2D.setStroke(new BasicStroke(strokeThickness));
        
        // 3.ø�s��ꨤ����ؽd��
        int x = padding + strokeThickness + arrowSize;
        int width = getWidth() - arrowSize - (strokeThickness * 2);
        int height = getHeight() - strokeThickness;
        graphics2D.fillRect(x, padding, width, height);
        RoundRectangle2D.Double rect = new RoundRectangle2D.Double(x, padding, width, height, radius, radius);
        // 4.ø�s��ܤ��ܼL������
        Polygon arrow = new Polygon();
        arrow.addPoint(14, 6);
        arrow.addPoint(arrowSize + 2, 10);
        arrow.addPoint(14, 12);
        // 5.�N�G�ӹϧΥ[�J area���A�çQ�� draw() ��k�e�X���w���ϧ�
        Area area = new Area(rect);
        area.add(new Area(arrow));
        graphics2D.draw(area);
    } 
*/
