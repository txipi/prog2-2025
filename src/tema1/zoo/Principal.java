package tema1.zoo;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Animal> animales = new ArrayList<Animal>();
		
		Animal a1 = new Pez();
		
		animales.add(a1);
		
		animales.add(new Pez());
		animales.add(new Ave());
		animales.add(new Reptil());
		animales.add(new Reptil());
		animales.add(new Mamifero());
		animales.add(new Pez());
		animales.add(new Mamifero());

		for (Animal animal : animales) {
			animal.hablar();
		}
		
	}

}
