package tema1.esports;

import java.time.LocalDateTime;
import java.util.Objects;

public class Partida {
	protected Equipo local;
	protected Equipo visitante;
	protected Videojuego videojuego;
	protected LocalDateTime fecha;
	protected int puntosLocal;
	protected int puntosVisitante;
	
	public Partida(Equipo local, Equipo visitante, Videojuego videojuego, LocalDateTime fecha, int puntosLocal,
			int puntosVisitante) {
		super();
		this.local = local;
		this.visitante = visitante;
		this.videojuego = videojuego;
		this.fecha = fecha;
		this.puntosLocal = puntosLocal;
		this.puntosVisitante = puntosVisitante;
	}

	public Equipo getLocal() {
		return local;
	}

	public void setLocal(Equipo local) {
		this.local = local;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}

	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public int getPuntosLocal() {
		return puntosLocal;
	}

	public void setPuntosLocal(int puntosLocal) {
		this.puntosLocal = puntosLocal;
	}

	public int getPuntosVisitante() {
		return puntosVisitante;
	}

	public void setPuntosVisitante(int puntosVisitante) {
		this.puntosVisitante = puntosVisitante;
	}

	@Override
	public String toString() {
		return "Partida [local=" + local + ", visitante=" + visitante + ", videojuego=" + videojuego + ", fecha="
				+ fecha + ", puntosLocal=" + puntosLocal + ", puntosVisitante=" + puntosVisitante + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, local, puntosLocal, puntosVisitante, videojuego, visitante);
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
		return Objects.equals(fecha, other.fecha) && Objects.equals(local, other.local)
				&& puntosLocal == other.puntosLocal && puntosVisitante == other.puntosVisitante
				&& Objects.equals(videojuego, other.videojuego) && Objects.equals(visitante, other.visitante);
	}
	
	
}
