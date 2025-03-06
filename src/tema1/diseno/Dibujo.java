package tema1.diseno;

import java.util.ArrayList;
import java.util.Objects;

public class Dibujo {
	protected String titulo;
	protected ArrayList<Forma> formas;
	protected ArrayList<Texto> textos;
	
	public Dibujo(String titulo, ArrayList<Forma> formas, ArrayList<Texto> textos) {
		super();
		this.titulo = titulo;
		this.formas = formas;
		this.textos = textos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ArrayList<Forma> getFormas() {
		return formas;
	}

	public void setFormas(ArrayList<Forma> formas) {
		this.formas = formas;
	}

	public ArrayList<Texto> getTextos() {
		return textos;
	}

	public void setTextos(ArrayList<Texto> textos) {
		this.textos = textos;
	}

	@Override
	public String toString() {
		return "Dibujo [titulo=" + titulo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dibujo other = (Dibujo) obj;
		return Objects.equals(titulo, other.titulo);
	}
	
	
}
