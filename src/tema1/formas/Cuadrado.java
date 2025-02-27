package tema1.formas;

public class Cuadrado {
	// Atributos
	private double lado;
	private String color;
	
	// Métodos
	public Cuadrado(double lado, String color) {
		super();
		this.lado = lado;
		this.color = color;
	}
	
	public Cuadrado() {
		super();
		this.lado = 1.0;
		this.color = "red";
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getArea() {
		return this.lado * this.lado;
	}
	
	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + ", color=" + color + "]";
	}
	
	
	
}
