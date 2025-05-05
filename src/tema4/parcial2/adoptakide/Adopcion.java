package tema4.parcial2.adoptakide;

import java.time.LocalDate;
import java.util.ArrayList;

public class Adopcion {
    private String nombrePersona;
    private LocalDate fecha;
    private ArrayList<Animal> animalesAdoptados;

    public Adopcion(String nombrePersona, LocalDate fecha, ArrayList<Animal> animalesAdoptados) {
        this.nombrePersona = nombrePersona;
        this.fecha = fecha;
        this.animalesAdoptados = animalesAdoptados;
    }

    public String getNombrePersona() { 
    	return nombrePersona; 
    }
    
    public LocalDate getFecha() { 
    	return fecha; 
    }
    
    public ArrayList<Animal> getAnimalesAdoptados() { 
    	return animalesAdoptados; 
    }

    @Override
    public String toString() {
        return nombrePersona + " adoptó " + animalesAdoptados.size() + " animal(es) el " + fecha;
    }
}
