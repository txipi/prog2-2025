package finales.extraspace;

/** Clase principal de la aplicación
 */
public class Principal {

	public static void main(String[] args) {
		DeustoSpace ds = new DeustoSpace();
		System.out.println(ds.generarPaisesAjenos());
		//ds.inicDatosDePrueba(); // Comentar esta llamada si se soluciona la tarea 2A
		ds.cargarMisionesTabs( "misiones.txt" );  // Llamada a tarea 2A
		System.out.println( "Misiones cargadas: " + ds.getMisiones() );
		ds.guardarMisionesTabs( "salida.txt" );  // Llamada a tarea 2B
		System.out.println( "Comprobación de especialidades con dificultades lejanas:" );
		ds.comprobarDificultadEspecialidades(); // Llamada a tarea 2C
		System.out.println( "Paises ajenos (objetos):" );
		// ds.generarPaisesAjenos();  // Llamada a tarea 1B
	}

}
