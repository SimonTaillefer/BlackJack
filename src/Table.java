import java.util.ArrayList;

/**
 * Table est la classe définissant une table du casino.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public class Table extends Thread{
	
	/**
	 * Liste des client de la table.
	 */
	ArrayList<Client> clients;
	
	/**
	 * Si la partie est en cours ou non.
	 */
	boolean partieEnCours;
	
	/**
	 * Le nombre maximum de joueurs sur la table.
	 */
	int nbMaxJoueurs;
	
	/**
	 * Le nombre de joueurs présents.
	 */
	int nbJoueurs;
	
	/**
	 * L'identifiant unique de la table.
	 */
	int idTable;
	
	/**
	 * Le type de la table.
	 */
	String typeTable;
	
	/**
	 * Le nom du créateur de la table.
	 */
	String createur;
	
	/**
	 * Le croupier de la table.
	 */
	CroupierImpl croupierImpl;
	
	/**
	 * Constructeur Table.
	 * 
	 * @param nbMaxJoueurs
	 * 			Le nombre maximum de joueurs.
	 * @param idTable
	 * 			L'indentifiant de la table.
	 * @param typeTable
	 * 			Le type de la table.
	 * @param createur
	 * 			Le créateur de la table.
	 * @param croupierImpl
	 * 			Le croupier de la table.
	 */
	public Table(int nbMaxJoueurs, int idTable, String typeTable, String createur, CroupierImpl croupierImpl) {
		super();
		this.nbMaxJoueurs = nbMaxJoueurs;
		this.idTable = idTable;
		partieEnCours = false;
		this.typeTable = typeTable;
		this.createur = createur;
		this.croupierImpl = croupierImpl;
	}
	
	/**
	 * Retourne le nombre de places libres restantes.
	 * 
	 * @return Le nombre de places libres.
	 */
	int nombrePlaceRestante(){
		return nbMaxJoueurs - nbJoueurs;
	}
	
	/**
	 * Retourne le croupier de la table.
	 * 
	 * @return Le croupier de la table.
	 */
	public CroupierImpl getCroupierImpl() {
		return croupierImpl;
	}

	/**
	 * Met à jour le croupier de la table.
	 * 
	 * @param croupierImpl
	 * 			Le nouveau croupier.
	 */
	public void setCroupierImpl(CroupierImpl croupierImpl) {
		this.croupierImpl = croupierImpl;
	}

	/**
	 * Ajoute un client à la table.
	 * 
	 * @param client
	 * 			Le client à ajouter.
	 */
	void accepterJoueur(Client client){
			clients.add(client);
	}
	
	/**
	 * Retourne l'identifiant de la table.
	 * 
	 * @return L'identifiant de la table.
	 */
	public int getIdTable() {
		return idTable;
	}

	/**
	 * Met à jour l'identifiant de la table.
	 * 
	 * @param idTable
	 * 			Le nouvel identifiant de la table.
	 */
	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}

	/**
	 * Retire un joueur de la table.
	 * 
	 * @param client
	 * 			Le joueur à retirer.
	 */
	void retirerJoueur(Client client){
		clients.remove(client);
	}
	
	/**
	 * Retourne le nombre maximum de joueurs accepté par la table.
	 * 
	 * @return Le nombre maximum de joueur.
	 */
	public int getNbMaxJoueurs() {
		return nbMaxJoueurs;
	}

	/**
	 * Met à jour le nombre maximum de joueurs que la table accepte.
	 * 
	 * @param nbMaxJoueurs
	 * 			Le nouveau nombre maximum de joueurs.
	 */
	public void setNbMaxJoueurs(int nbMaxJoueurs) {
		this.nbMaxJoueurs = nbMaxJoueurs;
	}

	/**
	 * Retourne le nombre de joueurs sur la table.
	 * 
	 * @return Le nombre de joueur.
	 */
	public int getNbJoueurs() {
		return nbJoueurs;
	}

	/**
	 * Met à jour le nombre de joueur de la table.
	 * 
	 * @param nbJoueurs
	 * 			Le nouveau nombre de joueurs de la table.
	 */
	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	/**
	 * Retourne le type de la table.
	 * 
	 * @return Le type de la table.
	 */
	public String getTypeTable() {
		return typeTable;
	}

	/**
	 * Met à jour le type de la table.
	 * 
	 * @param typeTable
	 * 			Le nouveau type de la table.
	 */
	public void setTypeTable(String typeTable) {
		this.typeTable = typeTable;
	}

	


	
	
	
	

}
