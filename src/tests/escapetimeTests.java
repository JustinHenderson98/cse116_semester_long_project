package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.doublePoint;
import code.generateFractal;

public class escapetimeTests {
	
	@Test
	public void mandlebrotTest(doublePoint XYCalc, doublePoint currentXY){
		generateFractal mandlebrotTest = new generateFractal();
		doublePoint p1 = new doublePoint(); 
		p1.x = 0.3207031250000001;
		p1.y = -0.07109374999999386;
		int output = mandlebrotTest.escapeTime(1, p1, 2, 255);
		assertEquals(255, output, 0.01);
	}
	
	@Test
	public void juliaTest(doublePoint p){
		generateFractal juliaTest = new generateFractal();
		doublePoint p2 = new doublePoint();
		p2.x = 1.0492187499999897;
		p2.y = -0.234375;
		int output = juliaTest.escapeTime(2, p2, 2, 255);
		assertEquals(255, output, 0.01);
	}

	@Test
	public void burningshipTest(doublePoint XYCalc, doublePoint currentXY){
		generateFractal burningshipTest = new generateFractal();
		doublePoint p3 = new doublePoint();
		p3.x = -1.7443359374999874;
		p3.y = -0.017451171875000338;
		int output = burningshipTest.escapeTime(3, p3, 2, 255);
		assertEquals(255, output, 0.01);
	}
	
	@Test
	public void multibrotTest(doublePoint XYCalc, doublePoint currentXY){
		generateFractal multibrotTest = new generateFractal();
		doublePoint p4 = new doublePoint();
		p4.x = 0.5859375;
		p4.y = 0.24375000000000108;
		int output = multibrotTest.escapeTime(4, p4, 2, 255);
		assertEquals(255, output, 0.01);
	}
	
	@Test
	public void juliaTest2(doublePoint XYCalc){
		update juliaTest2 = new update();
		doublePoint output = juliaTest2.juliaSet();
		assertEquals(0.0, output, 0.01);
	}
	
	@Test
	public void mandlebrotTest2(doublePoint XYCalc, doublePoint currentXY){
		update mandlebrotTest2 = new update();
		doublePoint output = mandlebrotTest2.mandlebrotSet();
		assertEquals(0.0, output, 0.01);
	}
	
	@Test
	public void multibrotTest2(doublePoint XYCalc, doublePoint currentXY){
		update multibrotTest2 = new update();
		doublePoint output = multibrotTest2.multibrotSet();
		assertEquals(0.0, output, 0.01);
	}
}