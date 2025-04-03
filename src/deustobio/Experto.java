package deustobio;

import java.util.ArrayList;

import deustobio.fenomenos.Continentes;
import deustobio.fenomenos.FenomenoNatural;
import deustobio.fenomenos.Terrestre;

public class Experto {
	private String nombre;
	private Especialidad especialidad;
	private ArrayList<FenomenoNatural> fenomenos;
	
	//CONSTRUCTORES
	public Experto(String nombre, Especialidad especialidad, ArrayList<FenomenoNatural> fenomenos) {
		// EJERCICIO 1A
		super();
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.fenomenos = fenomenos;
	}

	public Experto() {
		// EJERCICIO 1A
		super();
		this.nombre = "";
		this.especialidad = Especialidad.MARITIMO;
		this.fenomenos = new ArrayList<FenomenoNatural>();
	}

	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public ArrayList<FenomenoNatural> getFenomenos() {
		return fenomenos;
	}

	@Override
	public String toString() {
		return "Experto [nombre=" + nombre + ", especialidad=" + especialidad + ", fenomenos=" + fenomenos + "]";
	}
	
	public ArrayList<FenomenoNatural> obtenerFenomenosContinente(Continentes continente) {
		ArrayList<FenomenoNatural> lista = new ArrayList<FenomenoNatural>();
		
		for (FenomenoNatural fenomeno: this.fenomenos) {
			if (fenomeno instanceof Terrestre) {
				if (((Terrestre) fenomeno).getContinente() == continente) {
					lista.add(fenomeno);
				}				
			}
		}
		
		return lista;
	}
	
}
