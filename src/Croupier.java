import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Croupier est l'interface de la classe CroupierImpl pour RMI.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public interface Croupier extends Remote {
	
	/**
	 * Gère la fin de la partie (victoire, défaite ou égalité).
	 * 
	 * @return Le message de fin de partie.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public String gererGagnant() throws RemoteException;
	
	/**
	 * Fait tirer une carte au croupier s'il a moins de 17 points.
	 * 
	 * @return Si le croupier tire une carte ou non.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public boolean IACroupier() throws RemoteException;
	
	/**
	 * Gère la fin de la manche (si le joueur ou le croupier ont plus de 21 points).
	 * 
	 * @return Si la manche est finie ou non.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public boolean finManche() throws RemoteException;
	
	/**
	 * Gère la fin de la partie (si le joueur n'a plus d'argent sur le compte).
	 * 
	 * @return Si la partie est finie ou non.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public boolean finPartie() throws RemoteException;
	
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
	public boolean addJoueur(String nom, int compte) throws RemoteException;
	
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
	public String getNomClient(int index)throws RemoteException;
	
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
	public int getCompteClient(int index) throws RemoteException;
	
	/**
	 * Mélange le paquet de cartes.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public void melanger() throws RemoteException;
	
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
	public String gererMise(int index, int mise) throws RemoteException;
	
	/**
	 * Tire une carte pour le croupier.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public void tirageCroupier() throws RemoteException;
	
	/**
	 * Tire une carte pour le joueur.
	 * 
	 * @param index
	 * 			L'index du client dans la liste des clients. 
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public void tirageClient(int index) throws RemoteException;
	
	/**
	 * Retourne les cartes du croupier.
	 * 
	 * @return Les cartes du croupier.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public String lireCarteCroupier() throws RemoteException;
	
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
	public String lireCarteClient(int index) throws RemoteException;
	
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
	public String compterPoints(int index) throws RemoteException;
	
	/**
	 * Réinitialise le jeu (mise et cartes).
	 * 
	 * @param index
	 * 			L'index du client dans la liste des clients.
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public void reinitialiserJeu(int index) throws RemoteException;
	
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
	public void enregistrerNotification(AffichageClient ac,
			 String message) throws java.rmi.RemoteException;
}
