package tema1.videojuego;

public abstract class Enemigo extends Personaje {
	protected int vida;
	protected String imagen;
	
	public Enemigo(double x, double y, int vida, String imagen) {
		super(x, y);
		this.vida = vida;
		this.imagen = imagen;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Enemigo [vida=" + vida + ", imagen=" + imagen + ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public void dibujar() {
		System.out.println(imagen);
	}

}
