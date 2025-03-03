package tema1.zoo;

public class Insecto extends Animal {
	protected int patas;
	protected boolean venenoso;
	
	public Insecto(String nombre, String especie, int edad, double peso, double longitud, int patas, boolean venenoso) {
		super(nombre, especie, edad, peso, longitud);
		this.patas = patas;
		this.venenoso = venenoso;
	}

	public Insecto() {
		super();
		this.patas = 0;
		this.venenoso = false;
	}

	public int getPatas() {
		return patas;
	}

	public void setPatas(int patas) {
		this.patas = patas;
	}

	public boolean isVenenoso() {
		return venenoso;
	}

	public void setVenenoso(boolean venenoso) {
		this.venenoso = venenoso;
	}


	@Override
	public String toString() {
		return "Insecto [patas=" + patas + ", venenoso=" + venenoso + ", nombre=" + nombre + ", especie=" + especie
				+ ", edad=" + edad + ", peso=" + peso + ", longitud=" + longitud + "]";
	}

	@Override
	public void hablar() {
		System.out.println("cri cri");
	}

}
