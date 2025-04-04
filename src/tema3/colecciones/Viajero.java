package tema3.colecciones;

public class Viajero {
	protected String nombre;
	protected String dni;
	protected Prioridad prioridad;
	
	public Viajero(String nombre, String dni, Prioridad prioridad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.prioridad = prioridad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public String toString() {
		return "Viajero [nombre=" + nombre + ", dni=" + dni + ", prioridad=" + prioridad + "]";
	}

	
	
	
}
