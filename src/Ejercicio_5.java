/***PROGRAMA DE CONJETURA DE COLLATZ
 * AUTOR: DAVID MCCONNELL VICENTE
 * FECHA: 10/12/2018
 * CURSO: DM1B
 */

import java.util.Scanner;

public class Ejercicio_5 {
			
	/*M�TODO--> longCiclo
	 * 
	 * Entradas--> �ste m�todo tiene como entradas la variable i que viene de las iteraciones del bucle for del main.
	 * 
	 * Salidas--> El m�todo devuelve una variable tipo int llamada contador en la que se guarda la cantidad de n�meros 
	 * 				de cada sucesi�n.
	 * 
	 * Descripci�n--> �ste m�todo tiene como funci�n hacer la formula de la conjetura de collatz de la serie de numeros 
	 * 					que se le pase y devolver la cantidad de n�mero de cada sucesi�n en la variable contador.
	 */
	public static int longCiclo(int i){
		
		int contador = 1;
		long num = i;
		
		do { 
			if (num%2==0){
				num/=2;
				contador++;
			}
			else {
				num = (num*3)+1;
				contador++;
			}
		}while(num>1);
		
		return contador;
	}
	
	/*M�TODO--> main
	 * 
	 * Entradas--> �ste m�todo no recibe nada.
	 * 
	 * Salidas--> Devuelve un tipo void lo que significa que no devuelve nada.
	 * 
	 * Descripci�n--> �ste es el m�todo ejecutor del programa en el que se escribir� parte del c�digo y se llamar� al 
	 * 					m�todo longCiclo para eecutarlo cuando lo necesite. A trav�s de este se muestra por pantalla el
	 * 					resultado que se quer�a obtener con el programa.
	 */
	public static void main (String [] args) {
		
		long min = 0, max = 0;
		int mayor = 0;
		Scanner t = new Scanner(System.in);
		
		System.out.println("-----------------------------------");
		System.out.println("PROGRAMA DE LA CONJETURA DE COLLATZ");
		System.out.println("-----------------------------------");
		System.out.println();
		
		do {
			try {
				System.out.println("Introduzca el primer n�mero");
				min = t.nextLong();
			}
			catch(Exception e){
				t.next();
				min = -1;
			}
		}while((min<0)||(min>Math.pow(2,60)));
		
		do {
			try {
				System.out.println("Introduzca el segundo n�mero");
				max = t.nextLong();
			}
			catch(Exception e){
				t.next();
				max = -1;
			}
			
		}while((min<0)||(min>Math.pow(2,60)));
		
		for (int i = (int) min; i <= max; i++) {
			
			if (longCiclo(i)>mayor)   mayor = longCiclo(i);
			else {
				mayor = mayor;
			}
			
		}
		
		System.out.println("La mayor sucesi�n es de "+ mayor +" n�meros.");
		
	}
}
