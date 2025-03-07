package tema1.ludo12345678Z;

import java.util.ArrayList;

public class Actividad implements Reservable {
	protected String descripcion;
	protected TipoActividad tipoActividad;
	protected int fecha;
	protected Trabajadora responsable;
	protected ArrayList<Usuaria> asistentes;
	
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
