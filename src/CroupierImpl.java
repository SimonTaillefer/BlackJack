import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CroupierImpl est la classe qui gère le jeu.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public class CroupierImpl extends UnicastRemoteObject implements Croupier {

	/**
	 * Version de la classe.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Liste des clients.
	 */
	private ArrayList<Client> clients;
	
	/**
	 * Cartes en main du joueur;
	 */
	private MainJoueur mainJoueur;
	
	/**
	 * Interface de notification.
	 */
	private AffichageClient affichage;
	
	/**
	 * Jeu de carte.
	 */
	private JeuCarte jeuCarte;

	/**
	 * Constructeur CroupierImpl.
	 * 
	 * @param nom
	 * 			Le nom du joueur.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public CroupierImpl(String nom) throws RemoteException {
		super();
		this.clients = new ArrayList<Client>();
		this.mainJoueur = new MainJoueur();
		this.jeuCarte = new JeuCarte();
	}
	
	/**
	 * Gère la fin de la partie (victoire, défaite ou égalité).
	 * 
	 * @return Le message de fin de partie.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public String gererGagnant() throws RemoteException {
		int pointsMaxClients=0;
		int pointsCroupier=0;
		int joueurGagant=0;
		for (int i = 0; i < clients.size(); i++) {
			if (pointsMaxClients < clients.get(i).mainJoueur.compterPoints()){
				pointsMaxClients = clients.get(i).mainJoueur.compterPoints();
			}

		}
		pointsCroupier = this.mainJoueur.compterPoints();
		String message = "Points du Croupier : " + pointsCroupier + "\n";
		
		if ((pointsMaxClients > pointsCroupier) && (pointsMaxClients <21)){
			message += "Le joueur " + clients.get(joueurGagant).nom + " gagne et rafle la mise.";
			clients.get(joueurGagant).compte.ajouterSomme((clients.get(joueurGagant).mise.getMise())*2);	//Donner argent au client
		}
		else if ((pointsMaxClients < pointsCroupier) && (pointsCroupier >21)) {
			message += "Le joueur " + clients.get(joueurGagant).nom + " gagne et rafle la mise car le croupier a depasse 21.";
			clients.get(joueurGagant).compte.ajouterSomme((clients.get(joueurGagant).mise.getMise())*2);	//Donner argent au client
		}
		else if (pointsMaxClients == pointsCroupier) {
			if ((this.mainJoueur.compterNBCartes()) < (clients.get(joueurGagant).mainJoueur.compterNBCartes())){ //Victoire du client
				message += "Le joueur " + clients.get(joueurGagant).nom + " gagne et rafle la mise.";
				clients.get(joueurGagant).compte.ajouterSomme((clients.get(joueurGagant).mise.getMise())*2);	//Donner argent au client
			}
			else if ((this.mainJoueur.compterNBCartes()) == (clients.get(joueurGagant).mainJoueur.compterNBCartes())) {
				message += "Le croupier et le joueur " + clients.get(joueurGagant).nom + " ont fait egalite.";
				clients.get(joueurGagant).compte.ajouterSomme((clients.get(joueurGagant).mise.getMise()));	//Donner argent au client
			}
		}
		else {
			message += "Vous avez perdu la mise !!";
		}
		return message;
	}
	
	/**
	 * Fait tirer une carte au croupier s'il a moins de 17 points.
	 * 
	 * @return Si le croupier tire une carte ou non.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public boolean IACroupier() throws RemoteException {
		if (this.mainJoueur.compterPoints() <17) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Gère la fin de la manche (si le joueur ou le croupier ont plus de 21 points).
	 * 
	 * @return Si la manche est finie ou non.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
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
	
	/**
	 * Gère la fin de la partie (si le joueur n'a plus d'argent sur le compte).
	 * 
	 * @return Si la partie est finie ou non.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public boolean finPartie() {
		if (clients.get(0).compte.getSomme() == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Ajoute le client à la partie.
	 * 
	 * @param nom
	 * 			Le nom du joueur à ajouter.
	 * @param compte
	 * 			Le solde du compte du joueur.
	 * 
	 * @return Le client ajouté.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public boolean addJoueur(String nom, int compte) throws RemoteException {
		return clients.add(new Client(nom, compte));
	}
	
	/**
	 * Retourne le nom du client.
	 * 
	 * @param index
	 * 			L'index du client dans la liste des clients.
	 * 
	 * @return Le nom du client.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public String getNomClient(int index) throws RemoteException {
		return clients.get(index).getNom();
	}
	
	/**
	 * Retourne le solde du compte du client.
	 * 
	 * @param index
	 * 			L'index du client dans la liste des clients.
	 * 
	 * @return Le solde du compte du client.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public int getCompteClient(int index) throws RemoteException {
		return clients.get(index).compte.somme;
	}
	
	/**
	 * Mélange le paquet de cartes.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public void melanger() throws RemoteException {
		this.jeuCarte.melanger();
	}
	
	/**
	 * Mise la somme donnée par le client.
	 * 
	 * @param index
	 * 			L'index du client dans la liste des clients.
	 * @param mise
	 * 			Le montant de la mise.
	 * 
	 * @return La mise et le nouveau solde du compte.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public String gererMise(int index, int mise) throws RemoteException {
		clients.get(index).miser(mise);
		return clients.get(index).gestionMise();
	}
	
	/**
	 * Tire une carte pour le croupier.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public void tirageCroupier() throws RemoteException {
		this.mainJoueur.ajouterCarte(jeuCarte.distribuerUneCarte());
	}
	
	/**
	 * Tire une carte pour le joueur.
	 * 
	 * @param index
	 * 			L'index du client dans la liste des clients. 
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public void tirageClient(int index) throws RemoteException {
		clients.get(index).mainJoueur.ajouterCarte(jeuCarte.distribuerUneCarte());
	}
	
	/**
	 * Retourne les cartes du croupier.
	 * 
	 * @return Les cartes du croupier.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public String lireCarteCroupier() throws RemoteException {
		return this.mainJoueur.lireCartesEnMain();
	}
	
	/**
	 * Retourne les cartes du joueur.
	 * 
	 * @param index
	 * 			L'index du client dans la liste des clients. 
	 * 
	 * @return Les cartes du joueur.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public String lireCarteClient(int index) throws RemoteException {
		return clients.get(index).mainJoueur.lireCartesEnMain();
	}
	
	/**
	 * Retourne les points du joueurs.
	 * 
	 * @param index
	 * 			L'index du client dans la liste des clients. 
	 * 
	 * @return Le nombre de points du joueur.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public String compterPoints(int index) throws RemoteException {
		return "Ce qui fait un total de " + clients.get(index).mainJoueur.compterPoints() + " points.\n";
	}
	
	/**
	 * Réinitialise le jeu (mise et cartes).
	 * 
	 * @param index
	 * 			L'index du client dans la liste des clients.
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public void reinitialiserJeu(int index) throws RemoteException {
		clients.get(index).mainJoueur.reinitialiserListeCarte();
		clients.get(index).mise.reinitialiserMise();
		this.mainJoueur.reinitialiserListeCarte();
	}
	
	/**
	 * Enregistre la notification à envoyer au client.
	 * 
	 * @param ac
	 * 			L'interface de notification.
	 * @param message
	 * 			Le message contenu dans la notification.
	 * 
	 * @throws java.rmi.RemoteException
	 * 			Exceptino RMI.
	 */
	public synchronized void enregistrerNotification(AffichageClient ac, String message)
			throws RemoteException {
		this.setNotification(ac,message);
	}
	
	/**
	 * Initialise la notification.
	 * 
	 * @param affichage
	 * 			L'interface de notification.
	 * @param mes
	 * 			Le message contenu dans la notification.
	 */
	public void setNotification(AffichageClient affichage, String mes) {
	 	 this.affichage = affichage;
	}
}
