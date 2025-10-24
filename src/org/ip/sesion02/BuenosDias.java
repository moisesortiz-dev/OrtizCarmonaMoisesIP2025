package org.ip.sesion02;


import java.util.Scanner;

public class BuenosDias {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//introducir horas
		
		System.out.println("Introducir hora: ");
		int hora = scanner.nextInt();
		System.out.println("Introducir minutos: ");
		int minutos = scanner.nextInt();
		scanner.close();
		
		String saludo;
		
		//Buenos dias de 6 a 12
		if (hora >= 6 && hora <= 12) {
			saludo = "Buenos dias";
		}
		else if (hora >= 13 && hora <= 20) {
			saludo = "Buenas tardes";
		}
		else if (hora >= 21 || hora <= 5) {
			saludo = "Buenas noches";
		}
		else {
			saludo = "Hora no valida. Introduzca el formato 24h";
		}
			
		//Mostrar resultado
		System.out.println(saludo);

	}

}
