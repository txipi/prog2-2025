package tema3.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Principal {

	public static void main(String[] args) {
		// Crear 50 libros que se llamen "libro-0" a "libro-49" con valores aleatorios
		ArrayList<Libro> libros = crearLibros();
		System.out.println(libros);
		
		// Crear un mapa para contar cuántos libros hay de cada año
		
		// Crear un mapa para clasificar los libros por año
		
		// Crear un mapa para contar cuántos libros hay de cada genero
		
		// Crear un mapa para clasificar los libros por genero
				
	}

	private static ArrayList<Libro> crearLibros() {
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
