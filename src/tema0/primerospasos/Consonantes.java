package tema0.primerospasos;

public class Consonantes {

	public static void main(String[] args) {
		String frase = "en un lugar de la mancha";
		String consonantes = "bcdfghjklmnpqrstvwxyz";
		int contador = 0;
		
		for (int i = 0; i < frase.length(); i++) {
			char letra = frase.charAt(i);
			if (consonantes.contains(letra+"")) { // if (letra in consonantes):
				contador++;
			}
		}
		
		System.out.println(contador);

	}

}
