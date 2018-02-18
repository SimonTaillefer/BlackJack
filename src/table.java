import java.util.ArrayList;

public class table {
	
	ArrayList<Client> clients;
	int nbMaxJoueurs;
	int nbJoueurs;
	int IdTable;
	String typeTable;
	CroupierImpl croupierImpl;
	
	public table(int nbMaxJoueurs, int idTable, String typeTable, CroupierImpl croupierImpl) {
		super();
		this.nbMaxJoueurs = nbMaxJoueurs;
		IdTable = idTable;
		this.typeTable = typeTable;
		this.croupierImpl = croupierImpl;
	}
	
	
	int accepterJoueur(Client client){
		if (nbJoueurs < nbMaxJoueurs){
			clients.add(client);
			return 1;
		}
		else {
			return 0;
		}
		
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
