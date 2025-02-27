package tema1.grado;

import java.util.ArrayList;
import java.util.Objects;

public class Estudiante {
	private String nombre;
	private String dni;
	private int curso;
	private ArrayList<Asignatura> matricula;
	
	public Estudiante(String nombre, String dni, int curso, ArrayList<Asignatura> matricula) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.setCurso(curso);
		this.setMatricula(matricula);
	}
	
	public Estudiante() {
		super();
		this.nombre = "";
		this.dni = "12345678Z";
		this.curso = 1;
		this.matricula = new ArrayList();
	}
	
	public Estudiante(Estudiante e) {
		super();
		this.nombre = e.nombre;
		this.dni = e.dni;
		this.curso = e.curso;
		this.matricula = e.matricula;
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

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		if (curso > 0) {
			this.curso = curso;
		} else {
			this.curso = 1;
		}
	}

	public ArrayList<Asignatura> getMatricula() {
		return matricula;
	}

	public void setMatricula(ArrayList<Asignatura> matricula) {
		if (matricula != null) {
			this.matricula = matricula;
		} else {
			this.matricula = new ArrayList();
		}
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", dni=" + dni + ", curso=" + curso + ", matricula=" + matricula + "]";
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
		Estudiante other = (Estudiante) obj;
		return Objects.equals(dni, other.dni);
	}

	
}
