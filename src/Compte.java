
public class Compte {

	int somme; //de

	public Compte(int somme) {
		super();
		this.somme = somme;
	}
	
	void ajouterSomme(int somme){
		this.somme = this.somme + somme;
	}
	
	void retirerSomme(int somme){
		this.somme = this.somme - somme;
	}

}
