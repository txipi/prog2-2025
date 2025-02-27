package tema1.formas;

public class Circulo {
	// Atributos
	private double radio;
	private String color;
	
	// Métodos
	public Circulo(double radio, String color) {
		this.radio = radio;
		this.color = color;
	}

	public Circulo() {
		this.radio = 1.0;
		this.color = "red";
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public double getArea() {
		return Math.PI * this.radio * this.radio;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", color=" + color + "]";
	}
	
}
