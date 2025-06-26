package finales.greenpark;

class Principal {
    public static void main(String[] args) {
        GreenPark gp = new GreenPark();

        gp.cargarParquesCSV("parques.csv");
        gp.cargarPersonalCSV("personal.csv");
        gp.asignarPersonalAleatorio();
        gp.mostrarParquesPorCoste();
        gp.exportarResumenCSV("resumen.csv");
    }
}
