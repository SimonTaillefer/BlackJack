import java.util.concurrent.ThreadLocalRandom;

public class Croupier {
	
	public Croupier() {
		super();
	}

	public void distribuerCarte(Joueur joueur[], String nomJoueur, int nbJoueurs, JeuCarte jeuCarte){
		int randomNum = ThreadLocalRandom.current().nextInt(1, 13 + 1);
		int randomType = ThreadLocalRandom.current().nextInt(1, 4 + 1);
		System.out.println("RandomNum" + randomNum);
		System.out.println("RandomType" + randomType);
		String carteNum = (Integer.toString(randomType) + Integer.toString(randomNum));
		jeuCarte.setProprietaireCarte(joueur[trouverIDJoueur(joueur, nomJoueur, nbJoueurs)].nom, Integer.parseInt(carteNum));
	}
	
	public void compterPointsJoueurs(Joueur joueur[], int nbJoueurs, JeuCarte jeuCarte){
		for (int j=1; j<52; j++){
			String nomJoueur = jeuCarte.getProprietaireCarte(j);
			int idJoueur = trouverIDJoueur(joueur, nomJoueur, nbJoueurs);
			joueur[idJoueur].points = joueur[idJoueur].points + jeuCarte.getPointsCarte(j);
			//Points du joeurs = Points du joueur qu'il a déjà + Points de la carte
		}	
	}
	
	public int trouverIDJoueur(Joueur joueur[], String nomJoueur, int nbJoueurs){ //Cherche l'identifiant du joueur à partir de son nom
		for (int i=0; i<nbJoueurs; i++){
			if (joueur[i].nom == nomJoueur){
				return i;
			}
		}
		return -1;
	}
	

}
