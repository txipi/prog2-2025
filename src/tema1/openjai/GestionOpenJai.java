package tema1.openjai;

import java.util.ArrayList;
import java.util.Arrays;

public class GestionOpenJai {

	public static void main(String[] args) {
		ArrayList<Responsable> responsables = new ArrayList<Responsable>();
		ArrayList<Desarrollador> desarrolladores = new ArrayList<Desarrollador>();
		ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
		
		Departamento[] departamentos = Departamento.values();
	
		for (int i = 0; i < 10; i++) {
			//ArrayList<Departamento> deps = new ArrayList<Departamento>(Arrays.asList(Departamento.values()));
			int aleatorio = (int) (Math.random() * departamentos.length);
			Departamento dep = departamentos[aleatorio];
			Responsable nuevo = new Responsable("Responsable-"+i, dep);
			responsables.add(nuevo);
		}

		Lenguaje[] lenguajes = Lenguaje.values();
		
		for (int i = 0; i < 20; i++) {
			ArrayList<Lenguaje> leng = new ArrayList<Lenguaje>();
			for (int j = 0; j < 3; j++) {
				int aleatorio = (int) (Math.random() * lenguajes.length);
				Lenguaje l = lenguajes[aleatorio];
				while (leng.contains(l)) {
					aleatorio = (int) (Math.random() * lenguajes.length);
					l = lenguajes[aleatorio];
				}
				leng.add(l);
			}
			Desarrollador nuevo = new Desarrollador("Desarrollador-"+i, leng);
			desarrolladores.add(nuevo);
		}
		
		for (int i = 0; i < 30; i++) {
			String nombre = "Proyecto-"+i;
			double horas = Math.random() * (1500 - 10) + 10;
			double coste = Math.random() * (150000 - 500) + 500;
			int alea = (int) (Math.random() * responsables.size());
			Responsable resp = responsables.get(alea);
			ArrayList<Desarrollador> des = new ArrayList<Desarrollador>();
			int n = 0;
			if (horas <= 100) {
				n = 1;
			} else if (horas <= 500) {
				n = 2;
			} else {
				n = 3;
			}
			for (int j = 0; j < n; j++) {
				alea = (int) (Math.random() * desarrolladores.size());
				Desarrollador d = desarrolladores.get(alea);
				while (des.contains(d)) {
					alea = (int) (Math.random() * desarrolladores.size());
					d = desarrolladores.get(alea);	
				}
				des.add(d);
			}
			Proyecto proyecto = new Proyecto(nombre, horas, coste, resp, des);
			proyectos.add(proyecto);
		} 
		
		actualizarHorasDesarrolladores(proyectos);
		
		for (int i = 0; i < 5; i++) {
			proyectos.get(i).financiar(100);
		}
	}

	public static void actualizarHorasDesarrolladores(ArrayList<Proyecto> proyectos) {
		for (Proyecto proyecto : proyectos) {
			for (Desarrollador desarrollador : proyecto.getDesarrolladores()) {
				double asignar = proyecto.getHoras()/proyecto.getDesarrolladores().size();
				double tiene = desarrollador.getHoras();
				double disponibles = tiene - asignar;
				desarrollador.setHoras(disponibles);
				if (disponibles  < 0) {
					System.out.println("Atención, el desarrollador " + desarrollador.getNombre() +
							" tiene " + disponibles + " horas disponibles");
				}
			}
		}
	}
	
}
