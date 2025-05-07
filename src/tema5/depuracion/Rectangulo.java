package tema5.depuracion;

import java.util.Objects;

public class Rectangulo {
	private double base;
	private double altura;
	
	public Rectangulo(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}
	
	public Rectangulo() {
		super();
		this.base = 1.0;
		this.altura = 1.0;
	}
	
	public Rectangulo(Rectangulo r) {
		super();
		this.base = r.base;
		this.altura = r.altura;
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

	@Override
	public String toString() {
		return "Rectangulo [base=" + base + ", altura=" + altura + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, base);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangulo other = (Rectangulo) obj;
		return Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura)
				&& Double.doubleToLongBits(base) == Double.doubleToLongBits(other.base);
	}
	
	public double getArea() {
		return this.base * this.altura;
	}
	
	public double getPerimetro() {
		return 2 * this.base + 2 * this.altura;
	}
	
	public static void main(String[] args) {
		Rectangulo r1 = new Rectangulo(2.0, 1.0);
		System.out.println(r1);
		Rectangulo r2 = new Rectangulo();
		System.out.println(r2);
		Rectangulo r3 = new Rectangulo(r1);
		System.out.println(r3);
		System.out.println(r3.getArea());
		System.out.println(r3.getPerimetro());
	}
}
