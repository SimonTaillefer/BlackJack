import java.util.Scanner;

public class Croupier extends Joueur {

	

	public Croupier(String nom) {
		super(nom);
	}

	public void distribuerUneCarte(Joueur joueur, JeuCarte jeuCarte){
		jeuCarte.distribuerUneCarte();
	}
	
	
	public int trouverIDJoueur(Client client[], String nomJoueur, int nbJoueurs){ //Cherche l'identifiant du joueur à partir de son nom
		for (int i=0; i<nbJoueurs; i++){
			if (client[i].nom == nomJoueur){
				return i;
			}
		}
		return -1;
	}
	
	
	public void gererJeu(){
		Scanner sc = new Scanner(System.in);
		
		boolean finPartie = false;
		
		
		
		System.out.println("Bienvenue au BlackJacques");
		
		System.out.println("Quel est votre nom? ");
		String nomJoueur = sc.nextLine();
		Client client1 = new Client(nomJoueur, 1000);
		System.out.println("Bienvenue " + client1.getNom());
		
		
		JeuCarte jeuCarte = new JeuCarte();
		jeuCarte.melanger();
		
		System.out.println(client1.getNom() + ", votre butin est de " + client1.compte.somme + "€");
		
		System.out.println("Quelle est votre mise?");
		client1.miser( Integer.parseInt(sc.nextLine()) );
		System.out.println("Vous avez misé " + client1.getMise().mise + "€.");
		System.out.println("Vous avez " + client1.getCompte().somme + "€ sur votre compte.");
		
		int i=0;
		while (finPartie != true){
			System.out.println("Cycle " + i++);
			
			Carte carteTiree = jeuCarte.distribuerUneCarte();
			System.out.println("Carte tiree numero:" + carteTiree.numero);
			System.out.println("Carte tiree type:" + carteTiree.type);
			System.out.println("Carte tiree valeur:" + carteTiree.valeur);
			client1.mainJoueur.ajouterCarte(carteTiree);
			
			sc.nextLine();
			
		}

		
		
	}
	

	

}
