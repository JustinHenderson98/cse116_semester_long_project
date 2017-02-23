package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.doublePoint;
import code.update;

public class escapetimeTests {
	
	@Test
	public void juliaTest(doublePoint p){
		update juliaTest = new update();
		doublePoint output = juliaTest.juliaSet(p.x);
		assertEquals(, output, 0.01);
	}
	
	@Test
	public void mandlebrotTest(doublePoint XYCalc, doublePoint currentXY){
		update mandlebrotTest = new update();
		doublePoint output = mandlebrotTest.mandlebrotSet();
		assertEquals(, output, 0.01);
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
		doublePoint output = juliaTest2.juliaSet(p.x);
		assertEquals(, output, 0.01);
	}
	
	@Test
	public void mandlebrotTest2(doublePoint XYCalc, doublePoint currentXY){
		update mandlebrotTest2 = new update();
		doublePoint output = mandlebrotTest2.mandlebrotSet();
		assertEquals(, output, 0.01);
	}
	
	@Test
	public void multibrotTest2(doublePoint XYCalc, doublePoint currentXY){
		update multibrotTest2 = new update();
		doublePoint output = multibrotTest2.multibrotSet();
		assertEquals(, output, 0.01);
	}
}