package Handson5;
import jade.core.Agent;
import java.util.Random;

public class Evolutivo extends Agent {
	int[] arrayX = new int [4];
	int[] arrayY = new int [4];
	float[] predicciones = new float[26];
	public Evolutivo (int[] arrayX,int[] arrayY) {
		this.arrayX = arrayX;
		this.arrayY = arrayY;
	}
	public void mostrarb0b1() {
		double sumatoriar2 = 0;
		double sumatoriab1 = 0;
		double sumatoriab0 = 0;
		int sumatorias = 0;
		for (int j=0 ;j<100;j++) {
        float b0 = (float) (Math.random() * 50);
        float b1 = (float) (Math.random() * 50);		
        for (int i =0;i<26;i++)
        	predicciones[i] = (b0+b1*arrayX[i]);
        	
        	float sumatoria = 0;
        	for (int i=0 ; i<26 ;i++)
        		sumatoria +=(arrayY[i]-predicciones[i])*(arrayY[i]-predicciones[i]);

        	float sumatoria2 = 0;
        	for (int i=0; i<26 ;i++) 
        		sumatoria2 += arrayY[i];
        	sumatoria2 = sumatoria2/4;
        	float sumatoria3 = 0;
        	for (int i=0;i<26;i++)
        		sumatoria3 += (arrayY[i]-sumatoria2)*(arrayY[i]-sumatoria2);
        		
        	float r2 =1-(sumatoria/sumatoria3);
        	
        	if (r2 >= .7) {
        		sumatoriar2 += r2;
        		sumatoriab0 += b0;
        		sumatoriab1 += b1;
        		sumatorias++;
        		}
		}
		sumatoriar2 = sumatoriar2/sumatorias;
		sumatoriab0 = sumatoriab0/sumatorias;
		sumatoriab1 = sumatoriab1/sumatorias;

		System.out.println("El indice de error es de "+sumatoriar2);    
		System.out.println("B0 ="+sumatoriab0);
		System.out.println("B1 ="+sumatoriab1);
	}
}
