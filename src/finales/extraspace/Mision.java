package finales.extraspace;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/** Clase que permite crear objetos misiones espaciales
 */
public class Mision implements Serializable, Comparable<Mision> {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String lugar;
	private String destino;
	private LocalDate fecha;
	private Nave nave;
	private ArrayList<Personal> personal;
	
	/** Crea una nueva misión
	 * @param nombre	Nombre
	 * @param lugar	Lugar
	 * @param destino	Destino de la misión
	 * @param anyo	Año (cuatro dígitos)
	 * @param mes	Mes (1 a 12)
	 * @param dia	Día (1 a 31)
	 */
	public Mision(String nombre, String lugar, String destino, int anyo, int mes, int dia) {
		super();
		this.nombre = nombre;
		this.lugar = lugar;
		this.destino = destino;
		this.fecha = LocalDate.of(anyo, mes, dia);
		this.nave = null;
		this.personal = new ArrayList<Personal>();
	}
	
	/** Crea una nueva misión
	 * @param nombre	Nombre
	 * @param lugar	Lugar
	 * @param destino	Destino de la misión
	 * @param fechaLong	Fecha codificada en long - número de días transcurridos desde el 1 de enero de 1970
	 */
	public Mision(String nombre, String lugar, String destino, long fechaLong ) {
		this( nombre, lugar, destino, 1, 1, 1 );
		fecha = LocalDate.ofEpochDay( fechaLong );
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public void setFecha(int anyo, int mes, int dia) {
		this.fecha = LocalDate.of(anyo, mes, dia);
	}

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public ArrayList<Personal> getPersonal() {
		return personal;
	}

	public void setPersonal(ArrayList<Personal> personal) {
		this.personal = personal;
	}

	@Override
	public String toString() {
		return "Mision " + nombre + " a " + destino + " (" + fecha + ", nave: " + 
				nave + ", personal: " + personal.size() + "): " + getCosteTotal() + "M€";
	}

	@Override
	public int hashCode() {
		return Objects.hash(destino, fecha, lugar, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mision other = (Mision) obj;
		return Objects.equals(destino, other.destino) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(lugar, other.lugar) && Objects.equals(nombre, other.nombre);
	}
	
	public double getCosteTotal() {
		double total = 1.5;
		if (this.nave != null) {
			total += nave.getCoste();
		}
		for (Personal persona : personal) {
			total += persona.getCoste();
		}
		return total;
	}

	@Override
	public int compareTo(Mision o) {
		return (int)(this.getCosteTotal() - o.getCosteTotal());
	}

	/** Crea una nueva misión partiendo de los datos de línea tabulada de esa misión (sin nave ni personal)
	 * @param linea	Línea de texto con los datos separados por tabulador en formato MISION - nombre - lugar - destino - fecha_en_milisegundos
	 * @return Nueva misión creada desde esa línea, null si hay algún error
	 * @throws NullPointerException	Error si la línea es null
	 * @throws IndexOutOfBoundsException	Error si faltan partes en la línea
	 * @throws NumberFormatException	Error si la fecha no es un entero largo válido
	 * @throws DateTimeException	Error si la fecha es incorrecta
	 */
	public static Mision crearDesdeLineaTabulada( String linea ) throws NullPointerException, IndexOutOfBoundsException, NumberFormatException, DateTimeException {
		Mision ret = null;
		String[] partesLinea = linea.split( "\t" );
		if (!partesLinea[0].equals( "MISION" )) {
			return null;
		}
		LocalDate fecha = LocalDate.ofEpochDay( Long.parseLong(partesLinea[4]) );
		ret = new Mision( partesLinea[1], partesLinea[2], partesLinea[3], fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth() );
		return ret;
	}
	
	// TAREA 2B
	/** Devuelve un string con todas las líneas de texto separadas por tabuladores correspondientes a la misión
	 * @return	String multilínea
	 */
	public String aLineasTabuladas() {
		// TODO Tarea 2B
		return "MISION\t"+nombre+"\t"+lugar+"\t"+destino+"\t"+fecha;
	}
	
}
