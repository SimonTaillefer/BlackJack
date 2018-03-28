/**
 * Carte est la classe définissant les cartes du BlackJack.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public class Carte {

	/**
	 * Le numéro de la carte.
	 */
	private int numero;
	
	/**
	 * La forme de la carte (coeur, pique, carreau, trèfle).
	 */
	private int type;
	
	/**
	 * La valeur de la carte dans le BlackJack.
	 */
	private int valeur;

	/**
	 * Constructeur Carte.
	 * 
	 * @param numero
	 * 			Le numéro de la carte.
	 * @param type
	 * 			La forme de la carte.
	 * @param valeur
	 * 			La valeur de la carte.
	 */
	public Carte(int numero, int type, int valeur) {
		super();
		this.numero = numero;
		this.type = type;
		this.valeur = valeur;
	}

	/**
	 * Retourne la valeur de la carte.
	 * 
	 * @return La valeur de la carte.
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * Met à jour la valeur de la carte.
	 * 
	 * @param valeur
	 * 			La nouvelle valeur de la carte.
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * Retourne le numéro de la carte.
	 * 
	 * @return Le numéro de la carte.
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Met à jour le numéro de la carte.
	 * 
	 * @param numero
	 * 			Le nouveau numéro de la carte.
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/**
	 * Retourne le type de la carte.
	 * 
	 * @return Le type de la carte.
	 */
	public String lireTypeCarte(){
		switch (type) {
		case 0:
			return "coeur";
		case 1:
			return "carreau";
		case 2:
			return "pique";
		case 3:
			return "tr�fle";
		default:
			return "le joker de tr�fle";
		}
	}
	
	/**
	 * Retourne le numéro de la carte.
	 * 
	 * @return Le numéro de la carte.
	 */
	public String lireNumeroCarte(){
		switch (numero) {
		case 1:
			return "L'as";
		case 2:
			return "Un 2";
		case 3:
			return "Un 3";
		case 4:
			return "Un 4";
		case 5:
			return "Un 5";
		case 6:
			return "Un 6";
		case 7:
			return "Un 7";
		case 8:
			return "Un 8";
		case 9:
			return "Un 9";
		case 10:
			return "Un 10";
		case 11:
			return "Un valet";
		case 12:
			return "Une dame";
		case 13:
			return "Un roi";

		default:
			return "le joker :troll:";
		}
	}

	
}
