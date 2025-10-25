package org.ip.sesion4;

import java.util.HashMap;
import java.util.Map;

public class CalculadoraEstadistica {

    /**
     * Calcula la media aritmética del array.
     * @param datos El array de números double.
     * @return La media del conjunto de datos.
     */
    public static double calcularMedia(double[] datos) {
        if (datos == null || datos.length == 0) {
            return 0.0;
        }
        double suma = 0;
        for (double d : datos) {
            suma += d;
        }
        return suma / datos.length;
    }

    /**
     * Calcula la varianza muestral (dividido por N-1).
     * @param datos El array de números double.
     * @return La varianza del conjunto de datos.
     */
    public static double calcularVarianza(double[] datos) {
        if (datos == null || datos.length <= 1) {
            return 0.0;
        }
        
        double media = calcularMedia(datos);
        double sumaDiferenciasCuadrado = 0;

        for (double d : datos) {
            // (xi - media)^2
            sumaDiferenciasCuadrado += Math.pow(d - media, 2);
        }

        // Varianza muestral: suma de cuadrados / (N - 1)
        return sumaDiferenciasCuadrado / (datos.length - 1);
    }

    /**
     * Calcula la desviación estándar (raíz cuadrada de la varianza).
     * @param datos El array de números double.
     * @return La desviación estándar.
     */
    public static double calcularDesviacionEstandar(double[] datos) {
        return Math.sqrt(calcularVarianza(datos));
    }

    /**
     * Calcula la moda (valor más frecuente). Asume una única moda.
     * Utiliza un HashMap para contar frecuencias.
     * @param datos El array de números double.
     * @return El valor de la moda. Retorna Double.NaN si el array es nulo/vacío.
     */
    public static double calcularModa(double[] datos) {
        if (datos == null || datos.length == 0) {
            return Double.NaN;
        }

        // 1. Contar frecuencias
        Map<Double, Integer> frecuencias = new HashMap<>();
        for (double d : datos) {
            // Usamos d para generar la clave y actualizamos el contador.
            frecuencias.put(d, frecuencias.getOrDefault(d, 0) + 1);
        }

        // 2. Encontrar el valor con la frecuencia máxima
        int maxFrecuencia = 0;
        double moda = datos[0]; // Inicializamos con el primer elemento

        for (Map.Entry<Double, Integer> entrada : frecuencias.entrySet()) {
            if (entrada.getValue() > maxFrecuencia) {
                maxFrecuencia = entrada.getValue();
                moda = entrada.getKey();
            }
        }
        return moda;
    }
}
