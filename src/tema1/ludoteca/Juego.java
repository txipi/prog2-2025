package tema1.ludoteca;

import java.util.Objects;

public class Juego extends Recurso implements Comparable<Juego> {
	protected String titulo;
	protected double duracion;
	protected int edad;
	
	public Juego(String titulo, double duracion, int edad) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.edad = edad;
	}
	
	public Juego() {
		super();
		this.titulo = "Sin título";
		this.duracion = 0;
		this.edad = 0;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duracion, edad, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juego other = (Juego) obj;
		return Double.doubleToLongBits(duracion) == Double.doubleToLongBits(other.duracion) && edad == other.edad
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Juego [titulo=" + titulo + ", duracion=" + duracion + ", edad=" + edad + "]";
	}

	@Override
	public boolean esFamiliar() {
		if (this.edad < 10) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Juego other) {
//		if (this.edad < other.edad) {
//			return -1;
//		} else if (this.edad > other.edad) {
//			return 1;
//		} else {
//			return 0;
//		}
		return (this.edad - other.edad);
	}
	
}
