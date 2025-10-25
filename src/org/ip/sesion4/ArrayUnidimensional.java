package org.ip.sesion4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayUnidimensional {

    private static int[] arrayDatos = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 5);

        System.out.println("¡Programa finalizado! Hasta pronto.");
        scanner.close();
    }

    // --- Métodos de Menú y Control ---

    private static void mostrarMenu() {
        System.out.println("\n--- 2. Ejercicio: Array Unidimensional ---");
        System.out.println("1. Introducir un array de enteros ordenados de forma ascendente.");
        System.out.println("2. Visualizar el array.");
        System.out.println("3. Invertir el array para ordenarlo de forma inversa (Descendente/Ascendente).");
        System.out.println("4. Mostrar los valores mayor y el menor del array.");
        System.out.println("5. Salir.");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next(); 
            return -1;
        }
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                introducirArrayAscendente();
                break;
            case 2:
                visualizarArray();
                break;
            case 3:
                invertirArray();
                break;
            case 4:
                mostrarValoresExtremos();
                break;
            case 5:
                break;
            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
        }
    }

    private static void introducirArrayAscendente() {
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
        arrayDatos = new int[N];
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
                        arrayDatos[i] = valorActual;
                        valorAnterior = valorActual;
                        entradaValida = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, introduzca un número entero.");
                    scanner.next();
                }
            }
        }
        System.out.println("✅ Array cargado y validado con éxito.");
    }

    private static void visualizarArray() {
        if (arrayDatos == null) {
            System.out.println("⚠️ Error: El array de datos no ha sido cargado (Opción 1).");
            return;
        }
        System.out.println("\n--- Array Actual ---");
        System.out.println(Arrays.toString(arrayDatos));
    }

    private static void invertirArray() {
        if (arrayDatos == null) {
            System.out.println("⚠️ Error: El array de datos no ha sido cargado (Opción 1).");
            return;
        }
        
        int N = arrayDatos.length;
        for (int i = 0; i < N / 2; i++) {
            int temp = arrayDatos[i];
            arrayDatos[i] = arrayDatos[N - 1 - i];
            arrayDatos[N - 1 - i] = temp;
        }
        
        System.out.println("🔄 Array invertido con éxito.");
        visualizarArray();
    }


    private static void mostrarValoresExtremos() {
        if (arrayDatos == null) {
            System.out.println("⚠️ Error: El array de datos no ha sido cargado (Opción 1).");
            return;
        }
        
        
        int mayor = arrayDatos[0];
        int menor = arrayDatos[0];
        

        for (int i = 1; i < arrayDatos.length; i++) {
            if (arrayDatos[i] > mayor) {
                mayor = arrayDatos[i];
            }
            if (arrayDatos[i] < menor) {
                menor = arrayDatos[i];
            }
        }
        
        System.out.println("\n--- Valores Mayor y Menor ---");
        System.out.println("🌟 Valor Mayor: " + mayor);
        System.out.println("💧 Valor Menor: " + menor);
    }
}