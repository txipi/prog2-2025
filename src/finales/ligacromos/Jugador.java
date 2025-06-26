package finales.ligacromos;

import java.util.Objects;

public class Jugador implements Valorable {

	private String nombre;
	private Posicion posicion;
	private String equipo;
	private double valor;
	private Rareza rareza;
	private int dorsal;
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jugador(String nombre, Posicion posicion, String equipo, double valor, Rareza rareza, int dorsal) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.equipo = equipo;
		this.valor = valor;
		this.rareza = rareza;
		this.dorsal = dorsal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Rareza getRareza() {
		return rareza;
	}
	public void setRareza(Rareza rareza) {
		this.rareza = rareza;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", posicion=" + posicion + ", equipo=" + equipo + ", valor=" + valor
				+ ", rareza=" + rareza + ", dorsal=" + dorsal + "]";
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Jugador)) return false;
	    Jugador j = (Jugador) o;
	    return dorsal == j.dorsal
	        && Objects.equals(nombre, j.nombre)
	        && Objects.equals(equipo, j.equipo);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(nombre, equipo, dorsal);
	}

	
	// Ejercicio 4
	@Override
	public boolean esValioso() {
		if (rareza.equals(Rareza.EPICO) || rareza.equals(Rareza.LEGENDARIA)) { 
			return true;
		} else {
			return false;
		}
	}
	@Override
	public double getMultiplicador() {
		if (rareza.equals(Rareza.EPICO)) { 
			return 1.5;
		} else if (rareza.equals(Rareza.LEGENDARIA)) {
			return 2.0;
		} else {
			return 1.0;
		}
	}
	
	
	
	
}
