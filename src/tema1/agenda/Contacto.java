package tema1.agenda;

import java.util.Objects;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Contacto {
	// Atributos
	private String nombre;
	private String telefono;
	private String email;
	
	// Métodos
	public Contacto(String nombre, String telefono, String email) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
	
	public Contacto() {
		super();
		this.nombre = "";
		this.telefono = "";
		this.email = "";
	}
	
	public void editarVentanas() {
		this.nombre = JOptionPane.showInputDialog("Introduce el nombre del contacto:");
		this.telefono = JOptionPane.showInputDialog("Introduce el teléfono del contacto:");
		this.email = JOptionPane.showInputDialog("Introduce el email del contacto:");
	}
	
	public void mostrar() {
		JOptionPane.showMessageDialog(null, this.getNombre() + "\n" + this.getTelefono() + "\n" + this.getEmail());
	}

	public void editar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del contacto: ");
		this.nombre = sc.nextLine();
		System.out.println("Introduce el teléfono del contacto: ");
		this.telefono = sc.nextLine();
		System.out.println("Introduce el email del contacto: ");
		this.email = sc.nextLine();
		sc.close();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return Objects.equals(email, other.email) && Objects.equals(telefono, other.telefono);
	}
	
}
