public class JeuCarte {

	private Carte jeuCartes[];

	public JeuCarte() {
		super();
		int i;
		jeuCartes = null;
		for (i=0; i<39; i++){ // G�n�ration du jeu de 39 cartes
			for (int numTypeCarte=1; numTypeCarte<5; numTypeCarte++){	//G�n�ration du type: coeur carreau, tr�fle ou pique
				for (int numCarte=1; numCarte<14; numCarte++){			//G�n�ration des cartes de l'as(1) au roi(13) 
					System.out.println("NumTypeCarte="+numTypeCarte);
					System.out.println("NumCarte="+numCarte);
					jeuCartes[1] = new Carte(numCarte, numTypeCarte);
				}
			}
		}
	}
	

}
