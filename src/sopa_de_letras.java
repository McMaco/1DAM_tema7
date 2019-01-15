/***PROGRAMA DE SOPA DE LETRAS
 * AUTOR: DAVID MCCONNELL VICENTE
 * FECHA: 08/01/2019
 * CURSO: DM1B
 */


import java.util.Scanner;

public class sopa_de_letras {
	
	public static char sopa[][] = new char [15][15];
	
	/*MÉTODO--> crear
	 * 
	 * Entradas--> Éste método no tiene entradas
	 * 
	 * Salidas--> El método no devuelve nada
	 * 
	 * Descripción--> Éste método tiene como función crear una sopa de letras aleatorias
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
	
	/*MÉTODO--> colocar
	 * 
	 * Entradas--> Éste método no tiene entradas
	 * 
	 * Salidas--> El método no devuelve nada
	 * 
	 * Descripción--> Éste método tiene como función mostrar y recoger las opciones que da el juego
	 */
	public static void colocar() {
		
		Scanner t = new Scanner(System.in);
		int f, c, i, opc, n=0, j=0;
		String palabra = null;
		System.out.println("INTRODUCCION DE PALABRAS: ");
		
		do {
			boolean flag=true;
			boolean print=true;
			try {
				do {
					System.out.print((j+1)+": ");
					palabra = t.next();
					palabra = palabra.toUpperCase();
				}while((palabra.length()<3)||(palabra.length()>15)||(palabra.matches(".*[^A-Z].*")));
				j++;
			}
			catch(Exception e) {
				t.nextInt();
			}
			n++;
			
			System.out.println(palabra);
			
			char v [] = palabra.toCharArray();  
			
			do {
				flag=true;
				print=true;
				try {
					
					f = (int) (Math.random() * 14);
					c = (int) (Math.random() * 14);
					sopa[f][c] = v[0];
				
					opc = (int) (Math.random()*(8-1)+1);
					switch(opc) {
						
						case 1: //DIAGONAL DE ARRIBA A ABAJO Y DE IZQUIERDA A DERECHA
							
							if(((f+(palabra.length()-1))>15)||((c+(palabra.length()-1))>15))       flag=false;
							else {
								for(i=1; i<palabra.length(); i++) {
									sopa[f+i][c+i] = v[i]; 
									if(sopa[f+i][c+i]==v[i]) {
										print=true;
									}
									else {
										print=false;
									}
								}
							}
							
						break;
						
						case 2: //DIAGONAL DE ABAJO A ARRIBA Y DE DERECHA A IZQUIERDA
							if(((f-(palabra.length()-1))<0)||((c-(palabra.length()-1))<0))       flag=false;
							else {
								for(i=1; i<palabra.length(); i++) {
									sopa[f-i][c-i] = v[i]; 
									if(sopa[f+i][c+i]==v[i]) {
										print=true;
									}
									else {
										print=false;
									}
								}
							}
							
						break;
						
						case 3: //DIAGONAL DE ARRIBA A ABAJO Y DE DERECHA A IZQUIERDA
							if(((f+(palabra.length()-1))>15)||((c-(palabra.length()-1))<0))       flag=false;
							else {
								for(i=1; i<palabra.length(); i++) {
									sopa[f+i][c-i] = v[i]; 
									if(sopa[f+i][c+i]==v[i]) {
										print=true;
									}
									else {
										print=false;
									}
								}
							}
						break;
						
						case 4: //DIAGONAL DE ABAJO A ARRIBA Y DE IZQUIERDA A DERECHA
							if(((f-(palabra.length()-1))<0)||((c+(palabra.length()-1))>15))       flag=false;
							else {
								for(i=1; i<palabra.length(); i++) {
									sopa[f-i][c+i] = v[i]; 
									if(sopa[f+i][c+i]==v[i]) {
										print=true;
									}
									else {
										print=false;
									}
								}
							}
						break;
						
						case 5: //HORIZONTAL DE IZQUIERDA A DERECHA
							if((c+(palabra.length()-1))>15)       flag=false;
							else {
								for(i=1; i<palabra.length(); i++) {
									sopa[f][c+i] = v[i]; 
									if(sopa[f+i][c+i]==v[i]) {
										print=true;
									}
									else {
										print=false;
									}
								}
							}
						break;
						
						case 6: //HORIZONTAL DE DERECHA A IZQUIERDA
							if((c-(palabra.length()-1))<0)     flag=false;
							else {
								for(i=1; i<palabra.length(); i++) {
									sopa[f][c-i] = v[i];
									if(sopa[f+i][c+i]==v[i]) {
										print=true;
									}
									else {
										print=false;
									}
								}
							}
						break;
						
						case 7: //VERTICAL DE ARRIBA A ABAJO
							if((f+(palabra.length()-1))>15)       flag=false;
							else {
								for(i=1; i<palabra.length(); i++) {
									sopa[f+i][c] = v[i];
									if(sopa[f+i][c+i]==v[i]) {
										print=true;
									}
									else {
										print=false;
									}
								}
							}
						break;
						
						case 8: //VERTICAL DE ABAJO A ARRIBA
							if((f-(palabra.length()-1))<0)       flag=false;
							else {
								for(i=1; i<palabra.length(); i++) {
									sopa[f-i][c] = v[i]; 
									if(sopa[f+i][c+i]==v[i]) {
										print=true;
									}
									else {
										print=false;
									}
									
									if((f-i)<0)     flag=false;
								}
							}
						break;
		
					}
				}
				catch(Exception e) {
				
				}
			}while((flag==false)||(print==false));
			
		}while(n<10);
			
		for(f=0; f<15; f++) {
			for(c=0; c<15; c++) {
				System.out.print(" " + sopa[f][c]);
			}
			System.out.println();
		}
		
	
	}
	

	/*MÉTODO--> main
	 *
	 * Entradas--> Éste método no tiene entradas
	 * 
	 * Salidas--> El método no devuelve nada
	 * 
	 * Descripción--> Éste método tiene como función ejecutar el programa y hacer las llamadas a los diferentes métodos
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
