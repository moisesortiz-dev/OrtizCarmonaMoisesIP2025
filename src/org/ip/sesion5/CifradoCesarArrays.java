package org.ip.sesion5;

import java.util.Scanner;

public class CifradoCesarArrays {

    private static final String ALFABETO_MAYUSCULAS_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALFABETO_MINUSCULAS_STR = "abcdefghijklmnopqrstuvwxyz";
    private static final int LONGITUD_ALFABETO = ALFABETO_MAYUSCULAS_STR.length();
    
    private static final char[][] ALFABETOS = new char[2][LONGITUD_ALFABETO];

    public static void main(String[] args) {

        for (int i = 0; i < LONGITUD_ALFABETO; i++) {
            ALFABETOS[0][i] = ALFABETO_MAYUSCULAS_STR.charAt(i);
            ALFABETOS[1][i] = ALFABETO_MINUSCULAS_STR.charAt(i);
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Cifrado César ---");
            System.out.println("1. Cifrar un mensaje");
            System.out.println("2. Descifrar un mensaje");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        cifrarMensaje(scanner);
                        break;
                    case 2:
                        descifrarMensaje(scanner);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); 
                opcion = 0; 
            }

        } while (opcion != 3);

        scanner.close();
    }
    
    // ----------------------------------------------------------------------

    private static void cifrarMensaje(Scanner scanner) {
        System.out.print("Ingrese el mensaje a cifrar: ");
        String mensaje = scanner.nextLine();
        
        int desplazamiento = obtenerDesplazamiento(scanner);
        if (desplazamiento == Integer.MIN_VALUE) return; 

        String mensajeCifrado = procesarMensaje(mensaje, desplazamiento, "cifrar");
        System.out.println("\nMensaje Original: " + mensaje);
        System.out.println("Desplazamiento: " + desplazamiento);
        System.out.println("**Mensaje Cifrado: " + mensajeCifrado + "**");
    }

    private static void descifrarMensaje(Scanner scanner) {
        System.out.print("Ingrese el mensaje a descifrar: ");
        String mensaje = scanner.nextLine();
        
        int desplazamiento = obtenerDesplazamiento(scanner);
        if (desplazamiento == Integer.MIN_VALUE) return; 

        String mensajeDescifrado = procesarMensaje(mensaje, desplazamiento, "descifrar");
        System.out.println("\nMensaje Cifrado: " + mensaje);
        System.out.println("Desplazamiento inverso: " + (-desplazamiento));
        System.out.println("**Mensaje Descifrado: " + mensajeDescifrado + "**");
    }
    
    // ----------------------------------------------------------------------
    
    private static int obtenerDesplazamiento(Scanner scanner) {
        System.out.print("Ingrese el tamaño del desplazamiento (entero): ");
        if (scanner.hasNextInt()) {
            int desplazamiento = scanner.nextInt();
            scanner.nextLine();
            return desplazamiento;
        } else {
            System.out.println("Entrada no válida. El desplazamiento debe ser un número entero.");
            scanner.nextLine(); 
            return Integer.MIN_VALUE; 
        }
    }

    private static String procesarMensaje(String mensaje, int desplazamiento, String operacion) {
        String resultado = ""; 
        int desplazamientoEfectivo;

        if ("cifrar".equals(operacion)) {
            desplazamientoEfectivo = desplazamiento;
        } else { 
            desplazamientoEfectivo = -desplazamiento;
        }

        for (int i = 0; i < mensaje.length(); i++) {
            char caracterOriginal = mensaje.charAt(i);
            char caracterProcesado = caracterOriginal;
            boolean encontrado = false;
            
            int fila = -1; 

            if (caracterOriginal >= 'A' && caracterOriginal <= 'Z') {
                fila = 0; 
            } else if (caracterOriginal >= 'a' && caracterOriginal <= 'z') {
                fila = 1; 
            }

            if (fila != -1) {
                int posicionOriginal = -1;
                for (int j = 0; j < LONGITUD_ALFABETO; j++) {
                    if (ALFABETOS[fila][j] == caracterOriginal) {
                        posicionOriginal = j;
                        break; 
                    }
                }

                if (posicionOriginal != -1) {
                    int nuevaPosicion = (posicionOriginal + desplazamientoEfectivo) % LONGITUD_ALFABETO;
        
                    if (nuevaPosicion < 0) {
                        nuevaPosicion += LONGITUD_ALFABETO;
                    }

                    caracterProcesado = ALFABETOS[fila][nuevaPosicion];
                }

            } 
         
            
            resultado += caracterProcesado; 
        }

        return resultado;
    }
}