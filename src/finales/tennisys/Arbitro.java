package finales.tennisys;

import java.io.Serializable;

class Arbitro implements Serializable {
    private String nombre;
    private int nivel;

    public Arbitro(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}
