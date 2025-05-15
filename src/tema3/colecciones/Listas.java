package tema3.colecciones;

import java.util.ArrayList;

public class Listas {
	public static void main(String[] args) {
		// Crear una lista
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		// Añadir elementos
		numeros.add(1);
		numeros.add(5);
		numeros.add(15);
		numeros.add(7);
		System.out.println(numeros);
		
		// Obtener elementos
		int n = numeros.get(0);
		
		// Recorrer la lista
		for (int numero : numeros) {
			System.out.println(numero);
		}
		
		for (int i = 0; i < numeros.size(); i++) {
			System.out.println(numeros.get(i));
		}
		
		// Comprobar si un elemento está dentro de la lista
		if (numeros.contains(23)) {
			System.out.println("La lista contiene el elemento 23");
		}
							
		// Eliminar elementos
		numeros.remove(1); // elimina el elemento en la posición 1
		System.out.println(numeros);
		
		// CUIDADO: así no se vacía una lista
		/*
		for (int numero : numeros) {
			numeros.remove(numero);
		}
		
		for (int i = 0; i < numeros.size(); i++) {
			numeros.remove(i);
		}
		*/
		
		numeros.clear(); // Vaciar lista
		
		// Vaciar lista poco a poco porque quiero hacer cosas con cada elemento
		
		// Vaciar lista como si fuera una cola: FIFO
		while (!numeros.isEmpty()) {
			// Obtenemos el elemento actual (primero)
			int numero = numeros.remove(0);
			// Utilizamos el elemento actual
			System.out.println(numero);
		}
		
		// Vaciar lista como si fuera una pila: LIFO
		while (!numeros.isEmpty()) {
			// Obtenemos el elemento actual (último)
			int numero = numeros.remove(numeros.size() - 1);
			// Utilizamos el elemento actual
			System.out.println(numero);
		}
		
		// Calcular la media
		int total = 0;
		for (int num : numeros) {
			total += num;
		}
		double media = total / numeros.size();
		
		// Encontrar el mayor
		int mayor = numeros.get(0);
		for (int num : numeros) {
			if (num > mayor) {
				mayor = num;
			}
		}
	}
}
