package tema2.apijava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clonar {

	public static void main(String[] args) {
		ArrayList<Genero> generos1 = new ArrayList<Genero>();
		generos1.add(Genero.HUMOR);
		generos1.add(Genero.FANTASIA);
		generos1.add(Genero.TEATRO);
		Libro libro1 = new Libro("Quijote", "Cervantes", 
				1506, 30, 234234322, generos1);

		Libro libro2 = libro1;
		try {
			libro2 = (Libro) libro1.clone();
		} catch (CloneNotSupportedException e1) {
			System.out.println("No he podido clonar el objeto: "+ e1);
		}
		
		libro2.setAnyo(2020);
		libro2.getGeneros().add(Genero.POLICIACA);
		
		System.out.println(libro1);
		System.out.println(libro2);
		
		int[] nums = {1,2,3,4,5,6,7,8,9};
	
		List lista = Arrays.asList(nums);
		ArrayList<Integer> numeros = new ArrayList<Integer>(lista);
		
	}

}
