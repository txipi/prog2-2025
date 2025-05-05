package tema4.parcial2.adoptakide;

import java.util.Objects;

public class Animal implements Comparable<Animal> {
    private String nombre;
    private Especie especie;
    private int edad;
    private String chip;
    private boolean necesidadesEspeciales;

    public Animal(String nombre, Especie especie, int edad, String chip, boolean necesidadesEspeciales) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.chip = chip;
        this.necesidadesEspeciales = necesidadesEspeciales;
    }

    public String getNombre() { return nombre; }
    public Especie getEspecie() { return especie; }
    public int getEdad() { return edad; }
    public String getChip() { return chip; }
    public boolean tieneNecesidadesEspeciales() { return necesidadesEspeciales; }

    @Override
    public String toString() {
        return nombre + " (" + especie + ", " + edad + " años, chip " + chip + ")";
    }

	@Override
	public int hashCode() {
		return Objects.hash(chip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(chip, other.chip);
	}

	@Override
	public int compareTo(Animal other) {
		int comparacion =  this.especie.compareTo(other.especie);
		if (comparacion != 0) {
			return comparacion;
		} else {
			return this.edad - other.edad;
		}
	}
    
    
}
