package tema1.openjai;

import java.util.ArrayList;

public class Desarrollador extends Empleado {
	protected ArrayList<Lenguaje> lenguajes;

	public Desarrollador(String nombre, ArrayList<Lenguaje> lenguajes) {
		super(nombre);
		this.lenguajes = lenguajes;
	}

	public ArrayList<Lenguaje> getLenguajes() {
		return lenguajes;
	}

	public void setLenguajes(ArrayList<Lenguaje> lenguajes) {
		this.lenguajes = lenguajes;
	}

	@Override
	public String toString() {
		return "Desarrollador [lenguajes=" + lenguajes + ", nombre=" + nombre + ", id=" + id + "]";
	}
	
	
}
