package tema0.primerospasos;

public class Contarvocales {

	public static void main(String[] args) {
		String frase = "en un lugar de la mancha";
		String vocales = "aeiou";
		int contador = 0;
		
		for (int i = 0; i < frase.length(); i++) {
			char letra = frase.charAt(i);
			if (vocales.contains(letra+"")) { // if (letra in vocales):
				contador++;
			}
		}
		
		System.out.println(contador);

	}

}
