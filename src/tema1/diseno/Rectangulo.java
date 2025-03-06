package tema1.diseno;

public class Rectangulo extends Forma {
	protected double altura;
	protected double anchura;
	
	public Rectangulo(double x, double y, String color, double altura, double anchura) {
		super(x, y, color);
		this.altura = altura;
		this.anchura = anchura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getAnchura() {
		return anchura;
	}

	public void setAnchura(double anchura) {
		this.anchura = anchura;
	}

	@Override
	public String toString() {
		return "Rectangulo [altura=" + altura + ", anchura=" + anchura + ", x=" + x + ", y=" + y + ", color=" + color
				+ "]";
	}

	@Override
	public void dibujar() {
		System.out.println(this.altura*this.anchura);
	}
	
	
}
