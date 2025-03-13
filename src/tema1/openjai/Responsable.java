package tema1.openjai;

public class Responsable extends Empleado {
	protected Departamento departamento;

	public Responsable(String nombre, Departamento departamento) {
		super(nombre);
		this.departamento = departamento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Responsable [departamento=" + departamento + ", nombre=" + nombre + ", id=" + id + "]";
	}
	
	
}
