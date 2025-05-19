package finales.extraspace;

import java.io.Serializable;
import java.util.Objects;

/** Clase que permite crear objetos naves
 */
public class Nave implements Serializable, Subvencionable, PaisComprobable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String proveedor;
	private double coste;
	private double carga;
	
	/** Crea una nave
	 * @param nombre	Nombre
	 * @param proveedor	Proveedor (fabricante)
	 * @param coste	En millones de euros
	 * @param carga	En kilogramos
	 */
	public Nave(String nombre, String proveedor, double coste, double carga) {
		super();
		this.nombre = nombre;
		this.proveedor = proveedor;
		this.coste = coste;
		this.carga = carga;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}

	@Override
	public String toString() {
		return "Nave " + nombre + " (" + proveedor + "), " + coste + "M€, " + carga + "kg";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, proveedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nave other = (Nave) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(proveedor, other.proveedor);
	}

	// TAREA 2B: getCoste
	public double getCoste() {
		if (this.esSubvencionable()) {
			return coste - (coste * this.getPorcentaje() / 100);
		} else {
			return coste;
		}
	}

	// TAREA 2A: Subvencionable
	@Override
	public boolean esSubvencionable() {
		return (proveedor.equals("Arianespace"));
	}

	@Override
	public double getPorcentaje() {
		if (esSubvencionable()) {
			return 50;
		} else {
			return 0;
		}
	}

	/** Crea una nueva nave partiendo de los datos de línea tabulada de esa nave
	 * @param linea	Línea de texto con los datos separados por tabulador en formato NAVE - nombre - proveedor - coste - carga
	 * @return Nueva nave creada desde esa línea, null si hay algún error
	 * @throws NullPointerException	Error si la línea es null
	 * @throws IndexOutOfBoundsException	Error si faltan partes en la línea
	 * @throws NumberFormatException	Error si coste o carga no son valores doubles válidos
	 */
	public static Nave crearDesdeLineaTabulada( String linea ) throws NullPointerException, IndexOutOfBoundsException, NumberFormatException {
		String[] partesLinea = linea.split( "\t" );
		if (!partesLinea[0].equals( "NAVE" )) {
			return null;
		}
		Nave ret = new Nave( partesLinea[1], partesLinea[2], Double.parseDouble( partesLinea[3] ), Double.parseDouble( partesLinea[4] ) );
		return ret;
	}
	
	public String aLineaTabulada() {
		String ret = "NAVE\t" + nombre + "\t" + proveedor + "\t" + coste + "\t" + carga;
		return ret;
	}

	@Override
	public String getPais() {
		if (this.proveedor.equals("Arianespace")) {
			return "France";
		} else if (this.proveedor.equals("SpaceX")) {
			return "USA";
		} else {
			return "Russia";
		}
	}

	@Override
	public boolean esPaisAjeno() {
		return DeustoSpace.comprobarPaisAjeno(this.getPais());
	}

}
