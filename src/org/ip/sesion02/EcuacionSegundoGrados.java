package org.ip.sesion02;

import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class EcuacionSegundoGrados {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		double a, b, c;
		
		System.out.println("Solucion de una ecuacion de segundo grado");
		
		//Solicitamos los numeros
		System.out.println("Introduce el coeficiente 'a': ");
		a = scanner.nextDouble();
		
		System.out.println("Introduce el coeficiente 'b': ");
		b = scanner.nextDouble();
		
		System.out.println("Introduce el coeficiente 'c': ");
		c = scanner.nextDouble();
		
		scanner.close();
		
		System.out.println("\nValores de los coeficientes");
        System.out.printf("a = %.0f, b = %.0f, c = %.0f\n", a, b, c);
        
        if (a == 0) {
        	System.out.println("No es una ecuacion de 2º grados");
        	return;
        }
        
        double discriminante = (b * b) - (4 * a *c);
        
        if (discriminante < 0) {
        	System.out.println("No tiene solucion");
        }
        
        else if(discriminante == 0) {
        	double x = -b / (2 * a);
        	
        	System.out.println("Una unica raiz de valor doble");
        	System.out.printf("x = %.1f\n", x);
        }
        
        else {
        	double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        	double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
        	
        	System.out.println("Dos raices de valores");
        	System.out.printf("x1 = %.1f\n", x1);
            System.out.printf("x2 = %.1f\n", x2);
        }
	}

}
