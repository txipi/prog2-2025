package tema0.primerospasos;

import java.util.ArrayList;

public class Listas {

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList(); // numeros:list[int] = []
		
		numeros.add(1); // numeros.append(1)
		numeros.add(2); // numeros.append(2)
		numeros.add(3); // numeros.append(3)
		
		System.out.println(numeros); // print(numeros)
		
		// for-each
		for (Integer numero : numeros) {  // for numero in numeros:
			System.out.println(numero);   //     print(numero)
		}
		
		// for controlando el índice i
		for (int i = 0; i < numeros.size(); i++) { // for i in range(len(numeros)):
			System.out.println(numeros.get(i));    //     print(numeros[i])
		}
	}

}
