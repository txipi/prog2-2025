package finales.tennisys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

class Principal {
    public static void main(String[] args) {
        TenniSys sistema = new TenniSys();
        // Lógica de prueba con lectura/escritura binaria, ordenación, etc.
        
//        // Crear jugadores y árbitros
//        Jugador j1 = new JugadorInternacional("Carlos Alcaraz", 21, 2, "España", "Nike");
//        Jugador j2 = new JugadorInternacional("Novak Djokovic", 36, 1, "Serbia", "Lacoste");
//        Jugador j3 = new JugadorInternacional("Daniil Medvedev", 28, 4, "Rusia", "Tecnifibre");
//        Jugador j4 = new JugadorInternacional("Jannik Sinner", 22, 3, "Italia", "Gucci");
//        Jugador j5 = new JugadorNacional("Pedro Martínez", 25, 35, 5);
//        Jugador j6 = new JugadorNacional("Roberto Bautista", 35, 18, 12);
//
//        Arbitro a1 = new Arbitro("Laura Gil", 4);
//        Arbitro a2 = new Arbitro("Mark Evans", 3);
//
//        // Crear 10 torneos con datos ficticios
//        for (int i = 1; i <= 10; i++) {
//            String nombre = "Torneo " + i;
//            String ubicacion = (i % 2 == 0) ? "España" : "Francia";
//            String categoria = (i % 3 == 0) ? "Grand Slam" : "ATP 500";
//            LocalDate fecha = LocalDate.of(2025, Calendar.JUNE, i);
//
//            Torneo torneo = new Torneo(nombre, ubicacion, categoria, fecha);
//
//            Partido p1 = new Partido(j1, j2, 120 + i, a1);
//            p1.setResultado(j1, 2);
//            p1.setResultado(j2, 1);
//
//            Partido p2 = new Partido(j3, j4, 110 + i, a2);
//            p2.setResultado(j3, 0);
//            p2.setResultado(j4, 2);
//
//            torneo.añadirPartido(p1);
//            torneo.añadirPartido(p2);
//
//            sistema.getTorneos().add(torneo);
//        }
//        sistema.escribirTorneosBinario("torneos.bin");
        
        sistema.leerTorneosBinario("torneos.bin");
        
        // Creamos una lista de jugadores a partir de la que tiene el sistema
        List<Jugador> jugadores = new ArrayList<Jugador>(sistema.getJugadores());
        // La ordenamos con Comparator
        jugadores.sort(new Comparator<Jugador>() {
			@Override
			public int compare(Jugador j1, Jugador j2) {
				return j1.ranking - j2.ranking;
			}
		});
        
        sistema.guardarRankingBinario(jugadores, "ranking.bin");
        
        System.out.println(sistema.paisConMasTorneos());
        
        sistema.ordenarPartidosPorDuracion();
    }
}
