package tema1.zoo;

import java.util.Objects;

public class Animal {
	// Atributos
	protected String nombre;
	protected String especie;
	protected int edad;
	protected double peso;
	protected double longitud;
	
	public Animal(String nombre, String especie, int edad, double peso, double longitud) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.edad = edad;
		this.peso = peso;
		this.longitud = longitud;
	}
	
	public Animal() {
		super();
		this.nombre = "";
		this.especie = "";
		this.edad = 0;
		this.peso = 0;
		this.longitud = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + ", peso=" + peso + ", longitud="
				+ longitud + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(especie, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(especie, other.especie) && Objects.equals(nombre, other.nombre);
	}
	
	
	
}
