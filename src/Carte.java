
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

	
}
