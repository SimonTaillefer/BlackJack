import java.util.Random;

/**
 * JeuCarte est la classe contenant les 54 cartes d'un jeu de cartes.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public class JeuCarte {

	/**
	 * Nombre de carte 
	 */
	private static final int NB_CARTES = 52;
	
	/**
	 * Variable de hasard.
	 */
	private static final Random rand = new Random();
	
	/**
	 * Nombre de cartes à distribuer.
	 */
	private int carteADistribuer;
	
	/**
	 * Tableau de cartes.
	 */
	public Carte jeuCartes[];
			
	// Les cartes sont num�rot�es de 1 � 52 en m�moire, mais identifi�es par la concat�nation de son type et de son numero
	// Exemple: dame de coeur : type = 1 dame = 11 identifiant=111
	
	/**
	 * Constructeur JeuCarte.
	 */
    public JeuCarte(){
    	jeuCartes = new Carte[NB_CARTES];
    	this.carteADistribuer = 0;
    	int k=0;
        for(int numTypeCarte=0; numTypeCarte<4;numTypeCarte++ ) {	//Boucle du type: coeur carreau, tr�fle ou pique
            for(int numCarte=1; numCarte<14; numCarte++){			//Boucle pour les cartes de l'as(1) au roi(13) 
                if ((numCarte>0) && (numCarte<11)){					//G�n�ration des cartes � nombres sauf as
                	jeuCartes[k] = new Carte(numCarte, numTypeCarte, numCarte);
    			}
    			else if (numCarte>10) {								//G�n�ration des cartes figure et as
 					jeuCartes[k] = new Carte(numCarte, numTypeCarte, 10);
   				}
                k++;
           }
       }

    }
	
	/**
	 * Mélange le jeu de cartes.
	 */
    public void melanger(){
        for(int i=0; i<(jeuCartes.length); i++){
            int random = rand.nextInt(NB_CARTES);
            Carte t = jeuCartes[i];
            jeuCartes[i] = jeuCartes[random];
            jeuCartes[random]=t;
        }
    }

    /**
     * Distribue une carte 
     * 
     * @return La carte à distribuer.
     */
	public Carte distribuerUneCarte(){

		if(carteADistribuer<jeuCartes.length){
			Carte j = jeuCartes[carteADistribuer];
			carteADistribuer++;
	        return j;
	        
	    }
	    else{
	        return null;
	    }
	}
	

}
