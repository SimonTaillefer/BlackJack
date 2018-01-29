import java.util.ArrayList;

public class MainJoueur {

	ArrayList<Carte> carteList;
	
	public MainJoueur() {
		super();
		this.carteList = new ArrayList<Carte>();
	}

	public int compterPoints(ArrayList<Carte> cartesJ){
		int score = 0;			
		for (Carte carte : cartesJ) {
			score = score + carte.getValeur();
		}
		return score;
	}
	
	public void ajouterCarte(Carte carte){
		System.out.println("IIIIIIIIICCCCCCCCCCCCCCIIIIIIIIII :" +  carteList);
		carteList.add(carte);
	}
	
}