package org.ip.sesion01;

public class EjercicioDistancia {

	public static void main(String[] args) {
		// La formula de la distancia de (x, y) al origen (0, 0) es: distancia = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))
		
		int x1 = 3;
		int y1 = 4;
		
		double sumaCuadrado1 = Math.pow(x1, 2) + Math.pow(y1, 2);
		
		
		//Calcular raiz cuadrada´
		
		double distancia1 = Math.sqrt(sumaCuadrado1);
		System.out.printf("Distancia del punto (%d, %d al punto (0, 0) es: %.1f\n", x1, y1, distancia1);
		

	}

}
