package tema2.parcial1.deustobio;

import java.util.ArrayList;

import tema2.parcial1.deustobio.fenomenos.Continentes;
import tema2.parcial1.deustobio.fenomenos.FenomenoNatural;
import tema2.parcial1.deustobio.fenomenos.Incendio;
import tema2.parcial1.deustobio.fenomenos.Terremoto;
import tema2.parcial1.deustobio.fenomenos.Terrestre;
import tema2.parcial1.deustobio.fenomenos.Tsunami;

public class DeustoBio {

	public static void main(String[] args) {
		// EJERCICIO 1B-A
		ArrayList<Experto> listaExpertos = new ArrayList<>();
		// DESCOMENTAR ESTA LÍNEA CUANDO ESTÉ RESUELTO EL EJERCICIO 1B-A
		generarListaExpertos(listaExpertos);
		
		// Código de comprobación en consola
		System.out.println(listaExpertos);
		System.out.println("_____________________");
		System.out.println("EJERCICIO - GENERAR LISTA DE EXPERTOS - COMPROBACIÓN");
		System.out.println("Tamaño: " + listaExpertos.size()); // Debe ser 10
		System.out.println("Nombre experto 3: " + listaExpertos.get(3).getNombre()); // Debe ser Experto-4
		System.out.println("Especialidad: " + listaExpertos.get(0).getEspecialidad()); // Debe ser TERRESTRE o MARITIMA
		System.out.println("Tamaño de la lista de un experto: " + listaExpertos.get(1).getFenomenos().size()); // Debe ser 0

		
		// EJERCICIO 1B-B
		ArrayList<FenomenoNatural> listaFenomenos = new ArrayList<>();
		//DESCOMENTAR CUANDO ESTÉ RESUELTO EL EJERCICIO - generarListaFenomenos
		generarListaFenomenos(listaFenomenos);
		
		//DESCOMENTAR CUANDO ESTÉ RESUELTO EL EJERCICIO PARA COMPROBACIÓN
		
		// Código de comprobación en consola
		System.out.println("EJERCICIO - GENERAR LISTA DE FENÓMENOS NATURALES - COMPROBACIÓN");
		System.out.println(listaFenomenos.size()); // Debe ser 30
		int contTsun = 0;
		int contTerrem = 0;
		int contIncend = 0;
		int contProvocados = 0;
		for(FenomenoNatural f: listaFenomenos) {
			if (f instanceof Tsunami)
				contTsun++;
			else if (f instanceof Terremoto)
				contTerrem++;
			else if (f instanceof Incendio) {
				contIncend++;
				if (((Incendio)f).isProvocado())
					contProvocados++;
			}
		}
		//Deberían variar en cada ejecución
		System.out.println("Incendios: " + contIncend);
		System.out.println("Incendios provocados: " + contProvocados);
		System.out.println("Terremotos: " + contTerrem);
		System.out.println("Tsunamis: " + contTsun);
		System.out.println(contIncend + contTerrem + contTsun);// Debe ser 30
		
		
		
		// EJERCICIO 1B-C
		System.out.println("EJERCICIO - ASIGNAR FENÓMENOS A LOS EXPERTOS - COMPROBACIÓN");
		//DESCOMENTAR CUANDO ESTÉ RESUELTO EL EJERCICIO - asignarFenomenoExperto
		//int contador = 0;
		int contador = asignarFenomenoExperto(listaFenomenos, listaExpertos);
		System.out.println(contador); //número entre 0 y 30
		int contAsignados = 0;
		for(Experto e: listaExpertos) { //Contamos el número de fenómenos en la lista de cada experto 
			contAsignados += e.getFenomenos().size();
		}
		System.out.println((contador == contAsignados));//true
		
		
		// EJERCICIO 1B-D
		System.out.println("EJERCICIO - CALCULAR HECTÁREAS AFECTADAS - COMPROBACIÓN");
		//DESCOMENTAR CUANDO ESTÉ RESUELTO EL EJERCICIO - calcularHectareasAfectadas
		System.out.println("Hectáreas afectadas: " + calcularHectareasAfectadas(listaExpertos));

		
		// EJERCICIO 1B-E
		// DESCOMENTAR PARA COMPROBAR - CUANDO ESTÉ RESUELTO EL EJERCICIO - obtenerFenomenosContinente
		System.out.println("EJERCICIO - COMPROBACIÓN FENOMENOS CONTINENTE DE UN EXPERTO");
		Experto e = null;
		int i=0;
		do {
			e = listaExpertos.get(i);
			if (e.getEspecialidad()==Especialidad.TERRESTRE) {
				break;
			} else {
				i++;
			}
		} while (i<listaExpertos.size());
		System.out.println("EUROPA: " + e.obtenerFenomenosContinente(Continentes.EUROPA).size() + " --> " + e.obtenerFenomenosContinente(Continentes.EUROPA));
		System.out.println("ASIA: " + e.obtenerFenomenosContinente(Continentes.ASIA).size());
		System.out.println("AMÉRICA: " + e.obtenerFenomenosContinente(Continentes.AMERICA).size());
		System.out.println("ÁFRICA: " + e.obtenerFenomenosContinente(Continentes.AFRICA).size());
		System.out.println("OCEANÍA: " + e.obtenerFenomenosContinente(Continentes.OCEANIA).size());
		System.out.println("Número de fenómenos del experto " + e.getNombre() + " = " + e.getFenomenos().size()); //El resultado debe ser igual a la suma de los 5 valores anteriores
		
		
		//EJERCICIO 1B-F
		//DESCOMENTAR CUANDO ESTÉ RESUELTO EL EJERCICIO - eliminarFenomenosMeses
		System.out.println("Fenómenos eliminados: " + eliminarFenomenosMeses(3, listaExpertos)); //30 fenómenos eliminados porque todos son de marzo
		System.out.println("Fenómenos eliminados: " + eliminarFenomenosMeses(1, listaExpertos)); //0 fenómenos eliminados porque todos son de marzo
	}
	
	public static int eliminarFenomenosMeses(int mes, ArrayList<Experto> listaExpertos) {
		int contador = 0;
		
		for (Experto experto : listaExpertos) {
			for (FenomenoNatural fenomeno : experto.getFenomenos()) {
				if (fenomeno.getFecha().getMonthValue() == mes) {
					// Borrar fenomeno
					// experto.getFenomenos().remove(fenomeno); -> DA ERROR
					contador++;
				}
			}
		}
		
		return contador;
	}

	private static double calcularHectareasAfectadas(ArrayList<Experto> listaExpertos) {
		double total = 0;
		
		for (Experto experto : listaExpertos) {
			for (FenomenoNatural fenomeno : experto.getFenomenos()) {
				if (fenomeno instanceof Incendio) {
					total += ((Incendio) fenomeno).getHectareas();
				}
			}
		}
		
		return total;
	}

	public static int asignarFenomenoExperto(ArrayList<FenomenoNatural> listaFenomenos,
			ArrayList<Experto> listaExpertos) {
		int contador = 0;
		
		for (FenomenoNatural fenomeno : listaFenomenos) {
			// Intentar asignarlo
			Especialidad espFenomeno;
			Especialidad espExperto;
			
			if (fenomeno instanceof Terrestre) {
				espFenomeno = Especialidad.TERRESTRE;
			} else {
				espFenomeno = Especialidad.MARITIMO;
			}
			
			// Buscar un experto que nos valga
			Experto expertoEncontrado = null; // Al principio, no tenemos a nadie
			for (Experto experto : listaExpertos) {
				espExperto = experto.getEspecialidad();
				if (espFenomeno == espExperto && experto.getFenomenos().size() < 5) {
					expertoEncontrado = experto;
					break;
				}				
			}
			
			if (expertoEncontrado != null) {
				// Asignar el experto al fenómeno
				expertoEncontrado.getFenomenos().add(fenomeno);
				// Si lo hemos podido asignar, sumamos 1 al contador
				contador++;
			}
		
		}
		
		return contador;
	}

	public static void generarListaFenomenos(ArrayList<FenomenoNatural> listaFenomenos) {
		for (int i = 0; i < 30; i++) {
			FenomenoNatural nuevo;
			double aleatorio = Math.random();
			
			if (aleatorio < 0.33) {
				// Crear un Tsunami
				nuevo = new Tsunami();
			} else if (aleatorio < 0.66) {
				// Crear un Terremoto
				nuevo = new Terremoto();
			} else {
				// Crear un Incendio
				nuevo = new Incendio();
			}
			
			nuevo.setValoresAleatorio();
			listaFenomenos.add(nuevo);
		}
	}

	public static void generarListaExpertos(ArrayList<Experto> listaExpertos) {
		for (int i = 0; i < 10; i++) {
			Experto nuevo = new Experto();
			nuevo.setNombre("Experto-"+(i+1));
			Especialidad[] todas = Especialidad.values();
			int aleatorio = (int) (Math.random() * todas.length); 
			nuevo.setEspecialidad(todas[aleatorio]);
			listaExpertos.add(nuevo);
		}
	}

	public static void generarListaExpertosCopy(ArrayList<Experto> lista) {
		lista.add(new Experto("Experto-1", Especialidad.MARITIMO, new ArrayList<>()));
		lista.add(new Experto("Experto-2", Especialidad.MARITIMO, new ArrayList<>()));
		lista.add(new Experto("Experto-3", Especialidad.MARITIMO, new ArrayList<>()));
		lista.add(new Experto("Experto-4", Especialidad.MARITIMO, new ArrayList<>()));
		lista.add(new Experto("Experto-5", Especialidad.MARITIMO, new ArrayList<>()));
		lista.add(new Experto("Experto-6", Especialidad.TERRESTRE, new ArrayList<>()));
		lista.add(new Experto("Experto-7", Especialidad.TERRESTRE, new ArrayList<>()));
		lista.add(new Experto("Experto-8", Especialidad.TERRESTRE, new ArrayList<>()));
		lista.add(new Experto("Experto-9", Especialidad.TERRESTRE, new ArrayList<>()));
		lista.add(new Experto("Experto-10", Especialidad.TERRESTRE, new ArrayList<>()));
	}

}
