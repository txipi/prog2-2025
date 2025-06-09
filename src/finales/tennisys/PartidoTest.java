package finales.tennisys;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PartidoTest {

	@Test
	void constructorTest() {
		Jugador j1 = new JugadorInternacional("jugador 1", 20, 1, "pais 1", "patrocinador 1");
		Jugador j2 = new JugadorInternacional("jugador 2", 22, 2, "pais 2", "patrocinador 2");
		Arbitro a1 = new Arbitro("a1", 1);
		Partido p1 = new Partido(j1, j2, 110, a1);
		assertEquals(j1, p1.getJugador1());
		assertEquals(j2, p1.getJugador2());
		assertEquals(110, p1.getDuracion());
		assertEquals(a1, p1.getArbitro());
	}
	
	@Test
	void esValidoTest() {
		Jugador j1 = new JugadorInternacional("jugador 1", 20, 1, "pais 1", "patrocinador 1");
		Jugador j2 = new JugadorInternacional("jugador 2", 22, 2, "pais 2", "patrocinador 2");
		Arbitro a1 = new Arbitro("a1", 1);
		Partido p1 = new Partido(j1, j2, 110, a1);
		assertEquals(false, p1.esValido());
		Arbitro a2 = new Arbitro("a2", 3);
		Partido p2 = new Partido(j1, j2, 110, a2);
		assertEquals(true, p2.esValido());
		Jugador j3 = new JugadorInternacional("jugador 3", 23, 0, "pais 3", "patrocinador 3");
		Partido p3 = new Partido(j1, j3, 110, a2);
		assertEquals(false, p3.esValido());
	}

}
