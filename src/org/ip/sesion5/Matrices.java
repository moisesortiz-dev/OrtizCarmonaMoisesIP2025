package org.ip.sesion5;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Matrices {

    private static final int MIN_VALOR = 0;
    private static final int MAX_VALOR = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("🎉 Programa de Operaciones con Matrices 🎉");

        do {
            System.out.println("\n--- MENÚ DE OPERACIONES ---");
            System.out.println("1. Producto por Escalar");
            System.out.println("2. Suma de Matrices");
            System.out.println("3. Multiplicación de Matrices");
            System.out.println("4. Salir");
            
            try {
                System.out.print("👉 Introduce tu opción (1-4): ");
                opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        productoPorEscalar(scanner);
                        break;
                    case 2:
                        sumaDeMatrices(scanner);
                        break;
                    case 3:
                        multiplicacionDeMatrices(scanner);
                        break;
                    case 4:
                        System.out.println("👋 ¡Gracias por usar el programa! Saliendo...");
                        break;
                    default:
                        System.out.println("⚠️ Opción no válida. Elige entre 1 y 4.");
                        break;
                }
                
                System.out.println("\n---");
                
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada no válida. Introduce un número.");
                scanner.next();
                opcion = 0;
            } catch (Exception e) {
                System.out.println("❌ Ocurrió un error: " + e.getMessage());
            }

        } while (opcion != 4);

        scanner.close();
    }
    
    public static int[][] generarMatrizAleatoria(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        Random random = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR; 
            }
        }
        return matriz;
    }
    
    public static void imprimirMatriz(int[][] matriz) {
        if (matriz == null) {
            System.out.println("[Matriz Nula]");
            return;
        }
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.printf("%3d ", matriz[i][j]);
            }
            System.out.println("|");
        }
    }

    public static void productoPorEscalar(Scanner scanner) {
        System.out.println("\n--- Producto por Escalar ---");

        System.out.print("Introduce el número de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Introduce el número de columnas: ");
        int columnas = scanner.nextInt();
        System.out.print("Introduce el escalar: ");
        int escalar = scanner.nextInt();

        int[][] matrizOriginal = generarMatrizAleatoria(filas, columnas);
        
        int[][] resultado = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matrizOriginal[i][j] * escalar;
            }
        }
        
        System.out.println("\nMatriz Original:");
        imprimirMatriz(matrizOriginal);
        System.out.println("\nEscalar: " + escalar);
        System.out.println("\nResultado:");
        imprimirMatriz(resultado);
    }
    
    public static void sumaDeMatrices(Scanner scanner) {
        System.out.println("\n--- Suma de Matrices ---");

        System.out.print("Introduce el número de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Introduce el número de columnas: ");
        int columnas = scanner.nextInt();
        
        if (filas <= 0 || columnas <= 0) {
            System.out.println("❌ Error: Las dimensiones deben ser positivas.");
            return;
        }

        int[][] matrizA = generarMatrizAleatoria(filas, columnas);
        int[][] matrizB = generarMatrizAleatoria(filas, columnas);
        
        int[][] resultado = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        
        System.out.println("\nMatriz A:");
        imprimirMatriz(matrizA);
        System.out.println("\nMatriz B:");
        imprimirMatriz(matrizB);
        System.out.println("\nResultado (A + B):");
        imprimirMatriz(resultado);
    }

    public static void multiplicacionDeMatrices(Scanner scanner) {
        System.out.println("\n--- Multiplicación de Matrices ---");

        System.out.print("Introduce el número de filas de A: ");
        int filasA = scanner.nextInt();
        System.out.print("Introduce el número de columnas de A: ");
        int columnasA = scanner.nextInt();

        int filasB = columnasA;
        System.out.println("ℹ️ Filas de B: " + filasB);
        System.out.print("Introduce el número de columnas de B: ");
        int columnasB = scanner.nextInt();
        
        if (columnasA != filasB) {
            System.out.println("❌ Error: Columnas de A deben ser iguales a filas de B.");
            return;
        }

        int[][] matrizA = generarMatrizAleatoria(filasA, columnasA);
        int[][] matrizB = generarMatrizAleatoria(filasB, columnasB);
        
        int[][] resultado = new int[filasA][columnasB];
        
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        
        System.out.println("\nMatriz A (" + filasA + "x" + columnasA + "):");
        imprimirMatriz(matrizA);
        System.out.println("\nMatriz B (" + filasB + "x" + columnasB + "):");
        imprimirMatriz(matrizB);
        System.out.println("\nResultado (A x B) (" + filasA + "x" + columnasB + "):");
        imprimirMatriz(resultado);
    }
}

