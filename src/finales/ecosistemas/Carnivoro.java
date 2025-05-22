package finales.ecosistemas;

import java.util.ArrayList;

public class Carnivoro extends Animal {
	protected ArrayList<Animal> alimentacion;

	public Carnivoro(String especie, ArrayList<Clima> climas, double edadMin, double edadMax, int reproduccion,
			ArrayList<Animal> alimentacion) {
		super(especie, climas, edadMin, edadMax, reproduccion);
		this.alimentacion = alimentacion;
	}

	public ArrayList<Animal> getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(ArrayList<Animal> alimentacion) {
		this.alimentacion = alimentacion;
	}

	@Override
	public String toString() {
		return "Carnivoro [alimentacion=" + alimentacion + ", especie=" + especie + ", climas=" + climas + ", edad="
				+ edad + ", edadMin=" + edadMin + ", edadMax=" + edadMax + ", reproduccion=" + reproduccion + "]";
	}
	
	
}
