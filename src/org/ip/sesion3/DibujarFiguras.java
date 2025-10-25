package org.ip.sesion3;

import java.util.Scanner;

public class DibujarFiguras {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;
		
		do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        dibujarCuadradoSolido(scanner);
                        break;
                    case 2:
                        dibujarTrianguloRectangulo(scanner);
                        break;
                    case 3:
                        dibujarCuadradoHueco(scanner);
                        break;
                    case 4:
                        dibujarCorazonAsciiArt();
                        break;
                    case 5:
                        dibujarMiAsciiArtFavorito();
                        break;
                    case 6:
                        System.out.println("\n👋 Saliendo del programa...");
                        break;
                    default:
                        System.out.println("\n❌ Opción no válida. Intente de nuevo.");
                }
            } else {
                System.out.println("\n❌ Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine();
                opcion = 0;
            }

            if (opcion != 6) {
                System.out.println("\n===========================================");
            }

        } while (opcion != 6);

        scanner.close();
    }


    public static void mostrarMenu() {
        System.out.println("\n===========================================");
        System.out.println("Menú: Dibujar Figuras Avanzadas");
        System.out.println("===========================================");
        System.out.println("1. Dibujar Cuadrado Sólido");
        System.out.println("2. Dibujar Triángulo Rectángulo");
        System.out.println("3. Dibujar Cuadrado Hueco");
        System.out.println("4. Dibujar Corazón AsciiArt");
        System.out.println("5. Dibujar mi AsciiArt favorito");
        System.out.println("6. Salir");
    }

    public static void dibujarCuadradoSolido(Scanner scanner) {
        System.out.print("Ingrese el tamaño del cuadrado: ");
        int lado = obtenerTamaño(scanner);

        System.out.print("Ingrese el carácter para dibujar: ");
        char caracter = obtenerCaracter(scanner);

        System.out.println("\n--- Cuadrado Sólido (" + lado + "x" + lado + ") ---");
        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                System.out.print(caracter + " ");
            }
            System.out.println();
        }
    }

    public static void dibujarTrianguloRectangulo(Scanner scanner) {
        System.out.print("Ingrese la altura del triángulo: ");
        int altura = obtenerTamaño(scanner);

        System.out.print("Ingrese el carácter para dibujar: ");
        char caracter = obtenerCaracter(scanner);

        System.out.println("\n--- Triángulo Rectángulo (Altura " + altura + ") ---");
        for (int i = 1; i <= altura; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(caracter);
            }
            System.out.println();
        }
    }

    public static void dibujarCuadradoHueco(Scanner scanner) {
        System.out.print("Ingrese el tamaño del cuadrado: ");
        int lado = obtenerTamaño(scanner);

        System.out.print("Ingrese el carácter para dibujar: ");
        char caracter = obtenerCaracter(scanner);

        System.out.println("\n--- Cuadrado Hueco (" + lado + "x" + lado + ") ---");
        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
            	if (i == 0 || i == lado - 1 || j == 0 || j == lado - 1) {
                    System.out.print(caracter + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

   
    public static void dibujarCorazonAsciiArt() {
        
        char caracter = '@';
        System.out.println("\n--- Corazón AsciiArt (Fijo) ---");
        System.out.println("  " + caracter + caracter + "   " + caracter + caracter);
        System.out.println(" " + caracter + "   " + caracter + " " + caracter + "   " + caracter);
        System.out.println(" " + caracter + "    " + caracter + "    " + caracter);
        System.out.println("  " + caracter + "    " + caracter + "   " + caracter);
        System.out.println("   " + caracter + "  " + caracter + "  " + caracter);
        System.out.println("    " + caracter + " " + caracter + " " + caracter);
        System.out.println("     " + caracter + caracter + caracter);
        System.out.println("      " + caracter);
    }
   
    public static void dibujarMiAsciiArtFavorito() {
        
        char caracter = '*';
        System.out.println("\n--- Mi AsciiArt Favorito (Estrella) ---");
        System.out.println("     " + caracter);
        System.out.println("    " + caracter + caracter + caracter);
        System.out.println("  " + caracter + caracter + caracter + caracter + caracter + caracter + caracter);
        System.out.println("   " + caracter + " " + caracter + " " + caracter);
        System.out.println("    " + caracter + caracter + caracter);
        System.out.println("     " + caracter);
    }

   
    
    
    public static int obtenerTamaño(Scanner scanner) {
        int tamaño = -1;
        while (tamaño <= 0) {
            if (scanner.hasNextInt()) {
                tamaño = scanner.nextInt();
                scanner.nextLine();
                if (tamaño <= 0) {
                    System.out.print("El tamaño debe ser un entero positivo. Ingrese de nuevo: ");
                }
            } else {
                System.out.print("Entrada no válida. Ingrese un número entero positivo: ");
                scanner.nextLine();
            }
        }
        return tamaño;
    }

    
    public static char obtenerCaracter(Scanner scanner) {
        String linea = scanner.nextLine();
        if (linea.isEmpty()) {
            return '#'; 
        }
        return linea.charAt(0);
    }
}
