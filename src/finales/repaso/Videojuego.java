package finales.repaso;

public class Videojuego extends Producto implements Online {
	protected Plataforma plataforma;

	public Videojuego(String nombre, String descripcion, double coste, Plataforma plataforma) {
		super(nombre, descripcion, coste);
		this.plataforma = plataforma;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	@Override
	public String toString() {
		return "Videojuego [plataforma=" + plataforma + ", codigo=" + codigo + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", coste=" + coste + "]";
	}

	@Override
	public boolean hayPromocion() {
		if (this.plataforma.equals(Plataforma.SWITCH) || this.plataforma.equals(Plataforma.PLAYSTATION4)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String accederWeb() {
		return "https://videojuegos.com/informacion/" + this.codigo;
	}
	
	
}
