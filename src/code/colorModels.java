package code;



import java.awt.image.IndexColorModel;
import java.util.ArrayList;

import UI.userInterface;
/**
 * This class functions as a container for the UI to access color models.
 * 
 * @author Justin Henderson
 * @author Kunku Wu
 * @author Ethan Gagne
 * @author Ben Conomos
 *
 */

public class colorModels {
	int _cm = 1;
	int _maxSteps;
	userInterface _ui;
	ArrayList<IndexColorModel> _cms; 
	public colorModels(userInterface ui){
		_ui = ui;	
		updateColorModelMaxSteps(255);

	}
	public void updateColorModelMaxSteps(int i) {
		_cms = new ArrayList<IndexColorModel>();
		//COLOR MODEL TEMPLATE
		_cms.add(ColorModelFactory.createGrayColorModel(i));
		//TEMPLATE
		_cms.add(ColorModelFactory.createPurpleColorModel(i));
		
		_cms.add(ColorModelFactory.createRainbowColorModel(i));
		
		_cms.add(ColorModelFactory.createGreensColorModel(i));
	}
	  /**
	   * Returns the currently selected color model.
	   * @return currently selected color model in _cms.
	   */
	public IndexColorModel getColorModel() {
			return _cms.get(_cm-1);

	}
	  /**
	   * Returns the number of saved color models to allow UI scaling.
	   * @return size of _cms.
	   */
	public int getNumOfColorModels() {
		return _cms.size();
	}
	  /**
	   * Sets a new selected color model.
	   * @param i
	   * 		The color model selection to be stored.
	   */
	
	public void setColorModel(int i) throws IndexOutOfBoundsException {
		if (i > 0 && i <= _cms.size()) {
			_cm = i;
			_ui.updateColor();
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
}
