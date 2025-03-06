package tema1.videojuego;

public class EnemigoEstatico extends Enemigo {

	public EnemigoEstatico(double x, double y, int vida, String imagen) {
		super(x, y, vida, imagen);
	}

	@Override
	public String toString() {
		return "EnemigoEstatico [vida=" + vida + ", imagen=" + imagen + ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public void actualizar() {

	}	
	
}
