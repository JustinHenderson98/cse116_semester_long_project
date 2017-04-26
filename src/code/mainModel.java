package code;

import UI.userInterface;

public class mainModel {
	private int _numThreads;
	private int _rows;
	private userInterface _ui; //set up observer pattern with this class instead of generateFractal
	
	public mainModel(int numThreads) {
		updateThreads(numThreads);
	}
	public void updateThreads(int numThreads) {
	_numThreads = numThreads;
	//create SwingWorker array arr with numThreads length
	//while smaller than _numThreads
		//generate FractalWorkers
		//add worker to arr
		//endwhile
	//new computepool comppool
	//comppool.changePanel(_ui.getFractalPanel)
	//comppool.generateFractal(_rows, arr)
	}
}
