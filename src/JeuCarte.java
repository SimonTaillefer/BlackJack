import java.util.Random;

public class JeuCarte {

	private static final int NB_CARTES = 52;
	private static final Random rand = new Random();
	int carteADistribuer;
	public Carte jeuCartes[];
			
	// Les cartes sont num�rot�es de 1 � 52 en m�moire, mais identifi�es par la concat�nation de son type et de son numero
	// Exemple: dame de coeur : type = 1 dame = 11 identifiant=111
	
    public JeuCarte(){
    	jeuCartes = new Carte[NB_CARTES+1];
    	this.carteADistribuer = 0;

        int k=0;
        for(int numTypeCarte=0; numTypeCarte<4;numTypeCarte++ ) {	//Boucle du type: coeur carreau, tr�fle ou pique
            for(int numCarte=0; numCarte<13; numCarte++){			//Boucle pour les cartes de l'as(1) au roi(13) 
                if ((numCarte>1) && (numCarte<11)){					//G�n�ration des cartes � nombres sauf as
					jeuCartes[k] = new Carte(numCarte, numTypeCarte, numCarte);
				}
				else if (numCarte>10) {								//G�n�ration des cartes figure et as
					jeuCartes[k] = new Carte(numCarte, numTypeCarte, 10);
				}
            }
        }
    }
	
	
	
    public void melanger(){
        for(int i=0; i<jeuCartes.length; i++){
            int random = rand.nextInt(NB_CARTES);
            Carte t = jeuCartes[i];
            jeuCartes[i] = jeuCartes[random];
            jeuCartes[random]=t;
        }
    }

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
	
	int correspondCarte(String numCarte){ //Fait la correspondance entre le num�ro concat�n� et le numero memoire de la carte
		if (numCarte.length()>2){
			return Character.getNumericValue(numCarte.charAt(1)+numCarte.charAt(2)) + (Character.getNumericValue(numCarte.charAt(0))-1)*13;
		}
		else {
			return Character.getNumericValue(numCarte.charAt(1)) + (Character.getNumericValue(numCarte.charAt(0))-1)*13;
		}
	}

}
