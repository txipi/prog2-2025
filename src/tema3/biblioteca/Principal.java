package tema3.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Principal {

	public static void main(String[] args) {
		// Crear 50 libros que se llamen "libro-0" a "libro-49" con valores aleatorios
		ArrayList<Libro> libros = crearLibros();
		System.out.println(libros);
		
		// Crear un mapa para contar cuántos libros hay de cada año
		HashMap<Integer, Integer> mapaCuentaLibrosAnyo = cuentaLibrosAnyo(libros);
		System.out.println(mapaCuentaLibrosAnyo);
		
		// Crear un mapa para clasificar los libros por año
		HashMap<Integer, ArrayList<Libro>> mapaClasiLibrosAnyo = clasificaLibrosAnyo(libros);
		System.out.println(mapaClasiLibrosAnyo);

		// Crear un mapa para contar cuántos libros hay de cada genero
		HashMap<Genero, Integer> mapaCuentaLibrosGen = cuentaLibrosGenero(libros);
		System.out.println(mapaCuentaLibrosGen);
		
		// Crear un mapa para clasificar los libros por genero
		HashMap<Genero, ArrayList<Libro>> mapaClasiLibrosGen = clasificarLibrosGenero(libros);
		System.out.println(mapaClasiLibrosGen);
	}

	public static HashMap<Genero, ArrayList<Libro>> clasificarLibrosGenero(ArrayList<Libro> libros) {
		HashMap<Genero, ArrayList<Libro>> resultado = new HashMap<Genero, ArrayList<Libro>>();
		
		for (Libro libro : libros) {
			for (Genero genero : libro.getGeneros()) {
				if (!resultado.containsKey(genero)) {
					resultado.put(genero, new ArrayList<Libro>());
				}
				resultado.get(genero).add(libro);
			}
		}
		
		return resultado;
	}

	public static HashMap<Genero, Integer> cuentaLibrosGenero(ArrayList<Libro> libros) {
		HashMap<Genero, Integer> resultado = new HashMap<Genero, Integer>();
		
		for (Libro libro : libros) {
			for (Genero genero : libro.getGeneros()) {
				if (resultado.containsKey(genero)) {
					// Sumar 1 al contador
					int valor = resultado.get(genero);
					resultado.put(genero, valor + 1);
				} else {
					// Crear el contador
					resultado.put(genero, 1);
				}
			}
		}
		
		return resultado;
	}

	public static HashMap<Integer, ArrayList<Libro>> clasificaLibrosAnyo(ArrayList<Libro> libros) {
		HashMap<Integer, ArrayList<Libro>> resultado = new HashMap<>();
		
		for (Libro libro : libros) {
			int anyo = libro.getAnyo();
			
			// Nos aseguramos de que la lista de libros existe
			if (!resultado.containsKey(anyo)) {
				resultado.put(anyo, new ArrayList<Libro>());
			}
			
			// Añadimos este libro a la lista correspondiente al año
			resultado.get(anyo).add(libro);
		}
			
		return resultado;
	}

	public static HashMap<Integer, Integer> cuentaLibrosAnyo(ArrayList<Libro> libros) {
		HashMap<Integer, Integer> resultado = new HashMap<Integer, Integer>();
		
		for (Libro libro : libros) {
			int anyo = libro.getAnyo();
			
			if (resultado.containsKey(anyo)) {
				// Actualizar el contador
				int valor = resultado.get(anyo);
				resultado.put(anyo, valor + 1);
			} else {
				// Añadir el contador al mapa
				resultado.put(anyo, 1);
			}
		}
		
		return resultado;
	}

	public static ArrayList<Libro> crearLibros() {
		ArrayList<Libro> resultado = new ArrayList<Libro>();
		
		for (int i = 0; i < 50; i++) {
			int anyoRandom = (int) (Math.random() * 25) + 2000;
			double precioRandom = Math.random() * 10 + 10;
			ArrayList<Genero> generosRandom = new ArrayList<Genero>();
			// Los libros tienen 3 géneros como máximo
			for (int j = 0; j < 3; j++) {
				Genero[] todos = Genero.values();
				int aleatorio = (int) (Math.random() * todos.length);
				Genero genero = todos[aleatorio];
				// Si no teníamos este género, lo añadimos
				if (!generosRandom.contains(genero)) {
					generosRandom.add(genero);
				}
			}
			Libro nuevo = new Libro("libro-"+i, "autoria-"+i, anyoRandom, 
					precioRandom, 134134534+i, generosRandom);
			resultado.add(nuevo);
		}
		
		return resultado;
	}

}
