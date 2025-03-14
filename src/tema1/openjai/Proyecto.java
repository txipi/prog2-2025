package tema1.openjai;

import java.util.ArrayList;
import java.util.Objects;

public class Proyecto implements Financiable {
	protected String nombre;
	protected double horas;
	protected double coste;
	protected Responsable responsable;
	protected ArrayList<Desarrollador> desarrolladores;
	
	public Proyecto(String nombre, double horas, double coste, Responsable responsable,
			ArrayList<Desarrollador> desarrolladores) {
		super();
		this.nombre = nombre;
		this.horas = horas;
		this.coste = coste;
		this.responsable = responsable;
		this.desarrolladores = desarrolladores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public ArrayList<Desarrollador> getDesarrolladores() {
		return desarrolladores;
	}

	public void setDesarrolladores(ArrayList<Desarrollador> desarrolladores) {
		this.desarrolladores = desarrolladores;
	}

	@Override
	public String toString() {
		return "Proyecto [nombre=" + nombre + ", horas=" + horas + ", coste=" + coste + ", responsable=" + responsable
				+ ", desarrolladores=" + desarrolladores + "]";
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
		Proyecto other = (Proyecto) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public void financiar(double cantidad) {
		this.coste = this.coste - cantidad;
		Departamento dep = this.responsable.getDepartamento();
		
		if (dep == Departamento.MEDICINA) {
			this.coste = this.coste * 0.90;
		} else if (dep == Departamento.EDUCACION) {
			this.coste = this.coste * 0.80;
		} else if (dep == Departamento.MARKETING || dep == Departamento.FINANZAS) {
			this.coste = this.coste * 0.85;
		}
	}
	
	
}
