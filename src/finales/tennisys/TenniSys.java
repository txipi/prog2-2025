package finales.tennisys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class TenniSys {
    private List<Torneo> torneos;
    private List<Jugador> jugadores;

    public TenniSys() {
        this.torneos = new ArrayList<>();
        this.jugadores = new ArrayList<>();
    }
    
    public void escribirTorneosBinario(String nombreArchivo) {
    	try {
    		FileOutputStream fos = new FileOutputStream(nombreArchivo); 
    		ObjectOutputStream oos = new ObjectOutputStream(fos); 
    		oos.writeObject(torneos);
    		oos.close();
    		fos.close();
    	} catch (Exception e) {
    		System.err.println(e);
    	}
    }

    public void leerTorneosBinario(String nombreArchivo) {
		try {
    		FileInputStream fis = new FileInputStream(nombreArchivo);
    		ObjectInputStream ois = new ObjectInputStream (fis);
			this.torneos = (List<Torneo>) ois.readObject();
    		ois.close();
    		fis.close();
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException e) {
			System.err.println(e);
			System.err.println("Error de entrada/salida");
		} catch (ClassNotFoundException  e) {
			System.err.println("Error al leer objeto");
		}

    }

    public void guardarRankingBinario(List<Jugador> lista, String nombreArchivo) {
    	try {
    		FileOutputStream fos = new FileOutputStream(nombreArchivo); 
    		ObjectOutputStream oos = new ObjectOutputStream(fos); 
    		oos.writeObject(lista);
    		oos.close();
    		fos.close();
    	} catch (FileNotFoundException e) {
    		System.err.println(e);
		} catch (IOException e) {
    		System.err.println(e);
		}
    }

    public String paisConMasTorneos() {
        TreeMap<String, Integer> mapa = new TreeMap<>();

        for (Torneo torneo : torneos) {
        	String pais = torneo.getUbicacion();
			
        	if (!mapa.containsKey(pais)) {
        		mapa.put(pais, 0);
        	}
        	
        	mapa.put(pais, mapa.get(pais) + 1);
		}
        
        String mayor_clave = "";
        int mayor_valor = 0;
        
        for (String clave : mapa.keySet()) {
        	int valor = mapa.get(clave);
        	if (valor > mayor_valor) {
        		mayor_clave = clave;
        		mayor_valor = valor;
        	}
        }
    	
        return mayor_clave;
    }

    public void ordenarPartidosPorDuracion() {
        ArrayList<Partido> partidos = new ArrayList<Partido>();
        
        for (Torneo torneo : torneos) {
        	partidos.addAll(torneo.getPartidos());
        }
        
        partidos.sort(new Comparator<Partido>() {
			@Override
			public int compare(Partido p1, Partido p2) {
				return p1.getDuracion() - p2.getDuracion();
			}
		});
        
        for (int i = 0; i < 5; i++) {
			System.out.println(partidos.get(i).getJugador1().getNombre() + " vs " + 
					partidos.get(i).getJugador2().getNombre() + ", " + 
					partidos.get(i).getDuracion() + " minutos");
		}
    }

    public List<Torneo> getTorneos() {
        return torneos;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}