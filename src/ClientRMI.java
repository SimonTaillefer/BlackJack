import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.Scanner;

@SuppressWarnings("deprecation")

/**
 * ClientRMI est la classe qui gère un client qui se connecte au serveur.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public class ClientRMI {

	/**
	 * Scanner de saisie du client.
	 */
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Déroulement du jeu.
	 * 
	 * @param args
	 * 
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		// Lancement du client et vérification de sécurité
		System.out.println("Lancement du client");
	    if (System.getSecurityManager() == null) {
	      System.setSecurityManager(new RMISecurityManager());
	    }
	    try {
	    	// Création de l'objet RMI
	    	Croupier croupier = (Croupier) Naming.lookup("rmi://localhost:1099/Croupier");
	    	String rep;
	    	
	    	// Début du jeu 
	    	System.out.println("------- Bonjour -------");
	    	System.out.println("Quel est votre nom? ");
			String nomJoueur = sc.nextLine();
			
			// Demande du montant que le joueur souhaite jouer
			System.out.println("Combien voulez-vous jouer d'argent ?");
			int compteJoueur = sc.nextInt();
			
			// Ajout du joueur à la table
			croupier.addJoueur(nomJoueur, compteJoueur);
			System.out.println("Bienvenue " + croupier.getNomClient(0));
			
			while (croupier.finPartie() != true){
				
				// Début manche
				System.out.println("###############     NOUVELLE MANCHE    ###############");
				System.out.println(croupier.getNomClient(0) + ", votre butin est de " + croupier.getCompteClient(0) + "€");
				
				boolean finManche = false;
				
				// Mélange du paquet de cartes
				croupier.melanger();
				
				// Demande de la mise
				boolean verifMiseOK = false;
				int valMise = 0;
				do {
					System.out.println("Quelle est votre mise ?");
					valMise = sc.nextInt();
				} while (verifMiseOK);
				
				System.out.println(croupier.gererMise(0, valMise));
				
				//Tirage du croupier
				croupier.tirageCroupier();
				croupier.tirageCroupier();
				System.out.println("Carte du Croupier : ");
				System.out.println(croupier.lireCarteCroupier());
				
				//Tirage du client
				int i=0;
				croupier.tirageClient(0);
				croupier.tirageClient(0);
				System.out.println(croupier.getNomClient(0) + " a les cartes suivantes : ");
				System.out.println(croupier.lireCarteClient(0));
				System.out.println(croupier.compterPoints(0));
				
				// Demande si le joueur veut une autre carte
				if (finManche != true){
					System.out.println("Voulez vous stand? (yes/no)");
					rep = sc.next();
					if (rep.equals("yes") || rep.equals("y")){
						System.out.println("Test");
						finManche = true;
					}
				}
				
				i++;
				
				// Tour de table si le joueur souhaite continuer à tirer des cartes
				while (finManche != true){
					System.out.println("Tour de table n°" + i++ + "\n");
					
					//Gestion du croupier
					if (croupier.IACroupier()){ 
						croupier.tirageCroupier();
					}
					System.out.println("Le Croupier a la carte suivantes :");
					System.out.println(croupier.lireCarteCroupier());
					
					//Distribution des cartes au joueur et prise des valeurs des mises
					croupier.tirageClient(0);
					System.out.println(croupier.getNomClient(0) + " a les cartes suivantes : ");
					System.out.println(croupier.lireCarteClient(0));
					System.out.println(croupier.compterPoints(0));
					
					finManche = croupier.finManche();
					
					// Demande si le joueur veut tirer une autre carte
					if (finManche != true){
						System.out.println("Voulez vous stand? (yes/no)");
						rep = sc.nextLine();
						if (rep.equals("yes") || rep.equals("y")){
							finManche = true;
						}
					}
					
					if (croupier.finManche()){
						finManche = true;
					}
				}
				
				// Vérification gagnant
				System.out.println(croupier.gererGagnant());
				
				// Remise à 0 pour la manche suivante.
				croupier.reinitialiserJeu(0);
			}
			
			System.out.println("###############   PARTIE TERMINEE - VOUS AVEZ PERDU - MERCI POUR LA CAILLASSE ;) ###############");
			
			  
	      //AffichageClientImpl aci = new AffichageClientImpl();
	      //croupier.enregistrerNotification(aci, "");
	        
	    } catch (MalformedURLException e) {
	      e.printStackTrace();
	    } catch (RemoteException e) {
	      e.printStackTrace();
	    } catch (NotBoundException e) {
	      e.printStackTrace();
	    }
	    System.out.println("Fin du client");
	}
}
