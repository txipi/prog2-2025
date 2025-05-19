package finales.ecosistemas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Ecosistema {
	protected double agua;
	protected Clima clima;
	protected HashMap<TipoOrganismo, ArrayList<Organismo>> organismos;
	
	public Ecosistema(double agua, Clima clima, HashMap<TipoOrganismo, ArrayList<Organismo>> organismos) {
		super();
		this.agua = agua;
		this.clima = clima;
		this.organismos = organismos;
	}

	public double getAgua() {
		return agua;
	}

	public void setAgua(double agua) {
		this.agua = agua;
	}

	public Clima getClima() {
		return clima;
	}

	public void setClima(Clima clima) {
		this.clima = clima;
	}

	public HashMap<TipoOrganismo, ArrayList<Organismo>> getOrganismos() {
		return organismos;
	}

	public void setOrganismos(HashMap<TipoOrganismo, ArrayList<Organismo>> organismos) {
		this.organismos = organismos;
	}

	@Override
	public String toString() {
		return "Ecosistema [agua=" + agua + ", clima=" + clima + ", plantas=" + 
				organismos.get(TipoOrganismo.PLANTA).size() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(agua, clima, organismos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ecosistema other = (Ecosistema) obj;
		return Double.doubleToLongBits(agua) == Double.doubleToLongBits(other.agua) && clima == other.clima
				&& Objects.equals(organismos, other.organismos);
	}


}
