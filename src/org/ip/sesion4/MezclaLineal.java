package org.ip.sesion4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MezclaLineal {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- 3. Ejercicio: Algoritmo de Mezcla Lineal ---");
        
        System.out.println("\nConfigurando Array 1 (Debe ser ascendente):");
        int[] array1 = solicitarArrayOrdenado();
        
        System.out.println("\nConfigurando Array 2 (Debe ser ascendente):");
        int[] array2 = solicitarArrayOrdenado();

        if (array1.length == 0 && array2.length == 0) {
            System.out.println("No se puede realizar la mezcla con arrays vacíos.");
            return;
        }

        int[] arrayResultante = mezclarArrays(array1, array2);

        System.out.println("\n=============================================");
        System.out.println("✅ Resultado de la Mezcla Lineal:");
        System.out.println("   Array 1: " + Arrays.toString(array1));
        System.out.println("   Array 2: " + Arrays.toString(array2));
        System.out.println("   Array Resultante: " + Arrays.toString(arrayResultante));
        System.out.println("=============================================");
    }

    public static int[] mezclarArrays(int[] arr1, int[] arr2) {
        int N = arr1.length;
        int M = arr2.length;
        int[] resultante = new int[N + M];


        int i = 0; 
        int j = 0; 
        int k = 0; 

        while (i < N && j < M) {
            if (arr1[i] <= arr2[j]) {
                resultante[k] = arr1[i];
                i++;
            } else {
                resultante[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < N) {
            resultante[k] = arr1[i];
            i++;
            k++;
        }

        while (j < M) {
            resultante[k] = arr2[j];
            j++;
            k++;
        }

        return resultante;
    }
    
    private static int[] solicitarArrayOrdenado() {
        int N = 0;
        while (N <= 0) {
            try {
                System.out.print("Introduzca la longitud (N) del array (> 0): ");
                N = scanner.nextInt();
                if (N <= 0) {
                    System.out.println("La longitud debe ser un número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Introduzca un número entero.");
                scanner.next();
            }
        }
        int[] datos = new int[N];
        int valorAnterior = Integer.MIN_VALUE;

        System.out.println("Introduzca los elementos de forma ASCENDENTE:");
        for (int i = 0; i < N; i++) {
            int valorActual;
            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    System.out.print("Elemento [" + (i + 1) + "/" + N + "]: ");
                    valorActual = scanner.nextInt();

                    if (valorActual < valorAnterior) {
                        System.out.println("❌ ERROR: El número " + valorActual + " es menor que el anterior (" + valorAnterior + "). Introduzca un número mayor o igual.");
                    } else {
                        datos[i] = valorActual;
                        valorAnterior = valorActual;
                        entradaValida = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, introduzca un número entero.");
                    scanner.next();
                }
            }
        }
        return datos;
    }
}
