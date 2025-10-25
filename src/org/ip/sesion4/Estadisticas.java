package org.ip.sesion4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Estadisticas {

    private static double[] datos = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 5);

        System.out.println("¡Programa finalizado! Gracias por usar la Calculadora Estadística.");
        scanner.close();
    }

  private static void mostrarMenu() {
        System.out.println("\n--- Menú de Ejercicio: Estadística ---");
        System.out.println("1. Cargar datos aleatorios");
        System.out.println("2. Cargar datos manualmente");
        System.out.println("3. Visualizar datos");
        System.out.println("4. Operaciones a realizar");
        System.out.println("5. Salir");
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
                cargarDatosAleatorios();
                break;
            case 2:
                cargarDatosManualmente();
                break;
            case 3:
                visualizarDatos();
                break;
            case 4:
                mostrarSubmenuOperaciones();
                break;
            case 5:
                break;
            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
        }
    }

    private static int solicitarTamanio() {
        int N = 0;
        while (N <= 0) {
            try {
                System.out.print("Introduzca el tamaño (N) del array (> 0): ");
                N = scanner.nextInt();
                if (N <= 0) {
                    System.out.println("El tamaño debe ser un número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduzca un número entero.");
                scanner.next(); 
            }
        }
        return N;
    }

    private static void cargarDatosAleatorios() {
        int N = solicitarTamanio();
        datos = new double[N];
        
        for (int i = 0; i < N; i++) {
            datos[i] = (int) (Math.random() * 21); 
        }
        System.out.println("✅ Datos aleatorios cargados con éxito.");
    }

    private static void cargarDatosManualmente() {
        int N = solicitarTamanio();
        datos = new double[N];
        
        System.out.println("Introduzca los " + N + " valores (pueden ser decimales):");
        for (int i = 0; i < N; i++) {
            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    System.out.print("Valor [" + (i + 1) + "/" + N + "]: ");
                    datos[i] = scanner.nextDouble();
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, introduzca un número (use coma si su sistema lo requiere).");
                    scanner.next(); 
                }
            }
        }
        System.out.println("✅ Datos cargados manualmente con éxito.");
    }

    private static void visualizarDatos() {
        if (datos == null) {
            System.out.println("⚠️ Error: El array de datos aún no ha sido cargado.");
            return;
        }
        System.out.println("\n--- Datos del Array ---");
        System.out.println(Arrays.toString(datos));
        System.out.println("Número de elementos (N): " + datos.length);
    }

    private static void mostrarSubmenuOperaciones() {
        if (datos == null) {
            System.out.println("⚠️ Error: Debe cargar los datos primero (Opción 1 o 2).");
            return;
        }

        System.out.println("\n--- Submenú de Operaciones ---");
        System.out.println("a. Calcular la media.");
        System.out.println("b. Calcular la varianza.");
        System.out.println("c. Calcular la desviación estándar.");
        System.out.println("d. Calcular la moda.");
        System.out.println("e. Volver al menú principal.");
        System.out.print("Seleccione una operación (a, b, c, d, e): ");

 String subOpcion = scanner.next().toLowerCase(); 
        
        switch (subOpcion) {
            case "a":
                System.out.printf("👉 Media (x̄): %.4f%n", CalculadoraEstadistica.calcularMedia(datos));
                break;
            case "b":
                System.out.printf("👉 Varianza (s²): %.4f%n", CalculadoraEstadistica.calcularVarianza(datos));
                break;
            case "c":
                System.out.printf("👉 Desviación Estándar (s): %.4f%n", CalculadoraEstadistica.calcularDesviacionEstandar(datos));
                break;
            case "d":
                System.out.printf("👉 Moda: %.2f%n", CalculadoraEstadistica.calcularModa(datos));
                break;
            case "e":
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Operación no válida. Volviendo al menú principal.");
        }
    }
}
