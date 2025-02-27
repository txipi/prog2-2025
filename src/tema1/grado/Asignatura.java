package tema1.grado;

import java.util.Objects;

public class Asignatura {
	private String nombre;
	private String codigo;
	private int curso;
	private double creditos;
	
	public Asignatura(String nombre, String codigo, int curso, double creditos) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.setCurso(curso);
		this.setCreditos(creditos);
	}
	
	public Asignatura() {
		super();
		this.nombre = "Sin nombre";
		this.codigo = "";
		this.curso = 1;
		this.creditos = 0.0;
	}
	
	public Asignatura(Asignatura a) {
		super();
		this.nombre = a.nombre;
		this.codigo = a.codigo;
		this.curso = a.curso;
		this.creditos = a.creditos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public double getCreditos() {
		return creditos;
	}

	public void setCreditos(double creditos) {
		if (creditos > 0.0) {
			this.creditos = creditos;
		} else {
			this.creditos = 0.0;
		}
	}

	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", codigo=" + codigo + ", curso=" + curso + ", creditos=" + creditos
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return Objects.equals(codigo, other.codigo);
	}	
	
}
