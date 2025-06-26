package finales.deustogym;

import java.time.LocalDate;
import java.time.DateTimeException;
import java.util.*;

public class Miembro implements Facturable {
    private static int contadorSocios = 1000;

    private final int numeroSocio;
    private String nombre;
    private LocalDate fechaAlta;
    private TipoMembresia tipo;
    private ArrayList<Actividad> actividades;

    public Miembro(String nombre, LocalDate fechaAlta, TipoMembresia tipo) {
        if (fechaAlta == null || fechaAlta.isAfter(LocalDate.now())) {
            throw new DateTimeException("Fecha de alta inválida");
        }
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.tipo = tipo;
        contadorSocios++;
        this.numeroSocio = contadorSocios;
        this.actividades = new ArrayList<Actividad>();
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public TipoMembresia getTipo() {
        return tipo;
    }

    @Override
    public double getCuotaMensual() {
    	double cuota = 25;
    	
    	if (this.tipo.equals(TipoMembresia.PREMIUM)) {
    		cuota = 45;
    	} else if (this.tipo.equals(TipoMembresia.VIP)) {
    		cuota = 80;
    		if (this.fechaAlta.plusYears(2).isBefore(LocalDate.now())) {
    			cuota = 80 - 80 * 15 /100;
    		}
    	}
    	
    	return cuota;
    }

    @Override
    public boolean tieneDescuento() {
    	if (this.tipo.equals(TipoMembresia.VIP)) {
    		if (this.fechaAlta.plusYears(2).isBefore(LocalDate.now())) {
    			return true;
    		}
    	}
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Miembro)) return false;
        Miembro miembro = (Miembro) o;
        return numeroSocio == miembro.numeroSocio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroSocio);
    }

	public ArrayList<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setTipo(TipoMembresia tipo) {
		this.tipo = tipo;
	}
    
    
}