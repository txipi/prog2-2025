package tema1.esports;

import java.util.Objects;

public class Jugador {
	protected static int contador = 1;
	
	protected int id;
	protected String nombre;
	protected int habilidad;
	protected int resistencia;
	protected int reflejos;
	
	public Jugador(String nombre, int habilidad, int resistencia, int reflejos) {
		super();
		this.id = Jugador.contador;
		Jugador.contador++;
		this.nombre = nombre;
		this.habilidad = habilidad;
		this.resistencia = resistencia;
		this.reflejos = reflejos;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(int habilidad) {
		this.habilidad = habilidad;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getReflejos() {
		return reflejos;
	}

	public void setReflejos(int reflejos) {
		this.reflejos = reflejos;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", habilidad=" + habilidad + ", resistencia=" + resistencia
				+ ", reflejos=" + reflejos + "]";
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
		Jugador other = (Jugador) obj;
		return id == other.id;
	}
	
	
}
