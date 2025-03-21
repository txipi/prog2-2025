package tema1.esports;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Evento {
	protected String nombre;
	protected LocalDateTime fecha;
	protected ArrayList<Equipo> equipos;
	
	public Evento(String nombre, LocalDateTime fecha, ArrayList<Equipo> equipos) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.equipos = equipos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public void setFecha(int y, int m, int d, int h, int mi) {
		this.fecha = LocalDateTime.of(y, m, d, h, mi);
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "Evento [nombre=" + nombre + ", fecha=" + fecha + ", equipos=" + equipos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(nombre, other.nombre);
	}
	
	public abstract Equipo getGanador();
}
