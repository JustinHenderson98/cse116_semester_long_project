package edu.buffalo.cse116;


import code.*;
public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
	  generateFractal genFrac = new generateFractal();
	  
	  int[][] pot = genFrac.genFractal(4);
	  for (int i = 0; i < pot.length; i++) {
		  System.out.println("");
		for (int j = 0; j < pot.length; j++) {
			System.out.print(pot[i][j]);
			
			
		}
	}
	  
  }

}
