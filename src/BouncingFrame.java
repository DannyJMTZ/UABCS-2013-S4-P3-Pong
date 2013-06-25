import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BouncingFrame extends JFrame {
	
	private ComponentBall cb;
	
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350;
	
	
	public static final int STEPS = 1000;
	public static final int DELAY = 1;
	
	public BouncingFrame(){
		
		this.setSize( DEFAULT_WIDTH , DEFAULT_HEIGHT );
		this.setTitle("BOUNCE D:");
		
		cb = new ComponentBall();
		this.add( cb , BorderLayout.CENTER );
		
		JPanel buttonPanel = new JPanel();
		
		this.addButton( buttonPanel , "Start", new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				addBall();
			}
		});
		
		this.addButton( buttonPanel , "Close", new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit( 0 );
			}
		});
		
		this.add( buttonPanel , BorderLayout.SOUTH );
	}
	
	public void addButton( Container c , String title , ActionListener listener ){
		
		JButton btn = new JButton( title );
		c.add( btn );
		btn.addActionListener( listener );
		
	}
	
	private void addBall() {
		
		Ball b = new Ball();
		cb.addBall( b );
		
		for( int i = 1 ; i < STEPS ; i++){
			b.move( cb.getBounds() );
			cb.paint( cb.getGraphics() );
			
			try{ Thread.sleep( DELAY );	} 
			catch( Exception e){}
			
		}
		
	}
}
