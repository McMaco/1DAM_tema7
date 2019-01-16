/***PROGRAMA DE SOPA DE LETRAS
 * AUTOR: DAVID MCCONNELL VICENTE
 * FECHA: 08/01/2019
 * CURSO: DM1B
 */


import java.util.Scanner;

public class sopa_de_letras {

	public static char s[][] = new char[15][15];
	
	static Scanner t = new Scanner(System.in);

	/*METODO: public static void colocar().
	 *
	 * DESCRIPCIÓN: En este metodo lo que hace es que pide la palabra y te la coloca
	 * aleatoriamente dentro de la sopa de letras.
	 */
	public static void colocar() {

		int f, c, i, k, l, n = 0;
		String palabra = null;

		System.out.println("INTRODUCE LAS PALABRAS DE LA SOPA DE LETRAS");
		System.out.println();
		do {
			boolean ok = true;
			boolean print = true;

			try {
				do {
					System.out.print((n + 1) + ": ");
					palabra = t.next();
					palabra = palabra.toUpperCase();
				} while ((palabra.length() < 3) || (palabra.length() > 15) || (palabra.matches(".*[^A-Z].*")));
				
				System.out.println(palabra);
				
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

					s[f][c] = v[0];

					if (s[f][c] == v[0]) {

					} else {
						print = false;
					}

					int opc = (int) (Math.random() * (8 - 1) + 1);

					switch (opc) {

						case 1: // Diagonal a la derecha hacia abajo
	
							if (((f + (palabra.length() - 1)) > 15) || ((c + (palabra.length() - 1)) > 15)) {
								ok = false;
							} else {
	
								for (int j = 1; j < palabra.length(); j++) {
									s[f + j][c + j] = v[j];
	
									if (s[f + j][c + j] == v[j]) {
	
									} else {
										print = false;
									}
								}
							}
	
						break;
	
						case 2:// Vertical hacia abajo.
	
							if ((f + (palabra.length() - 1)) > 15) {
								ok = false;
							} else {
								for (int j = 1; j < palabra.length(); j++) {
									s[f + j][c] = v[j];
	
									if (s[f + j][c] == v[j]) {
	
									} else {
										print = false;
									}
								}
							}
	
						break;
	
						case 3:// Horizontal de izquierda a derecha.
	
							if ((c + (palabra.length() - 1)) > 15) {
								ok = false;
							} else {
								for (int j = 1; j < palabra.length(); j++) {
									s[f][c + j] = v[j];
	
									if (s[f][c + j] == v[j]) {
	
									} else {
										print = false;
									}
								}
							}
	
						break;
	
						case 4:// Vertical hacia arriba.
	
							if ((f - (palabra.length() - 1)) < 0) {
								ok = false;
							} else {
	
								for (int j = 1; j < palabra.length(); j++) {
									s[f - j][c] = v[j];
	
									if (s[f - j][c] == v[j]) {
	
									} else {
										print = false;
									}
								}
							}
	
						break;
	
						case 5:// Horizontal hacia la izquierda.
	
							if ((c - (palabra.length() - 1)) < 0) {
								ok = false;
							} else {
								for (int j = 1; j < palabra.length(); j++) {
									s[f][c - j] = v[j];
	
									if (s[f][c - j] == v[j]) {
	
									} else {
										print = false;
									}
								}
							}
							
						break;
	
						case 6: // Diagonal hacia la derecha y hacia arriba.
	
							if (((f - (palabra.length() - 1)) < 0) || ((c + (palabra.length() - 1)) > 15)) {
								ok = false;
							} else {
								for (int j = 1; j < palabra.length(); j++) {
									s[f - j][c + j] = v[j];
	
									if (s[f - j][c + j] == v[j]) {
	
									} else {
										print = false;
									}
								}
							}
							
						break;
	
						case 7: // Diagonal hacia la izquierda y hacia abajo.
	
							if (((f + palabra.length() - 1) > 15) || (c - (palabra.length() - 1) < 0)) {
								ok = false;
							} else {
								for (int j = 1; j < palabra.length(); j++) {
									s[f + j][c - j] = v[j];
	
									if (s[f - j][c] == v[j]) {
	
									} else {
										print = false;
									}
								}
							}
	
						break;
	
						case 8: // Diagonal hacia la izquierda y hacia arriba.
	
							if (((f - palabra.length() - 1) < 0) || ((c - palabra.length() - 1) < 0)) {
								ok = true;
							} else {
								for (int j = 1; j < palabra.length(); j++) {
									s[f - j][c - j] = v[j];
	
									if (s[f - j][c - j] == v[j]) {
	
									} else {
										print = false;
									}
								}
							}
	
						break;
					}
				} catch (Exception e) {

				}
			} while ((ok == false) || (print == false));

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