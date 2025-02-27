package tema0.primerospasos;

public class Cadena {
	public static boolean iguales(String a, String b) {
		boolean resultado = true;
		if (a.length() != b.length()) {
			// Son de distinta longitud, seguro que son distintos Strings
			resultado = false;
		} else {
			// Son de igual de longitud, hay que mirar letra a letra
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) != b.charAt(i)) {
					resultado = false;
					break;
				}
			}
		}
		return resultado;
	}
	
	public static int indice (String s, char c) {
		int resultado = -1;
		
		for (int i = 0; i < s.length(); i++) {
			char letra = s.charAt(i);
			if (letra == c) {
				resultado = i;
				break;
			}
		}
		
		return resultado;
	}
	
	public static char caracterEn(String s, int p) {
		return s.charAt(p);
	}
	
	public static boolean palindromo (String s) {
		boolean resultado = false;
		String reves = "";
		
		for (int i = 0; i < s.length(); i++) {
			char letra = s.charAt(i);
			reves = letra + reves;
		}
		
		if (s.equals(reves)) {
			resultado = true;
		}
		
		return resultado;
	}
	
	public static void main(String[] args) {
		System.out.println(iguales("abc", "abc")); // true
		System.out.println(iguales("abc", "cba")); // false
	}

}
