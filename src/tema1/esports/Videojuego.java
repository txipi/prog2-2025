package tema1.esports;

import java.util.Objects;

public class Videojuego {
	protected String nombre;
	protected int numJugadores;
	protected int duracion;
	protected TipoVideojuego categoria;
	
	public Videojuego(String nombre, int numJugadores, int duracion, TipoVideojuego categoria) {
		super();
		this.nombre = nombre;
		this.numJugadores = numJugadores;
		this.duracion = duracion;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumJugadores() {
		return numJugadores;
	}

	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public TipoVideojuego getCategoria() {
		return categoria;
	}

	public void setCategoria(TipoVideojuego categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Videojuego [nombre=" + nombre + ", numJugadores=" + numJugadores + ", duracion=" + duracion
				+ ", categoria=" + categoria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return categoria == other.categoria && Objects.equals(nombre, other.nombre);
	}
	
	
}
