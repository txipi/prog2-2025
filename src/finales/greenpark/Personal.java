package finales.greenpark;

abstract class Personal {
    protected String nombre;
    protected String pais;

    public Personal(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }
}