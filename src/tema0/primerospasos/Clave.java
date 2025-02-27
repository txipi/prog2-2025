package tema0.primerospasos;

public class Clave {

	// def claveNumerica(longitud:int) -> str:
	public static String claveNumerica(int longitud) {
		String clave = "";
		for (int i = 0; i < longitud; i++) {
			int aleatorio = (int) (Math.random() * 10);
			clave = clave + aleatorio;
		}
		return clave;
	}

	public static String claveLetras(int longitud) {
		String clave = "";
		String alfabeto = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < longitud; i++) {
			int aleatorio = (int) (Math.random() * alfabeto.length());
			char letra = alfabeto.charAt(aleatorio);
			clave = clave + letra;
		}
		return clave;
	}
	
	public static void main(String[] args) {	
		System.out.println(claveNumerica(5));
		System.out.println(claveLetras(10));

	}

}
