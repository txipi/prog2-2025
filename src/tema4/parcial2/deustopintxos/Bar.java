package tema4.parcial2.deustopintxos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Bar {
	private String nombre;
	private LinkedList<Pedido> pedidos;
	// TAREA 2A: nuevo atributo recaudacion
	private HashMap<Dia, Double> recaudacion;
		
	public Bar(String nombre, LinkedList<Pedido> pedidos) {
		super();
		this.nombre = nombre;
		this.pedidos = new LinkedList<Pedido>(pedidos);
		this.recaudacion = new HashMap<>();
	}
	
	public Bar(String nombre) {
		super();
		this.nombre = nombre;
		this.pedidos = new LinkedList<Pedido>();
		this.recaudacion = new HashMap<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LinkedList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(LinkedList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public HashMap<Dia, Double> getRecaudacion() {
		return recaudacion;
	}

	@Override
	public String toString() {
		return "Bar " + nombre + ", " + pedidos.size() + " pedidos " + recaudacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bar other = (Bar) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	// TAREA 2C: metodo cobrarPedidos
	public void cobrarPedidos() {
		// Vaciar la cola de pedidos
		while (!pedidos.isEmpty()) {
			Pedido turno = pedidos.removeFirst();
			double dinero = turno.totalPedido();
			Dia dia = turno.getDia();
			// Actualizar la recaudación sumando el dinero
			// HashMap<Dia, Double> recaudacion;
			if (!recaudacion.containsKey(dia)) {
				recaudacion.put(dia, 0.0);
			}
			// Actualizamos la recaudación para este día
			recaudacion.put(dia, recaudacion.get(dia) + dinero);
		}
	}
}
