package org.ip.sesion3;

import java.util.Scanner;

public class Euclides {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Cálculo del Máximo Común Divisor (MCD) ---");

        int x;
        do {
            System.out.print("Introduce el primer entero positivo (x): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, introduce un número entero.");
                scanner.next();
            }
            x = scanner.nextInt();
            if (x <= 0) {
                System.out.println("El número debe ser positivo.");
            }
        } while (x <= 0);

        int y;
        do {
            System.out.print("Introduce el segundo entero positivo (y): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, introduce un número entero.");
                scanner.next();
            }
            y = scanner.nextInt();
            if (y <= 0) {
                System.out.println("El número debe ser positivo.");
            }
        } while (y <= 0);

        int mcd = calcularMCD(x, y);

        System.out.println("\nEl MCD de " + x + " y " + y + " es: " + mcd);

        scanner.close();
    }

    public static int calcularMCD(int a, int b) {
        
        int dividendo = Math.max(a, b);
        int divisor = Math.min(a, b);
        int resto;

        System.out.println("\nPasos del Algoritmo de Euclides:");

        while (divisor != 0) {
            resto = dividendo % divisor;
            
            System.out.println("Dividir " + dividendo + " por " + divisor + ". Resto = " + resto);
            
            if (resto == 0) {
                break;
            }

            dividendo = divisor;
            divisor = resto;
        }
        return divisor;
    }
}