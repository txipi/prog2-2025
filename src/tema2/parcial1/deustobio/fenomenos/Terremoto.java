package tema2.parcial1.deustobio.fenomenos;
import java.time.LocalDate;
import java.util.Random;

import tema2.parcial1.deustobio.Predecible;

public class Terremoto extends Terrestre implements Predecible {
	protected double magnitud;
	protected boolean alarma;

	public Terremoto(String nombre, LocalDate fecha, int duracion, Continentes continente, double magnitud) {
		// EJERCICIO 1A
		super(nombre, fecha, duracion, continente);
		this.setMagnitud(magnitud);
	}

	public Terremoto() {
		// EJERCICIO 1A
		super();
		this.magnitud = 2;
	}

	public double getMagnitud() {
		return magnitud;
	}

	public void setMagnitud(double magnitud) {
		if (magnitud >= 2 && magnitud <= 6.9) {
			this.magnitud = magnitud;
		} else {
			System.err.println("Magnitud errónea: " + magnitud);
		}
	}

	@Override
	public String toString() {
		return "Terremoto [magnitud=" + magnitud + "]" + super.toString();
	}
	
	@Override
	public boolean isAlarma() {
		return this.alarma;
	}

	@Override
	public void generarAlarma() {
		System.out.println("Alarma activada para fenómeno Terremoto - <"+nombre+">");
		this.alarma = true;
	}

	@Override
	public void desactivarAlarma() {
		System.out.println("Alarma desactivada para fenómeno Terremoto - <"+nombre+">");
		this.alarma = false;
	}

	@Override
	public void setValoresAleatorio() {
		this.magnitud = Math.random() * 5 + 2;
	}
	
}
