package tema1.ludoteca;

import java.util.Objects;

public class Libro extends Recurso {
	protected String titulo;
	protected String autoria;
	protected String genero;
	protected String reservado; // DNI de la persona que lo ha reservado, null si no está reservado
	
	public Libro(String titulo, String autoria, String genero, String reservado) {
		super();
		this.titulo = titulo;
		this.autoria = autoria;
		this.genero = genero;
		this.reservado = reservado;
	}
	
	public Libro() {
		super();
		this.titulo = "Sín título";
		this.autoria = "Sin autoría";
		this.genero = "";
		this.reservado = null;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutoria() {
		return autoria;
	}

	public void setAutoria(String autoria) {
		this.autoria = autoria;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getReservado() {
		return reservado;
	}

	public void setReservado(String reservado) {
		this.reservado = reservado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autoria, genero, reservado, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autoria, other.autoria) && Objects.equals(genero, other.genero)
				&& Objects.equals(reservado, other.reservado) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autoria=" + autoria + ", genero=" + genero + ", reservado=" + reservado
				+ "]";
	}

	@Override
	public boolean esFamiliar() {
		if (this.genero.equals("humor") ) {
			return true;
		} else {
			return false;
		}
	}
	
}
