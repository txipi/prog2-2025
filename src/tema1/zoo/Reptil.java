package tema1.zoo;

public class Reptil extends Animal {
	// Atributo
	protected boolean venenoso;

	public Reptil(String nombre, String especie, int edad, double peso, double longitud, boolean venenoso) {
		super(nombre, especie, edad, peso, longitud);
		this.venenoso = venenoso;
	}
	
	public Reptil() {
		super();
		this.venenoso = false;
	}

	public boolean isVenenoso() {
		return venenoso;
	}

	public void setVenenoso(boolean venenoso) {
		this.venenoso = venenoso;
	}

	@Override
	public String toString() {
		return "Reptil [venenoso=" + venenoso + ", nombre=" + nombre + ", especie=" + especie + ", edad=" + edad
				+ ", peso=" + peso + ", longitud=" + longitud + "]";
	}

}
