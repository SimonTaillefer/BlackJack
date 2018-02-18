import java.util.ArrayList;

public class MainJoueur {

	private ArrayList<Carte> carteList;
	
	public MainJoueur() {
		super();
		this.carteList = new ArrayList<Carte>();
	}

	public int compterPoints(){
		int score = 0;			
		for (Carte carte : carteList) {
			score = score + carte.getValeur();
		}
		return score;
	}
	
	public void ajouterCarte(Carte carte){
		carteList.add(carte);
	}
	
	public int compterNBCartes(){
		return carteList.size();
	}
	
	public void lireCartesEnMain(){
		for (Carte carteEnMain : carteList) {
			System.out.println(carteEnMain.lireNumeroCarte() + " de " + carteEnMain.lireTypeCarte() + ".");
		}
	}
	
	public void lireUneCarte(){
		System.out.println(carteList.get(0).lireNumeroCarte() + " de " + carteList.get(0).lireTypeCarte() + ".");
	}
	
	void reinitialiserListeCarte(){
		carteList = new ArrayList<Carte>();
	}
	
}