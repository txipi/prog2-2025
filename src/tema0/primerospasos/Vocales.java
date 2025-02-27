package tema0.primerospasos;

import java.util.ArrayList;

public class Vocales {

	public static void main(String[] args) {
		// ArrayList
		// ArrayList: crear
		ArrayList<Character> vocalesLista = new ArrayList();
		// ArrayList: añadir datos
		vocalesLista.add('a');
		vocalesLista.add('e');
		vocalesLista.add('i');
		vocalesLista.add('o');
		vocalesLista.add('u');
		// ArrayList: acceder al elemento 0
		System.out.println(vocalesLista.get(0));
		// ArrayList: tamaño
		System.out.println(vocalesLista.size());
		
		// String
		// String: crear
		String vocalesString = "";
		// String: añadir datos
		vocalesString = "aeiou";
		// String: acceder al elemento 0
		System.out.println(vocalesString.charAt(0));
		// String: tamaño
		System.out.println(vocalesString.length());
		
		// array
		// array: crear
		char[] vocalesArray = new char[5];
		// array: añadir datos
		vocalesArray[0] = 'a';
		vocalesArray[1] = 'e';
		vocalesArray[2] = 'i';
		vocalesArray[3] = 'o';
		vocalesArray[4] = 'u';
		// array: acceder al elemento 0
		System.out.println(vocalesArray[0]);
		// array: tamaño
		System.out.println(vocalesArray.length);
	}

}
