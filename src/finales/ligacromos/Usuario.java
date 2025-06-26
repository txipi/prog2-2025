package finales.ligacromos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Usuario implements Comparable<Usuario> {
	private String nombreUsuario;
	private List<Jugador> coleccion;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
		this.nombreUsuario = "";
		this.coleccion = new ArrayList<Jugador>();
	}
	public Usuario(String nombreUsuario, List<Jugador> coleccion) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.coleccion = coleccion;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public List<Jugador> getColeccion() {
		return coleccion;
	}
	public void setColeccion(List<Jugador> coleccion) {
		this.coleccion = coleccion;
	}
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", coleccion=" + coleccion + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(coleccion, nombreUsuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(coleccion, other.coleccion) && Objects.equals(nombreUsuario, other.nombreUsuario);
	}
	
	//Ejercicio 5
	public double getValorTotal() {
		double total = 0.0;
		
		for (Jugador jugador : coleccion) {
			total += jugador.getValor() * jugador.getMultiplicador();
		}
		
		return total;
	}
	
	@Override
	public int compareTo(Usuario other) {
		if (this.getValorTotal() < other.getValorTotal()) {
			return -1;
		} else if (this.getValorTotal() > other.getValorTotal()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	//Ejercicio 9
	public HashMap<Jugador, Integer> getRepetidos() {
		HashMap<Jugador, Integer> mapa = new HashMap<Jugador, Integer>();
		
		for (Jugador jugador : coleccion) {
			if (!mapa.containsKey(jugador)) {
				mapa.put(jugador, 0);
			}
			mapa.put(jugador, mapa.get(jugador) + 1);
		}
		
		return mapa;
	}

	
}
