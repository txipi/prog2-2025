package tema3.colecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Conjuntos {

	public static void main(String[] args) {
		// Crear un conjunto
		HashSet<String> nombres = new HashSet<String>();
		ArrayList<String> nombresLista = new ArrayList<String>();
		TreeSet<String> nombresOrdenado = new TreeSet<String>(); // String implements Comparable
		
		// Añadir elementos (no se añaden los duplicados)
		nombres.add("Pablo");
		nombres.add("Pablo");
		nombres.add("Pablo");
		nombres.add("Pablo");
		nombres.add("Jone");
		
		nombresLista.add("Pablo");
		nombresLista.add("Pablo");
		nombresLista.add("Pablo");
		nombresLista.add("Pablo");
		nombresLista.add("Jone");
		
		// Eliminar duplicados de una lista usando un conjunto
		for (String nombre : nombresLista) {
			nombres.add(nombre);
		}
		
		System.out.println(nombres);
		System.out.println(nombresLista);
		
		// Obtener un elemento
		//String nombre = nombres.get(0); -> NO SE PUEDE ACCEDER A UNA POSICION DEL SET
		
		// Recorrer un conjunto
		for (String nombre : nombres) {
			System.out.println(nombre);
		}
		
		// Comprobar si un elemento está dentro del conjunto
		if (nombres.contains("Pablo")) {
			System.out.println("El conjunto contiene el elemento Pablo");
		}
		
		// Vaciar un conjunto -> No se puede hacer así:
		while(!nombres.isEmpty()) {
			nombres.remove("Pablo"); // Cuidado porque tenemos que saber qué elementos había
		}
		
		nombres.clear();
		
	}

}
