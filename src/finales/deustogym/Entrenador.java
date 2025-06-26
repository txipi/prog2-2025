package finales.deustogym;

import java.util.ArrayList;
import java.util.List;

public class Entrenador {
    private String nombre;
    private String especialidad;
    private int aniosExperiencia;
    private List<String> certificaciones;
    private Centro centroAsignado;

    public Entrenador(String nombre, String especialidad, int aniosExperiencia, List<String> certificaciones) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.certificaciones = new ArrayList<>(certificaciones);
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public List<String> getCertificaciones() {
        return certificaciones;
    }

    public Centro getCentroAsignado() {
        return centroAsignado;
    }

    public void setCentroAsignado(Centro centroAsignado) {
        this.centroAsignado = centroAsignado;
    }

    @Override
    public String toString() {
        return nombre + " (" + aniosExperiencia + " años experiencia)";
    }
}

