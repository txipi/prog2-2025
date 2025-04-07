package tema2.parcial1.federacion12345678Z;

import java.util.Objects;

public class Ajedrecista implements Comparable<Ajedrecista> {
	private static int contador = 1;
	
	private int codigo;
	private String nombre;
	private int edad;
	private int puntosElo;
	
	/** 
	 * Constructor con argumentos
	 * 
	 * @param nombre nombre del ajedrecista
	 * @param edad edad del ajedrecista
	 * @param puntosElo puntos Elo del ajedrecista
	 */
	public Ajedrecista(String nombre, int edad, int puntosElo) {
		super();
		this.codigo = Ajedrecista.contador;
		Ajedrecista.contador++;
		this.nombre = nombre;
		this.edad = edad;
		this.puntosElo = puntosElo;
	}
	
	/**
	 * @return el codigo del ajedrecista
	 */
	public int getCodigo() {
		return codigo;
	}


	/**
	 * @return el nombre del ajedrecista
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre del ajedrecista
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return la edad del ajedrecista
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad la edad del ajedrecista
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return los puntos Elo
	 */
	public int getPuntosElo() {
		return puntosElo;
	}

	/**
	 * @param puntosElo los puntos Elo del ajedrecista
	 */
	public void setPuntosElo(int puntosElo) {
		this.puntosElo = puntosElo;
	}

	@Override
	public String toString() {
		return "Ajedrecista " + codigo + ": " + nombre + " (" + edad + " años), Elo=" + puntosElo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ajedrecista other = (Ajedrecista) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Ajedrecista other) {
		return this.puntosElo - other.puntosElo;
	}
	
}
