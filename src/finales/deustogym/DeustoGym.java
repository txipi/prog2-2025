package finales.deustogym;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class DeustoGym {
    private List<Centro> centros = new ArrayList<>();
    private List<Miembro> miembros = new ArrayList<>();
    private List<Actividad> actividades = new ArrayList<>();
    private List<Entrenador> entrenadores = new ArrayList<>();

    // Getters y setters para las listas
    public List<Centro> getCentros() { return centros; }
    public List<Miembro> getMiembros() { return miembros; }
    public List<Actividad> getActividades() { return actividades; }
    public List<Entrenador> getEntrenadores() { return entrenadores; }

    public void addCentro(Centro c) { centros.add(c); }
    public void addMiembro(Miembro m) { miembros.add(m); }
    public void addActividad(Actividad a) { actividades.add(a); }
    public void addEntrenador(Entrenador e) { entrenadores.add(e); }

	public void cargarCentrosCSV(String ruta) {
		try {
			File f = new File(ruta);
			Scanner sc = new Scanner(f);
			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				
				String nombre = campos[0];
				String direccion = campos[1];
				int capacidad = Integer.parseInt(campos[2]);
				String[] entrenadores = campos[3].split("\\|");
				
				Centro centro = new Centro(nombre, direccion, capacidad);
				
				for (String nombreEnt : entrenadores) {
					Entrenador entrenador = new Entrenador(nombreEnt, "General", 1, new ArrayList<String>());
					// Si no lo tenemos en el centro, lo añadimos al centro
					if (!centro.getEntrenadores().contains(entrenador)) {
						centro.getEntrenadores().add(entrenador);
					}
					// Si no lo tenemos en DeustoGym, lo añadimos a DeustoGym
					if (!this.entrenadores.contains(entrenador)) {
						this.entrenadores.add(entrenador);
					}
				}
				
				centros.add(centro);
			}
			
			sc.close();
		} catch (IOException e) {
			System.err.println("Error al cargar el fichero " + ruta);
		}
	}
	
	public void cargarActividadesCSV(String ruta) {
		try {
			File f = new File(ruta);
			Scanner sc = new Scanner(f);
			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				
				String nombre = campos[0];
				int duracion = Integer.parseInt(campos[1]);
				int nivel = Integer.parseInt(campos[2]);
				String tipo = campos[3];
				boolean requiere = Boolean.parseBoolean(campos[4]);
				
				Actividad actividad;
				
				if (tipo.equals("INTERIOR")) {
					actividad = new Interior(nombre, duracion, nivel, requiere);
				} else {
					actividad = new Exterior(nombre, duracion, nivel, requiere);
				}
				
				actividades.add(actividad);
			}
			
			sc.close();
		} catch (IOException e) {
			System.err.println("Error al cargar el fichero " + ruta);
		}

	}
	
	public void crearMiembros() {
		for (Centro centro : centros) {
			for (int i = 0; i < 100; i++) {
				String nombre = "miembro" + i + centro.getNombre();
				LocalDate fecha = LocalDate.now();
				int pos = (int) (Math.random() * TipoMembresia.values().length);
				TipoMembresia tipo = TipoMembresia.values()[pos];
				Miembro miembro = new Miembro(nombre, fecha, tipo);
				// Apuntarle a 5 actividades no repetidas
				for (int j = 0; j < 5; j++) {
					Actividad actividad;
					do {
						int alea = (int) (Math.random() * this.actividades.size());
						actividad = this.actividades.get(alea);
					} while (miembro.getActividades().contains(actividad));
					miembro.getActividades().add(actividad);
				}
				centro.getMiembros().add(miembro);
			}
		}
	}

	public List<Miembro> getMiembrosConDescuento() {
		return null;
	}

	public Map<String, Double> ingresosPorCentro() {
		Map<String, Double> mapa = new HashMap<String, Double>();
		
		for (Centro centro : centros) {
			double total = 0;
			
			for (Miembro miembro : centro.getMiembros()) {
				total += miembro.getCuotaMensual();
				
				for (Actividad actividad : miembro.getActividades()) {
					total += actividad.getCuotaMensual();
				}
			}
			
			total += centro.getEntrenadores().size() * 500;
			
			mapa.put(centro.getNombre(), total);
		}
		
		return mapa;
	}

	public void actividadesPorDificultad() {
		TreeMap<Integer, TreeSet<String>> mapa = new TreeMap<>();
		
		for (Actividad actividad : actividades) {
			int nivel = actividad.getNivel();
			String nombre = actividad.getNombre();
			
			if (!mapa.containsKey(nivel)) {
				mapa.put(nivel, new TreeSet<String>());
			}
			
			mapa.get(nivel).add(nombre);
		}
		
		for (Integer clave : mapa.keySet()) {
			TreeSet<String> valor = mapa.get(clave);
			System.out.println("Nivel " + clave + ":");
			for (String nombre : valor) {
				System.out.println(" - " + nombre);
			}
		}
	}

	public Map<String, Double> duracionMediaPorTipo() {
		Map<String, Double> mapa = new HashMap<String, Double>();
		
		mapa.put("Interior", 0.0);
		mapa.put("Exterior", 0.0);
		
		double sumaInterior = 0;
		double sumaExterior = 0;
		int contadorInterior = 0;
		int contadorExterior = 0;
		
		for (Actividad actividad : actividades) {
			if (actividad instanceof Interior) {
				sumaInterior += actividad.getDuracion();
				contadorInterior++;
			} else {
				sumaExterior += actividad.getDuracion();
				contadorExterior++;
			}
		}
		
		mapa.put("Interior", sumaInterior / contadorInterior);
		mapa.put("Exterior", sumaExterior / contadorExterior);
		
		return mapa;
	}

    public List<Entrenador> getEntrenadoresOrdenados() {
        List<Entrenador> copia = new ArrayList<>(entrenadores);
        
        copia.sort(new Comparator<Entrenador>() {
			@Override
			public int compare(Entrenador e1, Entrenador e2) {
				if (e1.getAniosExperiencia() != e2.getAniosExperiencia()) {
					return e2.getAniosExperiencia() - e1.getAniosExperiencia();
				} else {
					return e1.getNombre().compareTo(e2.getNombre());
				}
			}
        });

        return copia;
    }

}

