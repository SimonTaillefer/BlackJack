
public class Compte {

	int somme;

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

	public int getSomme() {
		return somme;
	}

	public void setSomme(int somme) {
		this.somme = somme;
	}

}
