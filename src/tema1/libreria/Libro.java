package tema1.libreria;

import java.util.Objects;

public class Libro {
	private String titulo;
	private String autoria;
	private int anyo;
	private String isbn;
	
	public Libro(String titulo, String autoria, int anyo, String isbn) {
		super();
		this.titulo = titulo;
		this.autoria = autoria;
		this.setAnyo(anyo);
		this.isbn = isbn;
	}
	
	public Libro() {
		super();
		this.titulo = "";
		this.autoria = "";
		this.anyo = 1501;
		this.isbn = "";
	}

	public Libro(Libro libro) {
		super();
		this.titulo = libro.titulo;
		this.autoria = libro.autoria;
		this.isbn = libro.isbn;
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

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int a) {
		if (a > 1500) {
			this.anyo = a;
		}
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autoria=" + autoria + ", anyo=" + anyo + ", isbn=" + isbn + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
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
		return Objects.equals(isbn, other.isbn);
	}
	
	
	
}
