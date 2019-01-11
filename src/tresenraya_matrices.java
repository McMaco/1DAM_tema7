/***PROGRAMA DE 3 EN RAYA
 * AUTOR: DAVID MCCONNELL VICENTE
 * FECHA: 25/12/2018
 * CURSO: DM1B
 */

import java.util.Scanner;

public class tresenraya_matrices{
	
	public static char[][] m = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
	
	/*MÉTODO--> tablero
	 * 
	 * Entradas--> Éste método no tiene entradas
	 * 
	 * Salidas--> El método no devuelve nada
	 * 
	 * Descripción--> Éste método tiene como función imprimir el tablero del juego
	 */
	public static void tablero() {

		System.out.println("  --- --- --- ");
		System.out.println(" | " + m[0][0] + " | " + m[0][1] + " | " + m[0][2] + " | ");
		System.out.println(" | " + m[1][0] + " | " + m[1][1] + " | " + m[1][2] + " | ");
		System.out.println(" | " + m[2][0] + " | " + m[2][1] + " | " + m[2][2] + " | ");
		System.out.println("  --- --- --- ");
	}
	
	/*MÉTODO--> posicionamiento
	 * 
	 * Entradas--> Éste método no tiene entradas
	 * 
	 * Salidas--> El método no devuelve nada
	 * 
	 * Descripción--> Éste método tiene como función recoger las posiciones que cada jugador desea pintar y comprobar si están
	 * ya cubiertas por otra ficha o de lo contrario pintarla.
	 */
	public static void posicionamiento() {
		
		Scanner t = new Scanner(System.in);
		
		int c, f, fichas=0;
		boolean flag = false;
		tablero();
		do {
			flag = false;
			do {
					//DATOS JUGADOR 1
					System.out.println("Jugador 1:");
					do {
						try {
							System.out.println("Introduce la fila 1-3:");
							f = t.nextInt();
							f -=1;
						}
						catch(Exception e) {
							t.next();
							f = -1;
						}
					}while((f<0)||(f>2));
					do {
						try {
							System.out.println("Introduce la columna 1-3:");
							c = t.nextInt();
							c-=1;
						}
						catch(Exception e) {
							t.next();
							c = -1;
						}
					}while((c<0)||(c>2));
					
					if(m[f][c] == ' ') {
						m[f][c] = 'X';
						fichas+=1;
						flag = true;
					}				
		
					else {
						System.out.println("Esta posición ya está pintada");
						System.out.println();
						flag = false;
					}
		
				System.out.println();
				
				System.out.println();

				tablero();
				System.out.println();
				
			}while(flag==false);
			
			//DATOS JUGADOR 2
			do {
				System.out.println("Jugador 2.");
				do {
					try {
						System.out.println("Introduce la fila 1-3:");
						f = t.nextInt();
						f-=1;
					}
					catch(Exception e) {
						t.next();
						f = -1;
					}
				}while((f<0)||(f>2));
				do {
					try {
						System.out.println("introduce la columna 1-3:");
						c = t.nextInt();
						c-=1;
					}
					catch(Exception e) {
						t.next();
						c = -1;
					}
				}while((c<0)||(c>2));
					
				if (m[f][c] == ' ') {
					m[f][c] = 'O';
					flag=true;
				}
				else {
					System.out.println("Esta posición ya está pintada");
					System.out.println();
					flag=false;
				}
				
				System.out.println();
				
				System.out.println();

				tablero();
				System.out.println();
				
			}while(flag==false);
			
			fichas+=1;
		
		}while(fichas<6);
	}
	
	/*MÉTODO--> comprobaciones
	 * 
	 * Entradas--> Éste método recibe una variable de tipo boolean 
	 * 
	 * Salidas--> El método devuelve una variable de tipo boolean
	 * 
	 * Descripción--> Éste método tiene como función comprobar si alguno de los jugadores ha conseguido hacer 3 en raya
	 */
	public static boolean comprobaciones(boolean win) {
		
		if((m[0][0]=='X') && (m[0][1]=='X') && (m[0][2]=='X')){
	        System.out.println("Ha ganado el jugador 1");
	        win = true;
		}
		else {
			if((m[0][0]=='X') && (m[0][1]=='X') && (m[0][2]=='X')){
		        System.out.println("Ha ganado el jugador 1");
		        win = true;
			}
			else {
				if((m[0][0]=='X') && (m[1][0]=='X') && (m[2][0]=='X')){
			        System.out.println("Ha ganado el jugador 1");
			        win = true;
			    }
				else {
					 if((m[0][0]=='X') && (m[1][1]=='X') && (m[2][2]=='X')){
					    	System.out.println("Ha ganado el jugador 1");
					    	 win = true;
					 }
					 else {
						 if((m[0][2]=='X') && (m[1][1]=='X') && (m[2][0]=='X')){
						    	System.out.println("Ha ganado el jugador 1");
						    	 win = true;
						 }
						 else {
							 if((m[1][0]=='X') && (m[1][1]=='X') && (m[1][2]=='X')){
							    	System.out.println("Ha ganado el jugador 1");
							    	 win = true;
							 }
							 else {
								 if((m[2][0]=='X') && (m[2][1]=='X') && (m[2][2]=='X')){
								    	System.out.println("Ha ganado el jugador 1");
								    	 win = true;
								 }
								 else {
									 if((m[0][1]=='X') && (m[1][1]=='X') && (m[2][1]=='X')){
									    	System.out.println("Ha ganado el jugador 1");
									    	 win = true;
									 }
									 else {
										if((m[0][2]=='X') && (m[1][2]=='X') && (m[2][2]=='X')){
									        System.out.println("Ha ganado el jugador 1");
									        win = true;
									    }
										else {
											if((m[0][0]=='O') && (m[0][1]=='O') && (m[0][2]=='O')){
										    	System.out.println("Ha ganado el jugador 2");
										    	 win = true;
											}
											else {
												if((m[0][0]=='O') && (m[1][0]=='O') && (m[2][0]=='O')){
											        System.out.println("Ha ganado el jugador 2");
											        win = true;
											    }
												else {
													 if((m[0][0]=='O') && (m[1][1]=='O') && (m[2][2]=='O')){
													    	System.out.println("Ha ganado el jugador 2");
													    	 win = true;
													 }
													 else {
														 if((m[0][2]=='O') && (m[1][1]=='O') && (m[2][0]=='O')){
														    	System.out.println("Ha ganado el jugador 2");
														    	 win = true;
														 }
														 else {
															 if((m[1][0]=='O') && (m[1][1]=='O') && (m[1][2]=='O')){
															    	System.out.println("Ha ganado el jugador 2");
															    	 win = true;
															 }
															 else {
																 if((m[2][0]=='O') && (m[2][1]=='O') && (m[2][2]=='O')){
																    	System.out.println("Ha ganado el jugador 2");
																    	 win = true;
																 }
																 else {
																	 if((m[0][1]=='O') && (m[1][1]=='O') && (m[2][1]=='O')){
																	    	System.out.println("Ha ganado el jugador 2");
																	    	 win = true;
																	 }
																	 else {
																		 if((m[0][2]=='O') && (m[1][2]=='O') && (m[2][2]=='O')){
																		        System.out.println("Ha ganado el jugador 2");
																		        win = true;
																		 }
																	 }
																 }
															 }
														 }
													 }
												}
											}
										}
									 }
								 } 
							 }
						 }
					 }
				}
			}
		}
		
		return win;
	}

	public static void main(String[] args) {

		System.out.println(" ------------");
		System.out.println("|TRES EN RAYA|");
		System.out.println(" ------------");
		
		Scanner t = new Scanner (System.in);
		boolean win = false;
		int opc = 1, r = 3;
		
		do {
			posicionamiento();
			comprobaciones(win);
			
			if ((win==true)||(r>=30)){
				do {
					try {
						System.out.println("Si desea seguir jugando introduzca un 1, de lo contrario introduzca un 0: ");
						opc = t.nextInt();
					}
					catch(Exception e) {
						t.next();
						opc  = -1;
					}
				}while((opc<0)||(opc>1));	
			}
			
		}while(opc==1);
		
		System.out.println("GRACIAS POR JUGAR A | 3 EN RAYA |");
	}
}
				