package tema0.primerospasos;

public class Matematicas {
	public static int parseaEntero (String s) {
		int resultado = 0;
		String numero = "";
		String digitos = "0123456789";
		
		for (int i = 0; i < s.length(); i++) {
			char letra = s.charAt(i);
			if (digitos.contains(letra+"")) { // if (str(letra) in digitos)
				numero = numero + letra;
			}
		}
		
		resultado = Integer.parseInt(numero);
		
		return resultado;
	}
	
	public static int sumaDigitos (String s) {
		int resultado = 0;
		String digitos = "0123456789";
		// Recorrer el String s
		for (int i = 0; i < s.length(); i++) {
			char letra = s.charAt(i);
			// mirar si la letra es un dígito ("0123456789")
			if (digitos.contains(letra+"")) {
				// convertir la letra a int: Integer.parseInt("123") -> 123
				resultado = resultado + Integer.parseInt(letra+"");
			}
		}
		return resultado;
	}
	
	public static int sumatorio (int a, int b) {
		int resultado = 0;
		for (int i = a; i <= b; i++) {
			resultado = resultado + i;
		}
		return resultado;
	}
	
	public static int sumatorio (int n) {
		return sumatorio(1, n);
	}
	
	public static int producto (int n) {
		int resultado = 1;
		for (int i = 1; i <= n; i++) {
			resultado = resultado * i;
		}
		return resultado;
	}
	
	public static int factorial (int n) {
		return producto(n);
	}
	
	public static boolean esPrimo (int n) {
		boolean resultado = true;

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				resultado = false;
				break;
			}
		}
		
		return resultado;
	}
	
	public static void main(String[] args) {
		System.out.println(sumatorio(10));
		System.out.println(producto(10));
		System.out.println(esPrimo(15));
		System.out.println(sumaDigitos("c1a2b3"));
	}

}
