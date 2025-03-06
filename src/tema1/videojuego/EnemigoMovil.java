package tema1.videojuego;

public class EnemigoMovil extends Enemigo {
	protected double vx;
	protected double vy;
	
	public EnemigoMovil(double x, double y, int vida, String imagen, double vx, double vy) {
		super(x, y, vida, imagen);
		this.vx = vx;
		this.vy = vy;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	@Override
	public String toString() {
		return "EnemigoMovil [vx=" + vx + ", vy=" + vy + ", vida=" + vida + ", imagen=" + imagen + ", x=" + x + ", y="
				+ y + "]";
	}

	@Override
	public void actualizar() {
		this.x = this.x + this.vx;
		this.y = this.y + this.vy;
	}
	
	
}
