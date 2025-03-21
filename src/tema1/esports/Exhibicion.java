package tema1.esports;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Exhibicion extends Evento {
	protected Partida partida;

	public Exhibicion(String nombre, LocalDateTime fecha, ArrayList<Equipo> equipos, Partida partida) {
		super(nombre, fecha, equipos);
		this.partida = partida;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	@Override
	public String toString() {
		return "Exhibicion [partida=" + partida + ", nombre=" + nombre + ", fecha=" + fecha + ", equipos=" + equipos
				+ "]";
	}
	
	
}
