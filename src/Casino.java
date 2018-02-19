import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Casino {
	
	ArrayList<Table> tables;
	ArrayList<CroupierImpl> croupierImpls;
	Scanner sca;
	
	private ServerThread[] sockServer; 

	public Casino() throws RemoteException {
		super();
		for (int i=0; i<7; i++){
			String nomCroupier = "Croupier" + i;
			CroupierImpl croupier = new CroupierImpl(nomCroupier);
			croupierImpls.add(croupier);
		}
		for (int j=0; j<7; j++){
			Table table = new Table(6, j, "permanente", "Casino", croupierImpls.get(j));
			tables.add(table);
		}
	}
	
	void rejoindreTablePermanente(Client client, int idTable){
		tables.get(idTable).accepterJoueur(client);
	}
	
	void quitterTablePermanente(Client client, int idTable){
		tables.get(idTable).retirerJoueur(client);
	}
	
	void proposerTable(){
		System.out.println("Tables disponibles");
		for (int k=0; k<7; k++){
			int nbPlaceRestante = tables.get(k).nombrePlaceRestante();
			if (nbPlaceRestante > 0){
				System.out.println(tables.get(k).getIdTable() + " Reste: " + nbPlaceRestante);
			}
		}
	}
	
	
	
	void gestionJeuTableTemp(Client client){
		synchronized (client) {
			System.out.println("Combien de joueurs acceptez-vous au maximum?");
			String nbJoueursMax = sca.nextLine();
			try {
				Table tableJoueur = creerTableTemporaire(Integer.parseInt(nbJoueursMax), client.getNom());
				tables.get(tableJoueur.getIdTable()).accepterJoueur(client);
				Date date = new Date();
				sockServer[counter] = new ServerThread(counter);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	Table creerTableTemporaire(int nbJoueursMax, String createur) throws RemoteException{
		int idTable = tables.size();
		CroupierImpl croupierImpl = new CroupierImpl("Croupier intérimaire");
		Table tableTemp = new Table(nbJoueursMax, idTable, "temporaire" , createur, croupierImpl);
		tables.add(tableTemp);
		return tableTemp;
	}
	
	void supprimerTableTemporaire(int idTable){
		Table tableASupprimer = tables.get(idTable);
		CroupierImpl croupierALicencier = tableASupprimer.getCroupierImpl();
		croupierImpls.remove(croupierALicencier);
		tables.remove(idTable);
	}
	

}
