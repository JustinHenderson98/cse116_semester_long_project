package code;

import javax.swing.SwingWorker;

import UI.userInterface;
import edu.buffalo.fractal.ComputePool;
import edu.buffalo.fractal.WorkerResult;

public class mainModel {
	private int _numThreads;
	private int _rows;
	private userInterface _ui; //set up observer pattern with this class instead of generateFractal
	
	public mainModel(int numThreads) {
		updateThreads(numThreads);
	}
	public void updateThreads(int numThreads) {
		_numThreads = numThreads;
		SwingWorker<WorkerResult, Void> Workers[] = new SwingWorker[_numThreads];//create SwingWorker array arr with numThreads length
		for (int i = 0; i < _numThreads; i++) {
			Workers[i] = new FractalWorker(_numThreads, i);
		}
		ComputePool comppool = new ComputePool();
		comppool.changePanel(_ui.getFractalPanel);
		comppool.generateFractal(_rows, Workers);
	}
}
