package finales.ecosistemas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Organismo implements Serializable {
	protected String especie; // especie a la que pertenece.
	protected ArrayList<Clima> climas; // climas que soporta.
	protected double edad; // edad del organismo en años.
	protected double edadMin; // edad mínima para reproducirse.
	protected double edadMax; // edad máxima para vivir.
	protected int reproduccion; // número de nuevos organismos cuando se reproduce.
	
	public Organismo(String especie, ArrayList<Clima> climas, double edadMin, double edadMax,
			int reproduccion) {
		super();
		this.especie = especie;
		this.climas = climas;
		this.edad = 0;
		this.edadMin = edadMin;
		this.edadMax = edadMax;
		this.reproduccion = reproduccion;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public ArrayList<Clima> getClimas() {
		return climas;
	}

	public void setClimas(ArrayList<Clima> climas) {
		this.climas = climas;
	}

	public double getEdad() {
		return edad;
	}

	public void setEdad(double edad) {
		this.edad = edad;
	}

	public double getEdadMin() {
		return edadMin;
	}

	public void setEdadMin(double edadMin) {
		this.edadMin = edadMin;
	}

	public double getEdadMax() {
		return edadMax;
	}

	public void setEdadMax(double edadMax) {
		this.edadMax = edadMax;
	}

	public int getReproduccion() {
		return reproduccion;
	}

	public void setReproduccion(int reproduccion) {
		this.reproduccion = reproduccion;
	}

	@Override
	public String toString() {
		return "Organismo [especie=" + especie + ", climas=" + climas + ", edad=" + edad + ", edadMin=" + edadMin
				+ ", edadMax=" + edadMax + ", reproduccion=" + reproduccion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(climas, edad, edadMax, edadMin, especie, reproduccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organismo other = (Organismo) obj;
		return Objects.equals(climas, other.climas)
				&& Double.doubleToLongBits(edad) == Double.doubleToLongBits(other.edad)
				&& Double.doubleToLongBits(edadMax) == Double.doubleToLongBits(other.edadMax)
				&& Double.doubleToLongBits(edadMin) == Double.doubleToLongBits(other.edadMin)
				&& Objects.equals(especie, other.especie) && reproduccion == other.reproduccion;
	}

}
