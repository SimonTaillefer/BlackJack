public class JeuCarte {

	public Carte jeuCartes[] = new Carte[53];
	// Les cartes sont numérotées de 1 à 52 en mémoire, mais identifiées par la concaténation de son type et de son numero
	// Exemple: dame de coeur : type = 1 dame = 11 identifiant=111

	public JeuCarte() {		// Génération du jeu de 52 cartes
		super();
		String i;
		for (int numTypeCarte=1; numTypeCarte<5; numTypeCarte++){	//Génération du type: coeur carreau, trèfle ou pique
			System.out.print(numTypeCarte);
			for (int numCarte=1; numCarte<14; numCarte++){			//Génération des cartes de l'as(1) au roi(13) 
				i = (Integer.toString(numTypeCarte) + Integer.toString(numCarte));
				System.out.println("Carte numero i = "+ i + " corresond à " + correspondCarte(i));
				jeuCartes[correspondCarte(i)] = new Carte(numCarte, numTypeCarte);
			}
		}
	}
	
	int correspondCarte(String numCarte){ //Fait la correspondance entre le numéro concaténé et le numero memoire de la carte
		if (numCarte.length()>2){
			return Character.getNumericValue(numCarte.charAt(1)+numCarte.charAt(2)) + (Character.getNumericValue(numCarte.charAt(0))-1)*13;
		}
		else {
			return Character.getNumericValue(numCarte.charAt(1)) + (Character.getNumericValue(numCarte.charAt(0))-1)*13;
		}
	}
	
	void setProprietaireCarte(String proprietaire, int numeroCarte){
		jeuCartes[correspondCarte(Integer.toString(numeroCarte))].propritaire=proprietaire;
	}
	
	String getProprietaireCarte(int numeroCarte){
		return jeuCartes[numeroCarte].getPropritaire();
	}
	
	int getPointsCarte(int numeroCarte){
		return jeuCartes[numeroCarte].getNumero();
	}
	

}
