package finales.repaso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Principal {
	
	public static void generarPedidos(Tienda tienda) {
		// Añadir 100 pedidos a la cola de pedidos de la tienda
		for (int i = 0; i < 100; i++) {
			Pedido pedido = new Pedido();
			LocalDate fecha = LocalDate.of(2025, 5, i%31 + 1);
			pedido.setFecha(fecha);
			pedido.setCliente("cliente-"+i%10);
			ArrayList<Producto> prods = new ArrayList<Producto>();
			// Esto hace pedidos de 1 a 3 productos (si se repiten, no se añaden)
			//for (int j = 0; j < 3; j++) {
			// Esto hace pedidos de 3 productos
			while (prods.size() < 3) {
				// Elegimos un producto aleatorio de los que hay en la tienda
				int pos = (int) (Math.random() * tienda.getProductos().size());
				Producto producto = tienda.getProductos().get(pos);
				// Si no queremos productos repetidos:
				if (!prods.contains(producto)) {
					prods.add(producto);
				}
			}
			pedido.setProductos(prods);
			tienda.getPedidos().addLast(pedido);
		}
	}

	public static void main(String[] args) {
		Tienda tienda1 = new Tienda("Frikitienda");
		ArrayList<Producto> productos1 = new ArrayList<Producto>();
		productos1.add(new Comic("El eternauta", "Postapocalipsis", 28.50, 120, "Ostagard"));
		productos1.add(new Videojuego("Mario Kart 8 Deluxe", "Mario Kart para la Switch", 50, Plataforma.SWITCH));
		productos1.add(new Comic("V de Vendeta", "Venganza", 38.50, 230, "Frank Miller"));
		productos1.add(new Videojuego("Luigis Mansion", "Plataformas", 70, Plataforma.SWITCH));
		productos1.add(new Comic("Persepolis", "Iran", 18.20, 110, "M. S."));
		productos1.add(new Videojuego("Call of Duty", "FPS", 59.99, Plataforma.PLAYSTATION5));
		productos1.add(new Videojuego("WoW", "World of Warcraft", 45, Plataforma.PLAYSTATION4));
		tienda1.setProductos(productos1);
		// Ejemplo de polimorfismo de datos
		Producto p1 = new Comic();
		p1 = new Videojuego("Mario Kart 8 Deluxe", "Mario Kart para la Switch", 50, Plataforma.SWITCH);
		
		Online tieneweb = new Videojuego("Mario Kart 8 Deluxe", "Mario Kart para la Switch", 50, Plataforma.SWITCH);
		tieneweb = tienda1;
		
		System.out.println(tienda1);
		
		for (Producto producto : tienda1.getProductos()) {
			// Ejemplo de polimorfismo de código
			if (producto.hayPromocion()) {
				System.out.println(producto);
			}
		}
		
		generarPedidos(tienda1);
		
		System.out.println(tienda1.getPedidos());
		
		//tienda1.guardarPedidosBinario();
		
		//tienda1.cargarPedidosBinario();
		
		System.out.println(tienda1.getPedidos());
		
		tienda1.procesarPedidos();
		
		System.out.println(tienda1.getPedidos());
		
		System.out.println(tienda1.getIngresos());
		
		System.out.println(tienda1.getPedidosPorDia());
	}

}
