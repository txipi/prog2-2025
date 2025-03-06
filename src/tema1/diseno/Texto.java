package tema1.diseno;

import java.util.Objects;

public class Texto implements Imprimible, Dibujable {
	protected double x;
	protected double y;
	protected String color;
	protected String texto;
	
	public Texto(double x, double y, String color, String texto) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.texto = texto;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Texto [x=" + x + ", y=" + y + ", color=" + color + ", texto=" + texto + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, texto, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Texto other = (Texto) obj;
		return Objects.equals(color, other.color) && Objects.equals(texto, other.texto)
				&& Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}

	@Override
	public void imprimir() {
		System.out.println(this.texto);
	}

	@Override
	public void dibujar() {
		System.out.println(this.texto + this.color);
	}
	
	
}
