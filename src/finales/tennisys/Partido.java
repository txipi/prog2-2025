package finales.tennisys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Partido implements Serializable {
    private Jugador jugador1;
    private Jugador jugador2;
    private Map<Jugador, Integer> setsGanados;
    private int duracion; // en minutos
    private Arbitro arbitro;

    public Partido(Jugador j1, Jugador j2, int duracion, Arbitro arbitro) {
        this.jugador1 = j1;
        this.jugador2 = j2;
        this.duracion = duracion;
        this.arbitro = arbitro;
        this.setsGanados = new HashMap<>();
    }

    public void setResultado(Jugador jugador, int sets) {
        setsGanados.put(jugador, sets);
    }

    public Jugador getGanador() {
    	// Obtenemos el conjunto de jugadores y lo convertimos a ArrayList
    	ArrayList<Jugador> jugadores = new ArrayList(setsGanados.keySet());
    	if (setsGanados.get(jugadores.get(0)) > setsGanados.get(jugadores.get(1))) {
    		return jugadores.get(0);
    	} else {
    		return jugadores.get(1);
    	}
    }

    public boolean esValido() {
        return arbitro.getNivel() >= 3 && jugador1.getRanking() > 0 && jugador2.getRanking() > 0;
    }

    public int getDuracion() {
        return duracion;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }
}
