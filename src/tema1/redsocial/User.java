package tema1.redsocial;

import java.util.Objects;

public class User {
	// Atributo para toda la clase: STATIC
	private static int contador = 0;
	
	// Atributos
	private int uid;
	private String nombre;
	
	// Métodos
	public User(String nombre) {
		super();
		this.uid = User.contador;
		User.contador++;
		this.nombre = nombre;
	}

	public int getUid() {
		return uid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(uid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return uid == other.uid;
	}
	
	
}
