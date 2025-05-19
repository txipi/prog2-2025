package finales.ecosistemas;

import java.util.ArrayList;

public abstract class Animal extends Organismo {

	public Animal(String especie, ArrayList<Clima> climas, double edadMin, double edadMax, int reproduccion) {
		super(especie, climas, edadMin, edadMax, reproduccion);
	}
	
	public abstract ArrayList<Organismo> getAlimentacion();
}
