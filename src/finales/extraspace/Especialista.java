package finales.extraspace;

/** Clase que permite crear objetos especialistas de misión
 */
public class Especialista extends Personal {
	private static final long serialVersionUID = 1L;
	private String especialidad;
	private int dificultad; // Dificultad de especialista, de 0 (fácil) a 100 (difícil)

	/** Crea un especialista
	 * @param nombre	Nombre
	 * @param pais	País
	 * @param especialidad	Nombre de la especialidad, si es null o string vacío se pone "Desconocida"
	 * @param dificultad	Dificultad de la especialidad (valor de 0 a 100)
	 * @throws ArithmeticException	Si se intenta asignar un valor fuera de ese rango
	 */
	public Especialista(String nombre, String pais, String especialidad, int dificultad) throws ArithmeticException {
		super(nombre, pais);
		setEspecialidad( especialidad );
		setDificultad( dificultad );
	}
	
	public int getDificultad() {
		return dificultad;
	}
	
	/** Modifica la dificultad del especialista
	 * @param dificultad	Dificultad, valor entre 0 y 100
	 * @throws ArithmeticException	Si se intenta asignar un valor fuera de ese rango
	 */
	public void setDificultad(int dificultad) throws ArithmeticException {
		if (dificultad < 0 || dificultad > 100) {
			throw new ArithmeticException( "Valor de dificultad incorrecto: " + dificultad );
		}
		this.dificultad = dificultad;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	/** Modifica la especialidad del especialista
	 * @param especialidad	Nombre de la especialidad, si es null o string vacío se pone "Desconocida"
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	@Override
	public String toString() {
		return "Especialista " + getNombre() + " (" + getPais() + "): " + especialidad + " [" + dificultad + "]";
	}

	@Override
	public double getCoste() {
		double coste = dificultad * 0.10;
		return coste;
	}

	/** Crea un nuevo especialista partiendo de los datos de línea tabulada de ese especialista
	 * @param linea	Línea de texto con los datos separados por tabulador en formato ESPECIALISTA - nombre - país - especialidad - dificultad
	 * @return Nuevo especialista creado desde esa línea, null si hay algún error
	 * @throws NullPointerException	Error si la línea es null
	 * @throws IndexOutOfBoundsException	Error si faltan partes en la línea
	 * @throws NumberFormatException	Error si la dificultad no es un entero válido
	 * @throws ArithmeticException	Error si la dificultad tiene un valor incorrecto
	 */
	public static Especialista crearDesdeLineaTabulada( String linea ) throws NullPointerException, IndexOutOfBoundsException, NumberFormatException, ArithmeticException {
		String[] partesLinea = linea.split( "\t" );
		if (!partesLinea[0].equals( "ESPECIALISTA" )) {
			return null;
		}
		Especialista ret = new Especialista( partesLinea[1], partesLinea[2], partesLinea[3], Integer.parseInt( partesLinea[4] ) );
		return ret;
	}
	
	@Override
	public String aLineaTabulada() {
		String ret = "ESPECIALISTA\t" + getNombre() + "\t" + getPais() + "\t" + especialidad + "\t" + dificultad;
		return ret;
	}
}
