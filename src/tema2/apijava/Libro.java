package tema2.apijava;

import java.util.Comparator;

public class Libro implements Comparable<Libro> {
	private String titulo;
	private String autoria;
	private int anyo;
	private double precio;
	private int isbn;

	/**
	 * Constructor con argumentos
	 * 
	 * @param titulo Titulo del libro
	 * @param autoria Autoría del libro
	 * @param anyo Año de publicación
	 * @param precio Precio en euros
	 * @param isbn Código ISBN
	 */
	public Libro(String titulo, String autoria, int anyo, double precio, int isbn) {
		super();
		this.titulo = titulo;
		this.autoria = autoria;
		this.anyo = anyo;
		this.precio = precio;
		this.isbn = isbn;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the autoria
	 */
	public String getAutoria() {
		return autoria;
	}

	/**
	 * @param autoria the autoria to set
	 */
	public void setAutoria(String autoria) {
		this.autoria = autoria;
	}

	/**
	 * @return the anyo
	 */
	public int getAnyo() {
		return anyo;
	}

	/**
	 * @param anyo the anyo to set
	 */
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the isbn
	 */
	public int getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autoria=" + autoria + ", anyo=" + anyo + ", precio=" + precio + ", isbn="
				+ isbn + "]";
	}

	@Override
	public int compareTo(Libro other) {
		// return this.anyo - other.anyo; Ordenacion creciente por año
		// return other.isbn - this.isbn; Ordenacion decreciente por ISBN
		// return this.titulo.compareTo(other.titulo); Ordenacion por titulo
		return other.autoria.compareTo(this.autoria); // Ordenacion por autoria decreciente
	}
	
}
