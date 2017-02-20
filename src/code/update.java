package code;

public class update {

	public doublePoint updateXY(int fractalType, doublePoint XYCalc, doublePoint currentXY ){
		if(fractalType ==1){
			//TODO add Mandlebrot set
			return mandlebrotSet(XYCalc, currentXY);
		}
		else if(fractalType ==2){
			return juliaSet(XYCalc);
		}
		else if(fractalType == 3){
			//TODO add burning Ship set
			return burningShipSet(XYCalc, currentXY);
		}
		else {
			//TODO add Multibrot set
			return multibrotSet(XYCalc, currentXY);
		}
	}
	
	private doublePoint multibrotSet(doublePoint XYCalc, doublePoint currentXY) {
		// TODO Auto-generated method stub
		return null;
	}

	private doublePoint burningShipSet(doublePoint XYCalc, doublePoint currentXY) {
		// TODO Auto-generated method stub
		return null;
	}

	private doublePoint mandlebrotSet(doublePoint XYCalc, doublePoint currentXY) {
		
		doublePoint mandlePoint = new doublePoint();
		mandlePoint.x = Math.pow(XYCalc.x, 2) - Math.pow(XYCalc.y, 2) + currentXY.x;
		mandlePoint.x = 2* XYCalc.x * XYCalc.y + currentXY.x;

		return mandlePoint;
	}

	public doublePoint juliaSet(doublePoint XYCalc) {
		doublePoint juliaPoint = new doublePoint();
		juliaPoint.x = Math.pow(XYCalc.x, 2.0) +  Math.pow(XYCalc.y, 2.0) - 0.72689;
		juliaPoint.y = 2.0 * XYCalc.x * XYCalc.y + 0.188887;
		return juliaPoint;
	}
	
}