package finales.deustogym;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class MiembroTest {

	@Test
	void constructorTest() {
		Miembro miembro = new Miembro("nombre", LocalDate.of(2025, 5, 25), TipoMembresia.BASICO);
		assertEquals("nombre", miembro.getNombre());
		assertEquals(LocalDate.of(2025, 5, 25), miembro.getFechaAlta());
		assertEquals(TipoMembresia.BASICO, miembro.getTipo());
		
		try {
			Miembro miembro2 = new Miembro("nombre", LocalDate.of(2055, 5, 30), TipoMembresia.BASICO);
			fail("Debería fallar porque la fecha está en el futuro");
		} catch(DateTimeException e) {
			// OK!
		}
	}
	
	@Test
	void getCuotaMensualTest() {
		Miembro m1 = new Miembro("nombre", LocalDate.of(2025, 5, 25), TipoMembresia.BASICO);
		assertEquals(25.0, m1.getCuotaMensual(), 0.001);
		Miembro m2 = new Miembro("nombre", LocalDate.of(2025, 5, 25), TipoMembresia.PREMIUM);
		assertEquals(45.0, m2.getCuotaMensual(), 0.001);
		Miembro m3 = new Miembro("nombre", LocalDate.of(2025, 5, 25), TipoMembresia.VIP);
		assertEquals(80.0, m3.getCuotaMensual(), 0.001);
		Miembro m4 = new Miembro("nombre", LocalDate.of(2020, 5, 25), TipoMembresia.VIP);
		assertEquals(68.0, m4.getCuotaMensual(), 0.001);
	}

}
