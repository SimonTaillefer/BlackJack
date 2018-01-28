
public class Client extends Joueur {

	int points;
	Compte compte;
	Mise mise;
	
	/*public Client(String nom, int sommeCompte) {
		super();
		this.nom = nom;
		this.compte = new Compte(sommeCompte);
	}*/
	
	public Client(String nom, int compte) {
		super(nom);
		this.points = 0;
		this.compte = new Compte(compte);
		this.mise	= new Mise(0);
	}
	
	public void miser(int somme){
		mise.miser(somme);
		compte.retirerSomme(somme);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Mise getMise() {
		return mise;
	}

	public void setMise(Mise mise) {
		this.mise = mise;
	}
	
	
}
