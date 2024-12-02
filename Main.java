package Handson5;
import jade.core.Agent;

public class Main  extends Agent{
	 @Override
	    protected void setup() {

		int[] arrayX = new int [26];
		arrayX[0] = 108;
		arrayX[1] = 115;	
		arrayX[2] = 106;
		arrayX[3] = 97;
		arrayX[4] = 95;
		arrayX[5] = 91;
		arrayX[6] = 97;
		arrayX[7] = 83;
		arrayX[8] = 83;
		arrayX[9] = 78;
		arrayX[10] = 54;
		arrayX[11] = 67;
		arrayX[12] = 56;
		arrayX[13] = 53;
		arrayX[14] = 61;
		arrayX[15] = 115;
		arrayX[16] = 81;
		arrayX[17] = 78;
		arrayX[18] = 30;
		arrayX[19] = 45;
		arrayX[20] = 99;
		arrayX[21] = 32;
		arrayX[22] = 25;
		arrayX[23] = 28;
		arrayX[24] = 90;
		arrayX[25] = 89;

		int[] arrayY = new int [26];
		arrayY[0] = 95;
		arrayY[1] = 96;
		arrayY[2] = 95;
		arrayY[3] = 97;
		arrayY[4] = 93;
		arrayY[5] = 94;
		arrayY[6] = 95;
		arrayY[7] = 93;
		arrayY[8] = 92;
		arrayY[9] = 86;
		arrayY[10] = 73;
		arrayY[11] = 80;
		arrayY[12] = 65;
		arrayY[13] = 69;
		arrayY[14] = 77;
		arrayY[15] = 96;
		arrayY[16] = 87;
		arrayY[17] = 89;
		arrayY[18] = 60;
		arrayY[19] = 63;
		arrayY[20] = 95;
		arrayY[21] = 61;
		arrayY[22] = 55;
		arrayY[23] = 56;
		arrayY[24] = 94;
		arrayY[25] = 93;
		int[] prediccion = new int [5];
		prediccion[0] = 60;
		prediccion[1] = 61;
		prediccion[2] = 62;
		prediccion[3] = 63;
		prediccion[4] = 64;
    	LinearFittedLinePlot objecto  = new LinearFittedLinePlot(arrayX,arrayY,prediccion);
		objecto.mostrarDatos();
        QuadraticFittedLinePlot objectoC  = new QuadraticFittedLinePlot(arrayX,arrayY,prediccion);
		objectoC.mostrarDatosC();
		CubicFittedLinePlot objectoCubic  = new CubicFittedLinePlot(arrayX,arrayY,prediccion);
		objectoCubic.mostrarDatosCubic();
		Evolutivo objectoV = new Evolutivo(arrayX,arrayY);
		objectoV.mostrarb0b1();
	 }
	}
