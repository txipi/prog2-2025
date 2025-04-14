package tema4.utilidades;

import java.util.ArrayList;

public class Aleatorios {

	public enum Semaforo {
		ROJO, VERDE, AMBAR;
	}
	
	public static void main(String[] args) {
		// int aleatorio entre 5 y 37
		int aleaInt = (int) (Math.random() * (37 - 5)) + 5;
		
		// double aleatorio entre 5.5 y 11.5
		double aleaDouble = Math.random() * (11.5 - 5.5) + 5.5;
		
		// boolean aleatorio
		boolean aleaBoolean = Math.random() > 0.5;
		
		// elemento aleatorio de una lista: random.choice(lista)
		ArrayList<Object> lista = new ArrayList<Object>();
		int pos = (int) (Math.random() * lista.size());
		Object elemento = lista.get(pos);
		
		// enum aleatorio
		Semaforo[] todos = Semaforo.values();
		int posicion = (int) (Math.random() * todos.length);
		Semaforo aleaEnum = todos[posicion];
		
	}

}
