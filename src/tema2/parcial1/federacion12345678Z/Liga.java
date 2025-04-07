package tema2.parcial1.federacion12345678Z;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Liga extends Evento {
	protected ArrayList<Ajedrecista> ajedrecistas;

	/**
	 * Constructor con argumentos
	 * 
	 * @param nombre nombre del evento
	 * @param edadMin edad mínima para poder participar
	 * @param edadMax edad máxima para poder participar
	 * @param fecha fecha inicial del evento
	 * @param partidas lista de partidas del evento
	 * @param ajedrecistas lista de ajedredrecistas de la liga
	 */
	public Liga(String nombre, int edadMin, int edadMax, LocalDateTime fecha, ArrayList<Partida> partidas,
			ArrayList<Ajedrecista> ajedrecistas) {
		super(nombre, edadMin, edadMax, fecha, partidas);
		this.ajedrecistas = ajedrecistas;
	}

	/**
	 * @return la lista de ajedredrecistas de la liga
	 */
	public ArrayList<Ajedrecista> getAjedrecistas() {
		return ajedrecistas;
	}

	/**
	 * @param ajedrecistas la lista de ajedredrecistas de la liga
	 */
	public void setAjedrecistas(ArrayList<Ajedrecista> ajedrecistas) {
		this.ajedrecistas = ajedrecistas;
	}

	@Override
	public String toString() {
		return "Liga [ajedrecistas=" + ajedrecistas + ", nombre=" + nombre + ", edadMin=" + edadMin + ", edadMax="
				+ edadMax + ", fecha=" + fecha + ", partidas=" + partidas + "]";
	}

	@Override
	public void actualizarElo() {
		for (Partida partida : partidas) {
			int puntosBlancas = partida.getBlancas().getPuntosElo();
			int puntosNegras = partida.getNegras().getPuntosElo();
			// Puntos por Elo
			if (puntosBlancas < puntosNegras) {
				partida.getBlancas().setPuntosElo(puntosBlancas + 1);
			} else if (puntosNegras < puntosBlancas) {
				partida.getNegras().setPuntosElo(puntosNegras + 1);
			}
		}
	}

	@Override
	public void crearEvento() {
		if (this.partidas.size() == 0) {
			for (Ajedrecista blancas : ajedrecistas) {
				for (Ajedrecista negras: ajedrecistas) {
					if (!blancas.equals(negras)) {
						partidas.add(new Partida(blancas, negras, Resultado.NINGUNO, fecha));
					}
				}
			}
		}	
	}	
	
}
