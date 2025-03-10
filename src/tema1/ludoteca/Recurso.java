package tema1.ludoteca;

public abstract class Recurso {
	// static: global para todos los recursos
	public static int contador = 1;

	// atributo solamente de this (NO static)
	protected int codigo;
	
	public Recurso() {
		super();
		this.codigo = Recurso.contador;
		Recurso.contador++;
	}

	@Override
	public String toString() {
		return "Recurso";
	}
	
	public abstract boolean esFamiliar();
	
}
