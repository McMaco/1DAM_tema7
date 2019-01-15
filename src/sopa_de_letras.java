/***PROGRAMA DE SOPA DE LETRAS
 * AUTOR: DAVID MCCONNELL VICENTE
 * FECHA: 08/01/2019
 * CURSO: DM1B
 */


import java.util.Scanner;

public class sopa_de_letras {
	
	public static char sopa[][] = new char [15][15];
	
	/*M�TODO--> crear
	 * 
	 * Entradas--> �ste m�todo no tiene entradas
	 * 
	 * Salidas--> El m�todo no devuelve nada
	 * 
	 * Descripci�n--> �ste m�todo tiene como funci�n crear una sopa de letras aleatorias
	 */
	public static void crear() {
		
		int f, c;
		
		for(f=0; f<15; f++) {
			for(c=0; c<15; c++) {
				sopa[f][c] = (char) (Math.random()* 26 + 'A'); 
			}
		}
		System.out.println();
	}
	
	/*M�TODO--> colocar
	 * 
	 * Entradas--> �ste m�todo no tiene entradas
	 * 
	 * Salidas--> El m�todo no devuelve nada
	 * 
	 * Descripci�n--> �ste m�todo tiene como funci�n mostrar y recoger las opciones que da el juego
	 */
	public static void colocar() {
		
		Scanner t = new Scanner(System.in);
		int f, c, i, opc, n=0, j=0;
		String palabra = null;
		System.out.println("INTRODUCCION DE PALABRAS: ");
		
		do {
			boolean flag=true;
			try {
				do {
					System.out.print((j+1)+": ");
					palabra = t.nextLine();
					palabra = palabra.toUpperCase();
				}while((palabra.length()<3)||(palabra.length()>15));
				j++;
			}
			catch(Exception e) {
				t.nextInt();
			}
			n++;
			
			System.out.println(palabra);
			
			char v [] = palabra.toCharArray();  
			
			do {
				
				try {
					
					f = (int) (Math.random() * 15);
					c = (int) (Math.random() * 15);
					sopa[f][c] = v[0];
				
					opc = (int) (Math.random()*(8-1)+1);
					switch(opc) {
						
						case 1: //DIAGONAL DE ARRIBA A ABAJO Y DE IZQUIERDA A DERECHA
							for(i=1; i<palabra.length(); i++) {
								sopa[f+i][c+i] = v[i]; 
								if(((f+i)>15)||((c+i)>15))       flag=false;
							}
						break;
						
						case 2: //DIAGONAL DE ABAJO A ARRIBA Y DE DERECHA A IZQUIERDA
							for(i=1; i<palabra.length(); i++) {
								sopa[f-i][c-i] = v[i]; 
								if(((f-i)<0)||((c-i)<0))         flag=false;
							}
						break;
						
						case 3: //DIAGONAL DE ARRIBA A ABAJO Y DE DERECHA A IZQUIERDA
							for(i=1; i<palabra.length(); i++) {
								sopa[f+i][c-i] = v[i]; 
								if(((f+i)>15)||((c-i)<0))        flag=false;
							}
						break;
						
						case 4: //DIAGONAL DE ABAJO A ARRIBA Y DE IZQUIERDA A DERECHA
							for(i=1; i<palabra.length(); i++) {
								sopa[f-i][c+i] = v[i]; 
								if(((f-i)<0)||((c+i)>15))        flag=false;
							}
						break;
						
						case 5: //HORIZONTAL DE IZQUIERDA A DERECHA
							for(i=1; i<palabra.length(); i++) {
								sopa[f][c+i] = v[i]; 
								if((c+i)>15)        flag=false;
							}
						break;
						
						case 6: //HORIZONTAL DE DERECHA A IZQUIERDA
							for(i=1; i<palabra.length(); i++) {
								sopa[f][c-i] = v[i];
								if((c-i)<0)        flag=false;
							}
						break;
						
						case 7: //VERTICAL DE ARRIBA A ABAJO
							for(i=1; i<palabra.length(); i++) {
								sopa[f+i][c] = v[i];
								if((f+i)>15)      flag=false;
							}
						break;
						
						case 8: //VERTICAL DE ABAJO A ARRIBA
							for(i=1; i<palabra.length(); i++) {
								sopa[f-i][c] = v[i]; 
								if((f-i)<0)     flag=false;
							}
						break;
		
					}
				}
				catch(Exception e) {
				
				}
			}while(flag==false);
			
		}while(n<10);
			
		for(f=0; f<15; f++) {
			for(c=0; c<15; c++) {
				System.out.print(" " + sopa[f][c]);
			}
			System.out.println();
		}
		
	
	}
	

	/*M�TODO--> main
	 *
	 * Entradas--> �ste m�todo no tiene entradas
	 * 
	 * Salidas--> El m�todo no devuelve nada
	 * 
	 * Descripci�n--> �ste m�todo tiene como funci�n ejecutar el programa y hacer las llamadas a los diferentes m�todos
	 */
	public static void main (String [] args) {
		
		System.out.println("--------------");
		System.out.println("SOPA DE LETRAS");
		System.out.println("--------------");
		System.out.println();
		
		crear();
		colocar();
	}

}
