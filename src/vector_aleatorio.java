/***PROGRAMA DE VECTORES ALEATORIOS
 * AUTOR: DAVID MCCONNELL VICENTE
 * FECHA: 10/12/2018
 * CURSO: DM1B
 */

import java.util.Scanner;

public class vector_aleatorio {
	
	final static int MAX = 20; //Número de posiciones del vector
	
	public static void main(String [] args) {
		
		int a = 0, b = 0, contador = 0;
		
		int[] aleatorio = new int[MAX]; //Declaración y creación del vector aleatorio
		
		System.out.println("Vector creado: ");
		for (int i = 0; i<MAX; i++) {
			aleatorio[i]= (int) (Math.random()*99+1);
			System.out.print(" "+ aleatorio[i]);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Vector ordenado por método burbuja: ");
		int aux = 0;
		boolean flag = false;
		int cont = 0;
		do {
			flag = false;
			for(int i=0; i<(MAX-1); i++) {
				cont++;
				if (aleatorio[i]>aleatorio[(i+1)]) {
					aux = aleatorio[i+1];
					aleatorio[i+1]=aleatorio[i];
					aleatorio[i]=aux;
					flag = true;
				}
			}
		}while(flag == true);
		
		for (int i=0; i<MAX; i++) {
			System.out.print(aleatorio[i] +" ");
		}
		
		System.out.println();
		System.out.println();
		System.out.print("Veces comparado: "+ cont);
		
		int contando = 0;
		System.out.println();
		System.out.println();
		System.out.println("Vector ordenado con métodos for: ");
		for (int k=1; k<=100; k++) {
			for (int u=0; u<MAX; u++) {
				contando++;
				if (aleatorio[u] == k) {
					System.out.print(aleatorio[u]+ " ");
				}
			}
		}
		System.out.println();
		System.out.println();
		System.out.print("Veces comparado: "+ contando);
		System.out.println();
		System.out.println();
		Scanner t = new Scanner (System.in);
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("BUSCAR VALORES EN EL VECTOR COMPRENDIDOS ENTRE\nDOS VALORES INTRODUCIDOS POR EL USUARIO");
		System.out.println("----------------------------------------------");
		System.out.println();
		System.out.println();
		do {
			try {
				System.out.println("Introduzca el primer valor entre 0 y 100");
				a = t.nextInt();
			}
			catch(Exception e) {
				t.next();
				a = -1;
			}
		}while((a<0)||(a>100));
		
		do {
			try {
				System.out.println("Introduzca el segundo valor entre 0 y 100 mayor que el primero");
				b = t.nextInt();
			}
			catch(Exception e) {
				t.next();
				b = -1;
			}
		}while((b<0)||(b>100)||(b<a));
		
		System.out.println();
		System.out.println("          VALOR          POSICIÓN");
		System.out.println("          -----          --------");
		
		for (int f = 0; f<MAX; f++) {
			if ((aleatorio[f]>=a)&&(aleatorio[f]<=b)) {
				contador++;
				System.out.println("          "+ aleatorio[f] +"             "+ (f+1));
			}
		}
		System.out.println();
		System.out.println("Hay "+ contador +" números entre el "+ a +" y el "+ b +" en el vector aleatorio.");
		
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("BUSCAR VALORES EN EL VECTOR IGUALES A UN VALOR\nINTRODCIDO POR EL USUARIO MEDIANTE BUSQUEDA SECUENCIAL");
		System.out.println("----------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println("Introduzca un valor para buscar en el vector: ");
		int c = t.nextInt();
		boolean contar = false;
		int numerodeveces=0;
		
		System.out.println();
		for (int f=0; f<MAX; f++) {
			numerodeveces++;
			if (aleatorio[f]==c) {
				System.out.println("El valor "+ c +" se encuentra en la posición "+ (f+1));
				contar = true;
			}
		}
		if (contar == false)      System.out.println("El valor "+ c +" no se encuentra en el vector.");
		System.out.println("El numero de veces de busqueda es: "+ numerodeveces);
		
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("BUSCAR VALORES EN EL VECTOR IGUALES A UN VALOR\nINTRODCIDO POR EL USUARIO MEDIANTE BUSQUEDA BINARIA");
		System.out.println("----------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println("Introduzca un valor para buscar en el vector: ");
		int n = t.nextInt();
		int i = 0, cnt = 0;
		int min = 0;
		int maxim = MAX;
		boolean change = false;
		do {
			i = (min+maxim)/2;
			if(aleatorio[i] == n) {
				System.out.println("El valor "+ n +" está en la posición "+ i);
				change = true;
			}
			else {
				if(aleatorio[i]>n) {
					maxim = i-1;
				}
				else {
					min = i+1;
				}
			}
			cnt++;
		}while((change == false)&&(min<maxim));
		
		if(change == false) System.out.println("El valor"+ n +" no se encuentra en el vector");
		
		System.out.println("El número de veces de búsqueda es: "+ cnt);
	}
}
