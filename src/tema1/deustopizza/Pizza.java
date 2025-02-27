package tema1.deustopizza;

import java.util.ArrayList;
import java.util.Arrays;

public class Pizza {
	private int tamanyo;
	private int masa;
	private String salsa;
	private boolean gratinar;
	private ArrayList<Ingrediente> ingredientes;
	
	public Pizza(int tamanyo, int masa, String salsa, boolean gratinar, ArrayList<Ingrediente> ingredientes) {
		super();
		this.setTamanyo(tamanyo);
		this.setMasa(masa);
		this.setSalsa(salsa);
		this.gratinar = gratinar;
		this.ingredientes = ingredientes;
	}
	
	public Pizza() {
		super();
		this.tamanyo = 1; // mediana
		this.masa = 1; // masa normal
		this.salsa = "tomate";
		this.gratinar = false;
		this.ingredientes = new ArrayList<Ingrediente>();
	}
	
	public Pizza(Pizza p) {
		super();
		this.tamanyo = p.tamanyo;
		this.masa = p.masa;
		this.salsa = p.salsa;
		this.gratinar = p.gratinar;
		this.ingredientes = p.ingredientes;
	}

	public int getTamanyo() {
		return tamanyo;
	}

	public void setTamanyo(int tamanyo) {
		if (tamanyo >= 0 && tamanyo <= 2) {
			this.tamanyo = tamanyo;
		}
	}

	public int getMasa() {
		return masa;
	}

	public void setMasa(int masa) {
		if (masa >= 0 && masa <= 2) {
			this.masa = masa;
		}
	}

	public String getSalsa() {
		return salsa;
	}

	public void setSalsa(String salsa) {
		// array de Strings válidos
		String[] salsas = {"tomate", "carbonara", "barbacoa", "doble carbonara", "carbonara"};
		// convertimos a ArrayList para poder usar contains
		ArrayList<String> sal = new ArrayList(Arrays.asList(salsas));
		// si el ArrayList de salsas contiene la salsa, actualizamos this.salsa
		if (sal.contains(salsa)) {
			this.salsa = salsa;
		}
	}

	public boolean isGratinar() {
		return gratinar;
	}

	public void setGratinar(boolean gratinar) {
		this.gratinar = gratinar;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public String toString() {
		String tam = "";
		if (this.tamanyo == 0) {
			tam = "pequeña";
		} else if (this.tamanyo == 1) {
			tam = "mediana";
		} else {
			tam = "grande";
		}
		String masa = "";
		if (this.masa== 0) {
			masa = "fina";
		} else if (this.masa == 1) {
			masa = "normal";
		} else {
			masa = "pan";
		}
		String grat = "gratinada";
		if (!this.gratinar) {
			grat = "sin gratinar";
		}
		String ingre = "";
		for (Ingrediente ingrediente : this.ingredientes) {
			ingre += ingrediente.getNombre() + ",";
		}
		return "Pizza "+tam+", masa "+masa+", salsa "+this.salsa+", "+grat+".\n"
				+ "Ingredientes: "+ingre+"\n";
	}
	
	public double getPesoMasa() {
		double resultado = 0;
		
		if (this.tamanyo == 0) {
			resultado = 100;
		} else if (this.tamanyo == 1) {
			resultado = 200;
		} else {
			resultado = 400;
		}
		
		if (this.masa == 0) {
			resultado = resultado * 0.8;
		} else if (this.masa == 2) {
			resultado = resultado * 1.2;
		}
		
		return resultado;
	}
	
	public double getPrecio() {
		double resultado = 0;
		
		if (this.tamanyo == 0) {
			resultado = 8;
		} else if (this.tamanyo == 1) {
			resultado = 12;
		} else {
			resultado = 16;
		}
		
		for (Ingrediente ingrediente : ingredientes) {
			resultado += ingrediente.getPrecio();
		}
		
		if (this.gratinar) {
			resultado += 0.5;
		}
		
		if (this.salsa.startsWith("doble")) {
			resultado += 1.0;
		}
		
		return resultado;
	}
}
