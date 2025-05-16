package finales.extraspace;

/** Clase que permite crear objetos de personas que trabajan como personal de tierra
 */
public class Tierra extends Personal {
	private static final long serialVersionUID = 1L;
	private int nivel;
	
	/** Crea un nuevo objeto personal de tierra
	 * @param nombre	Nombre
	 * @param pais	País de origen
	 * @param nivel	Nivel laboral del trabajador/a (de 1 a 5)
	 */
	public Tierra(String nombre, String pais, int nivel) {
		super(nombre, pais);
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "Personal de tierra " + getNombre() + " (" + getPais() + " nivel " + nivel + ")";
	}

	@Override
	public double getCoste() {
		return this.nivel * 0.15;
	}

	/** Crea un nuevo personal de tierra partiendo de los datos de línea tabulada de ese Tierra
	 * @param linea	Línea de texto con los datos separados por tabulador en formato TIERRA - nombre - país - nivel
	 * @return Nuevo tierra creado desde esa línea, null si hay algún error
	 * @throws NullPointerException	Error si la línea es null
	 * @throws IndexOutOfBoundsException	Error si faltan partes en la línea
	 * @throws NumberFormatException	Error si el nivel no es un entero válido
	 */
	public static Tierra crearDesdeLineaTabulada( String linea ) throws NullPointerException, IndexOutOfBoundsException, NumberFormatException {
		String[] partesLinea = linea.split( "\t" );
		if (!partesLinea[0].equals( "TIERRA" )) {
			return null;
		}
		Tierra ret = new Tierra( partesLinea[1], partesLinea[2], Integer.parseInt( partesLinea[3] ) );
		return ret;
	}
	
	@Override
	public String aLineaTabulada() {
		String ret = "TIERRA\t" + getNombre() + "\t" + getPais() + "\t" + nivel;
		return ret;
	}
	
}
