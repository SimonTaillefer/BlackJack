import java.util.ArrayList;

/**
 * MainJoueur est la classe qui représente les cartes du joueur.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public class MainJoueur {

	/**
	 * Liste de cartes.
	 */
	private ArrayList<Carte> carteList;
	
	/**
	 * Constructeur MainJoueur.
	 */
	public MainJoueur() {
		super();
		this.carteList = new ArrayList<Carte>();
	}

	/**
	 * Compte les points des cartes.
	 * 
	 * @return Le nombre de points des cartes.
	 */
	public int compterPoints(){
		int score = 0;			
		for (Carte carte : carteList) {
			score = score + carte.getValeur();
		}
		return score;
	}
	
	/**
	 * Ajoute une carte à la liste.
	 * 
	 * @param carte
	 * 			La carte à ajouter.
	 */
	public void ajouterCarte(Carte carte){
		carteList.add(carte);
	}
	
	/**
	 * Retourne le nombre de cartes que le joueur possède.
	 * 
	 * @return Le nombre de cartes.
	 */
	public int compterNBCartes(){
		return carteList.size();
	}
	
	/**
	 * Retourne le numéro de la carte et son type.
	 * 
	 * @return Le numéro et le type d'une carte.
	 */
	public String lireCartesEnMain(){
		String cartes = "";
		for (Carte carteEnMain : carteList) {
			cartes += carteEnMain.lireNumeroCarte() + " de " + carteEnMain.lireTypeCarte() + ".\n";
		}
		return cartes;
	}
	
	/**
	 * Réinitialise la liste de cartes.
	 */
	public void reinitialiserListeCarte(){
		carteList = new ArrayList<Carte>();
	}
	
}