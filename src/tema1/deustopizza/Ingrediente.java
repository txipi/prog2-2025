package tema1.deustopizza;

public class Ingrediente {
	private String nombre;
	private double precio;
	private double peso;
	
	public Ingrediente(String nombre, double precio, double peso) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.peso = peso;
	}
	
	public Ingrediente() {
		super();
		this.nombre = "";
		this.precio = 0;
		this.peso = 0;
	}
	
	public Ingrediente(Ingrediente i) {
		super();
		this.nombre = i.nombre;
		this.precio = i.precio;
		this.peso = i.peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Ingrediente [nombre=" + nombre + ", precio=" + precio + ", peso=" + peso + "]";
	}
	
	
}
