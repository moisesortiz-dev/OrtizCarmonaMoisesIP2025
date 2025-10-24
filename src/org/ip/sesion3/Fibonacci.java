package org.ip.sesion3;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el valor límite: ");
        int limite = scanner.nextInt();

        if (limite < 0) {
            System.out.println("El límite debe ser un número entero positivo o cero.");
            return;
        }
        System.out.println("Términos de Fibonacci menores o iguales a " + limite + ":");


        int a = 0; // f0
        int b = 1; // f1

        if (a <= limite) {
            System.out.print(a);
        } else {
            System.out.println();
            scanner.close();
            return;
        }
        if (b <= limite && limite >= 1) {
            System.out.print(", " + b);
        }
        long actual = (long)a;
        long siguiente = (long)b;

        while (true) {
            long proximo = actual + siguiente;
            if (proximo > limite) {
                break;
            }
            System.out.print(", " + proximo);
            actual = siguiente;
            siguiente = proximo;
        }

        System.out.println(); 
	}
}
