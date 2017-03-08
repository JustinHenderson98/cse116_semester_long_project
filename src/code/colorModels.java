package code;

import java.awt.Color;
import java.awt.image.IndexColorModel;
import java.util.ArrayList;

public class colorModels {
	int _cm = 1;
	ArrayList<IndexColorModel> _cms = new ArrayList<IndexColorModel>(); 
	public colorModels(){
	//COLOR MODEL TEMPLATE
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
	_cms.add(new IndexColorModel(3, 8, reds, greens, blues));
	//TEMPLATE
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
