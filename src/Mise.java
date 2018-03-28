/**
 * Mise est la classe de la mise d'un joueur.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public class Mise {
	
	/**
	 * La mise d'un joueur.
	 */
	private int mise;

	/**
	 * Constructeur Mise.
	 * 
	 * @param somme
	 * 			La somme qu'un joueur mise.
	 */
	public Mise(int somme) {
		super();
		this.mise = somme;
	}
	
	/**
	 * Rajoute une somme à la mise.
	 * 
	 * @param somme
	 * 			La somme à rajouter.
	 */
	public void miser(int somme){
		 setMise(getMise() + somme);
	}

	/**
	 * Retourne la mise.
	 * 
	 * @return La mise.
	 */
	public int getMise() {
		return mise;
	}

	/**
	 * Met à jour la mise.
	 * 
	 * @param mise
	 * 			La mise d'un joueur.
	 */
	public void setMise(int mise) {
		this.mise = mise;
	}

	/**
	 * Remet à 0 la mise.
	 */
	public void reinitialiserMise() {
		this.mise = 0;
	}
}
