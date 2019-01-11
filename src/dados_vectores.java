
public class dados_vectores {
	
	private static double[] Sumas = {2,3,4,5,6,7,8,9,10,11,12}; //VECTOR Sumas
	
	private static double[] Veces = {3,8,9,11,20,19,16,13,11,6,4}; //VECTOR Veces
	
	public static void main(String [] args) {
		
		double media = 0, desviacion = 0, sumatorio = 0, por = 0;
		
		//MEDIA
		for (int i=0;i<11;i++) {
			media += Sumas[i]*Veces[i];
		}
		
		media /= 120;
		System.out.println("La media es: "+ media);
		
		//DESVIACIÓN TÍPICA
		for (int i=0;i<11;i++) {
			sumatorio += Sumas[i]*Sumas[i]*Veces[i];
		}
		
		desviacion = Math.sqrt((sumatorio/120)-media*media);
		
		System.out.println("La desviación es: "+ desviacion);
		
		//PORCENTAJE DE RANGO 
		for (int i = 0; i<11; i++) {
			
			if (Sumas[i]>(media-desviacion)&&Sumas[i]<(media+desviacion)) {
				por += Veces[i];
			}
		}
		
		por = (por*100)/120;
		System.out.println("El porcentaje es: "+ por);
		
	}

}
