package Handson5;

import jade.core.Agent;

public class QuadraticFittedLinePlot extends Agent{
	int n = 26;
int x = 0;
int y = 0;
int xc2 = 0;
int xc3 = 0;
int xc4 = 0;
int xy = 0;
int xc2y =0;
int[] arrayX = new int [4];
int[] arrayY = new int [4];
int[] prediccion = new int[4];
public QuadraticFittedLinePlot (int[] arrayX,int[] arrayY,int[] prediccion) {
	this.arrayX = arrayX;
	this.arrayY = arrayY;
	this.prediccion = prediccion;
}
public void mostrarDatosC() {
	for (int i=0 ; i<n ; i++) {
		x = (x+arrayX[i]);
		y = (y+arrayY[i]);
		xc2 = (xc2+(arrayX[i]*arrayX[i]));
		xc3 = (xc3+(arrayX[i]*arrayX[i]*arrayX[i]));
		xc4 = (xc4+(arrayX[i]*arrayX[i]*arrayX[i]*arrayX[i]));
		xy = (xy+(arrayX[i]*arrayY[i]));
		xc2y = (xc2y+((arrayX[i]*arrayX[i])*arrayY[i]));
	}
 /*	System.out.println("y="+y);
	System.out.println("x="+x);
	System.out.println("xc2="+xc2);
	System.out.println("xc3="+xc3);
	System.out.println("xc4="+xc4);
	System.out.println("xy="+xy);
	System.out.println("xc2y="+xc2y);
	*/
	float[] Gaus1 = new float [4];
	Gaus1[0] = n;
	Gaus1[1] = x;
	Gaus1[2] = xc2;
	Gaus1[3] = y;
	float[] Gaus2 = new float [4];
	Gaus2[0] = x;
	Gaus2[1] = xc2;
	Gaus2[2] = xc3;
	Gaus2[3] = xy;
	float[] Gaus3 = new float [4];
	Gaus3[0] = xc2;
	Gaus3[1] = xc3;
	Gaus3[2] = xc4;
	Gaus3[3] = xc2y;
	
	Gaus1[1] = Gaus1[1]/Gaus1[0];
	Gaus1[2] = Gaus1[2]/Gaus1[0];
	Gaus1[3] = Gaus1[3]/Gaus1[0];
		Gaus1[0] = Gaus1[0]/Gaus1[0];

		Gaus2[1] = (Gaus1[1]*(Gaus2[0]*-1)+Gaus2[1]);
		Gaus2[2] = (Gaus1[2]*(Gaus2[0]*-1)+Gaus2[2]);
		Gaus2[3] = (Gaus1[3]*(Gaus2[0]*-1)+Gaus2[3]);
		Gaus2[0] = (Gaus1[0]*(Gaus2[0]*-1)+Gaus2[0]);

		Gaus3[1] = (Gaus1[1]*(Gaus3[0]*-1)+Gaus3[1]);
		Gaus3[2] = (Gaus1[2]*(Gaus3[0]*-1)+Gaus3[2]);
		Gaus3[3] = (Gaus1[3]*(Gaus3[0]*-1)+Gaus3[3]);
		Gaus3[0] = (Gaus1[0]*(Gaus3[0]*-1)+Gaus3[0]);
		
		Gaus2[2] = Gaus2[2]/Gaus2[1];
		Gaus2[3] = Gaus2[3]/Gaus2[1];
		Gaus2[1] = Gaus2[1]/Gaus2[1];

		Gaus1[2] = (Gaus2[2]*(Gaus1[1]*-1)+Gaus1[2]);
		Gaus1[3] = (Gaus2[3]*(Gaus1[1]*-1)+Gaus1[3]);
		Gaus1[1] = (Gaus2[1]*(Gaus1[1]*-1)+Gaus1[1]);

		Gaus3[2] = (Gaus2[2]*(Gaus3[1]*-1)+Gaus3[2]);
		Gaus3[3] = (Gaus2[3]*(Gaus3[1]*-1)+Gaus3[3]);
		Gaus3[1] = (Gaus2[1]*(Gaus3[1]*-1)+Gaus3[1]);
	
		Gaus3[3] = Gaus3[3]/Gaus3[2];
		Gaus3[2] = Gaus3[2]/Gaus3[2];
		
		Gaus1[3] = (Gaus1[2]*(Gaus3[3]*-1)+Gaus1[3]);
		Gaus1[2] = (Gaus1[2]*(Gaus3[2]*-1)+Gaus1[2]);
		
		Gaus2[3] = (Gaus2[2]*(Gaus3[3]*-1)+Gaus2[3]);
		Gaus2[2] = (Gaus2[2]*(Gaus3[2]*-1)+Gaus2[2]);
		System.out.println("--------------------------------------------------------------------");

		System.out.println("b0 ="+Gaus1[3]);
		System.out.println("b1 ="+Gaus2[3]);
		System.out.println("b2 ="+Gaus3[3]);
		float b0 = Gaus1[3];
		float b1 = Gaus2[3];
		float b2 = Gaus3[3];

		for (int i=0 ; i<5 ; i++)
	    	System.out.println("la prediccion de "+prediccion[i]+" es igual a: "+((b0+b1*prediccion[i])+b2*(prediccion[i]*prediccion[i])));
	    	

		}
}
