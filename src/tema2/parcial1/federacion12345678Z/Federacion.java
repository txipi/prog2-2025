package tema2.parcial1.federacion12345678Z;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Federacion {
	public static void main(String[] args) {
		// Lista de ajedrecistas de la Federación Vasca de Ajedrez
		Ajedrecista[] ajs = {
			    new Ajedrecista("Ane López", 12, 1250),
			    new Ajedrecista("Unai Etxebarria", 15, 1400),
			    new Ajedrecista("Maite Zubizarreta", 20, 1650),
			    new Ajedrecista("Iker Goikoetxea", 18, 1550),
			    new Ajedrecista("Nerea Arrieta", 22, 1700),
			    new Ajedrecista("Ander García", 19, 1600),
			    new Ajedrecista("Leire Mendizabal", 14, 1350),
			    new Ajedrecista("Jon Aldazabal", 17, 1450),
			    new Ajedrecista("Ainhoa Berasategi", 21, 1750),
			    new Ajedrecista("Peio Garaizar", 16, 1750),
			    new Ajedrecista("Eider Larrañaga", 23, 1800),
			    new Ajedrecista("Gorka Otxoa", 13, 1200),
			    new Ajedrecista("Juan Fernández", 25, 1780),
			    new Ajedrecista("Oihane Egaña", 24, 1720),
			    new Ajedrecista("Xabier Agirre", 13, 1580),
			    new Ajedrecista("Irati Altuna", 12, 1100)
			};
		ArrayList<Ajedrecista> ajedrecistas = new ArrayList<Ajedrecista>(Arrays.asList(ajs));
		
		ArrayList<Evento> eventos = new ArrayList<Evento>();

		// Creamos un torneo con todos los ajedrecistas <18 que empieza el lunes 24 de marzo de 2025 a las 16:00
		ArrayList<Ajedrecista> ajedrecistasJunior = new ArrayList<Ajedrecista>();
		for (Ajedrecista ajedrecista : ajedrecistas) {
			if (ajedrecista.getEdad() < 18) {
				ajedrecistasJunior.add(ajedrecista);
			}
		} 
		Evento torneoJunior = new Torneo("Torneo Junior 2025", 18, 100, LocalDateTime.of(2025, 03, 24, 16, 00), new ArrayList<Partida>(), ajedrecistasJunior);
		eventos.add(torneoJunior);
		
		// Creamos un torneo con todos los ajedrecistas >18 que empieza el lunes 24 de marzo de 2025 a las 12:00
		ArrayList<Ajedrecista> ajedrecistasSenior = new ArrayList<Ajedrecista>();
		for (Ajedrecista ajedrecista : ajedrecistas) {
			if (ajedrecista.getEdad() >= 18) {
				ajedrecistasSenior.add(ajedrecista);
			}
		} 
		Evento torneoSenior = new Torneo("Torneo Senior 2025", 18, 100, LocalDateTime.of(2025, 03, 24, 12, 00), new ArrayList<Partida>(), ajedrecistasSenior);
		eventos.add(torneoSenior);

		// Creamos una liga con todos los ajedrecistas <18 que empieza el domingo 23 de marzo de 2025 a las 16:00
		Evento ligaJunior = new Liga("Torneo Senior 2025", 18, 100, LocalDateTime.of(2025, 03, 23, 16, 00), new ArrayList<Partida>(), ajedrecistasJunior);
		for (Ajedrecista blancas : ajedrecistasJunior) {
			for (Ajedrecista negras: ajedrecistasJunior) {
				if (!blancas.equals(negras)) {
					int alea = (int) (Math.random() * Resultado.values().length - 1) + 1;
					Resultado resultado = Resultado.values()[alea];
					ligaJunior.getPartidas().add(new Partida(blancas, negras, resultado, LocalDateTime.of(2025, 03, 24, 16, 00)));
				}
			}
		}
		eventos.add(ligaJunior);
		
		ligaJunior.actualizarElo();
		
		Collections.sort(ajedrecistas);
		System.out.println(ajedrecistas);
		
	}
}
