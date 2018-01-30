
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
			return "trèfle";
		default:
			return "le joker de trèfle";
		}
	}
	
	public String lireNumeroCarte(){
		switch (numero) {
		case 1:
			return "L'as";
		case 2:
			return "Un deux";
		case 3:
			return "Un trois";
		case 4:
			return "Un quatre";
		case 5:
			return "Un cinq";
		case 6:
			return "Un six";
		case 7:
			return "Un sept";
		case 8:
			return "Un huit";
		case 9:
			return "Un neuf";
		case 10:
			return "Un dix";
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
