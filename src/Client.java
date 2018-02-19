import java.util.Scanner;

public class Client extends Joueur {

	int points;
	Compte compte;
	Mise mise;
	Scanner sc;
	
	public Client(String nom, int compte) {
		super(nom);
		this.points = 0;
		this.compte = new Compte(compte);
		this.mise	= new Mise(0);
		this.sc = new Scanner(System.in);
	}
	
	public void gestionMise(){
		boolean verifMiseOK = false;
		int valMise = 0;
		do {
			System.out.println("Quelle est votre mise?");
			valMise = Integer.parseInt(sc.nextLine());
		} while (verifMiseOK);
		
		
		miser(valMise);
		System.out.println("Vous avez misé " + getMise().getMise() + "€.");
		System.out.println("Vous avez " + getCompte().getSomme() + "€ sur votre compte.");
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
