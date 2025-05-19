package finales.extraspace;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/** Clase de agencia espacial, contenedora de datos
 */
public class DeustoSpace implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Mision> misiones;
	private ArrayList<Personal> personal;
	
	/** Crea un objeto de agencia espacial, contenedor de datos de misiones y personal. Se inicia con la lista de misiones y personal vacías
	 */
	public DeustoSpace() {
		super();
		this.misiones = new ArrayList<Mision>();
		this.personal = new ArrayList<Personal>();
	}
	
	/** Crea un objeto de agencia espacial, contenedor de datos de misiones y personal.
	 * @param misiones	Misiones iniciales de la agencia
	 * @param personal	Personal inicial de la agencia
	 */
	public DeustoSpace(ArrayList<Mision> misiones, ArrayList<Personal> personal) {
		super();
		this.misiones = new ArrayList<Mision>(misiones);
		this.personal = new ArrayList<Personal>(personal);
	}

	public ArrayList<Mision> getMisiones() {
		return misiones;
	}

	public ArrayList<Personal> getPersonal() {
		return personal;
	}

	public void setPersonal(ArrayList<Personal> personal) {
		this.personal = personal;
	}

	@Override
	public String toString() {
		return "DeustoSpace [misiones=" + misiones + ", personal=" + personal + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(misiones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeustoSpace other = (DeustoSpace) obj;
		return Objects.equals(misiones, other.misiones);
	}

	// TAREA 2A
	/** Carga las misiones desde fichero de texto tabulado con la información completa de misiones, naves y personal
	 * @param nombreFichero	Nombre del fichero a cargar
	 */
	public void cargarMisionesTabs( String nombreFichero ) {
		try {
			File f = new File(nombreFichero);
			Scanner sc = new Scanner(f);
			
			Mision ultima = null;
			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split("\t");
				
				if (campos[0].equals("MISION")) {
					// Crear mision
					Mision mision = Mision.crearDesdeLineaTabulada(linea);
					this.misiones.add(mision);
					ultima = mision;
				} else if (campos[0].equals("NAVE")) {
					// Crear nave
					Nave nave = Nave.crearDesdeLineaTabulada(linea);
					ultima.setNave(nave);
				} else if (campos[0].equals("TIERRA")) {
					// Crear tierra
					Tierra tierra = Tierra.crearDesdeLineaTabulada(linea);
					this.personal.add(tierra);
					ultima.getPersonal().add(tierra);
				} else if (campos[0].equals("ASTRONAUTA")) {
					// Crear astronauta
					Astronauta astronauta = Astronauta.crearDesdeLineaTabulada(linea);
					this.personal.add(astronauta);
					ultima.getPersonal().add(astronauta);
				} else if (campos[0].equals("ESPECIALISTA")) {
					// Crear especialista
					Especialista especialista = Especialista.crearDesdeLineaTabulada(linea);
					this.personal.add(especialista);
					ultima.getPersonal().add(especialista);
				} else {
					System.out.println("No se reconoce este tipo de dato");
				}
			}
			
			sc.close();
		} catch (IOException e) {
			System.err.println(e);
			System.err.println("Error de entrada/salida al leer misiones.txt");
		} catch (NullPointerException e2) {
			System.err.println(e2);
			System.err.println("Error al crear objeto");
		} catch (IndexOutOfBoundsException e3) {
			System.err.println(e3);
			System.err.println("Error: campos insuficientes en la línea");
		} catch (NumberFormatException e4) {
			System.err.println(e4);
			System.err.println("Error al convertir tipos de datos numéricos");
		} catch (DateTimeException e5) {
			System.err.println(e5);
			System.err.println("Error al convertir fechas");
		}
	}
		
	// TAREA 2B
	/** Guarda las misiones en fichero de texto con tabulaciones, con todos los datos de las misiones, naves y personal
	 * @param nombreFichero	Nombre del fichero a crear
	 */
	public void guardarMisionesTabs( String nombreFichero ) {
		try {
			PrintWriter pw = new PrintWriter(nombreFichero);
			
			for (Mision mision : misiones) {
				pw.println(mision.aLineasTabuladas());
				pw.println(mision.getNave().aLineaTabulada());
				for (Personal p : mision.getPersonal()) {
					pw.println(p.aLineaTabulada());
				}
			}
			
			pw.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	// TAREA 2C
	/** Comprueba si las dificultades de cada especialidad están bien codificadas. 
	 * No debería haber distancia de más de 30 dentro de cada especialidad
	 * Saca a consola las dificultades que no sean correctas, con el conjunto ordenado de sus dificultades
	 */
	// Pista: las especialidades con dificultades incorrectas deberían ser las siguientes:
	//  Biología --> [61, 95]
	//  Ingeniería Mecánica --> [25, 61, 72]
	//  Matemáticas --> [43, 58, 85]
	//  Meteorología --> [20, 61]	
	public void comprobarDificultadEspecialidades() {
		TreeMap<String, TreeSet<Integer>> mapa = new TreeMap<>();
		
		for (Mision mision : misiones) {
			for (Personal p : mision.getPersonal()) {
				if (p instanceof Especialista) {
					String especialidad = ((Especialista) p).getEspecialidad();
					int dificultad = ((Especialista) p).getDificultad();
					
					if (!mapa.containsKey(especialidad)) {
						mapa.put(especialidad, new TreeSet<Integer>());
					}
					
					mapa.get(especialidad).add(dificultad);
				}
			}
		}
		
		for (String clave : mapa.keySet()) {
			TreeSet<Integer> valor = mapa.get(clave);
			ArrayList<Integer> lista = new ArrayList<Integer>(valor);
			int max = lista.get(lista.size() - 1);
			int min = lista.get(0);
			if (max - min > 30) {
				System.out.println(clave + "->" + valor);	
			}
		}
	}

	
	// TAREA 1B
	// Pista: Los países incorrectos de los datos de prueba, ordenados por el orden en el que aparecen en las misiones, son los siguientes:
	// "Portugal", "Bulgaria", "Russia", "Switzerland", "Switzerland", "Portugal", "Czech Republic", "Austria", "Portugal", "Russia", "Switzerland", "Russia"
	// Si haces los elementos con países incorrectos, el listado es este: 
	// João Pereira (Portugal), Elena Ivanova (Bulgaria), Nave Soyuz (Russia), Marco Sieber (Switzerland), Marco Sieber (Switzerland), João Pereira (Portugal), 
	//    Aleš Svoboda (Czech Republic), Carmen Possnig (Austria), João Pereira (Portugal), Nave Soyuz (Russia), Marco Sieber (Switzerland), Nave Soyuz (Russia)
	/** Comprueba los países de todas las naves y personal generando una lista ordenada por misión de todos los países ajenos a DeustoSpace (con repetición)
	 * @return	Devuelve esa lista
	 */
	// TODO Definir e implementar generarPaisesAjenos()
	public ArrayList<String> generarPaisesAjenosStrings() {
		ArrayList<String> resultado = new ArrayList<String>();
		
		for (Mision mision : misiones) {
			// Comprobar cada nave
			Nave nave = mision.getNave();
			
			if (nave.esPaisAjeno()) {
				resultado.add(nave.getPais());
			}
			
			// Comprobar el personal
			for (Personal p : mision.getPersonal()) {
				if (p.esPaisAjeno()) {
					resultado.add(p.getPais());
				}
			}
		}
		
		return resultado;
	}
	
	public ArrayList<PaisComprobable> generarPaisesAjenos() {
		ArrayList<PaisComprobable> resultado = new ArrayList<PaisComprobable>();
		
		for (Mision mision : misiones) {
			// Comprobar cada nave
			Nave nave = mision.getNave();
			
			if (nave.esPaisAjeno()) {
				resultado.add(nave);
			}
			
			// Comprobar el personal
			for (Personal p : mision.getPersonal()) {
				if (p.esPaisAjeno()) {
					resultado.add(p);
				}
			}
		}
		
		return resultado;
	}
	
	/** Comprobador de si un país es ajeno a la lista de países que gestiona la agencia
	 * @param pais	Nombre de país
	 * @return	true si es un país incluido en esa lista, false si no está
	 */
	public static boolean comprobarPaisAjeno( String pais ) {
		return "#SPAIN#FRANCE#GERMANY#USA#BELGIUM#UK#SWEDEN#ITALY#DENMARK#POLAND#GREECE#HUNGARY#".contains(
					pais.toUpperCase() );
	}
	
	/** Inicializa la agencia espacial con una serie de datos de prueba
	 */
	public void inicDatosDePrueba() {
		Mision m;
		Nave n;
		Tierra p;
		Astronauta a;
		Especialista e;
		misiones.clear();
		personal.clear();

		m = new Mision("DS I", "Florida USA", "ISS", 20167);
		misiones.add( m );
		n = new Nave("Falcon 9", "SpaceX", 67.0, 22000.0);
		m.setNave(n);
		p = new Tierra("Ana García", "France", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Becker", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Belgium", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Ors", "UK", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Belgium", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Ors", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Johnson", "UK", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Spain", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Bocelli", "Spain", 5);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Sara García Alonso", "Spain", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.INVESTIGACION)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Pablo Álvarez Fernández", "Spain", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.PILOTAR, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Marcus Wandt", "Sweden", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.INGENIERIA, Habilidad.PILOTAR)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Friedrich Schmidt", "Germany", "Ingeniería Aeroespacial", 70);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Maja Eriksson", "Sweden", "Matemáticas", 85);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Élise Moreau", "France", "Meteorología", 20);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Lina Svensson", "Sweden", "Matemáticas", 58);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Marie Dubois", "France", "Electrónica", 54);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS II", "Florida USA", "ISS", 20290);
		misiones.add( m );
		n = new Nave("Falcon 9", "SpaceX", 67.0, 22000.0);
		m.setNave(n);
		p = new Tierra("Mark Becker", "Spain", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Ors", "Germany", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Ors", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Bocelli", "Spain", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Spain", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Becker", "Spain", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Johnson", "Spain", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Ors", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Becker", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Spain", 3);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Nicola Winter", "Germany", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.INGENIERIA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Raphaël Liégeois", "Belgium", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Amelie Schoenenwald", "Germany", new ArrayList<>(Arrays.asList(Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Giulia Rossi", "Italy", "Física", 75);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("João Pereira", "Portugal", "Geología", 47);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Gábor Nagy", "Hungary", "Robótica", 50);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Marco Moretti", "Italy", "Física", 65);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Eleni Kosta", "Greece", "Biología", 95);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS III", "Guayana Francesa", "Luna", 20496);
		misiones.add( m );
		n = new Nave("Ariane 5", "Arianespace", 178.0, 21000.0);
		m.setNave(n);
		p = new Tierra("Ana Ors", "Germany", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Bocelli", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Johnson", "UK", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Becker", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Johnson", "UK", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Bocelli", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Johnson", "Spain", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Bocelli", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Becker", "Spain", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Johnson", "Belgium", 5);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Nicola Winter", "Germany", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.INGENIERIA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Sławosz Uznański", "Poland", new ArrayList<>(Arrays.asList(Habilidad.MEDICINA, Habilidad.PILOTAR)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Andrea Patassa", "Italy", new ArrayList<>(Arrays.asList(Habilidad.MEDICINA, Habilidad.INVESTIGACION)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Hans Müller", "Germany", "Ingeniería Aeroespacial", 80);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Elena Ivanova", "Bulgaria", "Meteorología", 61);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Balázs Szabó", "Hungary", "Robótica", 72);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Friedrich Schmidt", "Germany", "Ingeniería Aeroespacial", 70);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Claude Lefevre", "France", "Electrónica", 45);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS IV", "Houston USA", "ISS", 20526);
		misiones.add( m );
		n = new Nave("Falcon 9", "SpaceX", 67.0, 22000.0);
		m.setNave(n);
		p = new Tierra("Andrea Johnson", "Spain", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Ors", "Spain", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Johnson", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Bocelli", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "UK", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Belgium", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Becker", "Spain", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Johnson", "Belgium", 1);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Nicola Winter", "Germany", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.INGENIERIA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Andrea Patassa", "Italy", new ArrayList<>(Arrays.asList(Habilidad.MEDICINA, Habilidad.INVESTIGACION)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Raphaël Liégeois", "Belgium", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Giulia Rossi", "Italy", "Física", 75);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Alexandros Vasilis", "Greece", "Biología", 95);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Ole Hansen", "Denmark", "Ingeniería Mecánica", 25);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Jan Kowalczyk", "Poland", "Química", 55);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Linnea Lund", "Sweden", "Matemáticas", 85);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS V", "Guayana Francesa", "Luna", 20861);
		misiones.add( m );
		n = new Nave("Ariane 5", "Arianespace", 178.0, 21000.0);
		m.setNave(n);
		p = new Tierra("John Bocelli", "Spain", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Ors", "Spain", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Bocelli", "Spain", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Bocelli", "Spain", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Becker", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Ors", "Spain", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Becker", "UK", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Ors", "Belgium", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Ors", "France", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Bocelli", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Anthea Comellini", "Italy", new ArrayList<>(Arrays.asList(Habilidad.MEDICINA, Habilidad.PILOTAR)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Rosemary Coogan", "UK", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.INVESTIGACION, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Raphaël Liégeois", "Belgium", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Alexandros Vasilis", "Greece", "Biología", 95);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Isabelle Dupont", "Belgium", "Astronomía", 65);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Francesco Ricci", "Italy", "Física", 65);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Luca Bianchi", "Italy", "Física", 84);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Bastian Lambert", "France", "Electrónica", 64);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS VI", "Baikonur", "ISS", 20888);
		misiones.add( m );
		n = new Nave("Soyuz", "Roscosmos", 38.0, 7020.0);
		m.setNave(n);
		p = new Tierra("Andrea Johnson", "UK", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Ors", "Germany", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Becker", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Becker", "Spain", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Johnson", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Johnson", "UK", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Johnson", "Spain", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "France", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Belgium", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Johnson", "Belgium", 1);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Marco Sieber", "Switzerland", new ArrayList<>(Arrays.asList(Habilidad.INGENIERIA, Habilidad.MEDICINA, Habilidad.PILOTAR)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Pablo Álvarez Fernández", "Spain", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.PILOTAR, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Nicola Winter", "Germany", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.INGENIERIA)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Zofia Mazur", "Poland", "Química", 55);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Niels Sørensen", "Denmark", "Ingeniería Mecánica", 25);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Leire Aguirre", "Spain", "Informática", 62);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Maja Eriksson", "Sweden", "Matemáticas", 85);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Ole Hansen", "Denmark", "Ingeniería Mecánica", 25);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS VII", "Guayana Francesa", "ISS", 20902);
		misiones.add( m );
		n = new Nave("Falcon 9", "SpaceX", 67.0, 22000.0);
		m.setNave(n);
		p = new Tierra("Ana García", "Spain", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Bocelli", "Italy", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Johnson", "Spain", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Becker", "Italy", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Bocelli", "Italy", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Becker", "Spain", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Ors", "Spain", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Bocelli", "Spain", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Johnson", "Belgium", 1);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Sara García Alonso", "Spain", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.INVESTIGACION)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Marco Sieber", "Switzerland", new ArrayList<>(Arrays.asList(Habilidad.INGENIERIA, Habilidad.MEDICINA, Habilidad.PILOTAR)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Amelie Schoenenwald", "Germany", new ArrayList<>(Arrays.asList(Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Manuel Ortega", "Spain", "Geología", 30);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Gábor Nagy", "Hungary", "Robótica", 50);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Francesco Ricci", "Italy", "Física", 65);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Luca Bianchi", "Italy", "Física", 84);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("João Pereira", "Portugal", "Geología", 47);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS VIII", "Guayana Francesa", "ISS", 21228);
		misiones.add( m );
		n = new Nave("Soyuz", "Arianespace", 47.0, 7020.0);
		m.setNave(n);
		p = new Tierra("Laura Johnson", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Ors", "Italy", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Bocelli", "Belgium", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Bocelli", "Germany", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Ors", "Spain", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Bocelli", "Spain", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Bocelli", "UK", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Ors", "Italy", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Johnson", "UK", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Johnson", "UK", 4);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Pablo Álvarez Fernández", "Spain", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.PILOTAR, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Aleš Svoboda", "Czech Republic", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Marcus Wandt", "Sweden", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.INGENIERIA, Habilidad.PILOTAR)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Giulia Rossi", "Italy", "Física", 75);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Klaus Becker", "Germany", "Ingeniería Aeroespacial", 75);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Claude Lefevre", "France", "Electrónica", 45);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Jan Kowalczyk", "Poland", "Química", 55);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Charlotte Dubois", "Belgium", "Astronomía", 40);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS IX", "Houston USA", "Luna", 21700);
		misiones.add( m );
		n = new Nave("Falcon 9", "SpaceX", 67.0, 22000.0);
		m.setNave(n);
		p = new Tierra("Andrea Johnson", "UK", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Spain", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Becker", "Spain", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Johnson", "France", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Ors", "UK", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Bocelli", "Italy", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Ors", "Italy", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Bocelli", "France", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Becker", "Italy", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Spain", 3);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Rosemary Coogan", "UK", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.INVESTIGACION, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Carmen Possnig", "Austria", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Sophie Adenot", "France", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.INGENIERIA)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("João Pereira", "Portugal", "Geología", 47);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Klaus Becker", "Germany", "Ingeniería Aeroespacial", 75);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Giulia Rossi", "Italy", "Física", 75);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Anders Nielsen", "Denmark", "Ingeniería Mecánica", 61);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Ursula Fischer", "Germany", "Ingeniería Aeroespacial", 75);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS X", "Guayana Francesa", "Marte", 21865);
		misiones.add( m );
		n = new Nave("Ariane 5", "Arianespace", 178.0, 21000.0);
		m.setNave(n);
		p = new Tierra("Ana Bocelli", "UK", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Ors", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Johnson", "Spain", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Ors", "Italy", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Bocelli", "Italy", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Bocelli", "Italy", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Bocelli", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Becker", "Italy", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Bocelli", "Italy", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Bocelli", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Rosemary Coogan", "UK", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.INVESTIGACION, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Sławosz Uznański", "Poland", new ArrayList<>(Arrays.asList(Habilidad.MEDICINA, Habilidad.PILOTAR)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Pablo Álvarez Fernández", "Spain", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.PILOTAR, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Bastian Lambert", "France", "Electrónica", 64);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Giulia Rossi", "Italy", "Física", 75);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Nikos Papadopoulos", "Greece", "Biología", 61);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Irene Sánchez", "Spain", "Informática", 35);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Ursula Fischer", "Germany", "Ingeniería Aeroespacial", 75);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS XI", "Florida USA", "ISS", 22020);
		misiones.add( m );
		n = new Nave("Falcon 9", "SpaceX", 67.0, 22000.0);
		m.setNave(n);
		p = new Tierra("John Becker", "Spain", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Johnson", "Italy", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Becker", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Becker", "UK", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Becker", "Italy", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Bocelli", "Spain", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "UK", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Johnson", "UK", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Johnson", "Spain", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Spain", 4);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Anthea Comellini", "Italy", new ArrayList<>(Arrays.asList(Habilidad.MEDICINA, Habilidad.PILOTAR)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Sara García Alonso", "Spain", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.INVESTIGACION)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Sophie Adenot", "France", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.INGENIERIA)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Linnea Lund", "Sweden", "Matemáticas", 85);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Francesco Ricci", "Italy", "Física", 65);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Sophie Leclerc", "Belgium", "Astronomía", 50);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Lucie Petit", "Belgium", "Astronomía", 40);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Jan Kowalczyk", "Poland", "Química", 55);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS XII", "Baikonur", "ISS", 22085);
		misiones.add( m );
		n = new Nave("Soyuz", "Roscosmos", 38.0, 7020.0);
		m.setNave(n);
		p = new Tierra("Andrea Johnson", "Belgium", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Bocelli", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Belgium", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Becker", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Bocelli", "France", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Ors", "Spain", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Becker", "Spain", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Johnson", "Spain", 3);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Pablo Álvarez Fernández", "Spain", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.PILOTAR, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Arnaud Prost", "France", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.INGENIERIA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Raphaël Liégeois", "Belgium", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Hans Müller", "Germany", "Ingeniería Aeroespacial", 80);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Marco Moretti", "Italy", "Física", 65);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Zofia Mazur", "Poland", "Química", 55);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Manuel Ortega", "Spain", "Geología", 30);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Luca Bianchi", "Italy", "Física", 84);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS XIII", "Guayana Francesa", "Marte", 22107);
		misiones.add( m );
		n = new Nave("Ariane 5", "Arianespace", 178.0, 21000.0);
		m.setNave(n);
		p = new Tierra("Mark Ors", "Spain", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Becker", "Spain", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Ors", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Becker", "Italy", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Johnson", "Spain", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Johnson", "UK", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Johnson", "Spain", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Bocelli", "Italy", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Bocelli", "France", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Ors", "UK", 4);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Marco Sieber", "Switzerland", new ArrayList<>(Arrays.asList(Habilidad.INGENIERIA, Habilidad.MEDICINA, Habilidad.PILOTAR)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Amelie Schoenenwald", "Germany", new ArrayList<>(Arrays.asList(Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Meganne Christian", "UK", new ArrayList<>(Arrays.asList(Habilidad.PILOTAR, Habilidad.INGENIERIA)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Anders Nielsen", "Denmark", "Ingeniería Mecánica", 61);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Emma Jensen", "Denmark", "Ingeniería Mecánica", 72);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Sophie Leclerc", "Belgium", "Astronomía", 50);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Klaus Becker", "Germany", "Ingeniería Aeroespacial", 75);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Balázs Szabó", "Hungary", "Robótica", 72);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS XIV", "Florida USA", "Luna", 22380);
		misiones.add( m );
		n = new Nave("Falcon 9", "SpaceX", 67.0, 22000.0);
		m.setNave(n);
		p = new Tierra("John Ors", "France", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Bocelli", "UK", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Ors", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Ors", "Spain", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Johnson", "France", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Bocelli", "Italy", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana Becker", "Germany", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Johnson", "Spain", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Ors", "Italy", 4);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Anthea Comellini", "Italy", new ArrayList<>(Arrays.asList(Habilidad.MEDICINA, Habilidad.PILOTAR)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Andrea Patassa", "Italy", new ArrayList<>(Arrays.asList(Habilidad.MEDICINA, Habilidad.INVESTIGACION)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("John McFall", "UK", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.INGENIERIA, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Sofia Johansson", "Sweden", "Matemáticas", 43);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Lucie Petit", "Belgium", "Astronomía", 40);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Maja Eriksson", "Sweden", "Matemáticas", 85);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Claude Lefevre", "France", "Electrónica", 45);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Giulia Rossi", "Italy", "Física", 75);
		personal.add(e);
		m.getPersonal().add(e);

		m = new Mision("DS XV", "Baikonur", "ISS", 22467);
		misiones.add( m );
		n = new Nave("Soyuz", "Roscosmos", 38.0, 7020.0);
		m.setNave(n);
		p = new Tierra("Ana García", "Spain", 5);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Laura Bocelli", "Germany", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Ors", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Bocelli", "Spain", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("John Becker", "Italy", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "UK", 2);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Becker", "Spain", 4);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Mark Becker", "Italy", 1);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Andrea Bocelli", "Germany", 3);
		personal.add(p);
		m.getPersonal().add(p);
		p = new Tierra("Ana García", "Spain", 3);
		personal.add(p);
		m.getPersonal().add(p);
		a = new Astronauta("Sławosz Uznański", "Poland", new ArrayList<>(Arrays.asList(Habilidad.MEDICINA, Habilidad.PILOTAR)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Raphaël Liégeois", "Belgium", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.MEDICINA)));
		personal.add(a);
		m.getPersonal().add(a);
		a = new Astronauta("Arnaud Prost", "France", new ArrayList<>(Arrays.asList(Habilidad.INVESTIGACION, Habilidad.INGENIERIA)));
		personal.add(a);
		m.getPersonal().add(a);
		e = new Especialista("Charlotte Dubois", "Belgium", "Astronomía", 40);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Niels Sørensen", "Denmark", "Ingeniería Mecánica", 25);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Linnea Lund", "Sweden", "Matemáticas", 85);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Tamás Kovács", "Hungary", "Robótica", 50);
		personal.add(e);
		m.getPersonal().add(e);
		e = new Especialista("Gábor Nagy", "Hungary", "Robótica", 50);
		personal.add(e);
		m.getPersonal().add(e);
	}
	
}
