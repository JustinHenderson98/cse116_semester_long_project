package UI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.image.IndexColorModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import code.generateFractal;
import edu.buffalo.fractal.FractalPanel;


public class userInterface {
	public static void main(String[] args)
	{  
	    new userInterface();  
	}  
	
	private JFrame _frame;
	private generateFractal _model;
	private menuBar _menu;
	private JPanel _globalPanel;
	private FractalPanel _display;
	public userInterface() {
		_model = new generateFractal(this);
		_menu = new menuBar();
		_display = new FractalPanel();
		_globalPanel = new JPanel();
		_globalPanel.setLayout(new GridLayout(1,1));
		_frame = new JFrame("CSE116IsBomb_B1");
		_frame.setMenuBar(_menu.getMenuBar());
		_globalPanel.add(_display);
		_frame.add(_globalPanel);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
		//Temporary - Trying to figure out color models
		Color[] colors = {Color.red, Color.green, Color.blue,
			    Color.cyan, Color.magenta, Color.yellow,
			    Color.white, Color.black};
			    byte[] reds = new byte[8];
			    byte[] greens = new byte[8];
			    byte[] blues = new byte[8];
			    for (int i = 0; i < colors.length; i++) {
			      reds[i] = (byte) colors[i].getRed();
			      greens[i] = (byte) colors[i].getGreen();
			      blues[i] = (byte) colors[i].getBlue();
			    }
			    IndexColorModel cm = new IndexColorModel(3, 8, reds, greens, blues);
		//temporary
		_display.setIndexColorModel(cm);
		_display.updateImage(_model.genFractal(3));
		//something seems wrong with GenFractal - need to take a look
		
	}
}
