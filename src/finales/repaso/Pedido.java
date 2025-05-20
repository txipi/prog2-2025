package finales.repaso;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	private static int contador = 1;
	
	protected int codigo;
	protected String cliente;
	protected LocalDate fecha;
	protected ArrayList<Producto> productos;

	public Pedido(String cliente, LocalDate fecha, ArrayList<Producto> productos) {
		super();
		this.codigo = Pedido.contador;
		Pedido.contador++;
		this.cliente = cliente;
		this.fecha = fecha;
		this.productos = productos;
	}
	
	public Pedido() {
		super();
		this.codigo = Pedido.contador;
		Pedido.contador++;
		this.cliente = "";
		this.fecha = LocalDate.now();
		this.productos = new ArrayList<Producto>();
	}

	public int getCodigo() {
		return codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", cliente=" + cliente + ", fecha=" + fecha + ", productos=" + productos
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return codigo == other.codigo;
	}

	public double getIngresoTotal() {
		double total = 0;
		
		for (Producto producto : productos) {
			total += producto.getCoste();
		}
		
		return total;
	}
	
	
}
