package tema3.colecciones;

import java.util.Objects;

public class Viajero implements Comparable<Viajero> {
	protected String nombre;
	protected String dni;
	
	public Viajero(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
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

	@Override
	public String toString() {
		return "Viajero [nombre=" + nombre + ", dni=" + dni + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viajero other = (Viajero) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public int compareTo(Viajero other) {
		return this.dni.compareTo(other.dni);
	}
	
	
}
