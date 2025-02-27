package tema0.primerospasos;

public class Pared {

	public static void main(String[] args) {
		double altura = 3.0;
		double anchura = 10.0;
		int ventanas = 2;
		int puertas = 1;
		
		double superficie = altura * anchura - 1 * ventanas - 1.6 * puertas;
		double litros = superficie / 10;
		
		System.out.println("Una pared de "+altura+" m de alto y "+anchura+" m de "
				+ "ancho con "+ventanas+" ventanas y "+puertas+" puerta "
				+ "necesita "+litros+" litros de pintura.");
	}

}
