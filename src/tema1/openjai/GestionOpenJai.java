package tema1.openjai;

import java.util.ArrayList;

public class GestionOpenJai {

	public static void main(String[] args) {
		ArrayList<Responsable> responsables = new ArrayList<Responsable>();
		
		for (int i = 0; i < 10; i++) {
			// TODO: Departamento aleatorio
			Departamento dep = Departamento.EDUCACION;
			Responsable nuevo = new Responsable("Responsable-"+i, dep);
			responsables.add(nuevo);
		}

	}

}
