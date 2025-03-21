package tema1.esports;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Esports {
	public static void main(String[] args) {
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		Videojuego lol = new Videojuego("League of Legends", 10, 40, TipoVideojuego.ESTRATEGIA);
		Videojuego valorant = new Videojuego("Valorant", 10, 40, TipoVideojuego.SHOOTER);
		Videojuego sf = new Videojuego("Street Fighter", 2, 5, TipoVideojuego.LUCHA);
		
		// Creamos los 16 equipos con 4 jugadores cada uno
		for (int i = 0; i < 16; i++) {
			ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
			for (int j = 0; j < 4; j++) {
				int hab = (int) (Math.random() * 50) + 50;
				int res = (int) (Math.random() * 50) + 50;
				int ref = (int) (Math.random() * 50) + 50;
				Jugador jug = new Jugador("Jugador"+j, hab, res, ref);
				jugadores.add(jug);
			}
			Region[] regiones = Region.values();
			int aleatorio = (int) (Math.random() * regiones.length);
			Region region = regiones[aleatorio];
			Equipo nuevo = new Equipo("Equipo"+i, region, jugadores);
			equipos.add(nuevo);
		}
		
		// Creamos la liga de LOL
		ArrayList<Equipo> equiposLol = new ArrayList<Equipo>();
		ArrayList<Partida> partidasLol = new ArrayList<Partida>(); 
		
		for (int i = 0; i < 8; i++) {
			int alea = (int) (Math.random() * equipos.size());
			Equipo elegido = equipos.get(alea);
			while (equiposLol.contains(elegido)) {
				alea = (int) (Math.random() * equipos.size());
				elegido = equipos.get(alea);
			}
			equiposLol.add(elegido);
		}
		
		// Creamos todas las partidas de la liga 
		// (cada equipo contra el resto, tanto como local como visitante) 
		for (Equipo local : equiposLol) {
			for (Equipo visitante : equiposLol) {
				if (!local.equals(visitante)) {
					int puntosLocal = (int) (Math.random() * 1000);
					int puntosVisitante = (int) (Math.random() * 1000);
					Partida nueva = new Partida(local, visitante, lol, 
						LocalDateTime.of(2025, 3, 21, 10, 0), puntosLocal, puntosVisitante);
					partidasLol.add(nueva);
				}
			}
		}
		
		Liga ligaLol = new Liga("Liga LOL", LocalDateTime.of(2025, 3, 21, 10, 0), 
				equiposLol, partidasLol);
		
		// Ordenamos los equipos aprovechando que son Comparables
		System.out.println("Equipos sin ordenar... " + equipos);
		Collections.sort(equipos);
		System.out.println("Equipos ordenados... " + equipos);
		
		System.out.println("El equipo ganador de la liga LOL es: " + ligaLol.getGanador());
		
	}
}
