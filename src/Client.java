import java.util.Scanner;

/**
 * Client est la classe définissant un joueur de BlackJack.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public class Client extends Joueur {

	/**
	 * Les points du client.
	 */
	private int points;
	/**
	 * Le compte du client.
	 */
	Compte compte;
	/**
	 * La mise du client.
	 */
	Mise mise;
	
	/**
	 * Construction Client.
	 * 
	 * @param nom
	 * 			Le nom du client.
	 * @param compte
	 * 			Le compte du client.
	 */
	public Client(String nom, int compte) {
		super(nom);
		this.points = 0;
		this.compte = new Compte(compte);
		this.mise	= new Mise(0);
	}
	
	/**
	 * Retourne la mise et le reste du solde du compte du client.
	 * 
	 * @return Le message contenant la mise et le solde du client.
	 */
	public String gestionMise(){
		
		String message = "Vous avez misé " + getMise().getMise() + "€.\n";
		message += "Vous avez " + getCompte().getSomme() + "€ sur votre compte.\n";
		return message;
	}
	
	/**
	 * Mise la somme choisie par le client et la retire du compte.
	 * 
	 * @param somme
	 * 			La somme à miser.
	 */
	public void miser(int somme){
		mise.miser(somme);
		compte.retirerSomme(somme);
	}

	/**
	 * Retourne le nom du client.
	 * 
	 * @return Le nom du client.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Met à jour le nom du client.
	 * 
	 * @param nom
	 * 			Le nouveau nom du client.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Retourne les points du client.
	 * 
	 * @return Les points du client.
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Met à jour les points du client.
	 * 
	 * @param points
	 * 			Les nouveaux points du client.
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Retourne le compte du client.
	 * 
	 * @return Le compte du client.
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * Met à jour le compte du client.
	 * 
	 * @param compte
	 * 			Le compte du client.
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/**
	 * Retourne la mise du client.
	 * 
	 * @return La mise du client.
	 */
	public Mise getMise() {
		return mise;
	}

	/**
	 * Met à jour la mise du client.
	 * 
	 * @param mise
	 * 			La mise du client.
	 */
	public void setMise(Mise mise) {
		this.mise = mise;
	}
	
	
}
