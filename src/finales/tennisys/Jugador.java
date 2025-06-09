package finales.tennisys;

import java.io.Serializable;

abstract class Jugador implements Serializable {
    protected String nombre;
    protected int edad;
    protected int ranking;

    public Jugador(String nombre, int edad, int ranking) {
        this.nombre = nombre;
        this.edad = edad;
        this.ranking = ranking;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public abstract double getFactorPromocion();
}