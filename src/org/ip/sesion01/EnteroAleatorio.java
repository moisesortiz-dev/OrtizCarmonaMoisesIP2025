package org.ip.sesion01;

public class EnteroAleatorio {

	public static void main(String[] args) {
		// Definir valores limites
		
		final int M = -15;
		final int N = 15;
		
		int rango = N - M + 1;
		
		//Generamos numero aleatorio
		
		double aleatorio = Math.random();
		double vAjustado = aleatorio * rango + M;
		int enteroAleatorio = (int) vAjustado;
		
		//Mostramos resultados
		
		System.out.println("Limite inferior: " + M);
		System.out.println("Limite superior: " + N);
		System.out.println("-----------------------");
		System.out.println("Numero aleatorio generado: " + enteroAleatorio);

		
		

		
	}

}
