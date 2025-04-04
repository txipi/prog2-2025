package tema3.colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Ejercicios {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> tabla = new ArrayList<ArrayList<Integer>>();

		// Creamos un array bidimensional con todos los datos
		int[][] t = {
				{1, 2, 0, 3, 0, 7},
				{0, 0, 0, 0},
				{0, 6, 9, 8, 0, 9, 6},
				{0, 0, 0, 0, 7, 9, 0, 0},
				{0, 0, 0, 0, 0},
				{8, 7, 0, 8, 9, 0, 8}
			};
		
		// Recorremos el array bidimensional
		for (int i = 0; i < t.length; i++) {
			// Por cada fila, creamos una fila nueva
			ArrayList<Integer> fila = new ArrayList<Integer>(); 
			for (int j = 0; j < t[i].length; j++) {
				// Añadimos los valores correspondientes a esta fila
				fila.add(t[i][j]);
			}
			// Añadimos la fila a la tabla
			tabla.add(fila);
		}
		
		// Creamos una tabla nueva donde estarán los datos finales
		ArrayList<ArrayList<Integer>> limpia = new ArrayList<ArrayList<Integer>>();

		// Limpiamos la tabla de ceros y guardamos el resultado en limpia
		for (ArrayList<Integer> fila : tabla) {
			ArrayList<Integer> f = new ArrayList<Integer>(); 
			for (int n : fila) {
				if (n != 0) {
					f.add(n);
				}
			}
			if (!f.isEmpty()) {
				limpia.add(f);
			}
		}
		
		// Mostramos el contenido de la tabla limpia
		for (ArrayList<Integer> fila : limpia) {
			for (int n : fila) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
		
		// Euromillones
		HashSet<Integer> euromillones = new HashSet<Integer>();
		
		while (euromillones.size() < 6) {
			int aleatorio = (int) (Math.random() * 50) + 1;
			euromillones.add(aleatorio);
		}
		
		System.out.println(euromillones);
		
		// Cola de viajeros
		LinkedList<Viajero> viajeros = new LinkedList<Viajero>();
		
		for (int i = 0; i < 20; i++) {
			Viajero nuevo = new Viajero("Viajero-"+i, "1234567"+i, Prioridad.TURISTA);
			viajeros.add(nuevo);
		}
		
		System.out.println(viajeros);
		
		while(!viajeros.isEmpty()) {
			Viajero turno = viajeros.removeFirst();
			System.out.println("El viajero " + turno + " entra en el tren");
		}
		
		// Cola de viajeros con prioridades
		
		// Llenamos la cola con 50 viajeros de prioridades aleatorias
		for (int i = 0; i < 50; i++) {
			Prioridad[] todas = Prioridad.values();
			int aleatorio = (int) (Math.random() * todas.length);
			Prioridad prioridad = todas[aleatorio];
			Viajero nuevo = new Viajero("Viajero-"+i, "1234567"+i, prioridad);
			viajeros.add(nuevo);
		}
		
		// Creamos una cola para prioridad
		LinkedList<Viajero> viajerosPrimera = new LinkedList<Viajero>();
		LinkedList<Viajero> viajerosBusiness = new LinkedList<Viajero>();
		LinkedList<Viajero> viajerosTurista = new LinkedList<Viajero>();
		LinkedList<Viajero> viajerosEconomica = new LinkedList<Viajero>();
		
		// Clasificamos a los viajeros en función de su prioridad
		while(!viajeros.isEmpty()) {
			Viajero turno = viajeros.removeFirst();
			
			if (turno.getPrioridad() == Prioridad.PRIMERA) {
				viajerosPrimera.add(turno);
			} else if (turno.getPrioridad() == Prioridad.BUSINESS) {
				viajerosBusiness.add(turno);
			} else if (turno.getPrioridad() == Prioridad.TURISTA) {
				viajerosTurista.add(turno);
			} else {
				viajerosEconomica.add(turno);
			}
		}
		
		while(!viajerosPrimera.isEmpty()) {
			Viajero turno = viajerosPrimera.removeFirst();
			System.out.println(turno + " entra al avión");
		}
		while(!viajerosBusiness.isEmpty()) {
			Viajero turno = viajerosBusiness.removeFirst();
			System.out.println(turno + " entra al avión");
		}
		while(!viajerosTurista.isEmpty()) {
			Viajero turno = viajerosTurista.removeFirst();
			System.out.println(turno + " entra al avión");
		}
		while(!viajerosEconomica.isEmpty()) {
			Viajero turno = viajerosEconomica.removeFirst();
			System.out.println(turno + " entra al avión");
		}
		
		// Yoda
		System.out.println(yoda("Usa tu fuerza Luke"));
		
		// Parentesis
		System.out.println(parentesis("((())(()())))"));
		
	}

	private static boolean parentesis(String frase) {
		boolean resultado = true;
		
		LinkedList<String> pila = new LinkedList<String>();
		
		String[] par = frase.split("");
		
		for (String p : par) {
			if (p.equals("(")) {
				pila.push(p);
			} else {
				if (!pila.isEmpty()) {
					pila.pop();
				} else {
					// Si teníamos que desapilar un paréntesis y no hay -> está mal
					resultado = false;
					break;
				}
			}
		}
		
		if (!pila.isEmpty()) {
			// Si hemos terminado y quedan paréntesis por desapilar -> está mal
			resultado = false;
		}
		
		return resultado;
	}

	public static String yoda(String frase) {
		String resultado = "";
		LinkedList<String> pila = new LinkedList<String>();
		
		String[] palabras = frase.split(" ");
		
		for (String palabra : palabras) {
			pila.push(palabra);
		}
		
		while(!pila.isEmpty()) {
			String palabra = pila.pop();
			resultado += palabra + " ";
		}
		
		return resultado;
	}

}
