package tema3.colecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

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
