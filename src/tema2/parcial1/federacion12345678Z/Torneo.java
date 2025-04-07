package tema2.parcial1.federacion12345678Z;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Torneo extends Evento {
	protected ArrayList<Ajedrecista> ajedrecistas;

	/**
	 * @param nombre nombre del evento
	 * @param edadMin edad mínima para poder participar
	 * @param edadMax edad máxima para poder participar
	 * @param fecha fecha inicial del evento
	 * @param partidas lista de partidas del evento
	 * @param ajedrecistas lista de ajedredrecistas del torneo
	 */
	public Torneo(String nombre, int edadMin, int edadMax, LocalDateTime fecha, ArrayList<Partida> partidas,
			ArrayList<Ajedrecista> ajedrecistas) {
		super(nombre, edadMin, edadMax, fecha, partidas);
		this.ajedrecistas = ajedrecistas;
	}

	/**
	 * @return la lista de ajedredrecistas del torneo
	 */
	public ArrayList<Ajedrecista> getAjedrecistas() {
		return ajedrecistas;
	}

	/**
	 * @param ajedrecistas la lista de ajedredrecistas del torneo
	 */
	public void setAjedrecistas(ArrayList<Ajedrecista> ajedrecistas) {
		this.ajedrecistas = ajedrecistas;
	}

	@Override
	public String toString() {
		return "Torneo [ajedrecistas=" + ajedrecistas + ", nombre=" + nombre + ", edadMin=" + edadMin + ", edadMax="
				+ edadMax + ", fecha=" + fecha + ", partidas=" + partidas + "]";
	}
	
	@Override
	public void actualizarElo() {
		for (Partida partida : partidas) {
			int puntosBlancas = partida.getBlancas().getPuntosElo();
			int puntosNegras = partida.getNegras().getPuntosElo();
			// Puntos por resultado
			if (partida.getResultado().equals(Resultado.BLANCAS)) {
				partida.getBlancas().setPuntosElo(puntosBlancas + 2);
				partida.getNegras().setPuntosElo(puntosNegras - 1);
			} else if (partida.getResultado().equals(Resultado.NEGRAS)) {
				partida.getBlancas().setPuntosElo(puntosBlancas - 1);
				partida.getNegras().setPuntosElo(puntosNegras + 2);
			} else if (partida.getResultado().equals(Resultado.TABLAS)) {
				partida.getBlancas().setPuntosElo(puntosBlancas + 1);
				partida.getNegras().setPuntosElo(puntosNegras + 1);
			}
		}
	}	

	@Override
	public void crearEvento() {
		if (this.partidas.size() == 0) {
			Collections.shuffle(ajedrecistas);
			for (int i = 0; i < ajedrecistas.size(); i+=2) {
				partidas.add(new Partida(ajedrecistas.get(i), ajedrecistas.get(i+1), Resultado.NINGUNO, fecha));
			}
		}	
	}	

}
