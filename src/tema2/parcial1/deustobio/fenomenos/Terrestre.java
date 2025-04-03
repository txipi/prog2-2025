package tema2.parcial1.deustobio.fenomenos;
import java.time.LocalDate;

public abstract class Terrestre extends FenomenoNatural {
	protected Continentes continente;

	public Terrestre(String nombre, LocalDate fecha, int duracion, Continentes continente) {
		// EJERCICIO 1A
		super(nombre, fecha, duracion);
		this.continente = continente;
	}

	public Terrestre() {
		// EJERCICIO 1A
		super();
		Continentes[] todos = Continentes.values();
		int aleatorio = (int) (Math.random() * todos.length);
		Continentes continente = todos[aleatorio]; 
		this.continente = continente;
	}

	public Continentes getContinente() {
		return continente;
	}

	public void setContinente(Continentes continente) {
		this.continente = continente;
	}

	@Override
	public String toString() {
		return "Terrestre - continente=" + continente + "] " + super.toString();
	}
}
