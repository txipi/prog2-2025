package tema1.agenda;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Agenda {
	// Atributos
	private String nombre;
	private ArrayList<Contacto> contactos;
	
	// Metodos
	public Agenda(String nombre, ArrayList<Contacto> contactos) {
		super();
		this.nombre = nombre;
		this.contactos = contactos;
	}
	
	public Agenda() {
		super();
		this.nombre = "";
		this.contactos = new ArrayList();
	}

	public void editar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre de la agenda: ");
		this.nombre = sc.nextLine();
		sc.close();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

	@Override
	public String toString() {
		return "Agenda [nombre=" + nombre + ", contactos=" + contactos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactos, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return Objects.equals(contactos, other.contactos) && Objects.equals(nombre, other.nombre);
	}
	
}
