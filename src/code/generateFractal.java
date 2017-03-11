package code;

import UI.userInterface;

/**
 * class that will generate fractals in either the Mandlebrot Set, Julia Set, Burning Ship Set, or the Multibrot Set.
 * 
 * @author Justin Henderson
 * @author Kunku Wu
 * @author Ethan Gagne
 * @author Ben Conomos
 *
 */
public class generateFractal {
	private userInterface _ui;
	public int _escapeDistance = 2;
	private int _fractalType = 1;
	public generateFractal(userInterface ui) {
		_ui = ui;
	}
	public generateFractal() {}

	/**
	 * will generate a two-dimmensional array containing integers from 0 to maxSteps. With each coordinate of the array translating to the escape time of a coordinate on the Cartesian plane 
	 * 
	 * @param _fractalType integer 1 through 4 determines if set is Mandlebrot, Julia, burning Ship, or Multibrot.
	 * @param fractalWidth integer number ofpixels per row in the fractal array.
	 * @param FractalHeight integer number of pixels per column in the fractal array. 
	 * @param xRangeStart double x-coordinate value that starts where the escape time is calculated.
	 * @param xRangeEnd double x-coordinate value that ends where the escape time is calculated.
	 * @param yRangeStart double y-coordinate value that starts where the escape time is calculated.
	 * @param yRangeEnd double y-coordinate value that endss where the escape time is calculated.
	 * @param _escapeDistance integer distance above which we expect the series will eventually reach infinity.
	 * @param maxSteps integer max number of steps the escape-time algorithm will be considered.
	 * @return int[][] where each coordinate translates to a 0-255 value calculated by the escape time algorithm(each point is a pixel).
	 */
	
	public int[][] genFractal(int _fractalType, int fractalWidth, int fractalHeight,double xRangeStart, double xRangeEnd, double yRangeStart,double yRangeEnd, int maxSteps){
		
		int[][] fractalSet = new int[fractalWidth][fractalHeight]; //creates new 2d array to hold each pixel value
		doublePoint currentXY = new doublePoint(); //contains the current x and y coordinates
		double xSpace = Math.abs( (xRangeEnd -  xRangeStart) / fractalWidth);//calculates the padding between each x-coordinate
		double ySpace = Math.abs( (yRangeEnd -  yRangeStart) / fractalHeight);//calculates the padding between each y-coordinate
		
		currentXY.x = xRangeStart;
		currentXY.y = yRangeStart;
		
		for(int cols = 0; cols<fractalHeight; cols++){
			currentXY.y =pixelColToCoordinate(yRangeStart, ySpace, cols);
			
			for(int rows = 0; rows <fractalWidth;rows++){ 
				currentXY.x = pixelRowToCoordinate(xRangeStart, xSpace, rows);
				
				fractalSet[rows][cols] = escapeTime(_fractalType, currentXY, _escapeDistance, maxSteps);
			}
		}
		
		return fractalSet;	
	}
	
	/**
	 * Overloaded method to allow default values to be used.
	 * 
	 * @param _fractalType integer value 1 through 4 determines if set is Mandlebrot, Julia, burning Ship, or Multibrot.
	 * @returnint[][] where each coordinate translates to a 0-255 value calculated by the escape time algorithm(each point is a pixel).
	 */
	public int[][] genFractal(){
		int width = 512; //default width
		int height = 512; //default height
		//int _escapeDistance = 2; //default escape distance
		int maxSteps = 255; //default max steps
		
		double xRangeStart =0;//initialize 
		double xRangeEnd =0;
		double yRangeStart =0;
		double yRangeEnd =0;
		
		//default range values for mandlebrot set
		if(_fractalType ==1){
			 xRangeStart = -2.15;
			 xRangeEnd= 0.6;
			 yRangeStart = -1.3;
			 yRangeEnd = 1.3;
		}
		//default range values for Julia set
		else if(_fractalType ==2){
			xRangeStart = -1.7;
			 xRangeEnd= 1.7;
			 yRangeStart = -1.0;
			 yRangeEnd = 1.0;
			
		}
		//default range values for burning ship set
		else if(_fractalType ==3){
			xRangeStart = -1.8;
			 xRangeEnd= -1.7;
			 yRangeStart = -0.08;
			 yRangeEnd = 0.025;
		}
		//default range values for multibrot set
		else if(_fractalType ==4){
			xRangeStart = -1.0;
			 xRangeEnd= 1.0;
			 yRangeStart = -1.3;
			 yRangeEnd = 1.3;
			
		}
		return genFractal(_fractalType, width, height, xRangeStart, xRangeEnd,  yRangeStart, yRangeEnd, maxSteps);
	}

		/**
		 * calculates the distance between(x,y) and (0,0).
		 * 
		 * @param double x coordinate
		 * @param double y coordniate
		 * @return
		 */
		public double distance(double x,double y){
			//calculates the distance from point x,y from the origin
			return Math.pow((Math.pow(x, 2.0) + Math.pow(y, 2.0)), 0.5);
		}
		
		/**
		 * calculates the escape time for a given coordinate on the Cartesian plane
		 * 
		 * @param _fractalType integer 1 through 4 determines if set is Mandlebrot, Julia, burning Ship, or Multibrot.
		 * @param currXY doublePoint value that contains the current x and y values.
		 * @param _escapeDistance integer distance above which we expect the series will eventually reach infinity.
		 * @param maxSteps integer max number of steps the escape-time algorithm will be considered.
		 * @return passes integer that is between 0 and maxSteps.
		 */
		public int escapeTime(int _fractalType, doublePoint currXY, int _escapeDistance, int maxSteps){
			doublePoint XYCalc = new doublePoint(); //doublePoint representing xCalc and yCalc; this is separate from the coordinates
			XYCalc = currXY;
			
			
			 double dist = distance(XYCalc.x, XYCalc.y);//sets dist equal to the distance between the current x and y and the origin
			int passes = 0;
			
			while(dist <= _escapeDistance && passes < maxSteps ){
				update update = new update();//can probably move this code outside of loop for better run times
				XYCalc = update.updateXY(_fractalType, XYCalc, currXY);
				passes++;		
				dist = distance(XYCalc.x,XYCalc.y) ;
			}
			
			return passes;
		}
		/**
		 * translates the current row to a coordinate on the Cartesian plane.
		 * 
		 * @param xRangeStart double x-coordinate value that starts where the escape time is calculated.
		 * @param xSpace double value for the space between each x coordinate.
		 * @param rows integer current row of the array.
		 * @return double value for the x-coordinate.
		 */
		public double pixelRowToCoordinate(double xRangeStart, double xSpace, int rows ){
					return xRangeStart + xSpace * rows;
				}
				
		/**
		 * Same as method above(dublicate code used for legibility)
		 * 
		 * @param yRangeStart double y-coordinate value that starts where the escape time is calculated.
		 * @param ySpace double value for the space between each y coordinate.
		 * @param cols integer value of the current column in the array.
		 * @return double value for the y-coordinate.
		 */
		public double pixelColToCoordinate(double yRangeStart, double ySpace,int cols ){
					return yRangeStart + ySpace * cols;
				}
		public void set_escapeDistance(int distance){
			_escapeDistance = distance;
		}
		public void set__fractalType(int fractalType) {
			this._fractalType = fractalType;
		}
}
