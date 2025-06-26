package finales.deustogym;

public abstract class Actividad implements Facturable {
    protected String nombre;
    protected int duracion; // minutos
    protected int nivel; // 1-5

    public Actividad(String nombre, int duracion, int nivel) {
        this.nombre = nombre;
        this.duracion = duracion;
        if (nivel < 1 || nivel > 5)
            throw new IllegalArgumentException("Nivel debe estar entre 1 y 5");
        this.nivel = nivel;
    }

    public abstract String getTipo();

    public abstract boolean esApropiadaParaPrincipiante();

    @Override
    public double getCuotaMensual() {
    	double cuota = (this.duracion / 30) * 8;
    	if (this.nivel >= 4) {
    		cuota = cuota - cuota * 20 / 100;
    	}
    	return cuota;
    }

    @Override
    public boolean tieneDescuento() {
    	if (this.nivel >= 4) {
    		return true;
    	} else {
    		return false;
    	}
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getNivel() {
        return nivel;
    }
}
