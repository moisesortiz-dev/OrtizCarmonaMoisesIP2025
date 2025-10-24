package org.ip.sesion02;

import java.util.Scanner;

public class DiasSemana {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introduzca el dia de la semana entre 1 y 7");
		int diaSemana = scanner.nextInt();
		
		String nombreDia = "Lunes";
		
		if( diaSemana == 1) {
			nombreDia = "Lunes";
		}
		else if (diaSemana == 2) {
			nombreDia = "Martes";
		}
		else if (diaSemana == 3) {
			nombreDia = "Miercoles";
		}
		else if (diaSemana == 4) {
			nombreDia = "Jueves";
		}
		else if (diaSemana == 5) {
			nombreDia = "Viernes";
		}
		else if (diaSemana == 6) {
			nombreDia = "sabado";
		}
		else if (diaSemana == 7) {
			nombreDia = "Domingo";
		}
		else {
			System.out.println("Has introducido un numero correcto");
		}
		System.out.println("El nombre del dia de la semana introducido es: " + nombreDia);
	}	
}
