import java.util.concurrent.ThreadLocalRandom;

public class Croupier extends Joueur {

	

	public Croupier(String nom) {
		super(nom);
	}

	public void distribuerUneCarte(Joueur joueur, JeuCarte jeuCarte){
		int randomNum = ThreadLocalRandom.current().nextInt(1, 13 + 1);
		int randomType = ThreadLocalRandom.current().nextInt(1, 4 + 1);
		System.out.println("RandomNum" + randomNum);
		System.out.println("RandomType" + randomType);
		String carteNum = (Integer.toString(randomType) + Integer.toString(randomNum));
		//if ((joueur.getClass().getName()) == "Client"){
			jeuCarte.setProprietaireCarte(joueur.nom, Integer.parseInt(carteNum));
		/*}
		else if ((joueur.getClass().getName()) == "Croupier") {
			jeuCarte.setProprietaireCarte(joueur.nom, Integer.parseInt(carteNum));
		}*/
		System.out.println("ProprietaireCarte:" + jeuCarte.getProprietaireCarte(jeuCarte.correspondCarte(carteNum))); //Vérifie le proprietaire de la carte
		
	}
	
	
	
	public int trouverIDJoueur(Client client[], String nomJoueur, int nbJoueurs){ //Cherche l'identifiant du joueur à partir de son nom
		for (int i=0; i<nbJoueurs; i++){
			if (client[i].nom == nomJoueur){
				return i;
			}
		}
		return -1;
	}
	

	

}
