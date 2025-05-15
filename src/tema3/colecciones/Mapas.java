package tema3.colecciones;

import java.util.HashMap;

public class Mapas {

	public static void main(String[] args) {
		/*
		 * Python:
		 * 
		 * libro = {
		 *   "titulo": "Quijote",
		 *   "autoria": "Cervantes",
		 *   "anyo": 1506
		 * }
		 * 
		 * HashMap: mapa ordenado con una tabla hash, las claves tengan hashCode()
		 * 		Tiene sus claves en un HashSet
		 * TreeMap: mapa ordenado con un árbol, las claves tienen que ser Comparables
		 * 		Tiene sus claves en un TreeSet
		 */
		
		// Crear un mapa
		HashMap<String, Integer> poblacionPorPais = new HashMap<>();
		
		// Añadir clave-valor a un mapa
		poblacionPorPais.put("Francia", 78324243);
		
		// Obtener un valor asociado a una clave
		int poblacion = poblacionPorPais.get("Francia");
		
		// Recorrer un mapa
		/*
		 * for (Clave clave : mapa.keySet()) {
		 *   Valor valor = mapa.get(clave);
		 * }
		 */
		for (String clave: poblacionPorPais.keySet()) {
			Integer valor = poblacionPorPais.get(clave);
			System.out.println(clave + "->" + valor);
		}
		
		// Clave asociada al mayor valor de un mapa
		String mayor_clave = "";
		int mayor_valor = -1;
		for (String clave: poblacionPorPais.keySet()) {
			Integer valor = poblacionPorPais.get(clave);
			if (valor > mayor_valor) {
				mayor_clave = clave;
				mayor_valor = valor;
			}
		}
		System.out.println(mayor_clave);
	}

}
