package finales.deustogym;

public class Exterior extends Actividad {
    private boolean dependeClima;

    public Exterior(String nombre, int duracion, int nivel, boolean dependeClima) {
        super(nombre, duracion, nivel);
        this.dependeClima = dependeClima;
    }

    @Override
    public String getTipo() {
        return "EXT-" + nombre;
    }

    @Override
    public boolean esApropiadaParaPrincipiante() {
        return !dependeClima && nivel <= 3;
    }

    public boolean isDependeClima() {
        return dependeClima;
    }
}