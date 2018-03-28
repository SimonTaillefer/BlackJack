/**
 * Joueur est la classe définissant un joueur du casino.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public class Joueur {
	
	/**
	 * Nom du joueur.
	 */
	String nom;
	
	/**
	 * Cartes que le joueur possède.
	 */
	MainJoueur mainJoueur;

	/**
	 * Constructeur Joueur.
	 * 
	 * @param nom
	 * 			Le nom du joueur.
	 */
	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.mainJoueur = new MainJoueur();
		
	}

	/**
	 * Retourne le nom du joueur.
	 * 
	 * @return Le nom du joueur.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Met à jour le nom du joueur.
	 * 
	 * @param nom
	 * 			Le nom du joueur.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
