package finales.repaso;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PedidoTest {

	@Test
	void constructorTest() {
		// Green path: que las cosas funcionen bien cuando las usamos bien
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(new Videojuego("Mario Kart 8 Deluxe", "Mario Kart para la Switch", 50, Plataforma.SWITCH));
		Pedido p1 = new Pedido("cliente1", LocalDate.of(2025, 5, 22), productos);
		assertEquals("cliente1", p1.getCliente());
		assertEquals(LocalDate.of(2025, 5, 22), p1.getFecha());
		assertEquals(1, p1.getProductos().size());
		// comprobamos también que las cosas funcionan mal cuando las usamos mal
		try {
			Pedido p2 = new Pedido("cliente2", LocalDate.of(31, 31, 31), productos);
			fail("Esperábamos una DateTimeException y no se ha lanzado");
		} catch(DateTimeException e) {
			// OK!
		}
		try {
			Pedido p3 = new Pedido(null, null, null);
		} catch (Exception e) {
			// MAL, no debería producirse una excepción
			fail("El constructor genera una excepción cuando no debería hacerlo");
		}
	}
	
	@Test
	void getIngresoTotalTest() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(new Comic("El eternauta", "Postapocalipsis", 28.50, 120, "Ostagard"));
		productos.add(new Videojuego("Mario Kart 8 Deluxe", "Mario Kart para la Switch", 50, Plataforma.SWITCH));
		productos.add(new Comic("V de Vendeta", "Venganza", 38.50, 230, "Frank Miller"));
		productos.add(new Videojuego("Luigis Mansion", "Plataformas", 70, Plataforma.SWITCH));
		productos.add(new Comic("Persepolis", "Iran", 18.1, 110, "M. S."));
		productos.add(new Videojuego("Call of Duty", "FPS", 59.99, Plataforma.PLAYSTATION5));
		productos.add(new Videojuego("Call of Duty", "FPS", 59.99, Plataforma.PLAYSTATION5));
		productos.add(new Videojuego("WoW", "World of Warcraft", 45, Plataforma.PLAYSTATION4));
		Pedido p1 = new Pedido("cliente1", LocalDate.of(2025, 5, 22), productos);
		assertEquals(370.08, p1.getIngresoTotal(), 0.001);
		ArrayList<Producto> productos2 = new ArrayList<Producto>();
		productos2.add(new Comic("El eternauta", "Postapocalipsis", 28.50, 120, "Ostagard"));
		productos2.add(new Comic("V de Vendeta", "Venganza", 38.50, 230, "Frank Miller"));
		productos2.add(new Comic("Persepolis", "Iran", 18.1, 110, "M. S."));
		Pedido p2 = new Pedido("cliente2", LocalDate.of(2025, 5, 22), productos2);
		assertEquals(85.10, p2.getIngresoTotal(), 0.001);
		ArrayList<Producto> productos3 = new ArrayList<Producto>();
		productos3.add(new Videojuego("Mario Kart 8 Deluxe", "Mario Kart para la Switch", 50, Plataforma.SWITCH));
		productos3.add(new Videojuego("Luigis Mansion", "Plataformas", 70.2, Plataforma.SWITCH));
		productos3.add(new Videojuego("Call of Duty", "FPS", 59.99, Plataforma.PLAYSTATION5));
		productos3.add(new Videojuego("Call of Duty", "FPS", 59.99, Plataforma.PLAYSTATION5));
		productos3.add(new Videojuego("WoW", "World of Warcraft", 45.1, Plataforma.PLAYSTATION4));
		Pedido p3 = new Pedido("cliente3", LocalDate.of(2025, 5, 22), productos3);
		assertEquals(285.28, p3.getIngresoTotal(), 0.000001);
		ArrayList<Producto> productos4 = new ArrayList<Producto>();
		Pedido p4 = new Pedido("cliente4", LocalDate.of(2025, 5, 22), productos4);
		assertEquals(0, p4.getIngresoTotal(), 0.000001);
		try {
			ArrayList<Producto> productos5 = new ArrayList<Producto>();
			productos5.add(null);
			productos5.add(null);
			Pedido p5 = new Pedido("cliente5", LocalDate.of(2025, 5, 22), productos5);
			p5.getIngresoTotal();
			fail("Se esperaba una excepción y no se ha producido");
		} catch (NullPointerException e) {
			// OK!
		}
	}

}
