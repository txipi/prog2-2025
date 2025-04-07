package tema2.parcial1.federacion12345678Z;

import java.time.LocalDateTime;
import java.util.Objects;

public class Partida implements Revisable {
	private Ajedrecista blancas;
	private Ajedrecista negras;
	private Resultado resultado;
	private LocalDateTime fecha;
	
	/**
	 * Constructor con argumentos
	 * 
	 * @param blancas Ajedrecista que juega con blancas
	 * @param negras Ajedrecista que juega con negras
	 * @param resultado Resultado de la partida
	 * @param fecha fecha de la partida
	 */
	public Partida(Ajedrecista blancas, Ajedrecista negras, Resultado resultado, LocalDateTime fecha) {
		super();
		this.blancas = blancas;
		this.negras = negras;
		this.resultado = resultado;
		this.fecha = fecha;
	}

	/**
	 * @return Ajedrecista que juega con blancas
	 */
	public Ajedrecista getBlancas() {
		return blancas;
	}

	/**
	 * @param blancas Ajedrecista que juega con blancas
	 */
	public void setBlancas(Ajedrecista blancas) {
		this.blancas = blancas;
	}

	/**
	 * @return Ajedrecista que juega con negras
	 */
	public Ajedrecista getNegras() {
		return negras;
	}

	/**
	 * @param negras Ajedrecista que juega con negras
	 */
	public void setNegras(Ajedrecista negras) {
		this.negras = negras;
	}

	/**
	 * @return Resultado de la partida
	 */
	public Resultado getResultado() {
		return resultado;
	}

	/**
	 * @param resultado Resultado de la partida
	 */
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return la fecha de la partida
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}

	/**
	 * @param fecha la fecha de la partida
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Partida [blancas=" + blancas + ", negras=" + negras + ", resultado=" + resultado + ", fecha=" + fecha
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(blancas, fecha, negras);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		return Objects.equals(blancas, other.blancas) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(negras, other.negras);
	}

	@Override
	public boolean revisar() {
		int diferencia = Math.abs(blancas.getPuntosElo() - negras.getPuntosElo());
		if (diferencia < 200) {
			return true;
		} else {
			return false;
		}
	}
	
}
