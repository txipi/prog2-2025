package tema4.parcial2.deustopintxos;

import java.io.File;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DeustoPintxos {
	
	// TAREA 1A: cargarProductosCSV
	private static Set<Producto> cargarProductosCSV() {
		HashSet<Producto> resultado = new HashSet<Producto>();
		
		// Leer datos desde fichero de texto
		try {
			// Abrir el fichero
			File fichero = new File("deustopintxos.csv");
			Scanner sc = new Scanner(fichero);
			
			// Leer el fichero
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(",");
				String tipo = campos[0];

				String nombre = campos[1];
				double precio = Double.parseDouble(campos[2]);
				
				if (tipo.equals("Bebida")) {
					// Creamos una bebida
					double grados = Double.parseDouble(campos[3]);
					Bebida bebida = new Bebida(nombre, precio, grados);
					resultado.add(bebida);
				} else {
					// Creamos un pintxo
					boolean caliente = Boolean.parseBoolean(campos[3]);
					Pintxo pintxo = new Pintxo(nombre, precio, caliente);
					resultado.add(pintxo);
				}
			}
			
			// Cerrar el fichero
			sc.close();
		} catch (Exception e) {
			System.err.println("Error al cargar datos desde deustopintxos.csv");
		}
		
		return resultado;
	}
	
	// TAREA 1B: generarPedidos
	private static void generarPedidos(Set<Producto> productos, List<Bar> bares) {
		ArrayList<Producto> lista = new ArrayList(productos);
		for (Bar bar : bares) {
			for (Dia dia : Dia.values()) {
				for (int i = 0; i < 100; i++) {
					// Crear un pedido
					int codigo = (int) (Math.random() * 1000000);
					HashMap<Producto, Integer> prods = new HashMap<>();
					// Añadir 5 productos aleatorios de lista a prods
					for (int j = 0; j < 5; j++) {
						int pos = (int) (Math.random() * lista.size());
						Producto producto = lista.get(pos);
						prods.put(producto, 5);						
					}
					
					Pedido pedido = new Pedido(codigo, dia, prods);
					// Añadir el pedido al bar
					bar.getPedidos().add(pedido);
				}
			}
		}
	}
	
	// TAREA 2D: diaMayorRecaudacion
	private static Dia diaMayorRecaudacion(List<Bar> bares) {
		// Aunar todas las recaudaciones de todos los bares en un mapa
		HashMap<Dia, Double> mapa = new HashMap<>();
		
		for (Bar bar : bares) {
			for (Dia dia : Dia.values()) {
				// Cuánto hemos ganado en este bar en este día
				double dinero = bar.getRecaudacion().get(dia);
				// Sumar este dinero al mapa
				if (!mapa.containsKey(dia)) {
					mapa.put(dia, 0.0);
				}
				mapa.put(dia, mapa.get(dia) + dinero);
			}
		}
		
		// Calcular el mayor del mapa
		Dia mayor_clave = Dia.LUNES;
		Double mayor_valor = 0.0;
		
		for (Dia clave : mapa.keySet()) {
			Double valor = mapa.get(clave);
			if (valor > mayor_valor) {
				mayor_valor = valor;
				mayor_clave = clave;
			}
		}
		
		return mayor_clave;
	}
	
	public static void main(String[] args) {
		Set<Producto> productos = new HashSet<Producto>();
		List<Bar> bares = new ArrayList<Bar>();
		
		// TAREA 1A: cargarProductosCSV
		productos = cargarProductosCSV();
		
		// Creamos los 4 bares
		String[] nombres = {"Kupela", "Zaharra", "Sagarra", "Epelde"};
		for (String nombre : nombres) {
			bares.add(new Bar(nombre));
		}
		
		// TAREA 1B: generarPedidos
		generarPedidos(productos, bares);

		// Descomenta esta linea solamente si no has sabido hacer la TAREA 1
		//datosIniciales(productos, bares);

		System.out.println(productos);
		System.out.println(bares);
		
		// TAREA 2C: recorre la lista de bares, ejecuta cobrarPedidos y muestra como ha quedado la recaudacion
		for (Bar bar : bares) {
			bar.cobrarPedidos();
			System.out.println(bar.getNombre() + ": "+ bar.getRecaudacion());
		}
		
		// TAREA 2D: diaMayorRecaudacion
		System.out.println("El dia de mayor recaudacion ha sido el " + diaMayorRecaudacion(bares));
	}

	private static void datosIniciales(Set<Producto> productos, List<Bar> bares) {
		// IMPORTANTE: no copies parte de este codigo en tus soluciones. 
		// Este metodo esta programado de la manera mas manual posible y 
		// NO sera considerado como una solucion valida en tus tareas.
		
		productos.add(new Bebida("Txakoli", 1.50, 10.5));
		productos.add(new Bebida("Estrella Galicia", 1.75, 5.5));
		productos.add(new Bebida("Coca-cola", 1.75, 0.0));
		productos.add(new Bebida("Radler", 2.0, 3.5));
		productos.add(new Bebida("Verdejo", 1.50, 11.5));
		productos.add(new Bebida("Rioja", 1.50, 10.5));
		productos.add(new Bebida("Fanta", 1.75, 0.0));
		productos.add(new Bebida("Mosto", 1.25, 0.0));
		productos.add(new Pintxo("Gilda", 1.50, false));
		productos.add(new Pintxo("Tortilla", 2.25, true));
		productos.add(new Pintxo("Mejillon relleno", 1.75, true));
		productos.add(new Pintxo("Croqueta de boletus", 1.50, false));
		productos.add(new Pintxo("Champi", 1.50, true));
		productos.add(new Pintxo("Brocheta de gambas", 2.25, false));
		productos.add(new Pintxo("Tartaleta de txangurro", 1.50, false));
		productos.add(new Pintxo("Txapela", 1.50, false));
		
		HashMap<Producto, Integer> mapa1 = new HashMap<>();
		mapa1.put(new Pintxo("Tortilla", 2.25, true), 2);
		mapa1.put(new Pintxo("Txapela", 1.50, false), 1);
		HashMap<Producto, Integer> mapa2 = new HashMap<>();
		mapa2.put(new Bebida("Coca-cola", 1.75, 0.0), 1);
		mapa2.put(new Bebida("Txakoli", 1.50, 10.5), 2);
		HashMap<Producto, Integer> mapa3 = new HashMap<>();
		mapa3.put(new Pintxo("Tortilla", 2.25, true), 2);
		mapa3.put(new Bebida("Txakoli", 1.50, 10.5), 2);
		HashMap<Producto, Integer> mapa4 = new HashMap<>();
		mapa4.put(new Pintxo("Txapela", 1.50, false), 1);
		mapa4.put(new Bebida("Coca-cola", 1.75, 0.0), 1);
		HashMap<Producto, Integer> mapa5 = new HashMap<>();
		mapa5.put(new Pintxo("Txapela", 1.50, false), 1);
		mapa5.put(new Bebida("Coca-cola", 1.75, 0.0), 1);
		mapa5.put(new Bebida("Txakoli", 1.50, 10.5), 2);
		HashMap<Producto, Integer> mapa6 = new HashMap<>();
		mapa6.put(new Pintxo("Tortilla", 2.25, true), 2);
		mapa6.put(new Pintxo("Txapela", 1.50, false), 1);
		mapa6.put(new Bebida("Coca-cola", 1.75, 0.0), 1);
		HashMap<Producto, Integer> mapa7 = new HashMap<>();
		mapa7.put(new Pintxo("Tortilla", 2.25, true), 2);
		mapa7.put(new Pintxo("Txapela", 1.50, false), 1);
		mapa7.put(new Bebida("Coca-cola", 1.75, 0.0), 1);
		mapa7.put(new Bebida("Txakoli", 1.50, 10.5), 2);
		
		Pedido p1 = new Pedido(1, Dia.LUNES, mapa1);
		Pedido p2 = new Pedido(2, Dia.MARTES, mapa2);
		Pedido p3 = new Pedido(3, Dia.MIERCOLES, mapa3);
		Pedido p4 = new Pedido(4, Dia.JUEVES, mapa4);
		Pedido p5 = new Pedido(5, Dia.VIERNES, mapa5);
		Pedido p6 = new Pedido(6, Dia.SABADO, mapa6);
		Pedido p7 = new Pedido(7, Dia.DOMINGO, mapa7);
		
		String[] nombres = {"Kupela", "Zaharra", "Sagarra", "Epelde"};
		for (String nombre : nombres) {
			bares.add(new Bar(nombre));
		}
		
		for (Bar bar : bares) {
			bar.getPedidos().add(p1);
			bar.getPedidos().add(p2);
			bar.getPedidos().add(p3);
			bar.getPedidos().add(p4);
			bar.getPedidos().add(p5);
			bar.getPedidos().add(p6);
			bar.getPedidos().add(p7);
		}
	}

}
