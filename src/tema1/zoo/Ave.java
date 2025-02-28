package tema1.zoo;

public class Ave extends Animal {
	// Atributos
	protected double tamHuevos;
	protected String colorHuevos;
	
	public Ave(String nombre, String especie, int edad, double peso, double longitud, double tamHuevos,
			String colorHuevos) {
		super(nombre, especie, edad, peso, longitud);
		this.tamHuevos = tamHuevos;
		this.colorHuevos = colorHuevos;
	}
	
	public Ave() {
		super();
		this.tamHuevos = 0;
		this.colorHuevos = "";
	}

	public double getTamHuevos() {
		return tamHuevos;
	}

	public void setTamHuevos(double tamHuevos) {
		this.tamHuevos = tamHuevos;
	}

	public String getColorHuevos() {
		return colorHuevos;
	}

	public void setColorHuevos(String colorHuevos) {
		this.colorHuevos = colorHuevos;
	}

	@Override
	public String toString() {
		return "Ave [tamHuevos=" + tamHuevos + ", colorHuevos=" + colorHuevos + ", nombre=" + nombre + ", especie="
				+ especie + ", edad=" + edad + ", peso=" + peso + ", longitud=" + longitud + "]";
	}
	
	
}
