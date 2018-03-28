/**
 * Compte est la classe définissant le compte du client.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public class Compte {

	/**
	 * Le solde du client.
	 */
	int somme;

	/**
	 * Constructeur Compte.
	 * 
	 * @param somme
	 * 			Le solde du compte.
	 */
	public Compte(int somme) {
		super();
		this.somme = somme;
	}
	
	/**
	 * Ajoute une somme au solde du compte.
	 * 
	 * @param somme	
	 * 			La somme à ajouter.
	 */
	public void ajouterSomme(int somme){
		this.somme = this.somme + somme;
	}
	
	/**
	 * Retire une somme du solde du compte.
	 * 
	 * @param somme
	 * 			La somme à retirer.
	 */
	public void retirerSomme(int somme){
		this.somme = this.somme - somme;
	}

	/**
	 * Retourne le solde du compte.
	 * 
	 * @return Le solde du compte.
	 */
	public int getSomme() {
		return somme;
	}

	/**
	 * Met à jour le solde du compte.
	 * 
	 * @param somme
	 * 			Le nouveau solde du compte.
	 */
	public void setSomme(int somme) {
		this.somme = somme;
	}

}
