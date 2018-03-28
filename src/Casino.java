import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Casino est la classe définissant le casino de BlackJack.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public class Casino {
	
	/**
	 * Liste des tables du casino.
	 */
	private ArrayList<Table> tables;
	
	/**
	 * Liste des croupiers du casino.
	 */
	private ArrayList<CroupierImpl> croupierImpls;
	
	/**
	 * Scanner de saisie.
	 */
	private Scanner sca;
	
	//private ServerThread[] sockServer; 

	/**
	 * Constructeur Casino.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public Casino() throws RemoteException {
		super();
		// Création des croupiers
		for (int i=0; i<7; i++){
			String nomCroupier = "Croupier" + i;
			CroupierImpl croupier = new CroupierImpl(nomCroupier);
			croupierImpls.add(croupier);
		}
		// Création des tables
		for (int j=0; j<7; j++){
			Table table = new Table(6, j, "permanente", "Casino", croupierImpls.get(j));
			tables.add(table);
		}
	}
	
	/**
	 * Permet au client de rejoindre une table.
	 * 
	 * @param client
	 * 			Le client qui rejoint la table.
	 * @param idTable
	 * 			L'identifiant de la table.
	 */
	public void rejoindreTablePermanente(Client client, int idTable){
		tables.get(idTable).accepterJoueur(client);
	}
	
	/**
	 * Permet au client de quitter une table.
	 * 
	 * @param client
	 * 			Le client qui quitte la table.
	 * @param idTable
	 * 			L'identifiant de la table.
	 */
	public void quitterTablePermanente(Client client, int idTable){
		tables.get(idTable).retirerJoueur(client);
	}
	
	/**
	 * Propose au joueur les tables disponibles.
	 */
	public void proposerTable(){
		System.out.println("Tables disponibles");
		// Recherche les places disponibles sur chaque tables
		for (int k=0; k<7; k++){
			int nbPlaceRestante = tables.get(k).nombrePlaceRestante();
			if (nbPlaceRestante > 0){
				System.out.println(tables.get(k).getIdTable() + " Reste: " + nbPlaceRestante);
			}
		}
	}
	
	/**
	 * Création d'une table par un client.
	 * 
	 * @param client
	 * 			Le Client qui crée la table.
	 */
	public void gestionJeuTableTemp(Client client){
		synchronized (client) {
			System.out.println("Combien de joueurs acceptez-vous au maximum?");
			String nbJoueursMax = sca.nextLine();
			try {
				Table tableJoueur = creerTableTemporaire(Integer.parseInt(nbJoueursMax), client.getNom());
				tables.get(tableJoueur.getIdTable()).accepterJoueur(client);
				Date date = new Date();
				//sockServer[counter] = new ServerThread(counter);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Crée une table de BlackJack.
	 * 
	 * @param nbJoueursMax
	 * 			Nombre de joueurs maximum accepté par la table.
	 * @param createur
	 * 			Nom du créateur de la table.
	 * 
	 * @return La nouvelle table.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	public Table creerTableTemporaire(int nbJoueursMax, String createur) throws RemoteException{
		int idTable = tables.size();
		CroupierImpl croupierImpl = new CroupierImpl("Croupier interimaire");
		Table tableTemp = new Table(nbJoueursMax, idTable, "temporaire" , createur, croupierImpl);
		tables.add(tableTemp);
		return tableTemp;
	}
	
	/**
	 * Supprime une table.
	 * 
	 * @param idTable
	 * 			Identifiant de la table à supprimer.
	 */
	public void supprimerTableTemporaire(int idTable){
		Table tableASupprimer = tables.get(idTable);
		CroupierImpl croupierALicencier = tableASupprimer.getCroupierImpl();
		croupierImpls.remove(croupierALicencier);
		tables.remove(idTable);
	}
	

}
