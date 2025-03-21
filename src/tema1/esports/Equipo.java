package tema1.esports;

import java.util.ArrayList;
import java.util.Objects;

public class Equipo implements Comparable<Equipo> {
	protected String nombre;
	protected Region region;
	ArrayList<Jugador> jugadores;
	
	public Equipo(String nombre, Region region, ArrayList<Jugador> jugadores) {
		super();
		this.nombre = nombre;
		this.region = region;
		this.jugadores = jugadores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}


	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", region=" + region + ", jugadores=" + jugadores + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}

	int getTotal() {
		int resultado = 0;
	
		for (Jugador jugador : jugadores) {
			resultado += jugador.getReflejos() + jugador.getResistencia() + jugador.getHabilidad();
		}
		
		return resultado;
	}
	
	@Override
	public int compareTo(Equipo other) {
		return this.getTotal() - other.getTotal();
	}
	
	
}
