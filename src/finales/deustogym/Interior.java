package finales.deustogym;

public class Interior extends Actividad {
    private boolean requiereEquipamiento;

    public Interior(String nombre, int duracion, int nivel, boolean requiereEquipamiento) {
        super(nombre, duracion, nivel);
        this.requiereEquipamiento = requiereEquipamiento;
    }

    @Override
    public String getTipo() {
        return "INT-" + nombre;
    }

    @Override
    public boolean esApropiadaParaPrincipiante() {
        return !requiereEquipamiento && nivel <= 2;
    }

    public boolean isRequiereEquipamiento() {
        return requiereEquipamiento;
    }
}