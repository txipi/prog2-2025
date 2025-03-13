package tema1.openjai;

import java.util.Objects;

public class Empleado {
	protected static int contador = 1;
	
	protected String nombre;
	protected int id;
	
	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
		this.id = Empleado.contador;
		Empleado.contador++;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return id == other.id;
	}

	
	
}
