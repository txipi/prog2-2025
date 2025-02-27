package tema0.primerospasos;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int numero;
		int factorial = 1;
		
		// Pedimos el número
		System.out.print("Introduce el número: ");
		numero = entrada.nextInt();
		
		// Calcular el factorial de numero
		for (int i = 1; i <= numero; i++) {
			factorial = factorial * i;
		}
		
		System.out.println("El factorial de " + numero + " es " + factorial);
	}

}
