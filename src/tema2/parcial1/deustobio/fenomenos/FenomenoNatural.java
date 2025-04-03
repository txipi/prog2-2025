package tema2.parcial1.deustobio.fenomenos;
import java.time.LocalDate;
import java.util.Objects;

public abstract class FenomenoNatural {
	private static int contador = 1;
	
	protected int codigo;
	protected String nombre;
	protected LocalDate fecha;
	protected int duracion;
	
	public FenomenoNatural(String nombre, LocalDate fecha, int duracion) {
		// EJERCICIO 1
		this.codigo = FenomenoNatural.contador;
		FenomenoNatural.contador++;
		this.nombre = nombre;
		this.fecha = fecha;
		this.duracion = duracion;
	}
	
	public FenomenoNatural() {
		// EJERCICIO 1
		this.codigo = FenomenoNatural.contador;
		FenomenoNatural.contador++;
		this.nombre = "";
		this.fecha = LocalDate.now();
		this.duracion = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getCodigo() {
		return codigo;
	}

//	public void setCodigo( int codigo ) {
//		this.codigo = codigo;
//	}

	@Override
	public String toString() {
		return "Fenómeno Natural [codigo=" + codigo + ", nombre=" + nombre + ", fecha=" + fecha + ", duracion=" + duracion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FenomenoNatural other = (FenomenoNatural) obj;
		return codigo == other.codigo;
	}

	public abstract void setValoresAleatorio();
	
}
