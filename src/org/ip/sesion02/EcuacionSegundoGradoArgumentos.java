package org.ip.sesion02;

public class EcuacionSegundoGradoArgumentos {

    public static void main(String[] args) {
        
        if (args.length != 3) {
            System.err.println("Error: Se deben proporcionar tres argumentos (a, b, c) para la ecuación de segundo grado.");
            System.err.println("Ejemplo de uso en Eclipse: 1 -3 2");
            return;
        }

        double a, b, c;
        
        try {
            // 1. Convertir los argumentos de String a double
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
            c = Double.parseDouble(args[2]);

        } catch (NumberFormatException e) {
            System.err.println("Error: Los argumentos deben ser números válidos.");
            System.err.println("Detalles del error: " + e.getMessage());
            return;
        }
        
        System.out.println("--- SOLUCION DE UNA ECUACION DE SEGUNDO GRADO POR ARGUMENTOS ---");
        
        // Mostrar los coeficientes
        System.out.println("\nValores de los coeficientes");
        System.out.printf("a = %.0f, b = %.0f, c = %.0f\n", a, b, c);
        
        // -----------------------------------------------------
        // 2. Lógica de Solución 
        // -----------------------------------------------------
        
        if (a == 0) {
            System.out.println("No es una ecuacion de segundo grado");
            return;
        }
        
        double discriminante = (b * b) - (4 * a * c);
        

        if (discriminante < 0) {
            System.out.println("No tiene solucion real");
        } 
        else if (discriminante == 0) {
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
