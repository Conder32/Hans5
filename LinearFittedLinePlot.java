package Handson5;

import jade.core.Agent;

public class LinearFittedLinePlot extends Agent{
	int n = 26;
	int[] arrayX = new int [4];
	int[] arrayY = new int [4];
	int[] prediccion = new int[4];
    Float CotinuidadX = (float) 0; 
    Float CotinuidadXP = (float) 0;
    Float CotinuidadY = (float) 0;
    Float CotinuidadXY = (float) 0;
	  public LinearFittedLinePlot (int[] arrayX,int[] arrayY,int[] prediccion) {
	    	this.arrayX = arrayX;
	    	this.arrayY = arrayY;
	    	this.prediccion = prediccion;
	    }
	  public void mostrarDatos() {

	    	for (int i=0 ; i<n ; i++) {
	    		CotinuidadX = (CotinuidadX+arrayX[i]);
	    		CotinuidadXP = (CotinuidadXP+(arrayX[i]*arrayX[i]));
	    		CotinuidadY = (CotinuidadY+arrayY[i]);
	    		CotinuidadXY = (CotinuidadXY+(arrayX[i]*arrayY[i]));
	    	}
			System.out.println("--------------------------------------------------------------------");

	    	float b0 = ((CotinuidadXP*CotinuidadY-CotinuidadX*CotinuidadXY)/(n*CotinuidadXP-CotinuidadX*CotinuidadX));
	    	float b1 = ((n*CotinuidadXY-CotinuidadX*CotinuidadY)/(n*CotinuidadXP-CotinuidadX*CotinuidadX));
	    	System.out.println("El Valor de B0 :"+b0);
	    	System.out.println("El Valor de B1 :"+b1);
	    	for (int i=0 ; i<5 ; i++)
	    	System.out.println("la prediccion de "+prediccion[i]+" es igual a: "+(b0+b1*prediccion[i]));

	    }
}
