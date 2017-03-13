package code;

import java.awt.Color;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.util.ArrayList;

import edu.buffalo.fractal.FractalPanel;

public class colorModels {
	int _cm = 1;
	ArrayList<IndexColorModel> _cms = new ArrayList<IndexColorModel>(); 
	public colorModels(){
	//COLOR MODEL TEMPLATE
	_cms.add(ColorModelFactory.createGrayColorModel(500));
	//TEMPLATE
	_cms.add(ColorModelFactory.createBluesColorModel(40));
	
	_cms.add(ColorModelFactory.createRainbowColorModel(30));

	}
	
	public IndexColorModel getColorModel() {
			return _cms.get(_cm-1);

	}
	public int getNumOfColorModels() {
		return _cms.size();
	}
	public void setColorModel(int i) throws IndexOutOfBoundsException {
		if (i > 0 && i <= _cms.size()) {
			_cm = i;
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
}
