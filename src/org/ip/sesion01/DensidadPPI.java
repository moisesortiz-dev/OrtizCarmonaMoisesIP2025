package org.ip.sesion01;

public class DensidadPPI {

	public static void main(String[] args) {
		// 1. Monitor Full HD 27 pulgadas
		
		double anchoResolucion_1 = 1920;
		double altoResolucion_1 = 1080;
		double tamañoDiagonal_1 = 27.0;
		
		//Raiz cuadrada de ANCHOx2 + ALTPx2
		double numerador_1 = Math.sqrt(Math.pow(anchoResolucion_1, 2) + Math.pow(altoResolucion_1, 2));
		
		//PPI: numerador_1 / tamaño
		double ppi_1 = numerador_1 / tamañoDiagonal_1;
		
		System.out.println(" Monitor full HD (27 pulgadas)");
		System.out.printf("Resolucion: %.0fx%.0f\n", anchoResolucion_1, altoResolucion_1);
		System.out.printf("Diagonal: %.0f pulgadas\n", tamañoDiagonal_1);
		System.out.printf("Densidad PPI: %.2f\n", ppi_1);
		
		System.out.println("----------------");
		
		// 2. Monitor 4k 32 pulgadas
		
		double anchoResolucion_2 = 3840;
		double altoResolucion_2 = 2160;
		double tamañoDiagonal_2 = 32.0;
		
		//Raiz cuadrada de ANCHOx2 + ALTPx2
		double numerador_2 = Math.sqrt(Math.pow(anchoResolucion_2, 2) + Math.pow(altoResolucion_2, 2));
		
		//PPI: numerador_1 / tamaño
		double ppi_2 = numerador_2 / tamañoDiagonal_2;
		
		System.out.println(" Monitor 4k (32 pulgadas)");
		System.out.printf("Resolucion: %.0fx%.0f\n", anchoResolucion_2, altoResolucion_2);
		System.out.printf("Diagonal: %.0f pulgadas\n", tamañoDiagonal_2);
		System.out.printf("Densidad PPI: %.2f\n", ppi_2);
		
		System.out.println("----------------");
		
		double anchoResolucion_3 = 2340;
		double altoResolucion_3 = 1080;
		double tamañoDiagonal_3 = 6.5;
		
		//Raiz cuadrada de ANCHOx2 + ALTPx2
		double numerador_3 = Math.sqrt(Math.pow(anchoResolucion_3, 2) + Math.pow(altoResolucion_3, 2));
		
		//PPI: numerador_1 / tamaño
		double ppi_3 = numerador_3 / tamañoDiagonal_3;
		
		System.out.println(" Monitor 4k (32 pulgadas)");
		System.out.printf("Resolucion: %.0fx%.0f\n", anchoResolucion_3, altoResolucion_3);
		System.out.printf("Diagonal: %.0f pulgadas\n", tamañoDiagonal_3);
		System.out.printf("Densidad PPI: %.2f\n", ppi_3);
		
	}

}
