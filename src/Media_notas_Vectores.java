
import java.util.Scanner;

public class Media_notas_Vectores {
	
	private static float[] notas; //Declaración del vector notas
		
	final static int POS = 10; //Número de posiciones del vector
	
	public static void main(String [] args) {
		
		float media = 0;
		
		Scanner t = new Scanner(System.in);
		
		//CREACION DEL VECTOR NOTAS
		notas = new float[POS];
		
		//LEER LOS VALORES DE NOTA
		for (int i=0;i<POS;i++) {
			do {
				try {
					System.out.println("Introduzca la nota "+ (i+1) +" (entre 0 y 10): ");
					notas[i] = t.nextFloat();
					
				}catch(Exception e) {
					System.out.println("Error de introduccion de nota");
					t.next();
					notas[i]=-1;
				}
			}while((notas[i]<0)||(notas[i]>10));
		}
		
		//MOSTRAR LAS NOTAS
		System.out.println();
		for(int i=0;i<POS;i++) {
			System.out.println("Nota "+ (i+1) +": "+ notas[i]);
		}
		
		//HACER LA MEDIA
		for (int i=0;i<POS;i++) {
			media = media + notas[i];
		}
		media = media / POS;
		System.out.println("La media de las notas es: "+ media);
		
		//TROLLEADA
		if(media>=5) {
			System.out.println("                              ----------------------------");
			System.out.println("                              ¡OHH ERES UN CHICO APLICADO!");
			System.out.println("                              ----------------------------");
		}
		
		else {
			System.out.println("                              -------------");
			System.out.println("                               AL POZO :(");
			System.out.println("                              -------------");
		}
	}

}
