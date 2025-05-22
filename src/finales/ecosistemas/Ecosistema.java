package finales.ecosistemas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Ecosistema implements Comparable<Ecosistema>, Serializable {
	protected double agua;
	protected Clima clima;
	protected HashMap<TipoOrganismo, ArrayList<Organismo>> organismos;
	
	public Ecosistema(double agua, Clima clima, HashMap<TipoOrganismo, ArrayList<Organismo>> organismos) {
		super();
		this.agua = agua;
		this.clima = clima;
		this.organismos = organismos;
	}
	
	public Ecosistema(Ecosistema e) {
		super();
		this.agua = e.agua;
		this.clima = e.clima;
		this.organismos = new HashMap<>();
		// Clonar el mapa
		for (TipoOrganismo clave : TipoOrganismo.values()) {
			this.organismos.put(clave, new ArrayList<>());
		}
		for (TipoOrganismo clave : e.organismos.keySet()) {
			ArrayList<Organismo> valor = e.organismos.get(clave);
			this.organismos.put(clave, new ArrayList<>(valor));
		}
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
	
	public double getEdadMediaOrganismos() {
		double total = 0.0;
		double contador = 0;
		
		// Recorremos este mapa:
		// HashMap<TipoOrganismo, ArrayList<Organismo>> organismos
		for (TipoOrganismo clave : organismos.keySet()) {
			ArrayList<Organismo> valor = organismos.get(clave);
			for (Organismo organismo : valor) {
				total += organismo.getEdad();
				contador++;
			}
		}
		
		return total / contador;
	}

	@Override
	public int compareTo(Ecosistema other) {
		return (int) (this.getEdadMediaOrganismos() - other.getEdadMediaOrganismos());
	}

	public Organismo buscarMayor(TipoOrganismo tipo) {
		ArrayList<Organismo> lista = this.organismos.get(tipo);
		Organismo organismo = lista.get(0);
		
		for (Organismo o : lista) {
			if (o.getEdad() > organismo.getEdad()) {
				organismo = o;
			}
		}
		
		return organismo;
	}
	
	public void simularAnyo() {
		LinkedList<Organismo> nacen = new LinkedList<Organismo>();
		LinkedList<Organismo> mueren = new LinkedList<Organismo>(); 
		for (TipoOrganismo clave : organismos.keySet()) {
			ArrayList<Organismo> valor = organismos.get(clave);
			for (Organismo organismo : valor) {
				// Añadimos un año a la edad de cada organismo
				organismo.setEdad(organismo.getEdad() + 1);
				// Simulamos la reproduccion
				if (organismo.getEdad() >= organismo.getEdadMin()) {
					for (int i = 0; i < organismo.getReproduccion(); i++) {
						Organismo nuevo;
						if (organismo instanceof Planta) {
							nuevo = new Planta(organismo.getEspecie(), organismo.getClimas(), organismo.getEdadMin(), organismo.getEdadMax(), organismo.getReproduccion(), ((Planta) organismo).getAgua());
						} else if (organismo instanceof Herbivoro) {
							nuevo = new Herbivoro(organismo.getEspecie(), organismo.getClimas(), organismo.getEdadMin(), organismo.getEdadMax(), organismo.getReproduccion(), ((Herbivoro) organismo).getAlimentacion());
						} else {
							nuevo = new Carnivoro(organismo.getEspecie(), organismo.getClimas(), organismo.getEdadMin(), organismo.getEdadMax(), organismo.getReproduccion(), ((Carnivoro) organismo).getAlimentacion());
						}
						//nacen.add(nuevo);
					}
				}
				// Si ha sobrepasado su edad máxima, muere
				if (organismo.getEdad() > organismo.getEdadMax()) {
					mueren.add(organismo);
				} else {
					// Alimentación
					if (organismo instanceof Planta) {
						if (this.agua >= ((Planta) organismo).getAgua()) {
							this.agua -= ((Planta) organismo).getAgua();
						} else {
							// No hay suficiente agua para esta planta, muere
							mueren.add(organismo);
						}
					} else if (organismo instanceof Herbivoro) {
						// Mirar si hay suficientes plantas para comer
						boolean hayPlanta = false;
						for (Planta planta : ((Herbivoro) organismo).getAlimentacion()) {
							if (organismos.get(TipoOrganismo.PLANTA).contains(planta)) {
								// Come
								mueren.add(planta);
								hayPlanta = true;
								break;
							}
						}
						if (!hayPlanta) {
							// No ha podido comer, muere
							mueren.add(organismo);
						}
					} else {
						// Mirar si hay suficientes animales para comer
						boolean hayAnimal = false;
						for (Animal animal : ((Carnivoro) organismo).getAlimentacion()) {
							if (organismos.get(TipoOrganismo.HERBIVORO).contains(animal) || organismos.get(TipoOrganismo.CARNIVORO).contains(animal)) {
								// Come
								mueren.add(animal);
								hayAnimal = true;
								break;
							}
						}
						if (!hayAnimal) {
							// No ha podido comer, muere
							mueren.add(organismo);
						}
					}
				}
			}		
			// Eliminamos a todos los que mueren
			while (!mueren.isEmpty()) {
				Organismo organismo = mueren.removeFirst();
				for (TipoOrganismo tipo : TipoOrganismo.values()) {
					organismos.get(tipo).remove(organismo);
				}
			}
		}
		// Añadimos a todos los que nacen	
		while (!nacen.isEmpty()) {
			Organismo organismo = nacen.removeFirst();
			TipoOrganismo tipo;
			if (organismo instanceof Planta) {
				tipo = TipoOrganismo.PLANTA;
			} else if (organismo instanceof Herbivoro) {
				tipo = TipoOrganismo.HERBIVORO;
			} else {
				tipo = TipoOrganismo.CARNIVORO;
			}
			organismos.get(tipo).add(organismo);
		}

	}
	
	public int getLongevidad() {
		int longevidad = 0;
		
		// Hacemos una copia para no romper this
		Ecosistema copia = new Ecosistema(this);
		
		// Calculamos la longevidad de esta copia
		while (copia.agua > 0 && copia.organismos.get(TipoOrganismo.PLANTA).size() + copia.organismos.get(TipoOrganismo.HERBIVORO).size() + copia.organismos.get(TipoOrganismo.CARNIVORO).size() > 0) {
			copia.simularAnyo();
			longevidad++;
		}
		
		return longevidad;
	}
	
}
