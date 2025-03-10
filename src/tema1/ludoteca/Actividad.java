package tema1.ludoteca;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Actividad {
	protected String descripcion;
	protected LocalDateTime fecha;
	protected ArrayList<String> asistentes; // lista con los DNIs de los asistentes
	
	public Actividad(String descripcion, LocalDateTime fecha, ArrayList<String> asistentes) {
		super();
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.asistentes = new ArrayList<String>(asistentes);
	}
	
	public Actividad() {
		super();
		this.descripcion = "Sin descripción";
		this.fecha = LocalDateTime.now();
		this.asistentes = new ArrayList<String>();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public ArrayList<String> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(ArrayList<String> asistentes) {
		this.asistentes = asistentes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, fecha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actividad other = (Actividad) obj;
		return Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(fecha, other.fecha);
	}

	@Override
	public String toString() {
		return descripcion + "(fecha: " + DateTimeFormatter.ISO_DATE.format(fecha) + "), asistentes: " + asistentes.size();
	}
	
}
