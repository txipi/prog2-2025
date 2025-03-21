package tema1.esports;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Reto extends Evento {
	protected ArrayList<Partida> partidas;
	protected int nivel;
	protected Equipo equipoBot;
	
	public Reto(String nombre, LocalDateTime fecha, ArrayList<Equipo> equipos, ArrayList<Partida> partidas, int nivel) {
		super(nombre, fecha, equipos);
		this.partidas = partidas;
		this.nivel = nivel;
		ArrayList<Jugador> jugadoresBot = new ArrayList<Jugador>();
		for (int i = 0; i < 4; i++) {
			Jugador bot = new Jugador("bot"+i, nivel, nivel, nivel);
			jugadoresBot.add(bot);
		}
		this.equipoBot = new Equipo("Bot team", Region.EUROPA, jugadoresBot);
	}

	public ArrayList<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Equipo getEquipoBot() {
		return equipoBot;
	}

	public void setEquipoBot(Equipo equipoBot) {
		this.equipoBot = equipoBot;
	}

	@Override
	public String toString() {
		return "Reto [partidas=" + partidas + ", nivel=" + nivel + ", equipoBot=" + equipoBot + ", nombre=" + nombre
				+ ", fecha=" + fecha + ", equipos=" + equipos + "]";
	}

	
	
}
