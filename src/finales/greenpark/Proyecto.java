package finales.greenpark;

import java.time.LocalDate;

class Proyecto implements Financiable, Comparable<Proyecto> {
    private String nombre;
    private TipoProyecto tipo; // Restauración, Educación, etc.
    private double presupuesto;
    private LocalDate fechaInicio;
    private Parque parque;

    public Proyecto(String nombre, TipoProyecto tipo, double presupuesto, LocalDate fechaInicio, Parque parque) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.parque = parque;
    }

    public double getCosteFinal() {
    	return this.presupuesto - this.presupuesto * this.getPorcentajeFinanciacion() / 100;
    }

	@Override
	public boolean esFinanciable() {
		if (this.tipo.equals(TipoProyecto.RESTAURACION) || this.tipo.equals(TipoProyecto.INVESTIGACION)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getPorcentajeFinanciacion() {
		if (this.esFinanciable()) {
			return 80;
		} else {
			return 0;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoProyecto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProyecto tipo) {
		this.tipo = tipo;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Parque getParque() {
		return parque;
	}

	public void setParque(Parque parque) {
		this.parque = parque;
	}

	@Override
	public String toString() {
		return "Proyecto [nombre=" + nombre + ", tipo=" + tipo + ", presupuesto=" + presupuesto + ", fechaInicio="
				+ fechaInicio + ", parque=" + parque + "]";
	}

	@Override
	public int compareTo(Proyecto other) {
		return (int) (other.presupuesto - this.presupuesto);
	}
	
}
