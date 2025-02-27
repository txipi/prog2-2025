package tema1.libreria;

import java.util.ArrayList;
import java.util.Objects;

public class Libreria {
	private String nombre;
	private String calle;
	private String localidad;
	private String cp;
	private ArrayList<Libro> libros;
	
	public Libreria(String nombre, String calle, String localidad, String cp, ArrayList<Libro> libros) {
		super();
		this.nombre = nombre;
		this.calle = calle;
		this.localidad = localidad;
		this.cp = cp;
		this.libros = libros;
	}
	
	public Libreria() {
		super();
		this.nombre = "";
		this.calle = "";
		this.localidad = "";
		this.cp = "";
		this.libros = new ArrayList();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Libreria [nombre=" + nombre + ", calle=" + calle + ", localidad=" + localidad + ", cp=" + cp
				+ ", libros=" + libros + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, cp, localidad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libreria other = (Libreria) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(cp, other.cp)
				&& Objects.equals(localidad, other.localidad) && Objects.equals(nombre, other.nombre);
	}
	
	
}
