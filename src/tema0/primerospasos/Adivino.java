package tema0.primerospasos;

import java.util.Scanner;

public class Adivino {
	/*
	 * Juego del adivino:
	 * 
	 * Una persona piensa un número del 1 al 100.
	 * 
	 * Tenemos 5 intentos para adivinarlo y nos tienen que decir:
	 * - Si hemos acertado.
	 * - Si hemos fallado, si el número secreto era menor o mayor.
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int secreto = (int) (Math.random() * 100) + 1;
		int intentos = 5;
		int numero;
		boolean acertado = false;
		
		while (intentos > 0 && !acertado) {
			// Pedir un número
			System.out.print("Introduce un número: ");
			numero = sc.nextInt();
			// Comprobar el número
			if (numero < secreto) {
				System.out.println("El número secreto es mayor");
			} else if (numero > secreto) {
				System.out.println("El número secreto es menor");
			} else {
				System.out.println("¡Has acertado!");
				acertado = true;
			}
			intentos--;
		}
		
		if (!acertado) {
			System.out.println("Has perdido");
		}
	}
}
