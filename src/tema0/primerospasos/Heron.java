package tema0.primerospasos;

public class Heron {

	public static void main(String[] args) {
		double a = 11;
		double b = 13;
		double c = 17;

		double s = (a + b + c) / 2; // Semisuma de a+b+c
		double area = Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Raíz de s(s-a)(s-b)(s.c)

		System.out.println(area);
	}

}
