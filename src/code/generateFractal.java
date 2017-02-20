package code;

public class generateFractal {
	/**
	 * 
	 * @param fractalType int 1-4 determines if Mandlebrot, Julia, burning Ship, unknown
	 * @param fractalWidth num of rows in the fractal array
	 * @param FractalHeight num of columns in the fractal array 
	 * @param xRangeStart 
	 * @param xRangeEnd
	 * @param yRangeStart
	 * @param yRangeEnd
	 * @param escapeDistance
	 * @param maxSteps
	 * @return
	 */
	
	public int[][] genFractal(int fractalType, int fractalWidth, int fractalHeight,double xRangeStart, double xRangeEnd, double yRangeStart,double yRangeEnd, int escapeDistance, int maxSteps){
		
		int[][] fractalSet = new int[fractalWidth][fractalHeight]; //creates new 2d array to hold each pixel value
		doublePoint currentXY = new doublePoint(); //contains the current x and y coordinates
		double xSpace = (xRangeEnd -  xRangeStart) / fractalWidth;//calculates the padding between each x-coordinate
		double ySpace = (yRangeEnd -  yRangeStart) / fractalHeight;//calculates the padding between each y-coordinate
		
		currentXY.x= xRangeStart;
		currentXY.y = yRangeStart;
		double dist = distance(currentXY.x, currentXY.y);//sets dist equal to the distance between the current x and y and the origin
		
		for(int cols = 0; cols<fractalHeight; cols++){
			currentXY.y = currentXY.y + ySpace;// increases the y coordinate by yspace
			
			for(int rows = 0; rows <fractalWidth;rows++){ 
				currentXY.x = currentXY.x + xSpace; //increases the x coordinate by xspace
				
				int escapeTime; //value to be written to the array
				doublePoint XYCalc = new doublePoint(); //doublePoint representing xCalc and yCalc; this is seperate from the coordinates
				XYCalc = currentXY;
				
				
				dist = distance(XYCalc.x, XYCalc.y);//sets dist equal to the distance between the current x and y and the origin
				int passes = 0;
				
				while(dist <= escapeDistance && passes < maxSteps ){
					update update = new update();//can probably move this code outside of loop for better run times
					XYCalc = update.updateXY(fractalType, XYCalc, currentXY);
					passes++;		
					dist = distance(XYCalc.x,XYCalc.y) ;
				}
				escapeTime= passes;
				
				fractalSet[cols][rows] = escapeTime;
			}
		}
		
		
		
		
		
		return fractalSet;	
	}
	
	public int[][] genFractal(int fractalType){
		int width = 512; //default width
		int height = 512; //default height
		int escapeDistance = 4; //default escape distance
		int maxSteps = 255; //default max steps
		
		double xRangeStart =0;//innitializ 
		double xRangeEnd =0;
		double yRangeStart =0;
		double yRangeEnd =0;
		
		//default range values for mandlebrot set
		if(fractalType ==1){
			 xRangeStart = -2.15;
			 xRangeEnd= 0.6;
			 yRangeStart = -1.3;
			 yRangeEnd = 1.3;
		}
		//default range values for Julia set
		else if(fractalType ==2){
			xRangeStart = -1.7;
			 xRangeEnd= 1.7;
			 yRangeStart = -1.0;
			 yRangeEnd = 1.0;
			
		}
		//default range values for burning ship set
		else if(fractalType ==3){
			xRangeStart = -1.8;
			 xRangeEnd= -1.7;
			 yRangeStart = -0.08;
			 yRangeEnd = -0.025;
		}
		//default range values for unknown set
		else if(fractalType ==4){
			
		}
		return genFractal(fractalType, width, height, xRangeStart, xRangeEnd,  yRangeStart, yRangeEnd, escapeDistance, maxSteps);
	}

		public double distance(double x,double y){
			//calculates the distance from point x,y from the oragin
			return Math.pow((Math.pow(x, 2.0) + Math.pow(y, 2.0)), 0.5);
			
		}
}
