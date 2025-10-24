package org.ip.sesion01;

import java.util.Scanner;


public class EjercicioCircunferencia {

	public static void main(String[] args) {
		// Declaramos variable de radio
		Scanner scanner = new Scanner(System.in);
		System.out.print("Por favor introduzca el radio: ");
		double radio = scanner.nextDouble();
		scanner.close();
		
		
		//calculo de la circunferencia
		double diametro = 2 * radio;
		double longitudCircunferencia = 2 * Math.PI * radio;
		double areaCirculo = Math.PI * Math.pow(radio, 2);
		
		System.out.println();
		// <-- CORRECCIÓN: Usamos %.2f para mostrar dos decimales en la salida
		System.out.printf("Radio = %.2f\n", radio);
		System.out.printf("Diametro de la circunferencia = %.2f\n", diametro);
		System.out.printf("Perimetro de la circunferencia = %.2f\n", longitudCircunferencia);
		System.out.printf("Area del circulo = %.2f\n", areaCirculo);
		
		System.out.println("\n--------------------------\n");
		
		
		//Parte 2, Calculo de la espera
		//Volumen de la espera: V = 4/3 * PI Rcubo
		
		double volumenEsfera = (4.0 / 3.0) * Math.pow(radio, 3);
		
		//area de la esfera = 4 * PI * Rcubo
		
		double areaEsfera = 4 * Math.PI * Math.pow(radio, 2);
		
		System.out.println("CALCULOS PARA LA ESFERA (mismo radio)");
		System.out.printf("Volumen de la esfera = %.3f\n", volumenEsfera);
		System.out.printf("Area de la esfera = %.3f\n", areaEsfera);
		
	}

}
