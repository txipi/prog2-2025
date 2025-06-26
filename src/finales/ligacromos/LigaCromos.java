package finales.ligacromos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LigaCromos {

	private List<Jugador> listaJugadores;
	private List<Usuario> listaUsuarios;
	
	public LigaCromos(List<Jugador> listaJugadores, List<Usuario> listaUsuarios) {
		super();
		this.listaJugadores = listaJugadores;
		this.listaUsuarios = listaUsuarios;
	}
	public LigaCromos() {
		super();
		// TODO Auto-generated constructor stub
		listaJugadores = new ArrayList<Jugador>();
		listaUsuarios = new ArrayList<Usuario>();
	}
	public List<Jugador> getListaJugadores() {
		return listaJugadores;
	}
	public void setListaJugadores(List<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}
	public List<Usuario> getlistaUsuarios() {
		return listaUsuarios;
	}
	public void setlistaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	@Override
	public String toString() {
		return "LigaCromos [listaJugadores=" + listaJugadores + ", listaUsuarios=" + listaUsuarios + "]";
	}

	// Ejercicio 1: cargarJugadoresCSV() 
	public void cargarJugadoresCSV() {
		// Nombre;Posición;Equipo;Dorsal;Valor;Rareza
		try {
			File f = new File("jugadores.csv");
			Scanner sc = new Scanner(f);
			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				
				try {
					String nombre = campos[0];
					Posicion posicion = Posicion.valueOf(campos[1]);
					String equipo = campos[2];
					double valor = Double.parseDouble(campos[4]);
					Rareza rareza = Rareza.valueOf(campos[5]);
					int dorsal = Integer.parseInt(campos[3]);
					
					Jugador jugador = new Jugador(nombre, posicion, equipo, valor, rareza, dorsal);
					
					this.listaJugadores.add(jugador);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.err.println("Error, línea sin suficientes datos");
				} catch (NumberFormatException e) {
					System.err.println("Error al leer datos numéricos");
				} catch (IllegalArgumentException e) {
					System.err.println("No existe ese valor para tipo enumerado");
				}
			}
			
			sc.close();	
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	
	//Ejercicio 2: cargarUsuariosCSV()
	
	public Jugador buscarJugadorNombre(String nombre) {
		Jugador encontrado = null;
		
		for (Jugador jugador : listaJugadores) {
			if (jugador.getNombre().equals(nombre)) {
				encontrado = jugador;
				break;
			}
		}
		
		return encontrado;
	}
	
	public void cargarUsuariosCSV() {
		try {
			File f = new File("usuarios.csv");
			Scanner sc = new Scanner(f);
			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				
				try {
					String nombreUsuario = campos[0];
					String[] nombreJugadores = campos[1].split(",");
					
					ArrayList<Jugador> lista = new ArrayList<Jugador>();
					
					for (String nombre : nombreJugadores ) {
						Jugador encontrado = buscarJugadorNombre(nombre);
						lista.add(encontrado);
					}
					
					Usuario usuario = new Usuario(nombreUsuario, lista);
					
					this.listaUsuarios.add(usuario);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.err.println("Error, línea sin suficientes datos");
				} 
			}
			
			sc.close();	
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	//Ejercicio extra: generarCromos()
	// Genera 10 cromos nuevos para la colección
	public void generarCromos() {
		for (int i = 0; i < 10; i++) {
			// Nombre aleatorio combinando estos nombres
			// {"Jon", "Pedro", "Mikel", "Pablo", "Juan"}
			// y estos apellidos
			// {"García", "Pérez", "Agirre", "Landa", "Martínez"}
			ArrayList<String> listaNombres = new ArrayList<String>();
			listaNombres.add("Jon");
			listaNombres.add("Pedro");
			listaNombres.add("Mikel");
			listaNombres.add("Pablo");
			listaNombres.add("Juan");
			ArrayList<String> listaApellidos = new ArrayList<String>();
			listaApellidos.add("García");
			listaApellidos.add("Pérez");
			listaApellidos.add("Agirre");
			listaApellidos.add("Landa");
			listaApellidos.add("Martínez");
			int pos = (int) (Math.random() * listaNombres.size());
			String nombre = listaNombres.get(pos);
			pos = (int) (Math.random() * listaApellidos.size());
			String apellido = listaApellidos.get(pos);
			nombre = nombre + " " + apellido;
			
			// Posicion aletoria
			pos = (int) (Math.random() * Posicion.values().length);
			Posicion posicion = Posicion.values()[pos];
			
			// Equipo aleatorio entre estos valores:
			// Athletic Club, Real Sociedad, Alaves, Real Madrid, FC Barcelona
			ArrayList<String> listaEquipos = new ArrayList<String>();
			listaEquipos.add("Athletic Club");
			listaEquipos.add("Real Sociedad");
			listaEquipos.add("Alaves");
			listaEquipos.add("Real Madrid");
			listaEquipos.add("FC Barcelona");
			pos = (int) (Math.random() * listaEquipos.size());
			String equipo = listaEquipos.get(pos);
			
			// Valor aleatorio entre 50 y 100
			double valor = Math.random() * 50 + 50;
			
			// Rareza aleatoria
			pos = (int) (Math.random() * Rareza.values().length);
			Rareza rareza = Rareza.values()[pos];
			
			// Dorsal aleatorio de 1 a 30
			int dorsal = (int) (Math.random() * 30) + 1;
			
			Jugador jugador = new Jugador(nombre, posicion, equipo, valor, rareza, dorsal);
			this.listaJugadores.add(jugador);
		}
	}
	
	//Ejercicio 3: asignarCromosAleatorios()
	public void asignarCromosAleatorios() {
		for (Usuario usuario : listaUsuarios) {
			// añadir 10 cromos a este usuario
			for (int i = 0; i < 10; i++) {
				// añadir 1 cromo a este usuario
				Jugador jugador = null;
				do {
					int pos = (int) (Math.random() * listaJugadores.size());
					jugador = listaJugadores.get(pos);
				} while (usuario.getColeccion().contains(jugador));
				usuario.getColeccion().add(jugador);
			}
		}
	}
	
	//Ejercicio 7: jugadoresPorRareza() 
	public HashMap<Rareza, ArrayList<Jugador>> jugadoresPorRareza() {
		HashMap<Rareza, ArrayList<Jugador>> mapa = new HashMap<Rareza, ArrayList<Jugador>>();

		for (Jugador jugador : listaJugadores) {
			Rareza rareza = jugador.getRareza();
			
			if (!mapa.containsKey(rareza)) {
				mapa.put(rareza, new ArrayList<Jugador>());
			}
			
			mapa.get(rareza).add(jugador);
		}
		
		return mapa;
	}
	
	//Ejercicio 8: intercambiarCromo()
	public boolean intercambiarCromo(Usuario u1, Jugador j1, Usuario u2, Jugador j2) {
		boolean resultado = true;
		
		// Comprobar que u1 tiene al j1 y que u2 tiene al j2
		if (u1.getColeccion().contains(j1) && u2.getColeccion().contains(j2)) {
			// Intentamos el intercambio
			if (!u1.getColeccion().contains(j2) && !u2.getColeccion().contains(j1)) {
				// Se puede hacer el intercambio
				u1.getColeccion().remove(j1);
				u2.getColeccion().add(j1);
				u2.getColeccion().remove(j2);
				u1.getColeccion().add(j2);
			} else {
				resultado = false;
			}
		} else {
			resultado = false;
		}
		
		return resultado;
	}
	
	//Ejercicio 10: rarezaComun()
	public Rareza rarezaComun() {	
		// Contar cuántos cromos hay de cada rareza
		HashMap<Rareza, Integer> mapa = new HashMap<Rareza, Integer>();
		
		for (Usuario usuario : listaUsuarios) {
			for (Jugador jugador : usuario.getColeccion()) {
				Rareza r = jugador.getRareza();
				
				if (!mapa.containsKey(r)) {
					mapa.put(r, 0);
				}
				
				mapa.put(r, mapa.get(r) + 1);
			}
		}
		
		// Calcular la mayor_clave del mapa
		Rareza mayor_clave = Rareza.COMUN;
		int mayor_valor = 0;
		
		for (Rareza clave : mapa.keySet()) {
			Integer valor = mapa.get(clave);
			
			if (valor > mayor_valor) {
				mayor_clave = clave;
				mayor_valor = valor;
			}
		}
		
		return mayor_clave;
	}
	
	//Ejercicio 11: cromoMasCopias()
	
	
	//Ejercicio 12: agruparEquiposJugadores()
	public void agruparEquiposJugadores() {
		// Mapa agrupando jugadores por equipo
		TreeMap<String, ArrayList<Jugador>> mapa = new TreeMap<String, ArrayList<Jugador>>();
		
		for (Usuario usuario : listaUsuarios) {
			for (Jugador jugador : usuario.getColeccion()) {
				String equipo = jugador.getEquipo();
				
				if (!mapa.containsKey(equipo)) {
					mapa.put(equipo, new ArrayList<Jugador>());
				}
				
				if (!mapa.get(equipo).contains(jugador)) {
					mapa.get(equipo).add(jugador);
				}
			}
		}
		// Recorrer el mapa para mostrar los equipos
		for (String clave : mapa.keySet()) {
			ArrayList<Jugador> valor = mapa.get(clave);
			System.out.println("Equipo " +  clave);
			for (Jugador jugador : valor) {
				System.out.println(jugador);
			}
		}
	}
	
}
