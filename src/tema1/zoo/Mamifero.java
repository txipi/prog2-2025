package tema1.zoo;

public class Mamifero extends Animal {
	// Atributos
	protected int camada;

	public Mamifero(String nombre, String especie, int edad, double peso, double longitud, int camada) {
		super(nombre, especie, edad, peso, longitud);
		this.camada = camada;
	}
	
	public Mamifero() {
		super();
		this.camada = 0;
	}

	public int getCamada() {
		return camada;
	}

	public void setCamada(int camada) {
		this.camada = camada;
	}

	@Override
	public String toString() {
		return "Mamifero [camada=" + camada + ", nombre=" + nombre + ", especie=" + especie + ", edad=" + edad
				+ ", peso=" + peso + ", longitud=" + longitud + "]";
	}
	
	
}
