public class JeuCarte {

	private Carte jeuCartes[];

	public JeuCarte() {
		super();
		int i;
		jeuCartes = null;
		for (i=0; i<39; i++){ // Génération du jeu de 39 cartes
			for (int numTypeCarte=1; numTypeCarte<5; numTypeCarte++){	//Génération du type: coeur carreau, trèfle ou pique
				for (int numCarte=1; numCarte<14; numCarte++){			//Génération des cartes de l'as(1) au roi(13) 
					System.out.println("NumTypeCarte="+numTypeCarte);
					System.out.println("NumCarte="+numCarte);
					jeuCartes[1] = new Carte(numCarte, numTypeCarte);
				}
			}
		}
	}
	

}
