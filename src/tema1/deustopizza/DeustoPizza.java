package tema1.deustopizza;

import java.util.ArrayList;
import java.util.Arrays;

public class DeustoPizza {

	public static void main(String[] args) {
		 Ingrediente[] aIngredientes = {
			 new Ingrediente("Aceitunas", 1.5, 50),
			 new Ingrediente("Anchoas", 2, 30),
			 new Ingrediente("Atún", 2, 25),
			 new Ingrediente("Bacon", 2, 35),
			 new Ingrediente("Calabacín", 1.5, 60),
			 new Ingrediente("Cebolla", 1, 30),
			 new Ingrediente("Champiñón", 1, 40),
			 new Ingrediente("Pepperoni", 2, 30),
			 new Ingrediente("Pimiento rojo", 1, 40),
			 new Ingrediente("Pimiento verde", 1, 50),
			 new Ingrediente("Piña", 1, 60),
			 new Ingrediente("Pollo", 2, 40),
			 new Ingrediente("Rúcula", 1, 30),
			 new Ingrediente("Salchicha", 1.5, 50),
			 new Ingrediente("Jamón cocido", 2, 50),
			 new Ingrediente("Jamón serrano", 2.5, 50)
			 };
		 ArrayList<Ingrediente> ingredientes = 
				 new ArrayList<Ingrediente>(Arrays.asList(aIngredientes));
		 ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		 crearPizzas(pizzas, ingredientes);
		 System.out.println(pizzas);
		 mostrarIngresos(pizzas);
		 mostrarMaximoIngreso(pizzas);
	}

	public static void mostrarMaximoIngreso(ArrayList<Pizza> pizzas) {
		Pizza resultado = pizzas.get(0);
		for (Pizza pizza : pizzas) {
			if (pizza.getPrecio() > resultado.getPrecio()) {
				resultado = pizza;
			}
		}
		System.out.println("Pizza más cara: " + resultado);
	}

	public static void mostrarIngresos(ArrayList<Pizza> pizzas) {
		double resultado = 0;
		for (Pizza pizza : pizzas) {
			resultado += pizza.getPrecio();
		}
		System.out.println("Total de ingresoso: " + resultado + "€");
	}

	public static void crearPizzas(ArrayList<Pizza> pizzas, ArrayList<Ingrediente> ingredientes) {
		for (int i = 0; i < 1000; i++) {
			Pizza nueva = new Pizza();
			nueva.setTamanyo((int)(Math.random() * 3));
			nueva.setMasa((int)(Math.random() * 3));
			if (Math.random() > 0.5) {
				nueva.setGratinar(true);
			} else {
				nueva.setGratinar(false);
			}
			for (int j = 0; j < 5; j++) {
				int alea = (int) (Math.random() * ingredientes.size());
				Ingrediente ingre = ingredientes.get(alea);
				nueva.getIngredientes().add(ingre);
			}
			pizzas.add(nueva);
		}
	}

}
