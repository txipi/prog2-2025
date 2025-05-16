package finales.extraspace;

import java.util.ArrayList;
import java.util.NoSuchElementException;

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

	@Override
	public boolean esSubvencionable() {
		return (this.habilidades.contains(Habilidad.INVESTIGACION));
	}

	@Override
	public double getPorcentaje() {
		if (esSubvencionable()) {
			return 90;
		} else {
			return 0;
		}
	}

	@Override
	public double getCoste() {
		double coste = this.habilidades.size() * 0.25;
		if (this.esSubvencionable()) {
			coste = coste - (coste * this.getPorcentaje() / 100);
		}
		return coste;
	}

	/** Crea un nuevo astronauta partiendo de los datos de línea tabulada de ese astronauta
	 * @param linea	Línea de texto con los datos separados por tabulador en formato ASTRONAUTA - nombre - país - lista_habilidades_separadas_por_comas
	 * @return Nuevo astronauta creado desde esa línea, null si hay algún error
	 * @throws NullPointerException	Error si la línea es null
	 * @throws IndexOutOfBoundsException	Error si faltan partes en la línea
	 * @throws NoSuchElementException	Error si la lista de habilidades tiene valores incorrectos de habilidad
	 */
	public static Astronauta crearDesdeLineaTabulada( String linea ) throws NullPointerException, IndexOutOfBoundsException, NoSuchElementException {
		String[] partesLinea = linea.split( "\t" );
		if (!partesLinea[0].equals( "ASTRONAUTA" )) {
			return null;
		}
		ArrayList<Habilidad> lH = new ArrayList<Habilidad>();
		for (String hab : partesLinea[3].split(",")) {
			lH.add( Habilidad.valueOf(hab) );
		}
		Astronauta ret = new Astronauta( partesLinea[1], partesLinea[2], lH );
		return ret;
	}
	
	@Override
	public String aLineaTabulada() {
		String ret = "ASTRONAUTA\t" + getNombre() + "\t" + getPais() + "\t";
		for (Habilidad h : habilidades) {
			if (h==habilidades.get(0)) {
				ret += h;
			} else {
				ret += "," + h;
			}
		}
		return ret;
	}
}
