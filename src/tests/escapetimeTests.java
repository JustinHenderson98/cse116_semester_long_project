package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.doublePoint;
import code.generateFractal;

public class escapetimeTests {
	
	@Test
	public void mandlebrotNeverExceedTest(){
		generateFractal mandlebrotTest = new generateFractal();
		doublePoint p1 = new doublePoint(); 
		p1.x = 0.3207031250000001;
		p1.y = -0.07109374999999386;
		int output = mandlebrotTest.escapeTime(1, p1, 2, 255);
		assertEquals(255, output);
	}
	
	@Test
	public void juliaNeverExceedTest(){
		generateFractal juliaTest = new generateFractal();
		doublePoint p2 = new doublePoint();
		p2.x = 1.0492187499999897;
		p2.y = -0.234375;
		int output = juliaTest.escapeTime(2, p2, 2, 255);
		assertEquals(255, output);
	}

	@Test
	public void burningshipNeverExceedTest(){
		generateFractal burningshipTest = new generateFractal();
		doublePoint p3 = new doublePoint();
		p3.x = -1.7443359374999874;
		p3.y = -0.017451171875000338;
		int output = burningshipTest.escapeTime(3, p3, 2, 255);
		assertEquals(255, output);
	}
	
	@Test
	public void multibrotNeverExceedTest(){
		generateFractal multibrotTest = new generateFractal();
		doublePoint p4 = new doublePoint();
		p4.x = 0.5859375;
		p4.y = 0.24375000000000108;
		int output = multibrotTest.escapeTime(4, p4, 2, 255);
		assertEquals(255, output);
	}
	
	@Test
	public void mandlebrotExceedTest(){
		generateFractal mandlebrotTest2 = new generateFractal();
		doublePoint p6 = new doublePoint();
		p6.x = 0.3207031250000001;
		p6.y = -0.07109374999999386;
		int output = mandlebrotTest2.escapeTime(1, p6, 2, 0);
		assertEquals(0, output);
	}
	
	@Test
	public void juliaExceedTest(){
		generateFractal juliaTest2 = new generateFractal();
		doublePoint p5 = new doublePoint();
		p5.x = 1.0492187499999897;
		p5.y = -0.234375;
		int output = juliaTest2.escapeTime(2, p5, 2, 0);
		assertEquals(0, output);
	}
	
	@Test
	public void multibrotExceedTest(){
		generateFractal multibrotTest2 = new generateFractal();
		doublePoint p7 = new doublePoint();
		p7.x = 0.5859375;
		p7.y = 0.24375000000000108;
		int output = multibrotTest2.escapeTime(4, p7, 2, 0);
		assertEquals(0, output);
	}
	
	@Test
	public void mandlebrotExceedTest2(){
		generateFractal mandlebrotTest2 = new generateFractal();
		doublePoint p6 = new doublePoint();
		p6.x = 0.46007827788650374;
		p6.y = -0.3383561643835661;
		int output = mandlebrotTest2.escapeTime(1, p6, 3, 10);
		assertEquals(10, output);
	}
	
	@Test
	public void juliaExceedTest2(){
		generateFractal juliaTest2 = new generateFractal();
		doublePoint p5 = new doublePoint();
		p5.x = 1.4538160469667272;
		p5.y = -0.13502935420743645;
		int output = juliaTest2.escapeTime(2, p5, 3, 10);
		assertEquals(10, output);
	}
	
	@Test
	public void burningshipExceedTest2(){
		generateFractal burningshipTest2 = new generateFractal();
		doublePoint p3 = new doublePoint();
		p3.x =  -1.6999999999999802;
		p3.y = 0.0030136986301371603;
		int output = burningshipTest2.escapeTime(3, p3, 3, 10);
		assertEquals(10, output);
	}
	@Test
	public void multibrotExceedTest2(){
		generateFractal multibrotTest2 = new generateFractal();
		doublePoint p7 = new doublePoint();
		p7.x = 0.7025440313111545;
		p7.y = -0.5520547945205528;
		int output = multibrotTest2.escapeTime(4, p7, 3, 10);
		assertEquals(10, output);
	}
	
	@Test
	public void burningshipTestNoZeroOrOne(){
		generateFractal burningshipTest3 = new generateFractal();
		burningshipTest3.set__fractalType(3);
		int[][] output = burningshipTest3.genFractal();
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output.length; j++) {
				if(1==output[i][j] || output[i][j] == 0){
					fail();
				}
			}	
		}
	}
	
	@Test
	public void return2DArrayOfSize512(){
		generateFractal return2darray = new generateFractal();
		return2darray.set__fractalType(1);
		int[][] array = return2darray.genFractal();
		assertEquals(512, array.length);
		assertEquals(512, array[0].length);
		
		return2darray.set__fractalType(2);
		array = return2darray.genFractal();
		assertEquals(512, array.length);
		assertEquals(512, array[0].length);
		
		return2darray.set__fractalType(3);
		array = return2darray.genFractal();
		assertEquals(512, array.length);
		assertEquals(512, array[0].length);
		
		return2darray.set__fractalType(4);
		array = return2darray.genFractal();
		assertEquals(512, array.length);
		assertEquals(512, array[0].length);
	}
	@Test
	public void pixelRowToCoordinateMandlebrotTest(){
		double rangeStart = -2.15;
		double rangeEnd= 0.6;
		double space = Math.abs( (rangeEnd -  rangeStart) / 512);
		
		generateFractal pixelToCoordinateXTest1 = new generateFractal();
		double output = pixelToCoordinateXTest1.pixelRowToCoordinate(rangeStart, space, 0);
		assertEquals(-2.15, output, 0.00001);
		double output2 = pixelToCoordinateXTest1.pixelRowToCoordinate(rangeStart, space, 512);
		assertEquals(0.6, output2, 0.00001);
		double output3 = pixelToCoordinateXTest1.pixelRowToCoordinate(rangeStart, space,206);
		assertEquals(-1.043554688, output3, 0.00001);
	}
	
	@Test
	public void pixelRowToCoordinateJuliaTest(){
		double rangeStart = -1.7;
		double rangeEnd= 1.7;
		double space = Math.abs( (rangeEnd -  rangeStart) / 512);
		
		generateFractal pixelToCoordinateXTest2 = new generateFractal();
		double output = pixelToCoordinateXTest2.pixelRowToCoordinate(rangeStart, space,0);
		assertEquals(-1.7, output, 0.00001);
		double output2 = pixelToCoordinateXTest2.pixelRowToCoordinate(rangeStart, space,512);
		assertEquals(1.7, output2, 0.00001);
	}
	
	@Test
	public void pixelRowToCoordinateBurningTest(){
		double rangeStart = -1.8;
		double rangeEnd= -1.7;
		double space = Math.abs( (rangeEnd -  rangeStart) / 512);
		
		generateFractal pixelToCoordinateXTest3 = new generateFractal();
		double output = pixelToCoordinateXTest3.pixelRowToCoordinate(rangeStart, space,0);
		assertEquals(-1.8, output, 0.00001);
		double output2 = pixelToCoordinateXTest3.pixelRowToCoordinate(rangeStart, space,512);
		assertEquals(-1.7, output2, 0.00001);
	}
	
	@Test
	public void pixelRowToCoordinateMultibrotTest(){
		double rangeStart = -1.0;
		double rangeEnd= 1.0;
		double space = Math.abs( (rangeEnd -  rangeStart) / 512);
		
		generateFractal pixelToCoordinateXTest4 = new generateFractal();
		double output = pixelToCoordinateXTest4.pixelRowToCoordinate(rangeStart, space,0);
		assertEquals(-1.0, output, 0.00001);
		double output2 = pixelToCoordinateXTest4.pixelRowToCoordinate(rangeStart, space,512);
		assertEquals(1.0, output2, 0.00001);
	}
	
	@Test
	public void pixelColToCoordinateMandlebrotTest(){
		double rangeStart = -1.3;
		double rangeEnd= 1.3;
		double space = Math.abs( (rangeEnd -  rangeStart) / 512);
		
		generateFractal pixelToCoordinateYTest1 = new generateFractal();
		double output = pixelToCoordinateYTest1.pixelColToCoordinate(rangeStart, space,0);
		assertEquals(-1.3, output, 0.0001);
		double output2 = pixelToCoordinateYTest1.pixelColToCoordinate(rangeStart, space,512);
		assertEquals(1.3, output2, 0.0001);
	}
	
	@Test
	public void pixelColToCoordinateJuliaTest(){
		double rangeStart = -1.0;
		double rangeEnd= 1.0;
		double space = Math.abs( (rangeEnd -  rangeStart) / 512);
		
		generateFractal pixelToCoordinateYTest2 = new generateFractal();
		double output = pixelToCoordinateYTest2.pixelColToCoordinate(rangeStart, space,0);
		assertEquals(-1.0, output, 0.0001);
		double output2 = pixelToCoordinateYTest2.pixelColToCoordinate(rangeStart, space,512);
		assertEquals(1.0, output2, 0.0001);
	}
	
	@Test
	public void pixeColToCoordinateBurningTest(){
		double rangeStart = -0.08;
		double rangeEnd= 0.025;
		double space = Math.abs( (rangeEnd -  rangeStart) / 512);
		
		generateFractal pixelToCoordinateYTest3 = new generateFractal();
		double output = pixelToCoordinateYTest3.pixelColToCoordinate(rangeStart, space,0);
		assertEquals(-0.08, output, 0.0001);
		double output2 = pixelToCoordinateYTest3.pixelColToCoordinate(rangeStart, space,512);
		assertEquals(0.025, output2, 0.0001);
	}
	
	@Test
	public void pixelColToCoordinateMultibrotTest(){
		double rangeStart = -1.3;
		double rangeEnd= 1.3;
		double space = Math.abs( (rangeEnd -  rangeStart) / 512);
		
		generateFractal pixelToCoordinateYTest4 = new generateFractal();
		double output = pixelToCoordinateYTest4.pixelColToCoordinate(rangeStart, space,0);
		assertEquals(-1.3, output, 0.0001);
		double output2 = pixelToCoordinateYTest4.pixelColToCoordinate(rangeStart, space,512);
		assertEquals(1.3, output2, 0.0001);
	}
	
	
}