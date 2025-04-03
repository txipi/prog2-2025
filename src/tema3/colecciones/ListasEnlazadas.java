package tema3.colecciones;

import java.util.LinkedList;

public class ListasEnlazadas {
	public static void main(String[] args) {
		// Crear una lista enlaza
		LinkedList<Double> temperaturas = new LinkedList<Double>();
		
		// Añadir elementos
		temperaturas.add(17.5);
		temperaturas.add(37.5);
		temperaturas.add(22.4);
		temperaturas.add(18.3);
		System.out.println(temperaturas);
		
		// Obtener elementos
		double t = temperaturas.get(0);
		
		// Recorrer la lista enlazada
		for (double temperatura : temperaturas) {
			System.out.println(temperatura);
		}
		
		for (int i = 0; i < temperaturas.size(); i++) {
			System.out.println(temperaturas.get(i));
		}
		
		// Comprobar si un elemento está dentro de la lista
		if (temperaturas.contains(23.2)) {
			System.out.println("La lista contiene el elemento 23.2");
		}
									
		// Eliminar elementos
		temperaturas.remove(1); // elimina el elemento en la posición 1
		System.out.println(temperaturas);
		
		// CUIDADO: así no se vacía una lista enlazada
		/*
		for (double temperatura : temperaturas) {
			temperaturas.remove(temperatura);
		}
		
		for (int i = 0; i < temperaturas.size(); i++) {
			temperaturas.remove(temperaturas.get(i));
		}
		*/
		
		temperaturas.clear(); // Vaciar lista
		
		// Vaciar lista poco a poco porque quiero hacer cosas con cada elemento
		
		// Vaciar lista enlazada como si fuera una cola: FIFO
		while (!temperaturas.isEmpty()) {
			// Obtenemos el elemento actual (primero)
			double temperatura = temperaturas.removeFirst();
			// Utilizamos el elemento actual
			System.out.println(temperatura);
		}
		
		// Vaciar lista como si fuera una pila: LIFO
		while (!temperaturas.isEmpty()) {
			// Obtenemos el elemento actual (último)
			double temperatura = temperaturas.removeLast();
			// Utilizamos el elemento actual
			System.out.println(temperatura);
		}
		
		// Funciones para tratamiento de colas
		temperaturas.addFirst(17.4);
		temperaturas.addLast(17.4);
		temperaturas.removeFirst();
		temperaturas.removeLast();
		
		// Funciones para tratamiento de pilas
		temperaturas.push(34.7); // Apilar un elemento
		temperaturas.pop(); // Desapilar el elemento de más arriba en la pila
		
		// Vaciar lista como si fuera una pila: LIFO
		while (!temperaturas.isEmpty()) {
			// Obtenemos el elemento actual (último)
			double temperatura = temperaturas.pop();
			// Utilizamos el elemento actual
			System.out.println(temperatura);
		}
	}
}
