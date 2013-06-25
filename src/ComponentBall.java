import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class ComponentBall extends JPanel {
	
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	
	public void addBall( Ball b){ balls.add( b ); }

	public void paintComponent( Graphics g){
		super.paintComponent( g );
		
		Graphics2D g2 = ( Graphics2D ) g;
		
		for( Ball ball : balls)
			g2.fill( ball.getShape() );
		
	}
	
}
