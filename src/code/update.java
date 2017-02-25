package code;

public class update {
	/**
	 * selects the update method to be used. 1 = mandbrot, 2 = Julia, 3 = burningShip, 4 = Multibrot.
	 * 
	 * @param fractalType integer 1 through 4 determines if set is Mandlebrot, Julia, burning Ship, or Multibrot.
	 * @param XYCalc doublePoint value that contains the current x and y values that are being calculated.
	 * @param currentXY doublePoint value that contains the current x and y values.
	 * @return doublePoint containing the updated xCalc and yCalc values.
	 */
	public doublePoint updateXY(int fractalType, doublePoint XYCalc, doublePoint currentXY ){
		if(fractalType ==1){
			return mandlebrotSet(XYCalc, currentXY);
		}
		else if(fractalType ==2){
			return juliaSet(XYCalc);
		}
		else if(fractalType == 3){
			return burningShipSet(XYCalc, currentXY);
		}
		else if(fractalType == 4){
			return multibrotSet(XYCalc, currentXY);
		}
		return currentXY;//TODO add exception
	}
	
	/**
	 * updates the the xCalc and yCalc for the Multibrot Set.
	 * 
	 * @param XYCalc doublePoint value being updated.
	 * @param currentXY doublePoint value that contains the current x and y values.
	 * @return doublePoint containing the updated xCalc and yCalc values.
	 */
	private doublePoint multibrotSet(doublePoint XYCalc, doublePoint currentXY) {
		doublePoint multiPoint = new doublePoint();
		multiPoint.x = (XYCalc.x * XYCalc.x * XYCalc.x) - (3 * XYCalc.x * XYCalc.y * XYCalc.y) + currentXY.x;
		multiPoint.y = (3 * XYCalc.x * XYCalc.x * XYCalc.y) - (XYCalc.y * XYCalc.y * XYCalc.y) + currentXY.y;
		return multiPoint;
	}

	/**
	 * updates the the xCalc and yCalc for the Burning Ship Set.
	 * 
	 * @param XYCalc doublePoint value being updated.
	 * @param currentXY doublePoint value that contains the current x and y values.
	 * @return doublePoint containing the updated xCalc and yCalc values.
	 */
	private doublePoint burningShipSet(doublePoint XYCalc, doublePoint currentXY) {
		doublePoint shipPoint = new doublePoint();
		shipPoint.x = XYCalc.x * XYCalc.x - XYCalc.y * XYCalc.y + currentXY.x;
		shipPoint.y = Math.abs(2 * XYCalc.x * XYCalc.y) + currentXY.y;
		return shipPoint;
	}

	/**
	 * updates the the xCalc and yCalc for the Mandlebrot Set.
	 * 
	 * @param XYCalc doublePoint value being updated.
	 * @param currentXY doublePoint value that contains the current x and y values.
	 * @return doublePoint containing the updated xCalc and yCalc values.
	 */
	private doublePoint mandlebrotSet(doublePoint XYCalc, doublePoint currentXY) {
		
		doublePoint mandlePoint = new doublePoint();
		mandlePoint.x = Math.pow(XYCalc.x, 2) - Math.pow(XYCalc.y, 2) + currentXY.x;
		mandlePoint.y = 2* XYCalc.x * XYCalc.y + currentXY.y;

		return mandlePoint;
	}
	/**
	 * updates the the xCalc and yCalc for the Julia Set.
	 * 
	 * @param XYCalc doublePoint value that contains the current x and y values.
	 * @return doublePoint containing the updated xCalc and yCalc values.
	 */
	public doublePoint juliaSet(doublePoint XYCalc) {
		doublePoint juliaPoint = new doublePoint();
		juliaPoint.x = Math.pow(XYCalc.x, 2.0) -  Math.pow(XYCalc.y, 2.0) - 0.72689;
		juliaPoint.y = 2.0 * XYCalc.x * XYCalc.y + 0.188887;
		return juliaPoint;
	}
	
}