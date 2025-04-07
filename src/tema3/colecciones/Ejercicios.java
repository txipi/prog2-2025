package tema3.colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

public class Ejercicios {

	public static void main(String[] args) {
		int[][] t = {
				{1, 2, 0, 3, 0, 7},
				{0, 0, 0, 0},
				{0, 6, 9, 8, 0, 9, 6},
				{0, 0, 0, 0, 7, 9, 0, 0},
				{0, 0, 0, 0, 0},
				{8, 7, 0, 8, 9, 0, 8}
			};
		
		ArrayList<ArrayList<Integer>> tabla = new ArrayList<ArrayList<Integer>>();
		
		// Llenar tabla con los valores de t
		
		for (int i = 0; i < t.length; i++) {
			ArrayList<Integer> fila = new ArrayList<Integer>();
			for (int j = 0; j < t[i].length; j++) {
				fila.add(t[i][j]);
			}
			tabla.add(fila);
		}
		
		// Limpiar de ceros la tabla
		ArrayList<ArrayList<Integer>> limpia = new ArrayList<ArrayList<Integer>>();
		
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
		
		System.out.println(limpia);
		
		// Euromillones
		HashSet<Integer> euromillones = new HashSet<Integer>();
		
		while (euromillones.size() < 6) {
			int aleatorio = (int) (Math.random() * 50) + 1;
			euromillones.add(aleatorio);
		}
		
		// Embarque de pasajeros de tren
		LinkedList<Viajero> colaViajeros = new LinkedList<Viajero>();
		
		for (int i = 0; i < 50; i++) {
			colaViajeros.add(new Viajero("Pasajero-"+i, "123456"+i));	
		}
		
		// procesamos la cola
		while (!colaViajeros.isEmpty()) {
			Viajero turno = colaViajeros.removeFirst();
			System.out.println("Entra en el avión el viajero " + turno);
		}
		
		// Embarque de viajeros de avión
		LinkedList<ViajeroPrioridad> colaViajerosPrioridad = new LinkedList<ViajeroPrioridad>();
		
		for (int i = 0; i < 50; i++) {
			Prioridad[] todas = Prioridad.values();
			int pos = (int) (Math.random() * todas.length);
			Prioridad prioridad = todas[pos];
			colaViajerosPrioridad.add(new ViajeroPrioridad("Pasajero-"+i, "123456"+i, prioridad));	
		}
		
		System.out.println(colaViajerosPrioridad);
		
		LinkedList<ViajeroPrioridad> colaViajerosPrimera = new LinkedList<ViajeroPrioridad>();
		LinkedList<ViajeroPrioridad> colaViajerosBusiness = new LinkedList<ViajeroPrioridad>();
		LinkedList<ViajeroPrioridad> colaViajerosTurista = new LinkedList<ViajeroPrioridad>();
		LinkedList<ViajeroPrioridad> colaViajerosEconomica = new LinkedList<ViajeroPrioridad>();
		
		for (ViajeroPrioridad viajeroPrioridad : colaViajerosPrioridad) {
			Prioridad p = viajeroPrioridad.getPrioridad();
			
			if (p == Prioridad.PRIMERA) {
				colaViajerosPrimera.add(viajeroPrioridad);
			} else if (p == Prioridad.BUSINESS) {
				colaViajerosBusiness.add(viajeroPrioridad);
			} else if (p == Prioridad.TURISTA) {
				colaViajerosTurista.add(viajeroPrioridad);
			} else {
				colaViajerosEconomica.add(viajeroPrioridad);
			}
		}
		
		while(!colaViajerosPrimera.isEmpty()) {
			ViajeroPrioridad turno = colaViajerosPrimera.removeFirst();
			System.out.println("Entra en el avión " + turno);
		}
		while(!colaViajerosBusiness.isEmpty()) {
			ViajeroPrioridad turno = colaViajerosBusiness.removeFirst();
			System.out.println("Entra en el avión " + turno);
		}
		while(!colaViajerosTurista.isEmpty()) {
			ViajeroPrioridad turno = colaViajerosTurista.removeFirst();
			System.out.println("Entra en el avión " + turno);
		}
		while(!colaViajerosEconomica.isEmpty()) {
			ViajeroPrioridad turno = colaViajerosEconomica.removeFirst();
			System.out.println("Entra en el avión " + turno);
		}

		// Yoda
		System.out.println(yoda("Usa tu fuerza Luke"));
		
		// Parentesis
		boolean correcta = parentesis("((3+4)+1)+((4+7))");
		
		// Conjunto de Viajeros
		HashSet<Viajero> conjuntoViajeros = new HashSet<Viajero>();
		
		conjuntoViajeros.add(new Viajero("Pablo", "12345678Z"));
		conjuntoViajeros.add(new Viajero("Kepa", "12345678Z"));
		
		System.out.println(conjuntoViajeros);
		
		Viajero v1 = new Viajero("Pablo", "1");
		Viajero v2 = new Viajero("Laura", "2");
		Viajero v3 = new Viajero("Mikel", "99");
		Viajero v4 = new Viajero("Kepa", "100");
		
		System.out.println(v1.hashCode());
		System.out.println(v2.hashCode());
		System.out.println(v3.hashCode());
		System.out.println(v4.hashCode());
		
		conjuntoViajeros.add(v1);
		conjuntoViajeros.add(v2);
		conjuntoViajeros.add(v3);
		conjuntoViajeros.add(v4);
		
		System.out.println(conjuntoViajeros);
		
		// Conjunto ORDENADO de viajeros
		TreeSet<Viajero> conjuntoViajerosOrdenado = new TreeSet<Viajero>();
		
		conjuntoViajerosOrdenado.add(v1);
		conjuntoViajerosOrdenado.add(v2);
		conjuntoViajerosOrdenado.add(v3);
		conjuntoViajerosOrdenado.add(v4);
		
		System.out.println(conjuntoViajerosOrdenado);
		
		// Mapa de Strings y enteros para guardar el stock de un supermercado
		
		HashMap<String, Integer> stock = new HashMap<>();
		
		stock.put("tomates", 17);
		stock.put("huevos", 23);
		stock.put("leche", 12);
		
		/*
		 * for clave in diccionario:
		 *     valor = diccionario[clave]
		 */
		
		for (String clave : stock.keySet()) {
			int valor = stock.get(clave);
			System.out.println(clave + " -> " + valor);
		}
		
		System.out.println("Imprimiendo el mapa con for-map");
		
		for (Map.Entry<String, Integer> entry : stock.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + " -> " + val);
		}
		
		HashMap<String, Integer> frecuencias = cuentaLetras("sdfsfsfasdfsdf");
		
		System.out.println(frecuencias);
		
		// Contar viajeros
		HashMap<Prioridad, Integer> freqViajeros = cuentaViajeros(colaViajerosPrioridad);
		
		// Clasificar viajeros
		HashMap<Prioridad, ArrayList<Viajero>> clasViajeros = clasificaViajeros(colaViajerosPrioridad);
		
	}

	public static HashMap<Prioridad, ArrayList<Viajero>> clasificaViajeros(
			LinkedList<ViajeroPrioridad> colaViajerosPrioridad) {
		HashMap<Prioridad, ArrayList<Viajero>> resultado = new HashMap<Prioridad, ArrayList<Viajero>>();

		for (ViajeroPrioridad viajeroPrioridad : colaViajerosPrioridad) {
			Prioridad prioridad = viajeroPrioridad.getPrioridad();
			
			if (!resultado.containsKey(prioridad)) {
				// Crear la lista asociada a esta prioridad
				resultado.put(prioridad, new ArrayList<Viajero>());
			} 
			// Añadir el viajero a la lista
			resultado.get(prioridad).add(viajeroPrioridad);
		}
		
		return resultado;
	}

	public static HashMap<Prioridad, Integer> cuentaViajeros(LinkedList<ViajeroPrioridad> colaViajerosPrioridad) {
		HashMap<Prioridad, Integer> resultado = new HashMap<Prioridad, Integer>();

		for (ViajeroPrioridad viajeroPrioridad : colaViajerosPrioridad) {
			Prioridad prioridad = viajeroPrioridad.getPrioridad();
			
			if (resultado.containsKey(prioridad)) {
				// Sumar 1
				int valor = resultado.get(prioridad);
				resultado.put(prioridad, valor + 1);
			} else {
				// Añadir esta prioridad al mapa
				resultado.put(prioridad, 1);
			}
		}
		
		return resultado;
	}

	public static HashMap<String, Integer> cuentaLetras(String frase) {
		HashMap<String, Integer> resultado = new HashMap<String, Integer>();
		
		// Dividimos la frase en letras
		String[] letras = frase.split("");
		
		for (String letra : letras) {
			if (resultado.containsKey(letra)) {
				// Sumar 1
				int valor = resultado.get(letra);
				resultado.put(letra, valor + 1);
			} else {
				// Añadir esta letra al mapa
				resultado.put(letra, 1);
			}
		}
		
		return resultado;
	}


	private static boolean parentesis(String expresion) {
		String[] letras = expresion.split("");
		LinkedList<String> pila = new LinkedList<String>(); 
		
		for (String letra : letras) {
			if (letra.equals("(")) {
				pila.push("(");
			} else if (letra.equals(")")) {
				if (!pila.isEmpty()) {
					pila.pop();
				} else {
					return false;
				}
			}
		}
		
		if (pila.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	private static String yoda(String frase) {
		String resultado = "";
		LinkedList<String> pila = new LinkedList<String>();
		
		String[] palabras = frase.split(" ");
		
		// Llenamos la pila -> push()
		for (String palabra : palabras) {
			pila.push(palabra);
		}
		
		// Vaciamos la pila -> pop()
		while(!pila.isEmpty()) {
			String palabra = pila.pop();
			resultado += palabra + " ";
		}
		
		return resultado;
	}

}
