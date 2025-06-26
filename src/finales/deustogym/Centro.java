package finales.deustogym;

import java.util.ArrayList;
import java.util.List;

public class Centro {
    private String nombre;
    private String direccion;
    private int capacidad;
    private List<Entrenador> entrenadores;
    private List<Miembro> miembros;
    private List<Actividad> actividades;

    public Centro(String nombre, String direccion, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.entrenadores = new ArrayList<>();
        this.miembros = new ArrayList<>();
        this.actividades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void addEntrenador(Entrenador e) {
        entrenadores.add(e);
        e.setCentroAsignado(this);
    }

    public void addMiembro(Miembro m) {
        miembros.add(m);
    }

    public void addActividad(Actividad a) {
        actividades.add(a);
    }
}