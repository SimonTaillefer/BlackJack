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
		System.out.println("Carte tiree numero:" + carte.numero);
		System.out.println("Carte tiree type:" + carte.type);
		System.out.println("Carte tiree valeur:" + carte.valeur);
		carteList.add(carte);
	}
	
}