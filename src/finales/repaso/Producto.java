package finales.repaso;

import java.util.Objects;

public abstract class Producto {
	private static int contador = 1;
	
	protected int codigo;
	protected String nombre;
	protected String descripcion;
	protected double coste;

	public Producto(String nombre, String descripcion, double coste) {
		super();
		this.codigo = Producto.contador;
		Producto.contador++;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.coste = coste;
	}
	
	public Producto() {
		super();
		this.codigo = Producto.contador;
		Producto.contador++;
		this.nombre = "";
		this.descripcion = "";
		this.coste = 0.0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", coste=" + coste
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
		Producto other = (Producto) obj;
		return codigo == other.codigo;
	}

	public abstract boolean hayPromocion();
	
	
}
