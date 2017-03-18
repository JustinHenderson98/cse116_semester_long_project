package UI;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import code.colorModels;
import code.generateFractal;
import edu.buffalo.fractal.FractalPanel;

/**
 * displays the menubar and the fractal image
 * 
 * @author Justin Henderson
 * @author Kunku Wu
 * @author Ethan Gagne
 * @author Ben Conomos
 *
 */
public class userInterface {
	private JFrame _frame;
	private generateFractal _model;
	private menuBar _menu;
	private JPanel _globalPanel;
	private FractalPanel _display;
	private colorModels _colorModel; 
	public userInterface() {
		_colorModel = new colorModels(this);
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
	/**
	 * generates a new fractal and updates the image
	 */
	public void update() {
		_display.setIndexColorModel(_colorModel.getColorModel());
		_display.updateImage(_model.genFractal());
		
	}
	/**
	 * Returns the colorModels
	 * @return the current colorModels object
	 */
	public colorModels getColorModel() {
		return _colorModel;
	}
	/**
	 * Returns the model
	 * @return the current generateFractal object
	 */
	public generateFractal getModel() {
		return _model;
	}
}