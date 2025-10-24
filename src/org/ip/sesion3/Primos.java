package org.ip.sesion3;

import java.util.Scanner;

public class Primos {

static boolean esPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void listarPrimosHasta(int limite) {
        System.out.println("\n--- Listado de Primos hasta " + limite + " ---");
        int contador = 0;

        for (int i = 2; i <= limite; i++) {
            if (esPrimo(i)) {
                System.out.print(i + "\t"); 
                contador++;
                if (contador % 10 == 0) {
                    System.out.println(); 
                }
            }
        }
        System.out.println("\n-------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            // Mostrar el menú
            System.out.println("\n===== Ejercicio Primos (Simple) =====");
            System.out.println("1. Verificar si un número es primo.");
            System.out.println("2. Generar listado de primos hasta un número.");
            System.out.println("3. Salir.");
            System.out.print("Elige una opción (1-3): ");

            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    
                    System.out.print("Ingresa el número a verificar: ");
                    int num = scanner.nextInt();
                    
                    System.out.println("--- Resultado ---");
                    if (esPrimo(num)) {
                        System.out.println("El número " + num + " SÍ es primo. ✅");
                    } else {
                        System.out.println("El número " + num + " NO es primo. ❌");
                    }
                    break;
                    
                case 2:
                    
                    System.out.print("Ingresa el límite (ej. 100): ");
                    int limite = scanner.nextInt();
                    
                    listarPrimosHasta(limite);
                    break;
                    
                case 3:
                   
                    System.out.println("👋 Programa finalizado.");
                    break;
                    
                default:

                    System.out.println("Opción inválida. Intenta de nuevo.");
            }

        } while (opcion != 3);

        scanner.close();
    }
}
