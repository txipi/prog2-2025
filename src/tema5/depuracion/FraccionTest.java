package tema5.depuracion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FraccionTest {

	@Test
	void constructorConArgsTest() {
		Fraccion f1 = new Fraccion(1, 2);
		assertEquals(1, f1.getNumerador());
		assertEquals(2, f1.getDenominador());
		try {
			Fraccion f2 = new Fraccion(1, 0);
			fail("Error, ¡ArithmeticException no lanzada!");
		} catch (ArithmeticException e) {
			// Falla cuando tiene que fallar, así que todo OK
		}
		try {
			Fraccion f3 = new Fraccion(0, 1);
		} catch (ArithmeticException e) {
			fail("No debería generar excepción, pero la genera");
		}
	}

	@Test
	void constructorSinArgsTest() {
		Fraccion f1 = new Fraccion();
		assertEquals(1, f1.getNumerador());
		assertEquals(1, f1.getDenominador());
	}
	
	@Test
	void constructorCopiaTest() {
		Fraccion f1 = new Fraccion(1,4);
		Fraccion f2 = new Fraccion(f1);
		assertEquals(1, f2.getNumerador());
		assertEquals(4, f2.getDenominador());
		assertEquals(true, f1.equals(f2));
	}
		
	@Test
	void sumarTest() {
		Fraccion f1 = new Fraccion(1,4);
		Fraccion f2 = new Fraccion(1,2);
		f1.sumar(f2);
		assertEquals(3, f1.getNumerador());
		assertEquals(4, f1.getDenominador());
		Fraccion f3 = null;
		try {
			f1.sumar(f3);
			fail("Error, ¡NullPointerException no lanzada!");
		} catch (NullPointerException e) {
			// Si se ha generado la excepción, está todo bien
		}
	}
	

}
