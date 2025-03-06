package tema1.diseno;

public class Circulo extends Forma {
	protected double radio;

	public Circulo(double x, double y, String color, double radio) {
		super(x, y, color);
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", x=" + x + ", y=" + y + ", color=" + color + "]";
	}

	@Override
	public void dibujar() {
		System.out.println(this.radio);
	}
	
}
