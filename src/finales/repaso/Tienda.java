package finales.repaso;

import java.util.ArrayList;
import java.util.Objects;

public class Tienda implements Online {
	protected String nombre;
	protected String direccion;
	protected ArrayList<Producto> producto;

	public Tienda(String nombre, String direccion, ArrayList<Producto> producto) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.producto = producto;
	}
	
	public Tienda(String nombre) {
		super();
		this.nombre = nombre;
		this.direccion = "";
		this.producto = new ArrayList<Producto>();
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

	public ArrayList<Producto> getProducto() {
		return producto;
	}

	public void setProducto(ArrayList<Producto> producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Tienda [nombre=" + nombre + ", direccion=" + direccion + ", producto=" + producto + "]";
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
	
}
