package finales.ecosistemas;

import java.util.ArrayList;

public class Herbivoro extends Animal {
	protected ArrayList<Planta> alimentacion;
	
	public Herbivoro(String especie, ArrayList<Clima> climas, double edadMin, double edadMax, int reproduccion,
			ArrayList<Planta> alimentacion) {
		super(especie, climas, edadMin, edadMax, reproduccion);
		this.alimentacion = alimentacion;
	}

	public ArrayList<Planta> getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(ArrayList<Planta> alimentacion) {
		this.alimentacion = alimentacion;
	}

	@Override
	public String toString() {
		return "Herbivoro [alimentacion=" + alimentacion + ", especie=" + especie + ", climas=" + climas + ", edad="
				+ edad + ", edadMin=" + edadMin + ", edadMax=" + edadMax + ", reproduccion=" + reproduccion + "]";
	}
	
}
