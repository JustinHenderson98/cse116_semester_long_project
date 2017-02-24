package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.doublePoint;
import code.generateFractal;
import code.update;

public class escapetimeTests {
	
	@Test
	public void juliaTest(doublePoint p){
		update juliaTest = new update();
		doublePoint output = juliaTest.juliaSet();
		assertEquals(, output, 0.01);
	}
	
	@Test
	public void mandlebrotTest(doublePoint XYCalc, doublePoint currentXY){
		generateFractal mandlebrotTest = new generateFractal();
		doublePoint p = new doublePoint(); 
		p.x = 0.3207031250000001;
		p.y = -0.07109374999999386;
		int output = mandlebrotTest.escapeTime(1, p, 4, 255);
		assertEquals(255, output, 0.01);
	}

	@Test
	public void burningshipTest(doublePoint XYCalc, doublePoint currentXY){
		update burningshipTest = new update();
		doublePoint output = burningshipTest.burningShipSet();
		assertEquals(, output, 0.01);
	}
	
	@Test
	public void multibrotTest(doublePoint XYCalc, doublePoint currentXY){
		update multibrotTest = new update();
		doublePoint output = multibrotTest.multibrotSet();
		assertEquals(, output, 0.01);
	}
	
	@Test
	public void juliaTest2(doublePoint XYCalc){
		update juliaTest2 = new update();
		doublePoint output = juliaTest2.juliaSet();
		assertEquals(255.0, output, 0.01);
	}
	
	@Test
	public void mandlebrotTest2(doublePoint XYCalc, doublePoint currentXY){
		update mandlebrotTest2 = new update();
		doublePoint output = mandlebrotTest2.mandlebrotSet();
		assertEquals(255.0, output, 0.01);
	}
	
	@Test
	public void multibrotTest2(doublePoint XYCalc, doublePoint currentXY){
		update multibrotTest2 = new update();
		doublePoint output = multibrotTest2.multibrotSet();
		assertEquals(255.0, output, 0.01);
	}
}