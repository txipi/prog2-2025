package tema0.primerospasos;

import java.util.ArrayList;

public class Euromillones {

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList();
		ArrayList<Integer> estrellas = new ArrayList();
		
		for (int i = 0; i < 5; i++) {
			int aleatorio = (int) (Math.random() * 50) + 1;
			while (numeros.contains(aleatorio)) {
				aleatorio = (int) (Math.random() * 50) + 1;
			}
			numeros.add(aleatorio);
		}
		
		for (int i = 0; i < 2; i++) {
			int aleatorio = (int) (Math.random() * 12) + 1;
			while (estrellas.contains(aleatorio)) {
				aleatorio = (int) (Math.random() * 12) + 1;
			}
			estrellas.add(aleatorio);
		}
		
		System.out.println("Prueba suerte con esta combinación: " + numeros);
		System.out.println("estrellas: " + estrellas);

	}

}
