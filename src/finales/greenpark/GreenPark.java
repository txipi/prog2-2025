package finales.greenpark;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class GreenPark {
    private List<Parque> parques;
    private List<Personal> personal;
    private List<Proyecto> proyectos;

    public GreenPark() {
        parques = new ArrayList<>();
        personal = new ArrayList<>();
        proyectos = new ArrayList<>();
    }

    public List<Parque> getParques() {
        return parques;
    }

    public List<Personal> getPersonal() {
        return personal;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    /**
     * Carga los datos de parques desde un fichero CSV.
     * Formato esperado: Nombre;País;Día;Mes;Año;Hectáreas
     */
    public void cargarParquesCSV(String nombreFichero) {
        try {
        	File f = new File(nombreFichero);
        	Scanner sc = new Scanner(f);
        	
        	while (sc.hasNextLine()) {
        		String linea = sc.nextLine();
        		String[] campos = linea.split(";");
        		
        		try {
	        		LocalDate fecha = LocalDate.of(Integer.parseInt(campos[4]), Integer.parseInt(campos[3]), Integer.parseInt(campos[2]));
	        		double hectareas = Double.parseDouble(campos[5]);
	        		
	        		Parque p = new Parque(campos[0], campos[1], fecha, hectareas);
	        		
	        		this.parques.add(p);
        		} catch (ArrayIndexOutOfBoundsException e) {
        			System.err.println("Error: línea incompleta en el fichero " + nombreFichero);
        		} catch (DateTimeException e) {
        			System.err.println("Error: fecha incorrecta en el fichero " + nombreFichero);
        		} catch (NumberFormatException e) {
        			System.err.println("Error: número incorrecto en el fichero " + nombreFichero);
        		}
        	}
        	
        	sc.close();
        } catch (IOException e) {
        	System.err.println(e);
        }
    }

    /**
     * Carga los datos de personal desde un fichero CSV.
     * Formato esperado: Tipo;Nombre;País
     */
    public void cargarPersonalCSV(String nombreFichero) {
    	try {
        	File f = new File(nombreFichero);
        	Scanner sc = new Scanner(f);
        	
        	while (sc.hasNextLine()) {
        		String linea = sc.nextLine();
        		String[] campos = linea.split(";");
        		
        		Personal p;
        		
        		if (campos[0].equals("Botánico")) {
        			p = new Botanico(campos[1], campos[2], campos[3]);
        		} else if (campos[0].equals("Guarda")) {
        			ArrayList<String> carnets = new ArrayList<String>();
        			for (String carnet : campos[3].split(",")) {
        				carnets.add(carnet);
        			}
        			p = new Guarda(campos[1], campos[2], carnets);
        		} else {
        			p = new IngAmbiental(campos[1], campos[2], Integer.parseInt(campos[3]));
        		}
        		
        		this.personal.add(p);
        	}
        	
        	sc.close();
        } catch (IOException e) {
        	System.err.println(e);
        }
    }

    /**
     * Asigna aleatoriamente personal a los parques siguiendo las restricciones:
     * - 2 botánicos, 2 guardas y 1 ingeniero ambiental por parque
     */
    public void asignarPersonalAleatorio() {
        for (Parque parque : parques) {
        	Personal p = null;
			// Añadir 2 Botánicos aleatorios
        	for (int i = 0; i < 2; i++) {
            	do {
            		int pos = (int) (Math.random() * personal.size());
            		p = personal.get(pos);
            	} while (!(p instanceof Botanico) || parque.getPersonalAsignado().contains(p));
            	parque.getPersonalAsignado().add(p);				
			}
        	
        	// Añadir 2 Guardas
        	for (int i = 0; i < 2; i++) {
        		do {
        			int pos = (int) (Math.random() * personal.size());
        			p = personal.get(pos);
        		} while (!(p instanceof Guarda) || parque.getPersonalAsignado().contains(p));
        		parque.getPersonalAsignado().add(p);
        	}
        	
        	// Añadir 1 IngAmbiental
        	do {
        		int pos = (int) (Math.random() * personal.size());
        		p = personal.get(pos);
        	} while (!(p instanceof IngAmbiental));
        	parque.getPersonalAsignado().add(p);
		}
    }

    /**
     * Muestra los parques ordenados por coste total (ascendente).
     */
    public void mostrarParquesPorCoste() {
        parques.sort(null);
        for (Parque parque : parques) {
			System.out.println(parque);
		}
    }

    /**
     * Devuelve un mapa ordenado alfabeticamente por país con el coste total de proyectos por país.
     */
    public Map<String, Double> mapaCostePorPais() {
        TreeMap<String, Double> mapa = new TreeMap<>();
        
        for (Parque parque : parques) {
        	String pais = parque.getPais();
        	Double presupuesto = parque.getCosteTotal();
        	
        	if (!mapa.containsKey(pais)) {
        		mapa.put(pais, 0.0);
        	}
        	
        	mapa.put(pais, mapa.get(pais) + presupuesto);
		}
        
        return mapa;
    }

    /**
     * Muestra por consola los proyectos agrupados por tipo y ordenados por presupuesto.
     */
    public void proyectosPorTipo() {
        HashMap<TipoProyecto, ArrayList<Proyecto>> mapa = new HashMap<>();
        
        for (Parque parque : parques) {
			for (Proyecto proyecto : parque.getProyectos()) {
				TipoProyecto tipo = proyecto.getTipo();
				
				if (!mapa.containsKey(tipo)) {
					mapa.put(tipo, new ArrayList<Proyecto>());
				}
				
				mapa.get(tipo).add(proyecto);
			}
		}
        
        for (TipoProyecto clave : mapa.keySet()) {
        	ArrayList<Proyecto> valor = mapa.get(clave);
        	
        	valor.sort(null);
        	
        	System.out.println("Proyectos de tipo " + clave);
        	
        	for (Proyecto proyecto : valor) {
        		System.out.println(proyecto);
        	}
        }
        
        /* Vaciar colas:
         * 
         * LinkedList<Proyecto> cola = new LinkedList<Proyecto>();
         * 
         * llenarCola(cola);
         * 
         * while (!cola.isEmpty()) {
         * 		Proyecto primero = cola.removeFirst();
         * 		System.out.println(primero);
         * }
         * 
         */
    }
    
    public void exportarResumenCSV(String nombreFichero) {
    	try {
    		PrintWriter pw = new PrintWriter(nombreFichero);
    		for (Parque parque : parques) {
    			pw.println(parque.getNombre() + ";" + 
					parque.getPais() + ";" + 
					parque.getProyectos().size() + ";" +
					parque.getCosteTotal() + ";");
    		}
//    		for (Personal p : personal) {
//    			if (p instanceof Guarda) {
//    				pw.println("Guarda;" + p.getNombre() + ";");
//    			} else if (p instanceof Botanico) {
//    				pw.println("Botanico;" + p.getNombre() + ";");
//    			} else {
//    				pw.println("IngAmbiental;" + p.getNombre() + ";");
//    			}
//    		}
    		pw.close();
    	} catch (IOException e) {
    		System.err.println(e);
    	}
    }
}