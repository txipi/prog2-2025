package finales.repaso;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.TreeMap;

public class Tienda implements Online {
	protected String nombre;
	protected String direccion;
	protected ArrayList<Producto> productos;
	protected LinkedList<Pedido> pedidos;
	protected TreeMap<LocalDate, Double> ingresos;
	protected HashMap<LocalDate, ArrayList<Pedido>> pedidosPorDia;

	public Tienda(String nombre, String direccion, ArrayList<Producto> productos) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.productos = productos;
		this.pedidos = new LinkedList<Pedido>();
		this.ingresos = new TreeMap<LocalDate, Double>();
		this.pedidosPorDia = new HashMap<LocalDate, ArrayList<Pedido>>();
	}
	
	public Tienda(String nombre) {
		super();
		this.nombre = nombre;
		this.direccion = "";
		this.productos = new ArrayList<Producto>();
		this.pedidos = new LinkedList<Pedido>();
		this.ingresos = new TreeMap<LocalDate, Double>();
		this.pedidosPorDia = new HashMap<LocalDate, ArrayList<Pedido>>();		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public LinkedList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(LinkedList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public TreeMap<LocalDate, Double> getIngresos() {
		return ingresos;
	}

	public void setIngresos(TreeMap<LocalDate, Double> ingresos) {
		this.ingresos = ingresos;
	}

	public HashMap<LocalDate, ArrayList<Pedido>> getPedidosPorDia() {
		return pedidosPorDia;
	}

	public void setPedidosPorDia(HashMap<LocalDate, ArrayList<Pedido>> pedidosPorDia) {
		this.pedidosPorDia = pedidosPorDia;
	}

	@Override
	public String toString() {
		return "Tienda [nombre=" + nombre + ", direccion=" + direccion + ", producto=" + productos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(direccion, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tienda other = (Tienda) obj;
		return Objects.equals(direccion, other.direccion) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String accederWeb() {
		return "https://" + this.nombre + ".des.com/" ;
	}

	public void guardarPedidosBinario() {
		// Guardamos la cola de pedidos en pedidos.dat
		try {
			FileOutputStream fos = new FileOutputStream("pedidos.dat");  
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.pedidos);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.err.println(e);
			System.err.println("Error al guardar pedidos.dat");
		}	
	}
	
	public void cargarPedidosBinario() {
		// Cargamos la cola de pedidos desde pedidos.dat
		try {
			FileInputStream fis = new FileInputStream("pedidos.dat");  
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.pedidos = (LinkedList<Pedido>) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException e) {
			System.err.println(e);
			System.err.println("Error al leer pedidos.dat");
		} catch (ClassNotFoundException e) {
			System.err.println("Error al leer pedidos.dat: no contiene una lista de pedidos");
		}	
	}
	
	public void procesarPedidos() {
		while (!pedidos.isEmpty()) {
			// Obtenemos el elemento actual (primero)
			Pedido pedido = pedidos.removeFirst();
			// Utilizamos el elemento actual
			System.out.println("Procesando el pedido " + pedido.getCodigo());
			double ingresoTotal = pedido.getIngresoTotal();
			LocalDate fecha = pedido.getFecha();
			
			// Añadir ingresoTotal de este pedido al mapa de ingresos
			
			if (!this.ingresos.containsKey(fecha)) {
				this.ingresos.put(fecha, 0.0);
			}
			
			this.ingresos.put(fecha, this.ingresos.get(fecha) + ingresoTotal);
			
			// Añadir este pedido al mapa de pedidosPorDia
			
			if (!this.pedidosPorDia.containsKey(fecha)) {
				this.pedidosPorDia.put(fecha, new ArrayList<Pedido>());
			}
			
			this.pedidosPorDia.get(fecha).add(pedido);
		}
	}
}
