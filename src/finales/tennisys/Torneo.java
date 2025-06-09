package finales.tennisys;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Torneo implements Serializable {
    private static final long serialVersionUID = 1L;
	private String nombre;
    private String ubicacion;
    private String categoria; // Grand Slam, ATP 500, etc.
    private LocalDate fecha;
    private List<Partido> partidos;

    public Torneo(String nombre, String ubicacion, String categoria, LocalDate fecha) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
        this.fecha = fecha;
        this.partidos = new ArrayList<>();
    }

    public void añadirPartido(Partido p) {
        partidos.add(p);
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getCategoria() {
        return categoria;
    }
}
