import java.rmi.RemoteException;
import java.util.ArrayList;

public class Table extends Thread{
	
	ArrayList<Client> clients;
	boolean partieEnCours;
	int nbMaxJoueurs;
	int nbJoueurs;
	int idTable;
	String typeTable;
	String createur;
	CroupierImpl croupierImpl;
	
	public Table(int nbMaxJoueurs, int idTable, String typeTable, String createur, CroupierImpl croupierImpl) {
		super();
		this.nbMaxJoueurs = nbMaxJoueurs;
		this.idTable = idTable;
		partieEnCours = false;
		this.typeTable = typeTable;
		this.createur = createur;
		this.croupierImpl = croupierImpl;
	}
	
	int nombrePlaceRestante(){
		return nbMaxJoueurs - nbJoueurs;
	}
	
	public CroupierImpl getCroupierImpl() {
		return croupierImpl;
	}

	public void setCroupierImpl(CroupierImpl croupierImpl) {
		this.croupierImpl = croupierImpl;
	}

	void accepterJoueur(Client client){
			clients.add(client);
	}
	
	public int getIdTable() {
		return idTable;
	}

	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}

	void retirerJoueur(Client client){
		clients.remove(client);
	}
	
	void commencerPartie() throws RemoteException{
		croupierImpl.gererJeu();
	}
	
	public int getNbMaxJoueurs() {
		return nbMaxJoueurs;
	}

	public void setNbMaxJoueurs(int nbMaxJoueurs) {
		this.nbMaxJoueurs = nbMaxJoueurs;
	}

	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public String getTypeTable() {
		return typeTable;
	}

	public void setTypeTable(String typeTable) {
		this.typeTable = typeTable;
	}

	


	
	
	
	

}
