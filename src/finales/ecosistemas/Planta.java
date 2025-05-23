package finales.ecosistemas;

import java.util.ArrayList;

public class Planta extends Organismo {
	protected double agua;

	public Planta(String especie, ArrayList<Clima> climas, double edadMin, double edadMax, int reproduccion,
			double agua) {
		super(especie, climas, edadMin, edadMax, reproduccion);
		this.agua = agua;
	}

	public double getAgua() {
		return agua;
	}

	public void setAgua(double agua) {
		this.agua = agua;
	}

	@Override
	public String toString() {
		return "Planta [agua=" + agua + ", especie=" + especie + ", climas=" + climas + ", edad=" + edad + ", edadMin="
				+ edadMin + ", edadMax=" + edadMax + ", reproduccion=" + reproduccion + "]";
	}
	
	
}
