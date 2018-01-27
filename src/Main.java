
public class Main {
	
	public static void main(String[] args){
		System.out.println("Bienvenue au BlackJacques");
		Compte compteJ1 = new Compte(1000);
		//JeuCarte jeuCarte = new JeuCarte();
		Croupier croupier = new Croupier();
		
		croupier.distribuerCarte();
		
		System.out.println("Le joeur a " + compteJ1.somme);
		compteJ1.ajouterSomme(5000);
		System.out.println("Le joeur a " + compteJ1.somme);
		compteJ1.retirerSomme(2000);
		System.out.println("Le joeur a " + compteJ1.somme);
	}

}
