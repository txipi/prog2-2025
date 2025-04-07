package tema3.colecciones;

public class ViajeroPrioridad extends Viajero {
	protected Prioridad prioridad;

	public ViajeroPrioridad(String nombre, String dni, Prioridad prioridad) {
		super(nombre, dni);
		this.prioridad = prioridad;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public String toString() {
		return "ViajeroPrioridad [prioridad=" + prioridad + ", nombre=" + nombre + ", dni=" + dni + "]";
	}
	
	
}
