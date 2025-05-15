package finales.repaso;

import java.util.ArrayList;

public class Principal {

//	public void funcion() {
//		
//	}
	
	public static void main(String[] args) {
		Tienda tienda1 = new Tienda("Frikitienda");
		ArrayList<Producto> productos1 = new ArrayList<Producto>();
		productos1.add(new Comic("El eternauta", "Postapocalipsis", 28.50, 120, "Ostagard"));
		productos1.add(new Videojuego("Mario Kart 8 Deluxe", "Mario Kart para la Switch", 50, Plataforma.SWITCH));
		tienda1.setProducto(productos1);
		// Ejemplo de polimorfismo de datos
		Producto p1 = new Comic();
		p1 = new Videojuego("Mario Kart 8 Deluxe", "Mario Kart para la Switch", 50, Plataforma.SWITCH);
		
		System.out.println(tienda1);
		
		for (Producto producto : tienda1.getProducto()) {
			// Ejemplo de polimorfismo de código
			if (producto.hayPromocion()) {
				System.out.println(producto);
			}
		}
	}

}
