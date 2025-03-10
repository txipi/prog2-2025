package tema1.ludoteca;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Ludoteca {
	public static void main(String[] args) {
		// Lista de recursos de la ludoteca
		ArrayList<Recurso> recursos = new ArrayList<Recurso>(Arrays.asList(
			new Libro("La historia interminable", "Michael Ende", "fantasía", null),
			new Libro("Frankstein", "Mary Shelley", "terror", null),
			new Libro("Persepolis", "Marjane Satrapi", "comic", "87654321-X"),
			new Libro("Los cuentos de Terramar", "Ursula K. Le Guin", "fantasía", "12345678-Z"),
			new Libro("Las estrellas son legión", "Kameron Hurley", "ciencia-ficción", null),
			new Juego("Catan", 45, 10),
			new Juego("Virus!", 15, 8),
			new Juego("Carcassonne", 30, 7),
			new Juego("Catan", 45, 10),
			new Juego("Catan", 45, 10),
			new Videoconsola("Nintendo", "Switch"),
			new Videoconsola("Nintendo", "Wii"),
			new Videoconsola("Nintendo", "3DS"),
			new Videoconsola("Sony", "PlayStation 5"),
			new Videoconsola("Sony", "PlayStation 4"),
			new Videoconsola("Sony", "PlayStation 3"),
			new Videoconsola("Sony", "PlayStation 2"),
			new Videoconsola("Microsoft", "XBOX 360"),
			new Videoconsola("Microsoft", "XBOX One"),
			new Videoconsola("Microsoft", "Series S")
		));
		
		// Lista de actividades de la ludoteca
		ArrayList<Actividad> actividades = new ArrayList<Actividad>(Arrays.asList(
			new Actividad("Teatro: Una habitación propia", LocalDateTime.now(), new ArrayList<String>(Arrays.asList("12345678-Z", "87654321-X"))),
			new Actividad("Conferencia: El calentamiento global", LocalDateTime.now(), new ArrayList<String>(Arrays.asList("87654321-X"))),
			new Actividad("Película: Interstellar", LocalDateTime.now(), new ArrayList<String>(Arrays.asList("12345678-Z"))),
			new Actividad("Taller de robótica", LocalDateTime.now(), new ArrayList<String>(Arrays.asList("12345678-Z", "87654321-X", "34567890-V"))),
			new Actividad("Taller de juegos de mesa", LocalDateTime.now(), new ArrayList<String>())
		));
		
		System.out.println("Actividades de la ludoteca...");
		for (Actividad actividad : actividades) {
			System.out.println(actividad);
		}
		
		System.out.println(actividadMasPopular(actividades));
		
		ArrayList<Recurso> reservables = recursosReservables(recursos);
		
		System.out.println(reservables);
	}

	public static ArrayList<Recurso> recursosReservables(ArrayList<Recurso> recursos) {
		ArrayList<Recurso> resultado = new ArrayList<Recurso>();
		
		for (Recurso recurso : recursos) {
			if (recurso instanceof Libro && ((Libro) recurso).reservado == null) {
				resultado.add(recurso);
			}
		}
		
		return resultado;
	}

	public static Actividad actividadMasPopular(ArrayList<Actividad> actividades) {
		Actividad mayor = actividades.get(0); 
		
		for (Actividad actividad : actividades) {
			if (actividad.getAsistentes().size() > mayor.getAsistentes().size()) {
				mayor = actividad;
			}
		}
		
		return mayor;
	}
}
