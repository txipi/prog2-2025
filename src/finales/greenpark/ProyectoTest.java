package finales.greenpark;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ProyectoTest {

	@Test
	void constructorTest() {
		// Green path: todo ha ido bien
		Parque parque = new Parque("parque1", "pais1", LocalDate.of(1913, 1, 1), 25000);
		Proyecto p1 = new Proyecto("nombre", TipoProyecto.EDUCACION, 100000, LocalDate.of(2025, 6, 6), parque);
		assertEquals("nombre", p1.getNombre());
		assertEquals(TipoProyecto.EDUCACION, p1.getTipo());
		assertEquals(100000, p1.getPresupuesto());
		assertEquals(LocalDate.of(2025, 6, 6), p1.getFechaInicio());
		assertEquals(parque, p1.getParque());
		// Red path: forzar a que algo vaya mal y detectarlo
		try {
			Proyecto p2 = new Proyecto("nombre2", TipoProyecto.EDUCACION, 100000, LocalDate.of(2025, 30, 30), parque);
			fail("Error, se esperaba una DateTimeException y no se ha lanzado");
		} catch (DateTimeException e) {
			// OK! 
		}
		
		try {
			Proyecto p3 = new Proyecto("nombre2", TipoProyecto.EDUCACION, 100000, null, parque);
		} catch (DateTimeException e) {
			fail("Error, NO se esperaba una DateTimeException y se ha lanzado"); 
		}
	}
	
	@Test
	void getCosteFinalTest() {
		// Primer caso: proyecto sin financiacion
		Parque parque = new Parque("parque1", "pais1", LocalDate.of(1913, 1, 1), 25000);
		Proyecto p1 = new Proyecto("nombre", TipoProyecto.EDUCACION, 100000, LocalDate.of(2025, 6, 6), parque);
		assertEquals(100000, p1.getCosteFinal(), 0.001);
		// Segundo caso: proyecto con financiacion
		Proyecto p2 = new Proyecto("nombre", TipoProyecto.INVESTIGACION, 100000, LocalDate.of(2025, 6, 6), parque);
		assertEquals(20000, p2.getCosteFinal(), 0.001);
		// Segundo caso: proyecto con financiacion
		Proyecto p3 = new Proyecto("nombre", TipoProyecto.INVESTIGACION, 6500.1, LocalDate.of(2025, 6, 6), parque);
		assertEquals(1300.02, p3.getCosteFinal(), 0.001);
	}

}
