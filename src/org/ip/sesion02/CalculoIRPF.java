package org.ip.sesion02;

import java.util.Scanner;

public class CalculoIRPF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		
		//Variables para almacenar base e impuesto
		double baseImponible = 0;
		double impuestoTotal = 0;
		
		
		final double tramo1Limite = 12450.0; 
		final double tramo1Tipo = 0.19;
		
		//Tramo 2
		final double tramo2Limite = 20200;
		final double tramo2Tipo = 0.24;
		final double tramo2CuotaAcumulada = tramo1Limite * tramo1Tipo; 
		
		//Tramo 3
		final double tramo3Limite = 35200.0;
		final double tramo3Tipo = 0.30;
		final double tramo3CuotaAcumulada = tramo2CuotaAcumulada + (tramo2Limite - tramo1Limite) * tramo2Tipo;
		
		//Tramo 4
		final double tramo4Limite = 60000.0;
		final double tramo4Tipo = 0.37;
		final double tramo4CuotaAcumulada = tramo3CuotaAcumulada + (tramo3Limite - tramo2Limite) * tramo3Tipo;
		
		//Tramo 5
		final double tramo5Limite = 300000.0;
		final double tramo5Tipo = 0.45;
		final double tramo5CuotaAcumulada = tramo4CuotaAcumulada + (tramo4Limite - tramo3Limite) * tramo4Tipo;
				
		
		//Tramo 6
		final double tramo6Tipo = 0.47; 
		final double tramo6CuotaAcumulada = tramo5CuotaAcumulada + (tramo5Limite - tramo4Limite) * tramo5Tipo;
		
		
		//Solicitar al usuario el importe
		System.out.println("---Calculadora del impuesto de la renta de personas fisicas---");
		System.out.println("Introduce el importe (€): ");
		if(scanner.hasNextDouble()) {
			baseImponible = scanner.nextDouble();
			
			if(baseImponible < 0) {
				System.out.println("Error, el numero introducido no puede ser negativo");
				return;
			}
			
			if(baseImponible <= tramo1Limite) {
				impuestoTotal = baseImponible * tramo1Tipo; 
		}
			else if(baseImponible  <= tramo2Limite) {
				impuestoTotal = tramo2CuotaAcumulada + (baseImponible - tramo1Limite) * tramo2Tipo;
			}
			else if(baseImponible  <= tramo3Limite) {
				impuestoTotal = tramo3CuotaAcumulada + (baseImponible - tramo2Limite) * tramo3Tipo;
			}	
			else if(baseImponible  <= tramo4Limite) {
				impuestoTotal = tramo4CuotaAcumulada + (baseImponible - tramo3Limite) * tramo4Tipo;
			}	
			else if(baseImponible  <= tramo5Limite) {
				impuestoTotal = tramo5CuotaAcumulada + (baseImponible - tramo4Limite) * tramo5Tipo;
			}	
			else { 
				impuestoTotal = tramo6CuotaAcumulada + (baseImponible - tramo5Limite) * tramo6Tipo;
			}
			
			
			System.out.println("\n--- Resultado del Cálculo ---");
			System.out.printf("Base Imponible Introducida: %,.2f €%n", baseImponible);
			System.out.printf("Impuesto Total a Pagar (IRPF): %,.2f €%n", impuestoTotal);

		} 
		
		scanner.close();
	}
}
