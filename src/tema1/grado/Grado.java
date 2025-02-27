package tema1.grado;

import java.util.ArrayList;
import java.util.Objects;

public class Grado {
	private String nombre;
	private ArrayList<Estudiante> estudiantes;
	
	public Grado(String nombre, ArrayList<Estudiante> estudiantes) {
		super();
		this.nombre = nombre;
		this.estudiantes = estudiantes;
	}
	
	public Grado() {
		super();
		this.nombre = "";
		this.estudiantes = new ArrayList<Estudiante>();
	}
	
	public Grado(Grado g) {
		super();
		this.nombre = g.nombre;
		this.estudiantes = g.estudiantes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		if (estudiantes != null) {
			this.estudiantes = estudiantes;
		} else {
			this.estudiantes = new ArrayList<Estudiante>();
		}
	}

	@Override
	public String toString() {
		return "Grado [nombre=" + nombre + ", estudiantes=" + estudiantes + "]";
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
		Grado other = (Grado) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
}
