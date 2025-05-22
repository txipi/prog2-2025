package finales.extraspace;

public interface Subvencionable {
	/** Informa si el objeto es subvencionable
	 * @return
	 */
	boolean esSubvencionable();
	/** Devuelve el porcentaje de subvención
	 * @return	Porcentaje positivo de subvención (valor entre 0.0 y 100.0) - 0 si el objeto no es subvencionable
	 */
	double getPorcentaje();
}
