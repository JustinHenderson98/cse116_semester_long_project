package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.doublePoint;
import code.generateFractal;

public class escapetimeTests {	
	
	@Test
	public void mandlebrotTest(){
		generateFractal mandlebrotTest = new generateFractal();
		doublePoint p1 = new doublePoint(); 
		p1.x = 0.3207031250000001;
		p1.y = -0.07109374999999386;
		int output = fractal.escapeTime(1, p1, 2, 255);
		assertEquals(255, output);
	}
	
	@Test
	public void juliaTest(){
		generateFractal juliaTest = new generateFractal();
		doublePoint p2 = new doublePoint();
		p2.x = 1.0492187499999897;
		p2.y = -0.234375;
		int output = juliaTest.escapeTime(2, p2, 2, 255);
		assertEquals(255, output);
	}

	@Test
	public void burningshipTest(){
		generateFractal burningshipTest = new generateFractal();
		doublePoint p3 = new doublePoint();
		p3.x = -1.7443359374999874;
		p3.y = -0.017451171875000338;
		int output = burningshipTest.escapeTime(3, p3, 2, 255);
		assertEquals(255, output);
	}
	
	@Test
	public void multibrotTest(){
		generateFractal multibrotTest = new generateFractal();
		doublePoint p4 = new doublePoint();
		p4.x = 0.5859375;
		p4.y = 0.24375000000000108;
		int output = multibrotTest.escapeTime(4, p4, 2, 255);
		assertEquals(255, output);
	}
	
	@Test
	public void mandlebrotTest2(){
		generateFractal mandlebrotTest2 = new generateFractal();
		doublePoint p6 = new doublePoint();
		p6.x = 0.3207031250000001;
		p6.y = -0.07109374999999386;
		int output = mandlebrotTest2.escapeTime(1, p6, 2, 0);
		assertEquals(0, output);
	}
	
	@Test
	public void juliaTest2(){
		generateFractal juliaTest2 = new generateFractal();
		doublePoint p5 = new doublePoint();
		p5.x = 1.0492187499999897;
		p5.y = -0.234375;
		int output = juliaTest2.escapeTime(2, p5, 2, 0);
		assertEquals(0, output);
	}
	
	@Test
	public void multibrotTest2(){
		generateFractal multibrotTest2 = new generateFractal();
		doublePoint p7 = new doublePoint();
		p7.x = 0.5859375;
		p7.y = 0.24375000000000108;
		int output = multibrotTest2.escapeTime(4, p7, 2, 0);
		assertEquals(0, output);
	}
	
	@Test
	public void burningshipTest3(){
		generateFractal burningshipTest3 = new generateFractal();
		int[][] output = burningshipTest3.genFractal(3);
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output.length; j++) {
				if(1==output[i][j] || output[i][j] == 0){
					fail();
				}
			}	
		}
	}
	
	@Test
	public void return2darrayTest(){
		generateFractal return2darray = new generateFractal();
		int[][] array = return2darray.genFractal(1);
		assertEquals(512, array.length);
		assertEquals(512, array[0].length);
		
		array = return2darray.genFractal(2);
		assertEquals(512, array.length);
		assertEquals(512, array[0].length);
		
		array = return2darray.genFractal(3);
		assertEquals(512, array.length);
		assertEquals(512, array[0].length);
		
		array = return2darray.genFractal(4);
		assertEquals(512, array.length);
		assertEquals(512, array[0].length);
	}
	
	@Test
	public void pixelToCoordinateXTest1(){
		generateFractal pixelToCoordinateXTest1 = new generateFractal();
		double output = pixelToCoordinateXTest1.pixelRowToCoordinate(0);
		assertEquals(-2.15, output, 0.00001);
		double output2 = pixelToCoordinateXTest1.pixelRowToCoordinate(512);
		assertEquals(0.6, output2, 0.00001);
		double output3 = pixelToCoordinateXTest1.pixelRowToCoordinate(206);
		assertEquals(-1.043554688, output3, 0.00001);
	}
	
	@Test
	public void pixelToCoordinateXTest2(){
		generateFractal pixelToCoordinateXTest2 = new generateFractal();
		double output = pixelToCoordinateXTest2.pixelRowToCoordinate(0);
		assertEquals(-1.7, output, 0.00001);
		double output2 = pixelToCoordinateXTest2.pixelRowToCoordinate(512);
		assertEquals(1.7, output2, 0.00001);
	    double output3 = pixelToCoordinateXTest2.pixelRowToCoordinate(512);
		assertEquals(, output3, 0.00001);
	}
	
	@Test
	public void pixelToCoordinateXTest3(){
		generateFractal pixelToCoordinateXTest3 = new generateFractal();
		double output = pixelToCoordinateXTest3.pixelRowToCoordinate(0);
		assertEquals(-1.8, output, 0.00001);
		double output2 = pixelToCoordinateXTest3.pixelRowToCoordinate(512);
		assertEquals(-1.7, output2, 0.00001);
		double output3 = pixelToCoordinateXTest3.pixelRowToCoordinate(512);
		assertEquals(, output3, 0.00001);
	}
	
	@Test
	public void pixelToCoordinateXTest4(){
		generateFractal pixelToCoordinateXTest4 = new generateFractal();
		double output = pixelToCoordinateXTest4.pixelRowToCoordinate(0);
		assertEquals(-1.0, output, 0.00001);
		double output2 = pixelToCoordinateXTest4.pixelRowToCoordinate(512);
		assertEquals(1.0, output2, 0.00001);
		double output3 = pixelToCoordinateXTest4.pixelRowToCoordinate(512);
		assertEquals(, output3, 0.00001);
	}
	
	@Test
	public void pixelToCoordinateYTest1(){
		generateFractal pixelToCoordinateYTest1 = new generateFractal();
		double output = pixelToCoordinateYTest1.pixelColToCoordinate(0);
		assertEquals(-1.3, output, 0.0001);
		double output2 = pixelToCoordinateYTest1.pixelColToCoordinate(512);
		assertEquals(1.3, output, 0.0001);
		double output3 = pixelToCoordinateYTest1.pixelColToCoordinate(512);
		assertEquals(, output, 0.0001);
	}
	
	@Test
	public void pixelToCoordinateYTest2(){
		generateFractal pixelToCoordinateYTest2 = new generateFractal();
		double output = pixelToCoordinateYTest2.pixelColToCoordinate(0);
		assertEquals(-1.0, output, 0.0001);
		double output2 = pixelToCoordinateYTest2.pixelColToCoordinate(512);
		assertEquals(1.0, output, 0.0001);
		double output3 = pixelToCoordinateYTest2.pixelColToCoordinate(512);
		assertEquals(, output, 0.0001);
	}
	
	@Test
	public void pixelToCoordinateYTest3(){
		generateFractal pixelToCoordinateYTest3 = new generateFractal();
		double output = pixelToCoordinateYTest3.pixelColToCoordinate(0);
		assertEquals(-0.08, output, 0.0001);
		double output2 = pixelToCoordinateYTest3.pixelColToCoordinate(512);
		assertEquals(-0.025, output, 0.0001);
		double output3 = pixelToCoordinateYTest3.pixelColToCoordinate(512);
		assertEquals(, output, 0.0001);
	}
	
	@Test
	public void pixelToCoordinateYTest4(){
		generateFractal pixelToCoordinateYTest4 = new generateFractal();
		double output = pixelToCoordinateYTest4.pixelColToCoordinate(0);
		assertEquals(-1.3, output, 0.0001);
		double output2 = pixelToCoordinateYTest4.pixelColToCoordinate(512);
		assertEquals(1.3, output, 0.0001);
		double output3 = pixelToCoordinateYTest4.pixelColToCoordinate(512);
		assertEquals(, output, 0.0001);
	}
}