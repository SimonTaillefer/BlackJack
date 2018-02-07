public class Carte {

	public int numero;
	public int type;
	int valeur;

	public Carte(int numero, int type, int valeur) {
		super();
		this.numero = numero;
		this.type = type;
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
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
