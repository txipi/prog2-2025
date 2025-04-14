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

	public void setRecaudacion(HashMap<Dia, Double> recaudacion) {
		this.recaudacion = recaudacion;
	}

	@Override
	public String toString() {
		return "Bar [nombre=" + nombre + ", pedidos=" + pedidos + ", recaudacion=" + recaudacion + "]";
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
		while(!this.pedidos.isEmpty()) {
			Pedido turno = this.pedidos.removeFirst();
			double total = turno.totalPedido();
			Dia dia = turno.getDia();
			
			if (this.recaudacion.containsKey(dia)) {
				// Si ya había un contador para este día sumamos lo que había y el total
				double valor = this.recaudacion.get(dia);
				this.recaudacion.put(dia, valor + total);
			} else {
				// Si no había un contador lo creamos
				this.recaudacion.put(dia, total);
			}
		}
	}
}
