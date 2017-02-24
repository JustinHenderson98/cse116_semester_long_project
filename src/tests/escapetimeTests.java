package tests;

import static org.junit.Assert.*;

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
		int output = mandlebrotTest.escapeTime(1, p1, 2, 255);
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
	public void return2darray(){
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
}