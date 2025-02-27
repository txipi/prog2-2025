package tema0.primerospasos;

public class Reves {

	public static void main(String[] args) {
		String palabra = "aceituna";

		for (int i = palabra.length() - 1; i >= 0; i--) {
			System.out.print(palabra.charAt(i));
		}

	}

}
