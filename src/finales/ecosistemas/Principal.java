package finales.ecosistemas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Ecosistema> ecosistemas = new ArrayList<Ecosistema>();
		ArrayList<Organismo> organismos = new ArrayList<Organismo>();
		
		cargarOrganismosCSV(organismos);	
		System.out.println(organismos);
		
		ecosistemas = generarEcosistemas(organismos);
		ecosistemas = generarEcosistemasViables(organismos);
		System.out.println(ecosistemas.get(0));
		
		double media = calcularEdadMaxMedia(ecosistemas.get(0));
		System.out.println("EdadMax media del primer ecosistema: " + media);
		
		ecosistemas.sort(null);

		guardarEcosistemas(ecosistemas);
		
		System.out.println(ecosistemaMasLongevo(ecosistemas));
		
	}
	
	private static void guardarEcosistemas(ArrayList<Ecosistema> ecosistemas) {
		try {
			FileOutputStream fos = new FileOutputStream("ecosistemas.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ecosistemas);
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	private static Ecosistema ecosistemaMasLongevo(ArrayList<Ecosistema> ecosistemas) {
		Ecosistema mayor = ecosistemas.get(0);
		
		for (Ecosistema ecosistema : ecosistemas) {
			if (ecosistema.getLongevidad() > mayor.getLongevidad()) {
				mayor = ecosistema;
			}
		}
		
		return mayor;
	}
	
	private static HashMap<Clima, ArrayList<Ecosistema>> agruparEcosistemasPorClima(ArrayList<Ecosistema> ecosistemas) {
		HashMap<Clima, ArrayList<Ecosistema>> mapa = new HashMap<Clima, ArrayList<Ecosistema>>();
		
		for (Ecosistema ecosistema : ecosistemas) {
			Clima clima = ecosistema.getClima();
			
			if (!mapa.containsKey(clima)) {
				mapa.put(clima, new ArrayList<Ecosistema>());
			}
			
			mapa.get(clima).add(ecosistema);
		}
		
		return mapa;
	}

	private static double calcularEdadMaxMedia(Ecosistema ecosistema) {
		HashMap<TipoOrganismo, Double> mapa = calcularEdadesMaxMedias(ecosistema);
		
		TipoOrganismo mayor_clave = TipoOrganismo.PLANTA;
		Double mayor_valor = 0.0;
		
		for (TipoOrganismo clave : mapa.keySet()) {
			Double valor = mapa.get(clave);
			if (valor > mayor_valor) {
				mayor_clave = clave;
				mayor_valor = valor;
			}
		}
		
		return mayor_valor;
	}
	
	private static HashMap<TipoOrganismo, Double> calcularEdadesMaxMedias(Ecosistema ecosistema) {
		HashMap<TipoOrganismo, Double> medias = new HashMap<>();

		for (TipoOrganismo clave : ecosistema.getOrganismos().keySet()) {
			ArrayList<Organismo> valor = ecosistema.getOrganismos().get(clave);
			// Calcular la media
			double media = 0.0;
			for (Organismo organismo : valor) {
				media += organismo.getEdadMax();
			}
			media = media / valor.size();
			// Añadir la media al mapa de medias
			medias.put(clave, media);
		}
		
		return medias;
	}
	
	private static boolean puedeVivir(Organismo organismo, Clima clima,
			HashMap<TipoOrganismo, ArrayList<Organismo>> orgs) {
		boolean puede = false;
		
		// Si el clima es compatible...
		if (organismo.getClimas().contains(clima)) {
			if (organismo instanceof Planta) {
				// Todas las plantas del clima apropiado son viables
				puede = true;
			} else if (organismo instanceof Herbivoro) {
				// Un herbívoro solo es viable si existe alguna planta que pueda comer
				Herbivoro herbivoro = (Herbivoro) organismo;
				ArrayList<Organismo> plantas = orgs.get(TipoOrganismo.PLANTA);
				if (plantas != null) {
					for (Organismo planta : herbivoro.getAlimentacion()) {
						if (plantas.contains(planta)) {
							puede = true;
							break;
						}
					}
				}
			} else if (organismo instanceof Carnivoro) {
				// Un carnívoro solo es viable si existe algún animal que pueda comer
				Carnivoro carnivoro = (Carnivoro) organismo;
				// getOrDefault nos da la lista que pedimos o, si no está, una lista vacía
				ArrayList<Organismo> herbivoros = orgs.getOrDefault(TipoOrganismo.HERBIVORO, new ArrayList<Organismo>());
				ArrayList<Organismo> animales = orgs.getOrDefault(TipoOrganismo.CARNIVORO, new ArrayList<Organismo>());
				animales.addAll(herbivoros); // concatenamos las dos listas					
				for (Organismo animal : carnivoro.getAlimentacion()) {
					if (animales.contains(animal)) {
						puede = true;
						break;
					}
				}
			}
		}
		return puede;
	}

	private static ArrayList<Ecosistema> generarEcosistemasViables(ArrayList<Organismo> organismos) {
		ArrayList<Ecosistema> ecosistemas = new ArrayList<Ecosistema>();
		
		for (int i = 0; i < 100; i++) {
			// agua aleatoria de 10000 a 20000 m3
			double agua = 10000 + Math.random() * 10000;
			// clima aleatorio entre todos los de Clima.values()
			int alea = (int) (Math.random() * Clima.values().length);
			Clima clima = Clima.values()[alea];
			// mapa de organismos
			HashMap<TipoOrganismo, ArrayList<Organismo>> orgs = new HashMap<>();
			
			for (int j = 0; j < 30; j++) {
				// Elegir un organismo aleatorio que sea viable en este ecosistema
				Organismo organismo;
				do {
					int aleat = (int) (Math.random() * organismos.size());
					organismo = organismos.get(aleat);
				} while (!puedeVivir(organismo, clima, orgs));
				
				// Añadir el organismo al mapa orgs
				TipoOrganismo tipo;
				
				if (organismo instanceof Planta) {
					tipo = TipoOrganismo.PLANTA;
				} else if (organismo instanceof Herbivoro) {
					tipo = TipoOrganismo.HERBIVORO;
				} else {
					tipo = TipoOrganismo.CARNIVORO;
				}
				
				if (orgs.containsKey(tipo)) {
					// Añadir el organismo a la lista orgs.get(tipo)
					orgs.get(tipo).add(organismo);
				} else {
					// Crear la lista y añadir
					orgs.put(tipo, new ArrayList<Organismo>());
					orgs.get(tipo).add(organismo);
				}
				
			}
			
			Ecosistema ecosistema = new Ecosistema(agua, clima, orgs);
			
			ecosistemas.add(ecosistema);
		}
		
		return ecosistemas;
	}

	private static ArrayList<Ecosistema> generarEcosistemas(ArrayList<Organismo> organismos) {
		ArrayList<Ecosistema> ecosistemas = new ArrayList<Ecosistema>();
		
		for (int i = 0; i < 100; i++) {
			int agua = (int) (Math.random() * 5000) + 1000;
			int alea = (int) (Math.random() * Clima.values().length);
			Clima clima = Clima.values()[alea];
			HashMap<TipoOrganismo, ArrayList<Organismo>> orgs = new HashMap<>();
			
			// Meter carnivoros en orgs
			orgs.put(TipoOrganismo.CARNIVORO, new ArrayList<Organismo>());
			for (int j = 0; j < 5; j++) {
				Carnivoro carnivoro = null;
				Collections.shuffle(organismos);
				// Encontrar un carnívoro
				for (Organismo organismo : organismos) {
					if (organismo instanceof Carnivoro) {
						carnivoro = (Carnivoro) organismo;
						break;
					}
				}
				
				orgs.get(TipoOrganismo.CARNIVORO).add(carnivoro);
			}
			// Meter herbivoros en orgs
			orgs.put(TipoOrganismo.HERBIVORO, new ArrayList<Organismo>());
			for (int j = 0; j < 10; j++) {
				Herbivoro herbivoro = null;
				// Encontrar un herbivoro
				for (Organismo organismo : organismos) {
					if (organismo instanceof Herbivoro) {
						herbivoro = (Herbivoro) organismo;
						break;
					}
				}
				orgs.get(TipoOrganismo.HERBIVORO).add(herbivoro);
			}
			
			// Meter plantas en orgs
			orgs.put(TipoOrganismo.PLANTA, new ArrayList<Organismo>());
			for (int j = 0; j < 15; j++) {
				Planta planta = null;
				// Encontrar una planta
				for (Organismo organismo : organismos) {
					if (organismo instanceof Planta) {
						planta = (Planta) organismo;
						break;
					}
				}
				orgs.get(TipoOrganismo.PLANTA).add(planta);
			}
			
			Ecosistema ecosistema = new Ecosistema(agua, clima, orgs);
			ecosistemas.add(ecosistema);
		}
		
		return ecosistemas;
	}

	private static void cargarOrganismosCSV(ArrayList<Organismo> organismos) {
		File f = new File("organismos.csv");
		try {
			Scanner sc = new Scanner(f);
			
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				String tipo = campos[0];
				String especie = campos[1];
				double edad = Double.parseDouble(campos[2]);
				double edadMin = Double.parseDouble(campos[3]);
				double edadMax = Double.parseDouble(campos[4]);
				int reproduccion = Integer.parseInt(campos[5]);
				String climas = campos[6];
				String alimentacion = campos[7];
				
				Organismo nuevo;
				
				// Preparamos la lista de climas a partir del String climas...
				ArrayList<Clima> listaClimas = new ArrayList<Clima>();
				
				for (String clima : climas.split(",")) {
					listaClimas.add(Clima.valueOf(clima));
				}
				
				// Creamos el organismo en función de su tipo
				if (tipo.equals("Planta")) {
					// Planta
					nuevo = new Planta(especie, listaClimas, edadMin, edadMax, reproduccion, Double.parseDouble(alimentacion));
				} else if (tipo.equals("Herbivoro")) {
					// Herbivoro
					// Falta añadir las plantas a la alimentación de este herbívoro
					String[] plantas = alimentacion.split(",");
					ArrayList<Planta> alim = new ArrayList<Planta>();
					for (String planta : plantas) {
						for (Organismo organismo : organismos) {
							if (organismo.getEspecie().equals(planta)) {
								alim.add((Planta) organismo);
							}
						}
					}
					nuevo = new Herbivoro(especie, listaClimas, edadMin, edadMax, reproduccion, alim);
				} else {
					// Carnivoro
					// Falta añadir los animales a la alimentación de este herbívoro
					String[] animales = alimentacion.split(",");
					ArrayList<Animal> alim = new ArrayList<Animal>();
					for (String animal : animales) {
						for (Organismo organismo : organismos) {
							if (organismo.getEspecie().equals(animal)) {
								alim.add((Animal) organismo);
							}
						}
					}
					nuevo = new Carnivoro(especie, listaClimas, edadMin, edadMax, reproduccion, alim);
					
				}
				
				organismos.add(nuevo);
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static boolean comePlantas(String alimentacion, ArrayList<Organismo> organismos) {
		boolean hayPlantas = false;
		
		for (String nombre : alimentacion.split(",")) {
			for (Organismo organismo : organismos) {
				if (organismo.getEspecie().equals(nombre) && organismo instanceof Planta) {
					hayPlantas = true;
					break;
				}
			}
		}
		
		return hayPlantas;
	}

}
