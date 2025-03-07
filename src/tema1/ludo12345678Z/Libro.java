package tema1.ludo12345678Z;

public class Libro extends Recurso implements Reservable {
	protected String titulo;
	protected String autoria;
	protected String genero;
	protected Usuaria persona;
	
	@Override
	public boolean reservar(Usuaria usuaria) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean anular(Usuaria usuaria) {
		// TODO Auto-generated method stub
		return false;
	}
}
