package finales.deustogym;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Principal {
	public static void main(String[] args) {
        DeustoGym gimnasio = new DeustoGym();

        // 1. Cargar centros desde CSV
        gimnasio.cargarCentrosCSV("centros.csv");
        
        gimnasio.cargarActividadesCSV("actividades.csv");

        // 2. Mostrar miembros con descuento
//        System.out.println("Miembros con descuento:");
//        List<Miembro> conDescuento = gimnasio.getMiembrosConDescuento();
//        for (int i = 0; i < conDescuento.size(); i++) {
//            Miembro m = conDescuento.get(i);
//            System.out.println("- " + m.getNombre() + " (Socio #" + m.getNumeroSocio() + ")");
//        }
//        System.out.println();

        // 3. Ingresos por centro
//        System.out.println("Ingresos por centro:");
//        Map<String, Double> ingresos = gimnasio.ingresosPorCentro();
//        Set<String> claves = ingresos.keySet();
//        for (String centro : claves) {
//            Double total = ingresos.get(centro);
//            System.out.println("- " + centro + ": " + total + " €");
//        }
//        System.out.println();

        // 4. Actividades por dificultad
//        System.out.println("Actividades por dificultad:");
//        gimnasio.actividadesPorDificultad();
//        System.out.println();

        // 5. Actividad más rentable
//        System.out.println("Actividad más rentable:");
//        Actividad rentable = gimnasio.actividadMasRentable();
//        if (rentable != null) {
//            System.out.println("- " + rentable.getTipo() + ": " + rentable.getCuotaMensual() + " €");
//        }
//        System.out.println();

        // 6. Duración media de actividades
//        double media = gimnasio.mediaDuracionActividades();
//        System.out.println("Duración media de las actividades: " + media + " minutos");
//        System.out.println();

        // 7. Entrenadores ordenados
//        System.out.println("Entrenadores ordenados:");
//        List<Entrenador> listaEntrenadores = gimnasio.getEntrenadoresOrdenados();
//        for (int i = 0; i < listaEntrenadores.size(); i++) {
//            Entrenador e = listaEntrenadores.get(i);
//            System.out.println("- " + e.getNombre() + " (" + e.getAniosExperiencia() + " años)");
//        }
	}
}
