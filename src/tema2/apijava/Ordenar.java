package tema2.apijava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ordenar {
	public static void main(String[] args) {
		// Ordenar enteros, fácil porque Integer implements Comparable
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		for (int i = 0; i < 100; i++) {
			numeros.add(i);
		}
		
		// Desordenamos
		Collections.shuffle(numeros);
		System.out.println(numeros);
		// Ordenamos
		Collections.sort(numeros);
		System.out.println(numeros);
		
		// Ordenar una clase inventada, Libro
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		libros.add(new Libro("El Quijote", "Cervantes", 1506, 30.5, 233544532));
		libros.add(new Libro("Invisible", "Eloy Moreno", 2020, 14.2, 678967864));
		libros.add(new Libro("1984", "George Orwell", 1936, 18.5, 999234923));
		libros.add(new Libro("El gran Gatsby", "Scott Fitzgerald", 1973, 22.5, 345645635));
		
		// Ordenamos la lista en función de compareTo (interfaz Comparable en Libro)
		// es decir, ordenados por autoría
		Collections.sort(libros);
		System.out.println(libros);
		
		// Ordenamos la lista usando un Comparator anónimo (no hemos creado una clase para ello)
		// en función del ISBN porque así lo decimos en el método compare
		libros.sort(new Comparator<Libro>() {
			@Override
			public int compare(Libro libro1, Libro libro2) {
				return libro1.getIsbn() - libro2.getIsbn();
			}
		});
		System.out.println(libros);
		
		// Ordenamos la lista usando un Comparator anónimo (no hemos creado una clase para ello)
		// en función del precio porque así lo decimos en el método compare
		libros.sort(new Comparator<Libro>() {
			@Override
			public int compare(Libro libro1, Libro libro2) {
				return (int) (libro1.getPrecio() - libro2.getPrecio());
			}
		});
		System.out.println(libros);
				
	}
}
