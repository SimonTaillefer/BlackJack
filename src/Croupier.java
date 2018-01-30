import java.util.ArrayList;
import java.util.Scanner;

public class Croupier extends Joueur {

	ArrayList<Client> clients;
	int scoreMaxClient;
	Scanner sc;
	boolean gagnantTrouve;
	Client clientGagnant;

	public Croupier(String nom) {
		super(nom);
		this.clients = new ArrayList<Client>();
		this.sc = new Scanner(System.in);
		this.scoreMaxClient = 0;
		this.gagnantTrouve = false;
	}
	
	
	public int trouverIDJoueur(Client client[], String nomJoueur, int nbJoueurs){ //Cherche l'identifiant du joueur à partir de son nom
		for (int i=0; i<nbJoueurs; i++){
			if (client[i].nom == nomJoueur){
				return i;
			}
		}
		return -1;
	}
	
	public void gererGagnant(){
		int pointsMaxClients=0;
		int pointsCroupier=0;
		int joueurGagant=0;
		for (int i = 0; i < clients.size(); i++) {
			if (pointsMaxClients < clients.get(i).mainJoueur.compterPoints()){
				pointsMaxClients = clients.get(i).mainJoueur.compterPoints();
			}
			System.out.println("i = " + i);
			System.out.println("Le " + clients.get(0).getNom() + " a " + clients.get(0).mainJoueur.compterPoints() + " points."); //Affiche les points de tous les joueurs
			System.out.println("ICIIII");
		}
		pointsCroupier = this.mainJoueur.compterPoints();
		System.out.println("pointsCroupier : " + pointsCroupier);
		if (pointsMaxClients > pointsCroupier){
			System.out.println("Le joueur " + clients.get(joueurGagant).nom + " gagne et rafle la mise.");
			clients.get(joueurGagant).compte.ajouterSomme((clients.get(joueurGagant).mise.getMise())*2);	//Donner argent au client
		}
		else if (pointsMaxClients == pointsCroupier) {
			if ((this.mainJoueur.compterNBCartes()) < (clients.get(joueurGagant).mainJoueur.compterNBCartes())){ //Victoire du client
				System.out.println("Le joueur " + clients.get(joueurGagant).nom + " gagne et rafle la mise.");
				clients.get(joueurGagant).compte.ajouterSomme((clients.get(joueurGagant).mise.getMise())*2);	//Donner argent au client
			}
		}
		else {
			System.out.println("Vous avez perdu la mise");
		}
		System.out.println("LAAAAAA");
		
	}
	
	
	public boolean finPartie(){
		if (clients.get(0).compte.getSomme() == 0){
			return true;
		}
		return false;
	}
	
	
	public void gererJeu(){
		
		boolean finManche = false;
		
		
		System.out.println("Bienvenue au BlackJacques");
		
		System.out.println("Quel est votre nom? ");
		String nomJoueur = sc.nextLine();
		clients.add(0, new Client(nomJoueur, 1000));
		System.out.println("Bienvenue " + clients.get(0).getNom());
		
		
		while (finPartie() != true){
			
			System.out.println(clients.get(0).getNom() + ", votre butin est de " + clients.get(0).compte.somme + "€");
			
			JeuCarte jeuCarte = new JeuCarte();
			jeuCarte.melanger();
			
			
			this.mainJoueur.ajouterCarte(jeuCarte.distribuerUneCarte());
			this.mainJoueur.ajouterCarte(jeuCarte.distribuerUneCarte());
			System.out.println(this.nom + " a les cartes suivantes:");
			this.mainJoueur.lireCartesEnMain();
			
			int i=0;
			Carte carteTiree = jeuCarte.distribuerUneCarte();
			clients.get(0).mainJoueur.ajouterCarte(carteTiree);
			clients.get(0).mainJoueur.ajouterCarte(jeuCarte.distribuerUneCarte());
			System.out.println(clients.get(0).nom + " a les cartes suivantes:");
			clients.get(0).mainJoueur.lireCartesEnMain();
			
			clients.get(0).gestionMise();
			

			
			i++;
			
			System.out.println("---------------------");
			
			while (finManche != true){
				System.out.println("Cycle " + i++);
				
				this.mainJoueur.ajouterCarte(jeuCarte.distribuerUneCarte());
				System.out.println(this.nom + " a les cartes suivantes:");
				this.mainJoueur.lireCartesEnMain();
				
				for (Client c : clients) { //Distribution des cartes aux joueurs et prise des valeurs des mises
					carteTiree = jeuCarte.distribuerUneCarte();
					System.out.println("Carte tiree numero:" + carteTiree.numero); System.out.println("Carte tiree type:" + carteTiree.type); System.out.println("Carte tiree valeur:" + carteTiree.valeur);
					c.mainJoueur.ajouterCarte(carteTiree);
					System.out.println(c.nom + " a les cartes suivantes:");
					c.mainJoueur.lireCartesEnMain();
					c.gestionMise();
				}

				
				System.out.println("Voulez vous stand? (yes/no)");
				String rep = sc.nextLine();
				if (rep.equals("yes") || rep.equals("y")){
					finManche=true;
				}
				
			}
			
			/*for (Client c : clients) {
				int scoreTemp = c.mainJoueur.compterPoints();
				if (scoreTemp > scoreMaxClient){
					scoreMaxClient = scoreTemp;
					clientGagnant = new Client(c.getNom(), c.getCompte().getSomme() );
					clientGagnant = c;
					gagnantTrouve = true;
				}
			}
			
			if (gagnantTrouve){
				System.out.println("Le gagnant est " + clientGagnant.nom);
				System.out.println(clientGagnant.getPoints());
				System.out.println(this.mainJoueur.compterPoints());
			}*/

			gererGagnant();
		}
		
		
		
	}
	

	

}
