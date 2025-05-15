package finales.repaso;

public class Comic extends Producto {
	protected int paginas;
	protected String autoria;

	public Comic(String nombre, String descripcion, double coste, int paginas, String autoria) {
		super(nombre, descripcion, coste);
		this.paginas = paginas;
		this.autoria = autoria;
	}
	
	public Comic() {
		super();
		this.paginas = paginas;
		this.autoria = autoria;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getAutoria() {
		return autoria;
	}

	public void setAutoria(String autoria) {
		this.autoria = autoria;
	}

	@Override
	public String toString() {
		return "Comic [paginas=" + paginas + ", autoria=" + autoria + ", codigo=" + codigo + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", coste=" + coste + "]";
	}

	@Override
	public boolean hayPromocion() {
		if (this.autoria.equals("Frank Miller")) {
			return true;
		} else {
			return false;
		}
	}

	
	
	
}
