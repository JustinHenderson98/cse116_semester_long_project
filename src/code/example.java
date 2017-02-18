package code;

public class example {

	public doublePoint juliaSet(doublePoint p) {
		doublePoint juliaPoint = new doublePoint();
		juliaPoint.x = Math.pow(p.x, 2.0) +  Math.pow(p.y, 2.0) - 0.72689;
		juliaPoint.y = 2.0 * p.x * p.y + 0.188887;
		return juliaPoint;
	}
	
}
