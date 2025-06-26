package finales.ligacromos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UsuarioTest {

	@Test
	void constructorTest() {
		// Green path: que todo lo que debería funcionar funciona
		ArrayList<Jugador> lista = new ArrayList<Jugador>();
		lista.add(new Jugador());
		Usuario u1 = new Usuario("usuario1", lista);
		assertEquals("usuario1", u1.getNombreUsuario());
		assertEquals(lista, u1.getColeccion());
		assertEquals(1, u1.getColeccion().size());
		
		// Red path: que todo lo que NO debería funcionar NO funciona
		// Tiene sentido cuando hay fechas que pueden ser inválidas
		// o propiedades que nunca deberían estar a null...
		// Dejamos esto comentado porque esta clase no tiene nada que pueda generar una excepcion al contruirse
//		try {
//			Usuario u2 = new Usuario("usuario2", null);
//			fail("Se ha pasado una coleccion nula y no ha fallado");
//		} catch (Exception e) {
//			// OK!
//		}
		
	}

	@Test
	void getValorTotalTest() {
		// Caso 1: usuario con coleccion vacía
		ArrayList<Jugador> lista = new ArrayList<Jugador>();
		Usuario u1 = new Usuario("usuario1", lista);
		assertEquals(0.0, u1.getValorTotal(), 0.001);
		// Caso 2: usuario con 1 cromo común
		ArrayList<Jugador> lista2 = new ArrayList<Jugador>();
		lista2.add(new Jugador("", Posicion.Centrocampista, "", 20, Rareza.COMUN, 0));
		Usuario u2 = new Usuario("usuario2", lista2);
		assertEquals(20.0, u2.getValorTotal(), 0.001);
		// Caso 3: usuario con 1 cromo común y un cromo legendario
		ArrayList<Jugador> lista3 = new ArrayList<Jugador>();
		lista3.add(new Jugador("", Posicion.Centrocampista, "", 20.1, Rareza.COMUN, 0));
		lista3.add(new Jugador("", Posicion.Centrocampista, "", 20.1, Rareza.LEGENDARIA, 0));
		Usuario u3 = new Usuario("usuario3", lista3);
		assertEquals(60.30, u3.getValorTotal(), 0.001);
	}
	
}
