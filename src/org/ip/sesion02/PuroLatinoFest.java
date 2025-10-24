package org.ip.sesion02;

import java.util.Scanner;

public class PuroLatinoFest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables de precios y resultados
        double precioBase = 0.0;
        double precioFinal = 0.0;
        String tipoAbono = "";

        System.out.println("--- Calculadora de Entradas 'Puro Latino Fest' ---");
        System.out.println("Tipos de Abono disponibles: General, Oro, Platino, Premium");
        System.out.print("Introduce el tipo de abono deseado: ");
        tipoAbono = scanner.nextLine().trim(); 
        
        
        if (tipoAbono.equalsIgnoreCase("General")) {
            precioBase = 60.0;
        } else if (tipoAbono.equalsIgnoreCase("Oro")) {
            precioBase = 175.0;
        } else if (tipoAbono.equalsIgnoreCase("Platino")) {
            precioBase = 210.0;
        } else if (tipoAbono.equalsIgnoreCase("Premium")) {
            precioBase = 240.0;
        } else {
            System.err.println("Error: Tipo de abono no reconocido. Saliendo del programa.");
            scanner.close();
            return;
        }

        precioFinal = precioBase;
        System.out.printf("Precio base: %.2f €\n", precioBase);

        // Descuentos
        double descuentoAcumulado = 0.0;

        // Descuento Carné Joven (-15%)
        System.out.print("¿Tienes Carné Joven acreditativo (S/N)? ");
        String carnejoven = scanner.nextLine().trim();
        if (carnejoven.equalsIgnoreCase("S")) {
            double descuentoJoven = precioFinal * 0.15; // 15% del precio actual
            precioFinal -= descuentoJoven;
            descuentoAcumulado += descuentoJoven;
            System.out.println("Descuento Carné Joven (-15%) aplicado.");
        }

        // Descuento Compra Anticipada (-10%)
        System.out.print("¿Fue una compra anticipada (más de 90 días) (S/N)? ");
        String anticipada = scanner.nextLine().trim();
        if (anticipada.equalsIgnoreCase("S")) {
            double descuentoAnticipada = precioFinal * 0.10; // 10% del precio actual
            precioFinal -= descuentoAnticipada;
            descuentoAcumulado += descuentoAnticipada;
            System.out.println("Descuento Compra Anticipada (-10%) aplicado.");
        }
        
        
        // Servicio de Reacceso
        System.out.print("¿Deseas el Servicio de Reacceso (+40€) (S/N)? ");
        String reacceso = scanner.nextLine().trim();
        if (reacceso.equalsIgnoreCase("S")) {
            precioFinal += 40.0;
            System.out.println("Recargo por Servicio de Reacceso (+40€) aplicado.");
        }
        
        //Mostrar Resultados
        System.out.println("\n--- Resumen de Compra ---");
        System.out.printf("Abono seleccionado: %s\n", tipoAbono);
        System.out.printf("Total Descuentos aplicados: %.2f €\n", descuentoAcumulado);
        System.out.printf("PRECIO FINAL A PAGAR: %.2f €\n", precioFinal);

        scanner.close();
    }
}
