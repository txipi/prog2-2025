package finales.deustospace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MisionTest {

	@Test
	void constructorTest() {
		//fail("Not yet implemented");
	}

	@Test
	void getCosteTotalTest() {
		//Una Mision sin Personal y con nave coste 0.
		Mision m1 = new Mision("m1", "", "", 2025, 1, 1);
		Nave n1 = new Nave("n1", "", 0, 0);
		m1.setNave(n1);
		assertEquals(1.5, m1.getCosteTotal());
		//Una Mision sin Personal y con nave con coste.
		Mision m2 = new Mision("m2", "", "", 2025, 1, 1);
		Nave n2 = new Nave("n2", "", 1.5, 0);
		m2.setNave(n2);
		assertEquals(3.0, m2.getCosteTotal());
		//Una Mision con la Nave anterior y 1 Astronauta sin Habilidades.
		Mision m3 = new Mision("m3", "", "", 2025, 1, 1);
		Astronauta a1 = new Astronauta("a1", "");
		a1.getHabilidades().add(Habilidad.PILOTAR);
		m3.getPersonal().add(a1);
		m3.setNave(n2);
		assertEquals(3.25, m3.getCosteTotal());
		//Una Mision con Nave y 1 Astronauta con 2 Habilidades.
		Mision m4 = new Mision("m4", "", "", 2025, 1, 1);
		a1.getHabilidades().add(Habilidad.MEDICINA);
		m4.getPersonal().add(a1);
		m4.setNave(n2);
		assertEquals(3.5, m4.getCosteTotal());
		//Una Mision con lo anterior y un personal de Tierra con nivel 1 y personal de Tierra con nivel 2.
		Mision m5 = new Mision("m5", "", "", 2025, 1, 1);
		m5.getPersonal().add(a1);
		m5.setNave(n2);
		Tierra t1 = new Tierra("t1", "", 1);
		Tierra t2 = new Tierra("t2", "", 2);
		m5.getPersonal().add(t1);
		m5.getPersonal().add(t2);
		assertEquals(3.95, m5.getCosteTotal());
	}

}
