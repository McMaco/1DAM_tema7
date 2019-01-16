/***PROGRAMA DE SOPA DE LETRAS
 * AUTOR: DAVID MCCONNELL VICENTE
 * FECHA: 08/01/2019
 * CURSO: DM1B
 */


import java.util.Scanner;

public class sopa_de_letras {

	public static char s[][] = new char[15][15];
	
	public static boolean aux[][] = new boolean[15][15];
	
	
	static Scanner t = new Scanner(System.in);

	/*METODO: public static void colocar().
	 *
	 * DESCRIPCIÓN: En este metodo lo que hace es que pide la palabra y te la coloca
	 * aleatoriamente dentro de la sopa de letras.
	 */
	public static void colocar() {

		int f, c, i, k, l, n = 0;
		String palabra = null;

		System.out.println("INTRODUCE LAS palabraS DE LA SOPA DE LETRAS");
		System.out.println();
		do {
			boolean ok = true;
			boolean print = true;

			try {
				do {
					System.out.print((n + 1)+ ": ");
					palabra = t.next();
					palabra = palabra.toUpperCase();
				} while ((palabra.length() < 3) || (palabra.length() > 15) || (palabra.matches(".*[^A-Z].*")));
				
				System.out.println("Busca la palabra: "+ palabra);
				
			} catch (Exception e) {
				t.next();
			}
			n++;

			char v[] = palabra.toCharArray();

			for (i = 0; i < palabra.length(); i++) {

			}

			do {
				ok = true;
				print = true;
				try {
					f = (int) (Math.random() * 15);
					c = (int) (Math.random() * 15);
					
					int opc = 1; //(int) (Math.random() * (8 - 1) + 1);

					switch (opc) {

						case 1: // Diagonal a la derecha hacia abajo
	
							if (((f + (palabra.length() - 1)) > 14) || ((c + (palabra.length() - 1)) > 14)) {
								ok = false;
							} 
							else {
								if(aux[f][c]==false) {
									s[f][c] = v[0];
									aux[f][c] = true;
								}
								else {
									if(s[f][c]==v[0]) {
										s[f][c] = v[0];
										aux[f][c] = true;
									}
									else {
										print = false;
									}
								}
								
								for (int j = 1; j < palabra.length(); j++) {
									if(aux[f+j][c+j]==false) {
										s[f+j][c+j] = v[j];
										aux[f+j][c+j] = true;
									}
									else {
										if(s[f+j][c+j]==v[j]) {
											s[f+j][c+j] = v[j];
											aux[f+j][c+j] = true;
										}
										else {
											print = false;
										}
									}
								}
							}
	
						break;
	
						case 2:// Vertical hacia abajo.
	
							if ((f + (palabra.length() - 1)) > 14) {
								ok = false;
							} 
							else {
								if(aux[f][c]==false) {
									s[f][c] = v[0];
									aux[f][c] = true;
								}
								else {
									if(s[f][c]==v[0]) {
										s[f][c] = v[0];
										aux[f][c] = true;
									}
									else {
										print = false;
									}
								}
								for (int j = 1; j < palabra.length(); j++) {
									
									if(aux[f+j][c]==false) {
										s[f+j][c] = v[j];
										aux[f+j][c] = true;
									}
									else {
										if(s[f+j][c]==v[j]) {
											s[f+j][c] = v[j];
											aux[f+j][c] = true;
										}
										else {
											print = false;
										}
									}
									
								}
							}
	
						break;
	
						case 3:// Horizontal de izquierda a derecha.
	
							if ((c + (palabra.length() - 1)) > 14) {
								ok = false;
							}
							else {
								if(aux[f][c]==false) {
									s[f][c] = v[0];
									aux[f][c] = true;
								}
								else {
									if(s[f][c]==v[0]) {
										s[f][c] = v[0];
										aux[f][c] = true;
									}
									else {
										print = false;
									}
								}
								for (int j = 1; j < palabra.length(); j++) {
									if(aux[f][c+j]==false) {
										s[f][c+j] = v[j];
										aux[f][c+j] = true;
									}
									else {
										if(s[f][c+j]==v[j]) {
											s[f][c+j] = v[j];
											aux[f][c+j] = true;
										}
										else {
											print = false;
										}
									}
					
								}
							}
	
						break;
	
						case 4:// Vertical hacia arriba.
	
							if ((f - (palabra.length() - 1)) < 0) {
								ok = false;
							} 
							else {
								if(aux[f][c]==false) {
									s[f][c] = v[0];
									aux[f][c] = true;
								}
								else {
									if(s[f][c]==v[0]) {
										s[f][c] = v[0];
										aux[f][c] = true;
									}
									else {
										print = false;
									}
								}
								for (int j = 1; j < palabra.length(); j++) {
									if(aux[f-j][c]==false) {
										s[f-j][c] = v[j];
										aux[f-j][c] = true;
									}
									else {
										if(s[f-j][c]==v[j]) {
											s[f-j][c] = v[j];
											aux[f-j][c] = true;
										}
										else {
											ok = false;
										}
									}
								}
							}
	
						break;
	
						case 5:// Horizontal hacia la izquierda.
	
							if ((c - (palabra.length() - 1)) < 0) {
								ok = false;
							}
							else {
								if(aux[f][c]==false) {
									s[f][c] = v[0];
									aux[f][c] = true;
								}
								else {
									if(s[f][c]==v[0]) {
										s[f][c] = v[0];
										aux[f][c] = true;
									}
									else {
										print = false;
									}
								}
								for (int j = 1; j < palabra.length(); j++) {
									if(aux[f][c-j]==false) {
										s[f][c-j] = v[j];
										aux[f][c-j] = true;
									}
									else {
										if(s[f][c-j]==v[j]) {
											s[f][c-j] = v[j];
											aux[f][c-j] = true;
										}
										else {
											print = false;
										}
									}
	
								}
							}
							
						break;
	
						case 6: // Diagonal hacia la derecha y hacia arriba.
	
							if (((f - (palabra.length() - 1)) < 0) || ((c + (palabra.length() - 1)) > 14)) {
								ok = false;
							} 
							else {
								if(aux[f][c]==false) {
									s[f][c] = v[0];
									aux[f][c] = true;
								}
								else {
									if(s[f][c]==v[0]) {
										s[f][c] = v[0];
										aux[f][c] = true;
									}
									else {
										print = false;
									}
								}
								for (int j = 1; j < palabra.length(); j++) {
									if(aux[f-j][c+j]==false) {
										s[f-j][c+j] = v[j];
										aux[f-j][c+j] = true;
									}
									else {
										if(s[f-j][c+j]==v[j]) {
											s[f-j][c+j] = v[j];
											aux[f-j][c+j] = true;
										}
										else {
											print = false;
										}
									}
	
								}
							}
							
						break;
	
						case 7: // Diagonal hacia la izquierda y hacia abajo.
	
							if (((f + palabra.length() - 1) > 14) || (c - (palabra.length() - 1) < 0)) {
								ok = false;
							} 
							else {
								if(aux[f][c]==false) {
									s[f][c] = v[0];
									aux[f][c] = true;
								}
								else {
									if(s[f][c]==v[0]) {
										s[f][c] = v[0];
										aux[f][c] = true;
									}
									else {
										print = false;
									}
								}
								for (int j = 1; j < palabra.length(); j++) {
									if(aux[f+j][c-j]==false) {
										s[f+j][c-j] = v[j];
										aux[f+j][c-j] = true;
									}
									else {
										if(s[f+j][c-j]==v[j]) {
											s[f+j][c-j] = v[j];
											aux[f+j][c-j] = true;
										}
										else {
											print = false;
										}
									}
	
								}
							}
	
						break;
	
						case 8: // Diagonal hacia la izquierda y hacia arriba.
	
							if (((f - palabra.length() - 1) < 0) || ((c - palabra.length() - 1) < 0)) {
								ok = true;
							} 
							else {
								if(aux[f][c]==false) {
									s[f][c] = v[0];
									aux[f][c] = true;
								}
								else {
									if(s[f][c]==v[0]) {
										s[f][c] = v[0];
										aux[f][c] = true;
									}
									else {
										print = false;
									}
								}
								for (int j = 1; j < palabra.length(); j++) {
									if(aux[f-j][c-j]==false) {
										s[f-j][c-j] = v[j];
										aux[f-j][c-j] = true;
									}
									else {
										if(s[f-j][c-j]==v[j]) {
											s[f-j][c-j] = v[j];
											aux[f-j][c-j] = true;
										}
										else {
											print = false;
										}
									}
									
	
								}
							}
	
						break;
					}
				} catch (Exception e) {

				}
				
			} while ((ok == false)||(print == false));

		} while (n < 10);

	}

	/* METODO: public static void crear_pintar(). 
	 * ENTRADAS: 
	 * SALIDAS: 
	 * DESCRIPCIÓN:
	 */

	public static void crear_pintar() {
		int f, c;

		for (f = 0; f < 15; f++) {
			for (c = 0; c < 15; c++) {
				s[f][c] = (char) (Math.random() * 26 + 'a');

			}
		}
		
		for (f = 0; f < 15; f++) {
			for (c = 0; c < 15; c++) {
				aux[f][c] = false;

			}
		}

		colocar();

		for (f = 0; f < 15; f++) {
			for (c = 0; c < 15; c++) {

				System.out.print(" " + s[f][c]);
			}
			System.out.println();
		}

	}

	/*
	 * 
	 */
	public static void main(String[] args) {
		int f, c;
		System.out.println("--------------");
		System.out.println("SOPA DE LETRAS");
		System.out.println("--------------");

		crear_pintar();

	}

}