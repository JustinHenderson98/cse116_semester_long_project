package code;

import java.awt.Point;

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
	private int _escapeDistance = 2;
	private int _maxEscapeTime = 255; 
	private	double xRangeStart =0;//initialize 
	private double xRangeEnd =0;
	private double yRangeStart =0;
	private double yRangeEnd =0;
	private Point zoomTL;
	private Point zoomBR;
	private int maxSteps = 255;
	private int _fractalType = 1;
	private int[][] _fractalHolder;
	private double _xSpace, _ySpace;
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
		_xSpace = Math.abs( (xRangeEnd -  xRangeStart) / fractalWidth);//calculates the padding between each x-coordinate
		_ySpace = Math.abs( (yRangeEnd -  yRangeStart) / fractalHeight);//calculates the padding between each y-coordinate
		
		currentXY.x = xRangeStart;
		currentXY.y = yRangeStart;
		
		for(int cols = 0; cols<fractalHeight; cols++){
			currentXY.y =pixelColToCoordinate(yRangeStart,cols);
			
			for(int rows = 0; rows <fractalWidth;rows++){ 
				currentXY.x = pixelRowToCoordinate(xRangeStart,rows);
				
				fractalSet[rows][cols] = escapeTime(_fractalType, currentXY, _escapeDistance, maxSteps);
			}
		}
		_fractalHolder = fractalSet;
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
		//int maxSteps = 255; //default max steps
		

		

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
				if(passes > _maxEscapeTime){
					return _maxEscapeTime;
				}
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
		public double pixelRowToCoordinate(double xRangeStart, int rows ){
					return xRangeStart + _xSpace * rows;
				}
				
		/**
		 * Same as method above(dublicate code used for legibility)
		 * 
		 * @param yRangeStart double y-coordinate value that starts where the escape time is calculated.
		 * @param ySpace double value for the space between each y coordinate.
		 * @param cols integer value of the current column in the array.
		 * @return double value for the y-coordinate.
		 */
		public double pixelColToCoordinate(double yRangeStart,int cols ){
					return yRangeStart + _ySpace * cols;
				}
		public void set_escapeDistance(int distance){
			_escapeDistance = distance;
			if (_ui != null)
				_ui.update();
		}
		public void set__fractalType(int fractalType) {
			this._fractalType = fractalType;
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
			if (_ui != null)
				_ui.update();
		}

		
		public int getMaxSteps() {return maxSteps;}
		public void setMaxSteps(int j) {maxSteps = j;}
		
		public double getXRangeStart() {return xRangeStart;}
		public void setXRangeStart(double j) {xRangeStart = j;}
		
		public double getXRangeEnd() {return xRangeEnd;}
		public void setXRangeEnd(double j) {xRangeEnd = j;}
		
		public double getYRangeStart() {return yRangeStart;}
		public void setYRangeStart(double j) {yRangeStart = j;}
		
		public double getYRangeEnd() {return yRangeEnd;}
		public void setYRangeEnd(double j) {yRangeEnd = j;}

		public void resetZoom() {
			set__fractalType(_fractalType);
		}
		public int[][] getFractalHolder(){ 
			return _fractalHolder;
		}
		public void SetMaxEscapeTime(int time){
			_maxEscapeTime = time;
		}
		
		public void coordinateToZoom(){
			//zoom x and y are flipped because of a bug core to the program's coordinate system.
			xRangeEnd = pixelRowToCoordinate(xRangeStart, zoomBR.y);
			yRangeEnd = pixelColToCoordinate(yRangeStart, zoomBR.x);
			xRangeStart = pixelRowToCoordinate(xRangeStart, zoomTL.y);
			yRangeStart = pixelColToCoordinate(yRangeStart, zoomTL.x);			
			
		}
		
		
		public Point getZoomBR() {
			return zoomBR;
		}
		public void setZoomBR(Point zoomBR) {
			this.zoomBR = zoomBR;
		}
		public Point getZoomTL() {
			return zoomTL;
		}
		public void setZoomTL(Point zoomTL) {
			this.zoomTL = zoomTL;
		}
		public double get_ySpace() {
			return _ySpace;
		}
		public void set_ySpace(double _ySpace) {
			this._ySpace = _ySpace;
		}
		public double get_xSpace() {
			return _xSpace;
		}
		public void set_xSpace(double _xSpace) {
			this._xSpace = _xSpace;
		}
}
