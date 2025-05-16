package finales.extraspace;

public interface PaisComprobable {
	/** Devuelve el país del objeto
	* @return nombre de país, null si no lo tiene definido
	*/
	public String getPais();
	/** Informa si el país es ajeno a la agencia DeustoSpace
	* @return true si el país es ajeno, false en caso contrario
	*/
	public boolean esPaisAjeno();
}
