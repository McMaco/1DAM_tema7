/***PROGRAMA DE SOPA DE LETRAS
 * AUTOR: DAVID MCCONNELL VICENTE
 * FECHA: 17/01/2019
 * CURSO: DM1B
 */

import java.util.Scanner;

public class sopa_de_letras {

	public static char s[][] = new char[15][15];
	public static boolean aux[][] = new boolean[15][15];
	public static String rep[] = new String[10];

	static Scanner t = new Scanner(System.in);

	/*
	 * METODO: public static void posicion(). 
	 * ENTRADA: 
	 * SALIDA: 
	 * DESCRIPCIÓN: La función de este método es recoger y validar las palabras
	 * y colocarlas en la sopa de manera aleatoria.
	 */
	public static void posicion() {

		int f, c, i, k, l, n = 0, u;
		String palabra = null;

		System.out.println("Introduce las palabras que quieres que esten en la sopa de letra: ");
		do {
			boolean flag = true;
			boolean ok = true;
			boolean print = true;

			try {
				do {
					flag = true;
					System.out.print((n + 1) + ": ");
					palabra = t.next();
					palabra = palabra.toUpperCase();
					
					for (u = 0; u<=n; u++) {
						if(palabra.equalsIgnoreCase(rep[u])) {
							flag = false;
						}
						
					}
					
				} while ((palabra.length() < 3) || (palabra.length() > 15) || (palabra.matches(".*[^A-Z].*") || (flag==false)));

			} catch (Exception e) {
				t.next();
			}
			
			System.out.println("Busca la palabra: "+ palabra);
			
			rep[n] = palabra;
			
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

					int opc = (int) (Math.random() * (8 - 1) + 1);

					switch (opc) {

						case 1: // Diagonal a la derecha hacia abajo
	
							if (((f + (palabra.length() - 1)) > 15) || ((c + (palabra.length() - 1)) > 15)) {
								ok = false;
							} 
							else {
								if (aux[f][c] == false) {								
									for (int j = 1; j < palabra.length(); j++) {
										if (aux[f+j][c+j] == false) {
											
										}
										else {
											if (s[f+j][c+j] == v[j]) {
												
											} 
											else {
												print = false;
											}
										}
									}
								} 
								else {
									
									if (s[f][c] == v[0]) {
										for (int j = 1; j < palabra.length(); j++) {
											if (aux[f+j][c+j] == false) {
												
											}
											else {
												if (s[f+j][c+j] == v[j]) {
													
												} 
												else {
													print = false;
												}
											}
										}
									} 
									else {
										print = false;
									}
								}
								
								
								aux[f][c] = true;
								
								s[f][c] = v[0];
								
								for (int j = 1; j < palabra.length(); j++) {
									s[f+j][c+j] = v[j];
									aux[f+j][c+j] = true;
								}
								
							}
							
							break;
	
						case 2:// Vertical hacia abajo.
	
							if ((f + (palabra.length() - 1)) > 15) {
								ok = false;
							} 
							else {
	
								if (aux[f][c] == false) {								
									for (int j = 1; j < palabra.length(); j++) {
										
										if (aux[f+j][c] == false) {	

										}
										else {
											if (s[f+j][c] == v[j]) {											

											}
											else {
												print = false;
											}
										}
									
									}
								} 
								else {
									if (s[f][c] == v[0]) {								
										for (int j = 1; j < palabra.length(); j++) {
											
											if (aux[f+j][c] == false) {	

											}
											else {
												if (s[f+j][c] == v[j]) {											

												}
												else {
													print = false;
												}
											}
										
										}
									} 
									else {
										print = false;
									}
								}
								
								
								aux[f][c] = true;
								
								s[f][c] = v[0];
								
								for (int j = 1; j < palabra.length(); j++) {
									s[f+j][c] = v[j];
									aux[f+j][c] = true;
								}
							}
							break;
	
						case 3:// Horizontal de izquierda a derecha.
	
							if ((c + (palabra.length() - 1)) > 15) {
								ok = false;
							}
							else {
	
								if (aux[f][c] == false) {								
									for (int j = 1; j < palabra.length(); j++) {
										
										if (aux[f][c+j] == false) {									

										}
										else {
											if (s[f][c+j] == v[j]) {

											} 
											else {
												print = false;
											}
										}
		
									}
								} 
								else {
									if (s[f][c] == v[0]) {										
										for (int j = 1; j < palabra.length(); j++) {
											
											if (aux[f][c+j] == false) {									

											}
											else {
												if (s[f][c+j] == v[j]) {

												} 
												else {
													print = false;
												}
											}
			
										}
									} 
									else {
										print = false;
									}
								}
								
								
								aux[f][c] = true;
								
								s[f][c] = v[0];
								
								for (int j = 1; j < palabra.length(); j++) {
									s[f][c+j] = v[j];
									aux[f][c+j] = true;
								}
							}
							break;
	
						case 4:// Vertical hacia arriba .
	
							if ((f - (palabra.length() - 1)) < 0) {
								ok = false;
							} 
							else {
	
								if (aux[f][c] == false) {									
									for (int j = 1; j < palabra.length(); j++) {
										
										if (aux[f-j][c] == false) {										

										}
										else {
											if (s[f-j][c] == v[j]) {									

											} 
											else {
												print = false;
											}
										}
										
		
									}
								} 
								else {
									if (s[f][c] == v[0]) {									
										for (int j = 1; j < palabra.length(); j++) {
											
											if (aux[f-j][c] == false) {										

											}
											else {
												if (s[f-j][c] == v[j]) {									

												} 
												else {
													print = false;
												}
											}
											
			
										}
									} 
									else {
										print = false;
									}
								}
								
								aux[f][c] = true;
								
								s[f][c] = v[0];
								
								for (int j = 1; j < palabra.length(); j++) {
									s[f-j][c] = v[j];
									aux[f-j][c] = true;
								}
							}
							break;
	
						case 5:// Horizontal hacia la izquierda.
	
							if ((c - (palabra.length() - 1)) < 0) {
								ok = false;
							} 
							else {
	
								if (aux[f][c] == false) {						
									for (int j = 1; j < palabra.length(); j++) {
										
										if (aux[f][c-j] == false) {										

										}
										else {
											if (s[f][c-j] == v[j]) {					

											}
											else {
												print = false;
											}
										}
		
									}
								}
								else {
									if (s[f][c] == v[0]) {										
										for (int j = 1; j < palabra.length(); j++) {
											
											if (aux[f][c-j] == false) {										

											}
											else {
												if (s[f][c-j] == v[j]) {					

												}
												else {
													print = false;
												}
											}
			
										}
									} 
									else {
										print = false;
									}
								}
								
								
								aux[f][c] = true;
								
								s[f][c] = v[0];
								
								for (int j = 1; j < palabra.length(); j++) {
									s[f][c-j] = v[j];
									aux[f][c-j] = true;
								}
							}
							break;
	
						case 6: // Diagonal hacia la derecha y hacia arriba.
	
							if (((f - (palabra.length() - 1)) < 0) || ((c + (palabra.length() - 1)) > 15)) {
								ok = false;
							} 
							else {
	
								if (aux[f][c] == false) {
									for (int j = 1; j < palabra.length(); j++) {
										
										if (aux[f-j][c+j] == false) {										

										}
										else {
											if (s[f-j][c+j] == v[j]) {										

											} 
											else {
												print = false;
											}
										}
		
									}
								} 
								else {
									if (s[f][c] == v[0]) {			
										for (int j = 1; j < palabra.length(); j++) {
											
											if (aux[f-j][c+j] == false) {										
												
											}
											else {
												if (s[f-j][c+j] == v[j]) {										
												
												} 
												else {
													print = false;
												}
											}
			
										}
									}
									else {
										print = false;
									}
								}
								
								aux[f][c] = true;
								
								s[f][c] = v[0];
								
								for (int j = 1; j < palabra.length(); j++) {
									s[f-j][c+j] = v[j];
									aux[f-j][c+j] = true;
	
								}
							}
							break;
	
						case 7: // Diagonal hacia la izquierda y hacia abajo
	
							if (((f + palabra.length() - 1) > 15) || (c - (palabra.length() - 1) < 0)) {
								ok = false;
							}
							else {
	
								if (aux[f][c] == false) {								
									for (int j = 1; j < palabra.length(); j++) {
										
										if (aux[f+j][c-j] == false) {	
											
										}
										else {
											if (s[f+j][c-j] == v[j]) {							
												
											} 
											else {
												print = false;
											}
										}
		
									}
								} 
								else {
									if (s[f][c] == v[0]) {									
										for (int j = 1; j < palabra.length(); j++) {
											
											if (aux[f+j][c-j] == false) {	
												
											}
											else {
												if (s[f+j][c-j] == v[j]) {							
													
												} 
												else {
													print = false;
												}
											}
			
										}
									} 
									else {
										print = false;
									}
								}
								
								aux[f][c] = true;
								
								s[f][c] = v[0];
								
								for (int j = 1; j < palabra.length(); j++) {
									s[f+j][c-j] = v[j];
									aux[f+j][c-j] = true;
	
								}
							}
							break;
	
						case 8: // Diagonal hacia la izquierda y hacia arriba.
	
							if (((f - palabra.length() - 1) < 0) || ((c - palabra.length() - 1) < 0)) {
								ok = true;
							} 
							else {
	
								if (aux[f][c] == false) {
									for (int j = 1; j < palabra.length(); j++) {
										
										if (aux[f-j][c-j] == false) {				
											
										}
										else {
											if (s[f-j][c-j] == v[j]) {
												
											} 
											else {
												print = false;
											}
										}
		
									}
								} 
								else {
									if (s[f][c] == v[0]) {
										for (int j = 1; j < palabra.length(); j++) {
											
											if (aux[f-j][c-j] == false) {				
												
											}
											else {
												if (s[f-j][c-j] == v[j]) {
													
												} 
												else {
													print = false;
												}
											}
			
										}
									}
									else {
										print = false;
									}
								}
								
								aux[f][c] = true;
						
								s[f][c] = v[0];
								
								for (int j = 1; j < palabra.length(); j++) {
									s[f-j][c-j] = v[j];
									aux[f-j][c-j] = true;
	
								}
							}
							break;
					}
				} catch (Exception e) {

				}
			} while ((ok == false) || (print == false));

			
		} while (n < 10);

	}

	/*
	 * METODO: public static void sopa().
	 * ENTRADAS: 
	 * SALIDAS:
	 * DESCRIPCION: La funcion de este método es crear una sopa de letras 
	 * con letras aleatorias y después imprimir la sopa con las nuevas palabras.
	 */

	public static void sopa() {
		int f, c;

		for (f = 0; f < 15; f++) {

			for (c = 0; c < 15; c++) {
				s[f][c] = (char) (Math.random() * 26 + 'A');

			}

		}

		for (f = 0; f < 15; f++) {

			for (c = 0; c < 15; c++) {
				aux[f][c] = (boolean) (false);

			}

		}

		posicion();

		for (f = 0; f < 15; f++) {
			for (c = 0; c < 15; c++) {

				System.out.print(" " + s[f][c] + " ");
				
			}
			System.out.println();
		}

	}

	/*
	 * METODO: public static void main(String[] args)
	 * ETRADAS:
	 * SALIDAS: 
	 * DESCRIPCION: La función de este método es ejecutar el programa y llamar
	 * al método sopa.
	 */
	public static void main(String[] args) {
		int f, c;
		System.out.println("Bienvenido a la sopa de letras");
		System.out.println("------------------------------");

		sopa();

	}

}