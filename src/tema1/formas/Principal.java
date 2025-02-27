package tema1.formas;

public class Principal {

	public static void main(String[] args) {
		Circulo c1 = new Circulo(); // c1: 1.0, "red"
		c1.setRadio(7.0); // c1: 7.0, "red"
		Circulo c2 = new Circulo(4.0, "blue");
		
		Cuadrado r1 = new Cuadrado(4.5, "green");
		
		Rectangulo r2 = new Rectangulo(2.5, 7.3, "blue");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(r1.getArea());
		System.out.println(r2);
	}

}
