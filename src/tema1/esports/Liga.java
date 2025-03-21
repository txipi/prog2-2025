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

	@Override
	public Equipo getGanador() {
		Equipo mayor = this.equipos.get(0);
		int victoriasMayor = 0;
		
		for (Equipo equipo : equipos) {
			int victoriasEquipo = 0;
			// Calculamos las victorias de este equipo
			for (Partida partida : partidas) {
				if (partida.getLocal().equals(equipo) && partida.getPuntosLocal() > partida.getPuntosVisitante() || partida.getVisitante().equals(equipo) && partida.getPuntosLocal() < partida.getPuntosVisitante()) {
					victoriasEquipo++;
				}
			}
			
			if (victoriasEquipo > victoriasMayor) {
				victoriasMayor = victoriasEquipo;
				mayor = equipo;
			}
		}
		
		return mayor;
	}
	
	
}
