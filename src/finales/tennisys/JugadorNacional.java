package finales.tennisys;

class JugadorNacional extends Jugador {
    private int aniosEnActivo;

    public JugadorNacional(String nombre, int edad, int ranking, int aniosEnActivo) {
        super(nombre, edad, ranking);
        this.aniosEnActivo = aniosEnActivo;
    }

    @Override
    public double getFactorPromocion() {
        return aniosEnActivo * 1.5;
    }
}
