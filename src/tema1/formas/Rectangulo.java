package tema1.formas;

public class Rectangulo {
	// Atributos
	private double base;
	private double altura;
	private String color;
	
	// Métodos
	public Rectangulo(double base, double altura, String color) {
		super();
		this.base = base;
		this.altura = altura;
		this.color = color;
	}
	
	public Rectangulo() {
		super();
		this.base = 2.0;
		this.altura = 1.0;
		this.color = "red";
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Rectangulo [base=" + base + ", altura=" + altura + ", color=" + color + "]";
	}
	
	
	
}
