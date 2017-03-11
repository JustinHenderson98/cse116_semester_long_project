package UI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.image.IndexColorModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import code.colorModels;
import code.generateFractal;
import edu.buffalo.fractal.FractalPanel;


public class userInterface {
	public static void main(String[] args)
	{  
	    new userInterface();  
	}  
	
	private JFrame _frame;
	public generateFractal _model;
	private menuBar _menu;
	private JPanel _globalPanel;
	private FractalPanel _display;
	private colorModels _colorModel;
	public userInterface() {
		_colorModel = new colorModels();
		_model = new generateFractal(this);
		_menu = new menuBar(this);
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
		update();
	}
	public void update() {
		_display.setIndexColorModel(_colorModel.getColorModel());
		_display.updateImage(_model.genFractal());
		
	}
}
