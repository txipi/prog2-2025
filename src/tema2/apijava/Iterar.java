package tema2.apijava;

import java.util.ArrayList;

public class Iterar {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9};
		
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		numeros.add(3);
		numeros.add(7);
		numeros.add(21);
		
		String frase = "Hola, mundo!";
		
		for (char letra : frase.toCharArray()) {
			System.out.println(letra);
		}
		
		for (String letra : frase.split("")) {
			System.out.println(letra);
		}
		
		for (int numero : numeros) {
			System.out.println(numero);
		}
		
		for (int numero : nums) {
			System.out.println(numero);
		}
		
		ArrayList<Genero> generos1 = new ArrayList<Genero>();
		generos1.add(Genero.HUMOR);
		generos1.add(Genero.FANTASIA);
		generos1.add(Genero.TEATRO);
		Libro libro1 = new Libro("Quijote", "Cervantes", 
				1506, 30, 234234322, generos1);
		
		for (Genero genero : libro1.getGeneros()) {
			System.out.println(genero);
		}
		
		for (Genero genero : libro1) {
			System.out.println(genero);
		}
	}

}
