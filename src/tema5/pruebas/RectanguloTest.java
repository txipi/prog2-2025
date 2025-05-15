package tema5.pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectanguloTest {

	@Test
	void constructorConArgumentosTest() {
		Rectangulo r1 = new Rectangulo(3.0, 2.0);
		assertEquals(3.0, r1.getBase());
		assertEquals(2.0, r1.getAltura());
	}

	@Test
	void constructorSinArgumentosTest() {
		Rectangulo r2 = new Rectangulo();
		assertEquals(1.0, r2.getBase());
		assertEquals(1.0, r2.getAltura());
	}
	
	@Test
	void constructorCopiaTest() {
		Rectangulo r1 = new Rectangulo(3.0, 2.0);
		Rectangulo r2 = new Rectangulo(r1);
		assertEquals(3.0, r2.getBase());
		assertEquals(2.0, r2.getAltura());
	}

	@Test
	void getAreaTest() {
		Rectangulo r1 = new Rectangulo(3.0, 2.0);
		Rectangulo r2 = new Rectangulo();
		Rectangulo r3 = new Rectangulo(3.0, 0.0);
		Rectangulo r4 = new Rectangulo(-3.0, 1.0);
		assertEquals(6.0, r1.getArea());
		assertEquals(1.0, r2.getArea());
		assertEquals(0.0, r3.getArea());
		assertEquals(-3.0, r4.getArea());
	}

	
}
