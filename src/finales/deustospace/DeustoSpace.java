package finales.deustospace;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/** Clase de agencia espacial, contenedora de datos
 */
public class DeustoSpace implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String TreeMap = null;
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
	
	/** Crea datos de prueba iniciales de la agencia: una serie de misiones y una lista de personal
	 */
	public void datosIniciales() {
		Mision m0 = new Mision("DS I", "Florida USA", "ISS", 2025, 3, 20);
		m0.setNave(new Nave("Falcon 9","SpaceX", 67, 22000));
		Mision m1 = new Mision("DS II", "Florida USA", "ISS", 2025, 7, 21);
		m1.setNave(new Nave("Falcon 9","SpaceX", 67, 22000));
		Mision m2 = new Mision("DS III", "Guayana Francesa", "Luna", 2026, 2, 12);
		m2.setNave(new Nave("Ariane 5","Arianespace", 178, 21000));
		Mision m3 = new Mision("DS IV", "Houston USA", "ISS", 2026, 3, 14);
		m3.setNave(new Nave("Falcon 9","SpaceX", 67, 22000));
		Mision m4 = new Mision("DS V", "Guayana Francesa", "Luna", 2027, 2, 12);
		m4.setNave(new Nave("Ariane 5","Arianespace", 178, 21000));
		Mision m5 = new Mision("DS VI", "Baikonur", "ISS", 2027, 3, 11);
		m5.setNave(new Nave("Soyuz", "Roscosmos", 38, 7020));
		personal.add(new Astronauta("Pablo Álvarez Fernández", "Spain", new ArrayList<Habilidad>(Arrays.asList(Habilidad.values()))));
		personal.add(new Astronauta("Sara García Alonso", "Spain", new ArrayList<Habilidad>(Arrays.asList(Habilidad.values()))));
		personal.add(new Astronauta("Andrea Patassa", "Italy", new ArrayList<Habilidad>(Arrays.asList(Habilidad.values()))));
		personal.add(new Tierra("Ana García", "Spain", 1));
		personal.add(new Tierra("Andrea Ors", "Italy", 1));
		personal.add(new Tierra("Laura Johnson", "UK", 1));
		personal.add(new Tierra("Andrea Johnson", "Spain", 1));
		personal.add(new Tierra("Mark Becker", "France", 1));
		personal.add(new Tierra("Ana García", "Spain", 2));
		personal.add(new Tierra("Andrea Ors", "Italy", 2));
		personal.add(new Tierra("Laura Johnson", "UK", 2));
		personal.add(new Tierra("John Becker", "Spain", 2));
		personal.add(new Tierra("Mark Bocelli", "Italy", 2));
		personal.add(new Tierra("Ana García", "Spain", 3));
		personal.add(new Tierra("Mark Ors", "Germany", 3));
		personal.add(new Tierra("John Johnson", "Spain", 3));
		personal.add(new Tierra("Laura Becker", "Germany", 3));
		personal.add(new Tierra("Andrea Bocelli", "Spain", 3));
		personal.add(new Tierra("Ana García", "Spain", 4));
		personal.add(new Tierra("Laura Ors", "UK", 4));
		personal.add(new Tierra("Mark Johnson", "Italy", 4));
		personal.add(new Tierra("Andrea Becker", "Spain", 4));
		personal.add(new Tierra("John Bocelli", "UK", 4));
		personal.add(new Tierra("Ana García", "Spain", 5));
		personal.add(new Tierra("Ana Ors", "Belgium", 5));
		personal.add(new Tierra("Ana Johnson", "UK", 5));
		personal.add(new Tierra("Ana Becker", "Germany", 5));
		personal.add(new Tierra("Ana Bocelli", "Italy", 5));
		m1.setPersonal(personal);
		m2.setPersonal(personal);
		m3.setPersonal(personal);
		m4.setPersonal(personal);
		m5.setPersonal(personal);
		misiones.add(m0);
		misiones.add(m1);
		misiones.add(m2);
		misiones.add(m3);
		misiones.add(m4);
		misiones.add(m5);
	}

	// TAREA 1A: cargarMisionesCSV
	public void cargarMisionesCSV() {
		try {
			File f = new File("misiones.csv");
			Scanner sc = new Scanner(f);
			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				
				// campos[0-5] -> crear Mision
				int d = Integer.parseInt(campos[3]);
				int m = Integer.parseInt(campos[4]);
				int a = Integer.parseInt(campos[5]);
				Mision mision = new Mision(campos[0], campos[1], campos[2], a, m, d);
				
				// campos[6-9] -> crear Nave
				double coste = Double.parseDouble(campos[8]);
				double carga = Double.parseDouble(campos[9]);
				Nave nave = new Nave(campos[6], campos[7], coste, carga);
				
				mision.setNave(nave);
				
				misiones.add(mision);
			}
			
			sc.close();
		} catch (IOException e) {
			System.err.println("Error al cargar misiones.csv");
		} catch (DateTimeException e2) {
			System.err.println("Error, fecha incorrecta");
		} catch (ArrayIndexOutOfBoundsException e3) {
			System.err.println("Error, línea con campos insuficientes");
		} catch (NumberFormatException e3) {
			System.err.println("Error, campo numérico incorrecto");
		}
	}

	// TAREA 1B: cargarPersonalCSV
	public void cargarPersonalCSV() {
		try {
			File f = new File("personal.csv");
			Scanner sc = new Scanner(f);
			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				
				Personal persona;
				String nombre = campos[1];
				String pais = campos[2];
				
				if (campos[0].equals("Astronauta")) {
					// Crear Astronauta
					ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
					String[] habs = campos[3].split(",");
					for (String h : habs) {
						Habilidad habilidad = Habilidad.valueOf(h.toUpperCase());
						habilidades.add(habilidad);
					}
					persona = new Astronauta(nombre, pais, habilidades);
				} else {
					// Crear Tierra
					int nivel = Integer.parseInt(campos[3]); 
					persona = new Tierra(nombre, pais, nivel);
				}
				
				personal.add(persona);
			}
			
			sc.close();
		} catch (IOException e) {
			System.err.println("Error al cargar personal.csv");
		}
	}

	// TAREA 1C: asignarPersonal
	public void asignarPersonal() {
		ArrayList<Personal> pilotos = new ArrayList<Personal>();
		ArrayList<Personal> astronautas = new ArrayList<Personal>();
		ArrayList<Personal> tierras = new ArrayList<Personal>();
		
		for (Personal persona : personal) {
			if (persona instanceof Astronauta) {
				astronautas.add(persona);
				Astronauta astronauta = (Astronauta) persona;
				if (astronauta.getHabilidades().contains(Habilidad.PILOTAR)) {
					pilotos.add(astronauta);
				}
			} else {
				tierras.add(persona);
			}
		}
		
		for (Mision mision : misiones) {
			// Añadir 1 astronauta que sepa pilotar
			int pos = (int) (Math.random() * pilotos.size());
			mision.getPersonal().add(pilotos.get(pos));
			// Añadir 2 astronautas no repetidos
			for (int i = 0; i < 2; i++) {
				do {
					pos = (int) (Math.random() * astronautas.size());
				} while (mision.getPersonal().contains(astronautas.get(pos)));
				mision.getPersonal().add(astronautas.get(pos));
			}
			// Añadir 25 tierra
			for (int i = 0; i < 25; i++) {
				do {
					pos = (int) (Math.random() * tierras.size());
				} while (mision.getPersonal().contains(tierras.get(pos)));
				mision.getPersonal().add(tierras.get(pos));
			}
		}
	}
	
	public void asignarPersonalComplicado() {
		for (Mision mision : misiones) {
			// Añadir 3 astronautas, 1 que sepa PILOTAR
			Personal pilotar;
			do {
				int pos = (int) (Math.random() * personal.size());
				pilotar = personal.get(pos);
			} while (!(pilotar instanceof Astronauta) || ((Astronauta) pilotar).getHabilidades().contains(Habilidad.PILOTAR));
			mision.getPersonal().add(pilotar);
			for (int i = 0; i < 2; i++) {
				// Añadir un astronauta
				Personal p;
				do {
					int pos = (int) (Math.random() * personal.size());
					p = personal.get(pos);
				} while (!(p instanceof Astronauta) || mision.getPersonal().contains(p));
				mision.getPersonal().add(p);
			}
			// Añadir 25 personal de tierra
			for (int i = 0; i < 25; i++) {
				// Añadir un personal de tierra
				Personal p;
				do {
					int pos = (int) (Math.random() * personal.size());
					p = personal.get(pos);
				} while (!(p instanceof Tierra) || mision.getPersonal().contains(p));
				mision.getPersonal().add(p);
			}
		}
	}
	
	// TAREA 3A: costesPorPais
	public HashMap<String, Double> costesPorPais() {
		HashMap<String, Double> mapa = new HashMap<>();
		
		for (Personal p : personal) {
			double coste = p.getCoste();
			String pais = p.getPais();
			
			if (!mapa.containsKey(pais)) {
				mapa.put(pais, 0.0);
			}
			
			mapa.put(pais, mapa.get(pais) + coste);
		}
		
		for (Mision mision : misiones) {
			Nave nave = mision.getNave();
			double coste = nave.getCoste();
			String pais = "";
			
			if (nave.getProveedor().equals("Arianespace")) {
				pais = "France";
			} else if (nave.getProveedor().equals("SpaceX")) {
				pais = "USA";
			} else {
				pais = "Russia";
			}
			
			if (!mapa.containsKey(pais)) {
				mapa.put(pais, 0.0);
			}
			
			mapa.put(pais, mapa.get(pais) + coste);
		}
		
		return mapa;
	}

	// TAREA 3B: destinosPorCoste
	public void destinosPorCoste() {
		TreeMap<String, TreeSet<Mision>> mapa = new TreeMap<>();
		
		for (Mision mision : misiones) {
			String destino = mision.getDestino();
			
			if (!mapa.containsKey(destino)) {
				mapa.put(destino, new TreeSet<Mision>());
			}
			
			mapa.get(destino).add(mision);
		}
		
		for (String destino : mapa.keySet()) {
			TreeSet<Mision> valor = mapa.get(destino);
			System.out.println("Misiones a " + destino + "...");
			for (Mision mision : valor) {
				System.out.println(mision);
			}
		}
	}

}
