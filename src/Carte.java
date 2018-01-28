
public class Carte {

	public int numero;
	public int type;
	String propritaire = null;
	
	public Carte(int numero, int type) {
		super();
		this.numero = numero;
		this.type = type;
	}

	public String getPropritaire() {
		return propritaire;
	}

	public void setProprietaire(String propritaire) {
		this.propritaire = propritaire;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}


	
}
