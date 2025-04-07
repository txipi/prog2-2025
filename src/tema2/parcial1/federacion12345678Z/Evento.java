package tema2.parcial1.federacion12345678Z;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Evento implements Revisable {
	protected String nombre;
	protected int edadMin;
	protected int edadMax;
	protected LocalDateTime fecha;
	protected ArrayList<Partida> partidas;
	
	/**
	 * Constructor con argumentos
	 * 
	 * @param nombre nombre del evento
	 * @param edadMin edad mínima para poder participar
	 * @param edadMax edad máxima para poder participar
	 * @param fecha fecha inicial del evento
	 * @param partidas lista de partidas del evento
	 */
	public Evento(String nombre, int edadMin, int edadMax, LocalDateTime fecha, ArrayList<Partida> partidas) {
		super();
		this.nombre = nombre;
		this.edadMin = edadMin;
		this.edadMax = edadMax;
		this.fecha = fecha;
		this.partidas = partidas;
	}

	/**
	 * @return el nombre del evento
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre del evento
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return la edad mínima para poder participar
	 */
	public int getEdadMin() {
		return edadMin;
	}

	/**
	 * @param edadMin la edad mínima para poder participar
	 */
	public void setEdadMin(int edadMin) {
		this.edadMin = edadMin;
	}

	/**
	 * @return la edad máxima para poder participar
	 */
	public int getEdadMax() {
		return edadMax;
	}

	/**
	 * @param edadMax la edad máxima para poder participar
	 */
	public void setEdadMax(int edadMax) {
		this.edadMax = edadMax;
	}

	/**
	 * @return la fecha del evento
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}

	/**
	 * @param fecha la fecha del evento
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return las partidas del evento
	 */
	public ArrayList<Partida> getPartidas() {
		return partidas;
	}

	/**
	 * @param partidas las partidas del evento
	 */
	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}

	@Override
	public String toString() {
		return "Evento [nombre=" + nombre + ", edadMin=" + edadMin + ", edadMax=" + edadMax + ", fecha=" + fecha
				+ ", partidas=" + partidas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(edadMax, edadMin, fecha, nombre);
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
		return edadMax == other.edadMax && edadMin == other.edadMin && Objects.equals(fecha, other.fecha)
				&& Objects.equals(nombre, other.nombre);
	}
	
	public abstract void actualizarElo();
	
	@Override
	public boolean revisar() {
		for (Partida partida : partidas) {
			int edadBlancas = partida.getBlancas().getEdad();
			int edadNegras = partida.getNegras().getEdad();
			if (edadBlancas < this.edadMin || edadBlancas > this.edadMax || edadNegras < this.edadMin || edadNegras > this.edadMax) {
				return false;
			}
		}
		return true;
	}
	
	public abstract void crearEvento();

}
