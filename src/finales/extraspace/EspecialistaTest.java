package finales.extraspace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EspecialistaTest {

	@Test
	void constructorTest() {
		// Tarea 3A
		Especialista e1 = new Especialista("nombre", "pais", "especialidad", 50);
		assertEquals("nombre", e1.getNombre());
		assertEquals("pais", e1.getPais());
		assertEquals("especialidad", e1.getEspecialidad());
		assertEquals(50, e1.getDificultad());
		Especialista e2 = new Especialista("nombre2", "pais2", "especialidad2", 0);
		assertEquals("nombre2", e2.getNombre());
		assertEquals("pais2", e2.getPais());
		assertEquals("especialidad2", e2.getEspecialidad());
		assertEquals(0, e2.getDificultad());
		Especialista e3 = new Especialista("nombre3", "pais3", "especialidad3", 100);
		assertEquals("nombre3", e3.getNombre());
		assertEquals("pais3", e3.getPais());
		assertEquals("especialidad3", e3.getEspecialidad());
		assertEquals(100, e3.getDificultad());
		// Tarea 3B
		try {
			Especialista e4 = new Especialista("nombre4", "pais4", "especialidad4", -25);
			fail("Se esperaba la excepción ArithmeticException y no se ha lanzado");
		} catch (ArithmeticException e) {
			// OK!
		}
		// Tarea 3C
		Especialista e5 = new Especialista("nombre5", "pais5", null, 100);
		assertEquals("nombre5", e5.getNombre());
		assertEquals("pais5", e5.getPais());
		assertEquals("Desconocida", e5.getEspecialidad());
		assertEquals(100, e5.getDificultad());
		
	}

}
