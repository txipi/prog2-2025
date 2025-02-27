package tema1.agenda;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Contacto c1 = new Contacto();
		c1.editarVentanas();
		
		c1.mostrar();
		
		Agenda agendaUni = new Agenda();
		agendaUni.editar();
		
		// Añadimos el contacto c1 a la lista de contactos de agendaUni
		agendaUni.getContactos().add(c1);
		
		System.out.println(agendaUni);
		
		// Mostrar el teléfono del primer contacto de la agenda
		// agenda['contactos'][0]['telefono']
		System.out.println(agendaUni.getContactos().get(0).getTelefono());
	}

}
