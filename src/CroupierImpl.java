import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

public class CroupierImpl extends UnicastRemoteObject implements Croupier {

	private static final long serialVersionUID = 1L;
	private ArrayList<Client> clients;
	//private int scoreMaxClient;
	private MainJoueur mainJoueur;
	Scanner sc;

	public CroupierImpl(String nom) throws RemoteException {
		super();
		this.clients = new ArrayList<Client>();
		this.sc = new Scanner(System.in);
		//this.scoreMaxClient = 0;
		this.mainJoueur = new MainJoueur();
	}
	
	public void gererGagnant() throws RemoteException {
		int pointsMaxClients=0;
		int pointsCroupier=0;
		int joueurGagant=0;
		for (int i = 0; i < clients.size(); i++) {
			if (pointsMaxClients < clients.get(i).mainJoueur.compterPoints()){
				pointsMaxClients = clients.get(i).mainJoueur.compterPoints();
			}

		}
		pointsCroupier = this.mainJoueur.compterPoints();
		System.out.println("pointsCroupier : " + pointsCroupier);
		if ((pointsMaxClients > pointsCroupier) && (pointsMaxClients <21)){
			System.out.println("Le joueur " + clients.get(joueurGagant).nom + " gagne et rafle la mise.");
			clients.get(joueurGagant).compte.ajouterSomme((clients.get(joueurGagant).mise.getMise())*2);	//Donner argent au client
		}
		else if ((pointsMaxClients < pointsCroupier) && (pointsCroupier >21)) {
			System.out.println("Le joueur " + clients.get(joueurGagant).nom + " gagne et rafle la mise car le croupier a d�pass� 21.");
			clients.get(joueurGagant).compte.ajouterSomme((clients.get(joueurGagant).mise.getMise())*2);	//Donner argent au client
		}
		else if (pointsMaxClients == pointsCroupier) {
			if ((this.mainJoueur.compterNBCartes()) < (clients.get(joueurGagant).mainJoueur.compterNBCartes())){ //Victoire du client
				System.out.println("Le joueur " + clients.get(joueurGagant).nom + " gagne et rafle la mise.");
				clients.get(joueurGagant).compte.ajouterSomme((clients.get(joueurGagant).mise.getMise())*2);	//Donner argent au client
			}
			else if ((this.mainJoueur.compterNBCartes()) == (clients.get(joueurGagant).mainJoueur.compterNBCartes())) {
				System.out.println("Le croupier et le joueur " + clients.get(joueurGagant).nom + " ont fait �galit�.");
				clients.get(joueurGagant).compte.ajouterSomme((clients.get(joueurGagant).mise.getMise()));	//Donner argent au client
			}
		}
		else {
			System.out.println("Vous avez perdu la mise");
		}
		
	}
	
	public boolean IACroupier() throws RemoteException {
		if (this.mainJoueur.compterPoints() <17) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean finManche() throws RemoteException {
		if (this.mainJoueur.compterPoints() > 21){
			return true;
		}
		else if (clients.get(0).mainJoueur.compterPoints() > 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public boolean finPartie() throws RemoteException {
		if (clients.get(0).compte.getSomme() == 0){
			return true;
		}
		return false;
	}
	
	
	public void gererJeu() throws RemoteException {
		
		
		String rep;
		
		System.out.println("Bienvenue au BlackJacques");
		
		System.out.println("Quel est votre nom? ");
		String nomJoueur = sc.nextLine();
		clients.add(0, new Client(nomJoueur, 1000));
		System.out.println("Bienvenue " + clients.get(0).getNom());
		
		
		while (finPartie() != true){
			
			System.out.println("######################     NOUVELLE MANCHE    ########################");
			System.out.println(clients.get(0).getNom() + ", votre butin est de " + clients.get(0).compte.somme + "�");
			
			boolean finManche = false;
			
			JeuCarte jeuCarte = new JeuCarte();
			jeuCarte.melanger();
			
			clients.get(0).gestionMise();
			
			//Tirage du croupier
			this.mainJoueur.ajouterCarte(jeuCarte.distribuerUneCarte());
			this.mainJoueur.ajouterCarte(jeuCarte.distribuerUneCarte());
			System.out.println("Carte du Croupier"/* + this.nom*/);
			this.mainJoueur.lireUneCarte();
			
			//Tirage du client
			int i=0;
			Carte carteTiree = jeuCarte.distribuerUneCarte();
			clients.get(0).mainJoueur.ajouterCarte(carteTiree);
			clients.get(0).mainJoueur.ajouterCarte(jeuCarte.distribuerUneCarte());
			System.out.println(clients.get(0).nom + " a les cartes suivantes:");
			clients.get(0).mainJoueur.lireCartesEnMain();
			System.out.println("Ce qui fait un total de " + clients.get(0).mainJoueur.compterPoints() + " points.");
			
			
			System.out.println("Voulez vous stand? (yes/no)");
			rep = sc.nextLine();
			if (rep.equals("yes") || rep.equals("y")){
				finManche = true;
			}
			
			i++;
			
			
			while (finManche != true){
				System.out.println("Tour de table n�" + i++);
				
				if (IACroupier()){  //Gestion du croupier
					this.mainJoueur.ajouterCarte(jeuCarte.distribuerUneCarte());
					System.out.println(/*this.nom + */"Croupier a la carte suivantes:");
					this.mainJoueur.lireUneCarte();
				}
				
				
				for (Client c : clients) { //Distribution des cartes aux joueurs et prise des valeurs des mises
					carteTiree = jeuCarte.distribuerUneCarte();
					c.mainJoueur.ajouterCarte(carteTiree);
					System.out.println(c.nom + " a les cartes suivantes:");
					c.mainJoueur.lireCartesEnMain();
					System.out.println("Ce qui fait un total de " + c.mainJoueur.compterPoints() + " points.");
					finManche = finManche();
				}
				
				

				if (finManche != true){
					System.out.println("Voulez vous stand? (yes/no)");
					rep = sc.nextLine();
					if (rep.equals("yes") || rep.equals("y")){
						finManche = true;
					}
				}
				
				if (finManche()){
					finManche = true;
				}
				
			}
			

			gererGagnant();
			
			clients.get(0).mainJoueur.reinitialiserListeCarte();
			clients.get(0).mise.reinitialiserMise();
			this.mainJoueur.reinitialiserListeCarte();
			
		}
		
		System.out.println("###############   PARTIE TERMINEE - VOUS AVEZ PERDU - MERCI POUR LA CAILLASSE ;) ####################");	
		
	}
	

	

}
