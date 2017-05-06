package code;

import javax.swing.SwingWorker;

import edu.buffalo.fractal.WorkerResult;

public class FractalWorker extends SwingWorker<WorkerResult, Void> {
	private int _numThreads;
	private int _id;
	private int _size;
	private generateFractal _fractalClass;
	private int[][] _fractal;
	//gettersetters
	
	public FractalWorker(int threads, int id, generateFractal fractal, int size) {
		_fractalClass = fractal;
		_size = size;
		_id = id;
		_numThreads = threads;
	}
	@Override
	protected WorkerResult doInBackground() throws Exception {
		
		_fractal = _fractalClass.genFractal(_size, _id, _numThreads);
		
		
		WorkerResult result = new WorkerResult(_id* (_size/_numThreads), _fractal);

		//generate fractal with genFractal in bounds of thread
			//rows = rows/_numThreads
			//startpoint _id *rows
		//return WorkerResult containing results of genFractal
		return result;
	}
	public int[][] getFractal(){
		return _fractal;
	}

}
