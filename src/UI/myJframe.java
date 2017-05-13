package UI;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;

public class myJframe extends JFrame implements ComponentListener{
	userInterface _ui;

	public myJframe(userInterface ui) {
		// TODO Auto-generated constructor stub
		_ui = ui;
	    addComponentListener(this); 

	}
	
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(this.getHeight());

	}

	@Override
	public void componentResized(ComponentEvent e) {
	System.out.println(this.getHeight());
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
