package code;

import javax.swing.SwingWorker;

import edu.buffalo.fractal.WorkerResult;

public class FractalWorker extends SwingWorker<WorkerResult, Void> {
	private int _numThreads;
	private int _id;
	//gettersetters
	
	public FractalWorker(int threads, int id) {
		_id = id;
		_numThreads = threads;
	}
	@Override
	protected WorkerResult doInBackground() throws Exception {
		//generate fractal with genFractal in bounds of thread
			//rows = rows/_numThreads
			//startpoint _id *rows
		//return WorkerResult containing results of genFractal
		return null;
	}

}
