package tema2.parcial1.deustobio.fenomenos;
import java.time.LocalDate;

public class Incendio extends Terrestre {
	protected double hectareas;
	protected boolean provocado;
	
	public Incendio(String nombre, LocalDate fecha, int duracion, Continentes continente, float hectareas, boolean provocado) {
		// EJERCICIO 1A
		super(nombre, fecha, duracion, continente);
		this.hectareas = hectareas;
		this.provocado = provocado;
	}

	public Incendio() {
		// EJERCICIO 1A
		super();
		this.hectareas = 0;
		this.provocado = false;
	}

	public double getHectareas() {
		return hectareas;
	}

	public void setHectareas(float hectareas) {
		this.hectareas = hectareas;
	}

	public boolean isProvocado() {
		return provocado;
	}

	public void setProvocado(boolean provocado) {
		this.provocado = provocado;
	}

	@Override
	public String toString() {
		return "Incendio [hectareas=" + hectareas + ", provocado=" + provocado + "]" + super.toString();
	}

	@Override
	public void setValoresAleatorio() {
		this.hectareas = Math.random() * 1000;
		// this.provocado = Math.random() > 0.5;
		if (Math.random() > 0.5) {
			this.provocado = true;
		} else {
			this.provocado = false;
		}
	}
	
	

}
