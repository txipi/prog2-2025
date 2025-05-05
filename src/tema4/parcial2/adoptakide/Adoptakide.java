package tema4.parcial2.adoptakide;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;

public class Adoptakide {

    public static TreeSet<Animal> cargarAnimales(String rutaCSV) {
    	TreeSet<Animal> resultado = new TreeSet<Animal>();
    	
    	try {
    		File f = new File(rutaCSV);
    		Scanner sc = new Scanner(f);
    		
    		while (sc.hasNextLine()) {
    			String linea = sc.nextLine();
    			String[] campos = linea.split(";");
    			
    			String nombre = campos[0];
    			Especie especie = Especie.valueOf(campos[1].toUpperCase());
    			int edad = Integer.parseInt(campos[2]);
    			String chip = campos[3];
    			boolean necesidades = Boolean.parseBoolean(campos[4]);
    			
    			Animal animal = new Animal(nombre, especie, edad, chip, necesidades);
    			resultado.add(animal);
    		}
    		
    		sc.close();
    		
    	} catch (Exception e) {
    		System.out.println(e);
    		System.out.println("Error al cargar el fichero " + rutaCSV);
    	}
    	
    	return resultado;
    }

    public static ArrayList<Adopcion> registrarAdopciones(Set<Animal> animales) {
    	ArrayList<Adopcion> adopciones = new ArrayList<Adopcion>();
    	
    	try {
    		File f = new File("adopciones.csv");
    		Scanner sc = new Scanner(f);
    		
    		while (sc.hasNextLine()) {
    			String linea = sc.nextLine();
    			String[] campos = linea.split(";");
    			
    			String nombre = campos[0];
    			LocalDate fecha = LocalDate.now();
    			ArrayList<Animal> animalesAdoptados = new ArrayList<Animal>();
    			String[] chips = campos[2].split(",");
    			
    			for (String chip : chips) {
					// Buscar el animal que tiene este chip
    				Animal animal = null;
    				for (Animal a : animales) {
    					if (a.getChip().equals(chip)) {
    						animal = a;
    						break;
    					}
    				}
    				// Añadir el animal a animalesAdoptados
    				if (animal != null) {
    					animalesAdoptados.add(animal);
    				} else {
    					System.out.println("Error, no existe el animal con chip: " + chip);
    				}
				}
    			
    			Adopcion adopcion = new Adopcion(nombre, fecha, animalesAdoptados);
    			adopciones.add(adopcion);
    		}
    		
    		sc.close();
    	} catch (Exception e) {
    		System.out.println(e);
    		System.out.println("Error al cargar el fichero adopciones.csv");
    	}
    	
    	return adopciones;
    }
    
    public static HashMap<Especie, Integer> contarPorEspecie(List<Adopcion> adopciones) {
    	HashMap<Especie, Integer> mapa = new HashMap<Especie, Integer>();
    	
    	for (Adopcion adopcion : adopciones) {
			for (Animal animal : adopcion.getAnimalesAdoptados()) {
				Especie especie = animal.getEspecie();
				
				// Si el contador no existe en el mapa, lo creamos
				if (!mapa.containsKey(especie)) {
					mapa.put(especie, 0);
				}
				
				// Añadir 1 al contador
				mapa.put(especie, mapa.get(especie) + 1);
			}
		}
    	
    	return mapa;
    }

    public static TreeMap<Integer, ArrayList<Animal>> animalesPorEdad(List<Adopcion> listaAdopciones) {
    	TreeMap<Integer, ArrayList<Animal>> mapa = new TreeMap<Integer, ArrayList<Animal>>();
    	
    	for (Adopcion adopcion : listaAdopciones) {
			for (Animal animal : adopcion.getAnimalesAdoptados()) {
				int edad = animal.getEdad();
				
				// Si la lista de animales de esta edad no existe, la creo
				if (!mapa.containsKey(edad)) {
					mapa.put(edad, new ArrayList<Animal>());
				}
				
				// Añadir el animal a la lista correspondiente a esta edad
				mapa.get(edad).add(animal);
			}
		}
    	
    	return mapa;
    }

    public static void simulacionEntrega(List<Adopcion> adopciones) {
    	for (Adopcion adopcion : adopciones) {
			for (Animal animal : adopcion.getAnimalesAdoptados()) {
				if (animal.getEdad() < 2 && animal.tieneNecesidadesEspeciales()) {
					System.out.println(adopcion.getNombrePersona() + 
										" no puede adoptar a " + 
										animal.getNombre() + 
										" (necesidades especiales y menor de 2)");
				} else {
					System.out.println(adopcion.getNombrePersona() + 
										" recoge a " + 
										animal.getNombre());
				}
			}
		}
    }
    
    public static void exportarAnimalesPorEspecie(Set<Animal> animales) {
    	// Preparar el mapa que clasifica los animales por especie
    	HashMap<Especie, ArrayList<Animal>> mapa = new HashMap<>();
    	
    	for (Animal animal : animales) {
			Especie especie = animal.getEspecie();
			
			if (!mapa.containsKey(especie)) {
				mapa.put(especie, new ArrayList<Animal>());
			}
			
			mapa.get(especie).add(animal);
		}
    	
    	// Guardar el mapa en los diferentes ficheros
    	for (Especie clave : mapa.keySet()) {
    		ArrayList<Animal> valor = mapa.get(clave);
    		
    		try {
    			PrintWriter pw = new PrintWriter(clave + ".csv");
    			
    			for (Animal animal : valor) {
    				pw.println(animal.getNombre() + ";" +
    							animal.getEspecie() + ";" +
    							animal.getEdad() + ";" + 
    							animal.getChip() + ";" +
    							animal.tieneNecesidadesEspeciales());
    			}
    			
    			pw.close();
    		} catch (Exception e) {
    			System.out.println(e);
    		}
    	}
    }


    public static void main(String[] args) {
    	TreeSet<Animal> animales = cargarAnimales("animales.csv");
        System.out.println("Animales cargados: " + animales.size());
        List<Adopcion> adopciones = registrarAdopciones(animales);
        Map<Especie, Integer> mapaPorEspecie = contarPorEspecie(adopciones);
        for (Especie e : mapaPorEspecie.keySet()) {
            System.out.println(e + ":" + mapaPorEspecie.get(e));
        }
        Map<Integer, ArrayList<Animal>> mapaPorEdad = animalesPorEdad(adopciones);
        for (Integer e : mapaPorEdad.keySet()) {
            System.out.println(e + " años:");
            for (Animal a : mapaPorEdad.get(e)) {
            	System.out.println(a);
            }
        }
        simulacionEntrega(adopciones);
        exportarAnimalesPorEspecie(animales);
    }
}