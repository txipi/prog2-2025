package tema4.restaurantes;

import java.io.Serializable;
import java.util.Objects;

public class Restaurante implements Serializable {
	protected String nombre;
	protected int precio;
	protected int calidad;
	
	public Restaurante(String nombre, int precio, int calidad) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.calidad = calidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCalidad() {
		return calidad;
	}

	public void setCalidad(int calidad) {
		this.calidad = calidad;
	}

	@Override
	public String toString() {
		return "Restaurante [nombre=" + nombre + ", precio=" + precio + ", calidad=" + calidad + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
}
