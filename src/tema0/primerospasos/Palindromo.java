package tema0.primerospasos;

public class Palindromo {

	public static void main(String[] args) {
		String palabra = "radar";
		String reves = "";
		
		for (int i = 0; i < palabra.length(); i++) {
			reves = palabra.charAt(i) + reves;
		}

		if (palabra.equals(reves)) {
			System.out.println(palabra + " es un palindromo");
		} else {
			System.out.println(palabra + " NO es un palindromo");
		}

	}

}
