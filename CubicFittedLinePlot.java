package Handson5;

import jade.core.Agent;

public class CubicFittedLinePlot extends Agent {
	int n = 26;
	int x = 0;
	int y = 0;
	int xc2 = 0;
	int xc3 = 0;
	int xc4 = 0;
	long xc5 = 0;
	long xc6 = 0;
	int xy = 0;
	int xc2y =0;
	int xc3y = 0;
	int[] arrayX = new int [4];
	int[] arrayY = new int [4];
	int[] prediccion = new int[4];
	public CubicFittedLinePlot (int[] arrayX,int[] arrayY,int[] prediccion) {
		this.arrayX = arrayX;
		this.arrayY = arrayY;
		this.prediccion = prediccion;
	}
	public void mostrarDatosCubic() {
		for (int i=0 ; i<n ; i++) {
			x = (x+arrayX[i]);
			y = (y+arrayY[i]);
			xc2 = (xc2+(arrayX[i]*arrayX[i]));
			xc3 = (xc3+(arrayX[i]*arrayX[i]*arrayX[i]));
			xc4 = (xc4+(arrayX[i]*arrayX[i]*arrayX[i]*arrayX[i]));
			xc5 = (xc5+(arrayX[i]*arrayX[i]*arrayX[i]*arrayX[i]*arrayX[i]));
			xc6 = (xc6+(arrayX[i]*arrayX[i]*arrayX[i]*arrayX[i]*arrayX[i]*arrayX[i]));
			xy = (xy+(arrayX[i]*arrayY[i]));
			xc2y = (xc2y+((arrayX[i]*arrayX[i])*arrayY[i]));
			xc3y = (xc3y+((arrayX[i]*arrayX[i])*arrayY[i]*arrayY[i]));
		}
		//xc5 = 141485738256;
		//xc6 = 14187643590752;
					
		double[] Gaus1 = new double [5];
		Gaus1[0] = n;
		Gaus1[1] = x;
		Gaus1[2] = xc2;
		Gaus1[3] = xc3;
		Gaus1[4] = y;
		double[] Gaus2 = new double [5];
		Gaus2[0] = x;
		Gaus2[1] = xc2;
		Gaus2[2] = xc3;
		Gaus2[3] = xc4;
		Gaus2[4] = xy;
		double[] Gaus3 = new double [5];
		Gaus3[0] = xc2;
		Gaus3[1] = xc3;
		Gaus3[2] = xc4;
		Gaus3[3] = xc5;
		Gaus3[4] = xc2y;
		double[] Gaus4 = new double [5];
		Gaus4[0] = xc3;
		Gaus4[1] = xc4;
		Gaus4[2] = xc5;
		Gaus4[3] = xc6;
		Gaus4[4] = xc3y;

		Gaus1[1] = Gaus1[1]/Gaus1[0];
		Gaus1[2] = Gaus1[2]/Gaus1[0];
		Gaus1[3] = Gaus1[3]/Gaus1[0];
		Gaus1[4] = Gaus1[4]/Gaus1[0];
	    Gaus1[0] = Gaus1[0]/Gaus1[0];

			Gaus2[1] = (Gaus1[1]*(Gaus2[0]*-1)+Gaus2[1]);
			Gaus2[2] = (Gaus1[2]*(Gaus2[0]*-1)+Gaus2[2]);
			Gaus2[3] = (Gaus1[3]*(Gaus2[0]*-1)+Gaus2[3]);
			Gaus2[4] = (Gaus1[4]*(Gaus2[0]*-1)+Gaus2[4]);
			Gaus2[0] = (Gaus1[0]*(Gaus2[0]*-1)+Gaus2[0]);

			Gaus3[1] = (Gaus1[1]*(Gaus3[0]*-1)+Gaus3[1]);
			Gaus3[2] = (Gaus1[2]*(Gaus3[0]*-1)+Gaus3[2]);
			Gaus3[3] = (Gaus1[3]*(Gaus3[0]*-1)+Gaus3[3]);
			Gaus3[4] = (Gaus1[4]*(Gaus3[0]*-1)+Gaus3[4]);
			Gaus3[0] = (Gaus1[0]*(Gaus3[0]*-1)+Gaus3[0]);
			
			Gaus4[1] = (Gaus1[1]*(Gaus4[0]*-1)+Gaus4[1]);
			Gaus4[2] = (Gaus1[2]*(Gaus4[0]*-1)+Gaus4[2]);
			Gaus4[3] = (Gaus1[3]*(Gaus4[0]*-1)+Gaus4[3]);
			Gaus4[4] = (Gaus1[4]*(Gaus4[0]*-1)+Gaus4[4]);
			Gaus4[0] = (Gaus1[0]*(Gaus4[0]*-1)+Gaus4[0]);
			
			Gaus2[2] = Gaus2[2]/Gaus2[1];
			Gaus2[3] = Gaus2[3]/Gaus2[1];
			Gaus2[4] = Gaus2[4]/Gaus2[1];
			Gaus2[1] = Gaus2[1]/Gaus2[1];

			Gaus1[2] = (Gaus2[2]*(Gaus1[1]*-1)+Gaus1[2]);
			Gaus1[3] = (Gaus2[3]*(Gaus1[1]*-1)+Gaus1[3]);
			Gaus1[4] = (Gaus2[4]*(Gaus1[1]*-1)+Gaus1[4]);
			Gaus1[1] = (Gaus2[1]*(Gaus1[1]*-1)+Gaus1[1]);

			Gaus3[2] = (Gaus2[2]*(Gaus3[1]*-1)+Gaus3[2]);
			Gaus3[3] = (Gaus2[3]*(Gaus3[1]*-1)+Gaus3[3]);
			Gaus3[4] = (Gaus2[4]*(Gaus3[1]*-1)+Gaus3[4]);
			Gaus3[1] = (Gaus2[1]*(Gaus3[1]*-1)+Gaus3[1]);
		
			Gaus4[2] = (Gaus2[2]*(Gaus4[1]*-1)+Gaus4[2]);
			Gaus4[3] = (Gaus2[3]*(Gaus4[1]*-1)+Gaus4[3]);
			Gaus4[4] = (Gaus2[4]*(Gaus4[1]*-1)+Gaus4[4]);
			Gaus4[1] = (Gaus2[1]*(Gaus4[1]*-1)+Gaus4[1]);
			
			Gaus3[3] = Gaus3[3]/Gaus3[2];
			Gaus3[4] = Gaus3[4]/Gaus3[2];
			Gaus3[2] = Gaus3[2]/Gaus3[2];
			
			Gaus1[3] = (Gaus3[3]*(Gaus1[2]*-1)+Gaus1[3]);
			Gaus1[4] = (Gaus3[4]*(Gaus1[2]*-1)+Gaus1[4]);
			Gaus1[2] = (Gaus3[2]*(Gaus1[2]*-1)+Gaus1[2]);
			
			Gaus2[3] = (Gaus3[3]*(Gaus2[2]*-1)+Gaus2[3]);
			Gaus2[4] = (Gaus3[4]*(Gaus2[2]*-1)+Gaus2[4]);
			Gaus2[2] = (Gaus3[2]*(Gaus2[2]*-1)+Gaus2[2]);
			
			Gaus4[3] = (Gaus3[3]*(Gaus4[2]*-1)+Gaus4[3]);
			Gaus4[4] = (Gaus3[4]*(Gaus4[2]*-1)+Gaus4[4]);
			Gaus4[2] = (Gaus3[2]*(Gaus4[2]*-1)+Gaus4[2]);
			
			Gaus4[4] = Gaus4[4]/Gaus4[3];
			Gaus4[3] = Gaus4[3]/Gaus4[3];
			
			Gaus1[4] = (Gaus4[4]*(Gaus1[3]*-1)+Gaus1[4]);
			Gaus1[3] = (Gaus4[3]*(Gaus1[3]*-1)+Gaus1[3]);
			
			Gaus2[4] = (Gaus4[4]*(Gaus2[3]*-1)+Gaus2[4]);
			Gaus2[3] = (Gaus4[3]*(Gaus2[3]*-1)+Gaus2[3]);
			
			Gaus3[4] = (Gaus4[4]*(Gaus3[3]*-1)+Gaus3[4]);
			Gaus3[3] = (Gaus4[3]*(Gaus3[3]*-1)+Gaus3[3]);
			System.out.println("--------------------------------------------------------------------");
			System.out.println("b0 = "+Gaus1[4]);
			System.out.println("b1 = "+Gaus2[4]);
			System.out.println("b2 = "+Gaus3[4]);
			System.out.println("b3 = "+Gaus4[4]);
			double b0 = Gaus1[4];
			double b1 = Gaus2[4];
			double b2 = Gaus3[4];
			double b3 = Gaus4[4];


			for (int i=0 ; i<5 ; i++)
		    	System.out.println("la prediccion de "+prediccion[i]+" es igual a: "+((b0+b1*prediccion[i])+b2*(prediccion[i]*prediccion[i])+b3*(prediccion[i]*prediccion[i]*prediccion[i])));
		    	
			System.out.println("--------------------------------------------------------------------");

			}

}
