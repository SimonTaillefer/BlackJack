public class Joueur {
	
	String nom;

	int hit(){
		return 1;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Joueur(String nom) {
		super();
		this.nom = nom;
	}

	int stand(){
		return 2;
	}

}
