package tema0.primerospasos;

public class Museo {
	
	/*
	  	Los menores de 5 años entran gratis.
		Los menores de 18 años tienen tarifa joven: 5 €.
		Los adultos entre 19 y 64 años tienen tarifa normal: 10 €.
		Los adultos mayores de 65 años tienen tarifa senior: 7 €.
		Los miércoles la entrada es gratuita para todo el mundo.
	 */
	public static void main(String[] args) {
		int edad = 47;
		boolean miercoles = false;
		double precio = 0;
		
		// Calcular el precio para esta edad y día de la semana
		if (miercoles == true) {
			precio = 0;
		} else {
			if (edad < 5) {
				precio = 0;
			} else if (edad <= 18) {
				precio = 5;
			} else if (edad <= 64) {
				precio = 10;
			} else {
				precio = 7;
			}
		}
		
		System.out.println("Edad: " + edad);
		System.out.println("¿Miércoles? " + miercoles);
		System.out.println("Precio: " + precio);
	}
}
