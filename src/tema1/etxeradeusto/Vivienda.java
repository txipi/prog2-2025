package tema1.etxeradeusto;

public class Vivienda implements Reservable {
	protected static int contador = 1;
	
	protected int identificador;
	protected int metros;
	protected String direccion;
	protected String nombre;
	protected double precio;
	protected boolean disponibilidad;
	
	@Override
	public void reservar() {
		this.disponibilidad = false;
	}
	
	@Override
	public void cancelar() {
		this.disponibilidad = true;	
	}
	
}
