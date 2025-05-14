package finales.deustospace;

import java.util.ArrayList;

/** Clase que permite crear objetos astronautas
 */
public class Astronauta extends Personal implements Subvencionable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Habilidad> habilidades;

	/** Crea un astronauta
	 * @param nombre	Nombre
	 * @param pais	País
	 * @param habilidades	Lista de habilidades
	 */
	public Astronauta(String nombre, String pais, ArrayList<Habilidad> habilidades) {
		super(nombre, pais);
		this.habilidades = new ArrayList<Habilidad>(habilidades);
	}
	
	public Astronauta(String nombre, String pais) {
		super(nombre, pais);
		this.habilidades = new ArrayList<Habilidad>();
	}

	public ArrayList<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}

	@Override
	public String toString() {
		return "Astronauta " + getNombre() + " (" + getPais() + "): " + habilidades;
	}

	// TAREA 2A: Subvencionable
	@Override
	public boolean esSubvencionable() {
		if (this.habilidades.contains(Habilidad.INVESTIGACION)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public double getPorcentaje() {
		if (this.esSubvencionable()) {
			return 90;
		} else {
			return 0;
		}
	}
	
	// TAREA 2B: getCoste
	public double getCoste() {
		double coste = this.habilidades.size() * 0.25;
		return coste - coste * this.getPorcentaje() / 100;
	}
}
