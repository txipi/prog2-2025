package tema1.diseno;

import java.util.Objects;

public abstract class Forma implements Dibujable {
	protected double x;
	protected double y;
	protected String color;
	
	public Forma(double x, double y, String color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
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

	@Override
	public String toString() {
		return "Forma [x=" + x + ", y=" + y + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Forma other = (Forma) obj;
		return Objects.equals(color, other.color) && Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}
	
	
	
}
