package tema1.zoo;

public class Pez extends Animal {
	// Atributos
	protected double velocidad;
	protected boolean aguaDulce;
	
	public Pez(String nombre, String especie, int edad, double peso, double longitud, double velocidad,
			boolean aguaDulce) {
		super(nombre, especie, edad, peso, longitud);
		this.velocidad = velocidad;
		this.aguaDulce = aguaDulce;
	}
	
	public Pez() {
		super();
		this.velocidad = 0;
		this.aguaDulce = false;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public boolean isAguaDulce() {
		return aguaDulce;
	}

	public void setAguaDulce(boolean aguaDulce) {
		this.aguaDulce = aguaDulce;
	}

	@Override
	public String toString() {
		return "Pez [velocidad=" + velocidad + ", aguaDulce=" + aguaDulce + ", nombre=" + nombre + ", especie="
				+ especie + ", edad=" + edad + ", peso=" + peso + ", longitud=" + longitud + "]";
	}
	
}
