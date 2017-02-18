package code;

public class update {

	public doublePoint updateXY(int fractalType, doublePoint p){
		if(fractalType ==1){
			//TODO add Mandlebrot set
		}
		else if(fractalType ==2){
			return juliaSet(p);
		}
		else if(fractalType ==3){
			//TODO add burning Ship set
		}
		else {
			//TODO add unknown set
		}
		return null;
	}
	
	public doublePoint juliaSet(doublePoint p) {
		doublePoint juliaPoint = new doublePoint();
		juliaPoint.x = Math.pow(p.x, 2.0) +  Math.pow(p.y, 2.0) - 0.72689;
		juliaPoint.y = 2.0 * p.x * p.y + 0.188887;
		return juliaPoint;
	}
	
}