package tema4.parcial2.atracciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class DeustoAventura {

	public static void main(String[] args) {
		// Lista de atracciones de DeustoAventura
		Atraccion[] ats = {
				new Atraccion("Carrusel", 0, 50),
				new Atraccion("Montaña rusa", 140, 25),
				new Atraccion("Autos locos", 100, 35),
				new Atraccion("Mansión embrujada", 120, 15),
				new Atraccion("Water splash", 90, 40)
		};
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>(Arrays.asList(ats));

		// EJERCICIO 1: Cargar lista de visitantes de DeustoAventura
		ArrayList<Visitante> visitantes = cargaDatosVisitantes();
		System.out.println(visitantes.size()); // debería mostrar 50
		//Collections.sort(visitantes);
		System.out.println(visitantes); // debería mostrar la lista de visitantes ordenada por altura
		
		// EJERCICIO 2: Asignar atracciones a visitantes
		asignarAtracciones(atracciones, visitantes);
		System.out.println(visitantes.get(0)); // debería mostrar un visitante con 3 atracciones asignadas
		
		// EJERCICIO 3: Contar visitantes por tipo de entrada
		HashMap<Entrada, Integer> numeroPorEntrada = contarVisitantes(visitantes);
		System.out.println(numeroPorEntrada); // debería mostrar {VIP=8, EXPRESS=17, NORMAL=25}
		
		// EJERCICIO 4: Agrupar visitantes por atracción
		HashMap<Atraccion, LinkedList<Visitante>> visitantesPorAtraccion = agruparVisitantes(visitantes);
		System.out.println(visitantesPorAtraccion.get(atracciones.get(0)).size()); // debería mostrar un número aleatorio entre 0 y 50 
		
		// EJERCICIO 5: Simular el comportamiento de los visitantes
		//simularComportamiento(visitantesPorAtraccion);
		
		// EXTRA: Simular el comportamiento de los visitantes teniendo en cuenta la duración de las atracciones
		simularComportamientoExtra(visitantesPorAtraccion);
	}

	public static void simularComportamientoExtra(HashMap<Atraccion, LinkedList<Visitante>> visitantesPorAtraccion) {
		for (Atraccion atraccion : visitantesPorAtraccion.keySet()) {
			LinkedList<Visitante> cola = visitantesPorAtraccion.get(atraccion);
			
			cola.sort(new Comparator<Visitante>() {

				@Override
				public int compare(Visitante v1, Visitante v2) {
					return v1.getEntrada().compareTo(v2.getEntrada());
				}
				
			});
						
			System.out.println("Atracción " + atraccion.getNombre());
			
			int contador = 0;
			
			while (!cola.isEmpty()) {
				Visitante turno = cola.removeFirst();
				if (turno.getAltura() >= atraccion.getAltura()) {
					System.out.println("Entra " + turno);
					contador++;
					if (contador > atraccion.getCapacidad()) {
						if (!cola.isEmpty()) {
							System.out.println("Siguiente turno");
							contador = 0;
						}
					}
				} else {
					System.out.println(turno.getCodigo() + " no puede entrar por falta de altura");
				}
			}
		}
		
	}

	public static void simularComportamiento(HashMap<Atraccion, LinkedList<Visitante>> visitantesPorAtraccion) {
		for (Atraccion atraccion : visitantesPorAtraccion.keySet()) {
			LinkedList<Visitante> cola = visitantesPorAtraccion.get(atraccion);
			
			System.out.println("Atracción " + atraccion.getNombre());
			
			int contador = 0;
			
			while (!cola.isEmpty()) {
				Visitante turno = cola.removeFirst();
				if (turno.getAltura() >= atraccion.getAltura()) {
					System.out.println("Entra " + turno.getCodigo());
					contador++;
					if (contador > atraccion.getCapacidad()) {
						if (!cola.isEmpty()) {
							System.out.println("Siguiente turno");
							contador = 0;
						}
					}
				} else {
					System.out.println(turno.getCodigo() + " no puede entrar por falta de altura");
				}
			}
		}
	}

	public static HashMap<Atraccion, LinkedList<Visitante>> agruparVisitantes(ArrayList<Visitante> visitantes) {
		HashMap<Atraccion, LinkedList<Visitante>> mapa = new HashMap<>();
		
		for (Visitante visitante : visitantes) {
			for (Atraccion atraccion : visitante.getAtracciones()) {
				if (!mapa.containsKey(atraccion)) {
					mapa.put(atraccion, new LinkedList<Visitante>());
				}
				mapa.get(atraccion).add(visitante);
			}
		}
		
		return mapa;
	}

	public static HashMap<Entrada, Integer> contarVisitantes(ArrayList<Visitante> visitantes) {
		HashMap<Entrada, Integer> mapa = new HashMap<Entrada, Integer>();
		
		for (Visitante visitante : visitantes) {
			Entrada entrada = visitante.getEntrada();
			
			if (!mapa.containsKey(entrada)) {
				mapa.put(entrada, 0);
			}
			
			int valor = mapa.get(entrada);
			mapa.put(entrada, valor + 1);
		}
		
		return mapa;
	}

	public static void asignarAtracciones(ArrayList<Atraccion> atracciones, ArrayList<Visitante> visitantes) {
		for (Visitante visitante : visitantes) {
			// añadir 3 atracciones aleatorias y no repetidas
			while (visitante.getAtracciones().size() < 3) {
				// conseguir una atracción aleatoria
				int pos = (int) (Math.random() * atracciones.size());
				Atraccion atraccion = atracciones.get(pos);
				visitante.getAtracciones().add(atraccion);
			}
		}
	}

	public static ArrayList<Visitante> cargaDatosVisitantes() {
		ArrayList<Visitante> visitantes = new ArrayList<Visitante>();
		
		try {
			File f = new File("visitantes.csv");
			Scanner sc = new Scanner(f);
			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				int altura = Integer.parseInt(campos[0]);
				Entrada entrada = Entrada.valueOf(campos[1].toUpperCase());
				Visitante visitante = new Visitante(altura, entrada);
				visitantes.add(visitante);
			}
			
			sc.close();
		} catch (Exception e) {
			System.err.println("Error al leer los datos del fichero visitantes.csv");
		}
		
		return visitantes;
	}

	public static ArrayList<Visitante> cargaDatosVisitantes2() {
		ArrayList<Visitante> resultado = new ArrayList<Visitante>();
		for (int i = 0; i < 50; i++) {
			Entrada entrada = Entrada.NORMAL;
			if (i % 3 == 0) {
				entrada = Entrada.EXPRESS;
			} else if (i % 4 == 0) {
				entrada = Entrada.VIP;
			}  
			Visitante nuevo = new Visitante((int)(Math.random()*100)+100, entrada);
			resultado.add(nuevo);
		}
		return resultado;
	}

}
