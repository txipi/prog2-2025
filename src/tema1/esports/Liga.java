package tema1.esports;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Liga extends Evento {
	protected ArrayList<Partida> partidas;

	public Liga(String nombre, LocalDateTime fecha, ArrayList<Equipo> equipos, ArrayList<Partida> partidas) {
		super(nombre, fecha, equipos);
		this.partidas = partidas;
	}

	public ArrayList<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}

	@Override
	public String toString() {
		return "Liga [partidas=" + partidas + ", nombre=" + nombre + ", fecha=" + fecha + ", equipos=" + equipos + "]";
	}
	
	
	
	
}
