package code;

import javax.swing.SwingWorker;

import UI.userInterface;
import edu.buffalo.fractal.ComputePool;
import edu.buffalo.fractal.WorkerResult;

public class mainModel {
	private int _numThreads;
	private int _rows;
	private userInterface _ui; //set up observer pattern with this class instead of generateFractal
	private generateFractal _fractal;
	private int _size;
	private ComputePool _pool;
	
	public mainModel(userInterface ui,int numThreads,int size) {
		_ui = ui;
		_fractal = new generateFractal();
		_numThreads = numThreads;
		_size = size;
	}
	public void update() {
		SwingWorker<WorkerResult, Void> Workers[] = new SwingWorker[_numThreads];//create SwingWorker array arr with numThreads length
		for (int i = 0; i < _numThreads; i++) {
			Workers[i] = new FractalWorker(_numThreads, i, _fractal, _size);
		}
		_rows = _size;
		ComputePool comppool = new ComputePool();
		_pool = comppool;
		comppool.changePanel(_ui.getFractalPanel());
		comppool.generateFractal(_rows, Workers);
	}
	public void setThreads(int numThreads) {
		_numThreads = numThreads;
	}
	public generateFractal getFractalClass(){
		return _fractal;
	}
	public ComputePool get_pool() {
		return _pool;
	}
	public void set_pool(ComputePool _pool) {
		this._pool = _pool;
	}
	public int getSize() {
		return _size;
	}
	public void setSize(int j) {
		_size = j;
	}
}
