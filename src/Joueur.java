
public class Joueur {
	
	String nom;
	
	MainJoueur mainJoueur; //Contient les cartes que le joueur possède

	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.mainJoueur = new MainJoueur();
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
