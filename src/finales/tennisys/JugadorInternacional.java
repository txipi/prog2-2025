package finales.tennisys;

class JugadorInternacional extends Jugador {
    private String pais;
    private String patrocinador;

    public JugadorInternacional(String nombre, int edad, int ranking, String pais, String patrocinador) {
        super(nombre, edad, ranking);
        this.pais = pais;
        this.patrocinador = patrocinador;
    }

    @Override
    public double getFactorPromocion() {
        return ranking * 0.8;
    }

    public String getPais() {
        return pais;
    }
}