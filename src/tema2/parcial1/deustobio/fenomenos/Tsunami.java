package tema2.parcial1.deustobio.fenomenos;
import java.time.LocalDate;

import tema2.parcial1.deustobio.Predecible;

public class Tsunami extends FenomenoNatural implements Predecible {
	protected double velocidad;
	protected double alturaMaxima;
	protected boolean alarma;
	
	public Tsunami(String nombre, LocalDate fecha, int duracion, float velocidad, float alturaMaxima) {
		// EJERCICIO 1A
		super(nombre, fecha, duracion);
		this.velocidad = velocidad;
		this.alturaMaxima = alturaMaxima;
		this.alarma = false;
	}

	public Tsunami() {
		// EJERCICIO 1A
		super();
		this.velocidad = 0;
		this.alturaMaxima = 0;
		this.alarma = false;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public double getAlturaMaxima() {
		return alturaMaxima;
	}
	public void setAlturaMaxima(double alturaMaxima) {
		this.alturaMaxima = alturaMaxima;
	}

	@Override
	public String toString() {
		return "Tsunami [velocidad=" + velocidad + ", alturaMaxima=" + alturaMaxima + "]" + super.toString();
	}

	@Override
	public boolean isAlarma() {
		return this.alarma;
	}

	@Override
	public void generarAlarma() {
		System.out.println("Alarma activada para fenómeno Tsunami - <"+nombre+">");
		this.alarma = true;
	}

	@Override
	public void desactivarAlarma() {
		System.out.println("Alarma desactivada para fenómeno Tsunami - <"+nombre+">");
		this.alarma = false;
	}

	@Override
	public void setValoresAleatorio() {
		this.velocidad = Math.random() * 120;
		this.alturaMaxima = Math.random();
	}
	
}
