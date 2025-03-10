package tema1.ludoteca;

import java.util.Objects;

public class Videoconsola extends Recurso {
	protected String marca;
	protected String modelo;
	
	public Videoconsola(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public Videoconsola() {
		super();
		this.marca = "Sin marca";
		this.modelo = "desconocido";
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca, modelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videoconsola other = (Videoconsola) obj;
		return Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo);
	}

	@Override
	public String toString() {
		return "Videoconsola [marca=" + marca + ", modelo=" + modelo + "]";
	}

	@Override
	public boolean esFamiliar() {
		if (this.marca.equals("Nintendo")) {
			return true;
		} else {
			return false;	
		}
	}
	
}
