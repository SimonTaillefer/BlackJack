import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		Compte compteJ1 = new Compte(1000);
		JeuCarte jeuCarte = new JeuCarte();
		Croupier croupier1 = new Croupier("Croupier");
		
		System.out.println("Bienvenue au BlackJacques");
		
		System.out.println("Quel est votre nom? ");
		String nomJoueur = sc.nextLine();
		Client client1 = new Client(nomJoueur, 1000);
		System.out.println("Bienvenue " + client1.getNom());
		System.out.println(client1.getNom() + ", votre butin est de " + client1.compte.somme + "€");
		
		System.out.println("Quelle est votre mise?");
		client1.miser( Integer.parseInt(sc.nextLine()) );
		System.out.println("Vous avez misé " + client1.getMise().mise + "€.");
		System.out.println("Vous avez " + client1.getCompte().somme + "€ sur votre compte.");
		
		
		croupier1.distribuerUneCarte(client1, jeuCarte);
		
		croupier1.distribuerUneCarte(croupier1, jeuCarte);
		
		
		
		
	}

}
