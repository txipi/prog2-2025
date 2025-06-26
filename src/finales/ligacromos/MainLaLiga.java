package finales.ligacromos;

import java.util.Collections;
import java.util.HashMap;

public class MainLaLiga {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LigaCromos laLiga = new LigaCromos();
		
		laLiga.cargarJugadoresCSV();
		laLiga.cargarUsuariosCSV();
		
		laLiga.getlistaUsuarios().sort(null);
		
		for (Usuario usuario : laLiga.getlistaUsuarios()) {
			System.out.println(usuario.getNombreUsuario() 
					+ ": " + usuario.getValorTotal());
		}
		
	}

}
