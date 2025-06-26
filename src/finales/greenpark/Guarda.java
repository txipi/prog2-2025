package finales.greenpark;

import java.util.ArrayList;

class Guarda extends Personal {
	protected ArrayList<String> carnets;
	
    public Guarda(String nombre, String pais, ArrayList<String> carnets) {
        super(nombre, pais);
        this.carnets = carnets;
    }
}
