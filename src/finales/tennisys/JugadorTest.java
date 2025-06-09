package finales.tennisys;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JugadorTest {

	@Test
	void getFactorPromocionTest() {
		Jugador j1 = new JugadorInternacional("jugador 1", 20, 1, "pais 1", "patrocinador 1");
		assertEquals(0.8, j1.getFactorPromocion(), 0.001);
		Jugador j2 = new JugadorNacional("jugador 2", 21, 1, 3);
		assertEquals(4.5, j2.getFactorPromocion(), 0.001);
		Jugador j3 = new JugadorNacional("jugador 3", 21, 1, 2);
		assertEquals(3.0, j3.getFactorPromocion(), 0.001);
	}

}
