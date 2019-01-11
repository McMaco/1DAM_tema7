/***PROGRAMA DE ARCADE PIEDRA, PAPEL O TIJERA
 * AUTOR: DAVID MCCONNELL VICENTE
 * FECHA: 02/01/2019
 * CURSO: DM1B
 */

import java.util.Scanner;

public class Arcade_p_x_t {
	
	/*MÉTODO--> opciones
	 * 
	 * Entradas--> Éste método no tiene entradas
	 * 
	 * Salidas--> El método no devuelve nada
	 * 
	 * Descripción--> Éste método tiene como función mostrar y recoger las opciones que da el juego
	 */
	public static void opciones() {
		
		int opc, n;
		
		String p1, x1, t1, p2, x2, t2;
		
		Scanner t = new Scanner(System.in);
		
		do {
			do {
				System.out.println("0.- VOLVER");
				System.out.println("1.- CONTROLES");
				System.out.println("2.- NIVEL");
				System.out.println();
				try {
					System.out.print("Introduzca una de las opciones: ");
					opc = t.nextInt();
				}
				catch(Exception e){
					t.next();
					opc = -1;
				}
			}while((opc<0)||(opc>2));
			
			switch(opc) {
			
			case 0: // VOLVER
				System.out.println("Volviendo al menú principal...");
			break;
			
			case 1: // CONTROLES	
				System.out.println("¿Controles para un jugador (1) o dos jugadores (2)?");
				n = t.nextInt();
				
				if(n==1){
					System.out.println("Introduzca una letra por cada elemento");
					System.out.print("PIEDRA: ");
					p1 = t.nextLine();
					System.out.println();
				
				
					System.out.print("PAPEL: ");
					x1 = t.nextLine();
					System.out.println();
				
				
					System.out.print("TIJERA: ");
					t1 = t.nextLine();
					System.out.println();
			
						
				}
				else {
					System.out.println("Introduzca una letra por cada elemento del jugador 1");
					System.out.print("PIEDRA: ");
					p1 = t.nextLine();
					System.out.println();
				
				
					System.out.print("PAPEL: ");
					x1 = t.nextLine();
					System.out.println();
				
				
					System.out.print("TIJERA: ");
					t1 = t.nextLine();
					System.out.println();
					
					System.out.println("Introduzca una letra por cada elemento del jugador 2");
					System.out.print("PIEDRA: ");
					p2 = t.nextLine();
					System.out.println();
				
				
					System.out.print("PAPEL: ");
					x2 = t.nextLine();
					System.out.println();
				
				
					System.out.print("TIJERA: ");
					t2 = t.nextLine();
					System.out.println();
				}
			break;
			
			case 2: // NIVEL
				System.out.print("La dificultad será introducida a la hora de jugar ( 1=Fácil, 2=Normal, 3=Difícil)");
			break;
			
			}
		}while(opc!=0);
	}
	
	/*MÉTODO--> oneplayer
	 * 
	 * Entradas--> Éste método no tiene entradas
	 * 
	 * Salidas--> El método no devuelve nada
	 * 
	 * Descripción--> Éste método tiene como función permitir jugar al modo de un solo jugador en el que te enfrentas a la máquina
	 * con diferentes dificultades
	 */
	public static void oneplayer() {
		
		Scanner t = new Scanner(System.in);
		int lvl = 0;
		
		do {
			try {
				System.out.println("Introduzca el nivel de dificultad al que quiere jugar contra la máquina ");
				lvl = t.nextInt();
			}
			catch(Exception e) {
				t.next();
				lvl = 0;
			}
		}while((lvl<1)||(lvl>3));
		
		
		
		switch(lvl) {
		
			case 1:
				int com, jug=0, maq=0;
				String a;
				do {
					System.out.println("SU TURNO");
					System.out.println();
					System.out.print("Introduzca su elemento: (Piedra = P, Papel = X, Tijeras = T) ");
					a = t.nextLine();
					
					if(a=="P") {
						System.out.println("piedra");
					}
					if(a=="X") {
						System.out.println("papel");
					}
					if(a=="T") {
						System.out.println("tijeras");
					}
					
					System.out.println("TURNO DE LA MAQUINA");
					System.out.println();
					
					com = (int)(Math.random()*(1-4)+4);
					
					switch(com) {
						case 1:
							System.out.println("piedra");
						break;
						
						case 2:
							System.out.println("papel");
						break;
						 	
						case 3:
							System.out.println("tijera");
						break;
					}
					
					if (((a=="P")&&(com==1))||((a=="X")&&(com==2))||((a=="T")&&(com==3))) {
						System.out.println("EMPATE");
					}
					if (((a=="P")&&(com==3))||((a=="X")&&(com==1))||((a=="T")&&(com==2))) {
						System.out.println("HAS GANADO");
						jug++;
					}
					if (((a=="T")&&(com==1))||((a=="P")&&(com==2))||((a=="X")&&(com==3))) {
						System.out.println("HAS PERDIDO");
						maq++;
					}
				}while((jug<2)||(maq<2));
				
				break;
				
				case 2:
					System.out.println("ESTA DIFICULTAD NO ESTÁ IMPLEMENTADA");
				break;
				
				case 3:
					System.out.println("ESTA DIFICULTAD NO ESTÁ IMPLEMENTADA");
				break;
		}
	}
	
	/*MÉTODO--> twoplayers
	 * 
	 * Entradas--> Éste método no tiene entradas
	 * 
	 * Salidas--> El método no devuelve nada
	 * 
	 * Descripción--> Éste método tiene como función permitir jugar al modo de dos jugadores en el que os enfrentareis en un clásico
	 * duelo de piedra, papel o tijera.
	 */
	public static void twoplayers() {
		
		Scanner t = new Scanner(System.in);
		
		int j1=0, j2=0;
		String a, b;
		do {
			System.out.println("TURNO J1");
			System.out.println();
			System.out.print("Introduzca su elemento: (Piedra = P, Papel = X, Tijeras = T) ");
			a = t.nextLine();
			
			if(a=="P") {
				System.out.println("piedra");
			}
			if(a=="X") {
				System.out.println("papel");
			}
			if(a=="T") {
				System.out.println("tijeras");
			}
			
			System.out.println("TURNO J2");
			System.out.println();
			System.out.print("Introduzca su elemento: (Piedra = P, Papel = X, Tijeras = T) ");
			b = t.nextLine();
		
			if(b=="P") {
				System.out.println("piedra");
			}
			if(b=="X") {
				System.out.println("papel");
			}
			if(b=="T") {
				System.out.println("tijeras");
			}
			
			if (((a=="P")&&(b=="P"))||((a=="X")&&(b=="X"))||((a=="T")&&(b=="T"))) {
				System.out.println("EMPATE");
			}
			if (((a=="P")&&(b=="T"))||((a=="X")&&(b=="P"))||((a=="T")&&(b=="X"))) {
				System.out.println("HA GANADO J1");
				j1++;
			}
			if (((a=="T")&&(b=="P"))||((a=="P")&&(b=="X"))||((a=="X")&&(b=="T"))) {
				System.out.println("HA GANADO J2");
				j2++;
			}
		}while((j1<3)||(j2<3));
		
		if(j1==3) {
			System.out.println("EL GANADOR ES EL JUGADOR 1");
		}
		else {
			System.out.println("EL GANADOR ES EL JUGADOR 2");
		}
	}
		
	public static void main (String [] args) {
		
		int opc;
		
		Scanner t = new Scanner(System.in);
		
		do {
			System.out.println("----------------------");
			System.out.println("PIEDRA, PAPEL O TIJERA");
			System.out.println("----------------------");
			System.out.println();
			System.out.println();
			do {
				System.out.println("0.- SALIR");
				System.out.println("1.- 1 JUGADOR");
				System.out.println("2.- 2 JUGADORES");
				System.out.println("3.- OPCIONES");
				System.out.println();
				try {
					System.out.print("Introduzca una de las opciones: ");
					opc = t.nextInt();
				}
				catch(Exception e){
					t.next();
					opc = -1;
				}
			}while((opc<0)||(opc>3));
			
			switch(opc) {
			
				case 0: // SALIR
					System.out.println("Gracias por jugar");
				break;
				
				case 1: // 1 JUGADOR
					oneplayer();
				break;
				
				case 2: // 2 JUGADORES
					twoplayers();
				break;
					
				case 3: // OPCIONES
					opciones();
				break;
			}
		}while(opc!=0);
		
		
	}
	
}
