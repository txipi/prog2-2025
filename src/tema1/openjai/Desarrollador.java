package tema1.openjai;

import java.util.ArrayList;

public class Desarrollador extends Empleado {
	protected ArrayList<Lenguaje> lenguajes;
	protected double horas;

	public Desarrollador(String nombre, ArrayList<Lenguaje> lenguajes) {
		super(nombre);
		this.lenguajes = lenguajes;
		this.horas = 1600;
	}

	public ArrayList<Lenguaje> getLenguajes() {
		return lenguajes;
	}

	public void setLenguajes(ArrayList<Lenguaje> lenguajes) {
		this.lenguajes = lenguajes;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	@Override
	public String toString() {
		return "Desarrollador [lenguajes=" + lenguajes + ", horas=" + horas + ", nombre=" + nombre + ", id=" + id + "]";
	}
	
}
