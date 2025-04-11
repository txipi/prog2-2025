package tema4.restaurantes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
		
		restaurantes.add(new Restaurante("Nerua", 5, 5));
		restaurantes.add(new Restaurante("Sua San", 3, 3));
		restaurantes.add(new Restaurante("Tagliatella", 2, 5));
		restaurantes.add(new Restaurante("Lurrina", 1, 4));
		restaurantes.add(new Restaurante("Asador Mikel", 4, 1));
		restaurantes.add(new Restaurante("Kia", 3, 2));
		restaurantes.add(new Restaurante("Gran Jardín", 4, 3));
		restaurantes.add(new Restaurante("Fusion", 5, 4));
		
		// Guardamos la lista en "restaurantes.csv"
		guardarRestaurantesCSV(restaurantes);
		
		// Cargamos la lista desde "restaurantes.csv"
		ArrayList<Restaurante> nueva = new ArrayList<Restaurante>();
		cargarRestaurantesCSV(nueva);
		System.out.println(nueva);
		
		// Guardar la lista en "restaurantes.dat"
		guardarRestaurantesBin(restaurantes);
		
		// Cargar la lista desde "restaurantes.dat"
		cargarRestaurantesBin(nueva);
		System.out.println(nueva);
	}

	public static void cargarRestaurantesBin(ArrayList<Restaurante> nueva) {
		// fis -> ois -> readObject
		try {
			FileInputStream fis = new FileInputStream("restaurantes.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			nueva = (ArrayList<Restaurante>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.err.println("Error al leer el fichero restaurantes.dat");
		}
	}

	public static void guardarRestaurantesBin(ArrayList<Restaurante> restaurantes) {
		// fos -> oos -> writeObject
		try {
			FileOutputStream fos = new FileOutputStream("restaurantes.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(restaurantes);
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println(e);
			System.err.println("Error al escribir el fichero restaurantes.dat");
		}
	}

	public static void cargarRestaurantesCSV(ArrayList<Restaurante> nueva) {
		// Leer datos desde fichero de texto
		try {
			// Abrir el fichero
			File fichero = new File("restaurantes.csv");
			Scanner sc = new Scanner(fichero);
			
			// Leer el fichero
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				String nombre = campos[0];
				int precio = Integer.parseInt(campos[1]);
				int calidad = Integer.parseInt(campos[2]);
				Restaurante restaurante = new Restaurante(nombre, precio, calidad);
				nueva.add(restaurante);
			}
			
			// Cerrar el fichero
			sc.close();
		} catch (Exception e) {
			System.err.println("Error al cargar datos desde restaurantes.csv");
		}
		
	}

	public static void guardarRestaurantesCSV(ArrayList<Restaurante> restaurantes) {
		// Escribir en un fichero de texto
		try {
			// Abrir/Crear fichero
			PrintWriter pw = new PrintWriter("restaurantes.csv");
			
			for (Restaurante restaurante : restaurantes) {
				pw.println(restaurante.getNombre()+";"+
						restaurante.getPrecio()+";"+
						restaurante.getCalidad());
			}
			
			// Cerrar fichero
			pw.close();
		} catch (Exception e) {
			System.err.println("Error al escribir en el fichero de restaurantes");
		}
	}

}
