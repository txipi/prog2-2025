package tema0.primerospasos;

public class Longitud {

	public static void main(String[] args) {
		double velocidad = 4;
		double angulo = 45;
		double g = 9.81;
		
		double longitud = Math.pow(velocidad, 2) * Math.sin(2*Math.toRadians(angulo)) / g;
		
		System.out.println("Una persona que salte con un ángulo de "
				+ angulo + "º a "+velocidad+" m/s en un planeta con g = "
				+ g + " m/s2 recorrería "+longitud+" m.");
	}

}
