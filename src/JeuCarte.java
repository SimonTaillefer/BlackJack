import java.util.Random;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class JeuCarte {

	private static final int NB_CARTES = 52;
	private static final Random rand = new Random();
	private int carteADistribuer;
	public Carte jeuCartes[];
			
	// Les cartes sont numérotées de 1 à 52 en mémoire, mais identifiées par la concaténation de son type et de son numero
	// Exemple: dame de coeur : type = 1 dame = 11 identifiant=111
	
    public JeuCarte(){
    	jeuCartes = new Carte[NB_CARTES+1];
    	this.carteADistribuer = 0;
    	int k=0;
        for(int numTypeCarte=0; numTypeCarte<4;numTypeCarte++ ) {	//Boucle du type: coeur carreau, trèfle ou pique
            for(int numCarte=1; numCarte<14; numCarte++){			//Boucle pour les cartes de l'as(1) au roi(13) 
                if ((numCarte>0) && (numCarte<11)){					//Génération des cartes à nombres sauf as
                	jeuCartes[k] = new Carte(numCarte, numTypeCarte, numCarte);
    				System.out.println("Carte numero : " + jeuCartes[k].numero);
    				System.out.println("Carte type : " + jeuCartes[k].type);
    			}
    			else if (numCarte>10) {								//Génération des cartes figure et as
 					jeuCartes[k] = new Carte(numCarte, numTypeCarte, 10);
   					System.out.println("CARTE numero : " + jeuCartes[k].numero);
   					System.out.println("CARTE type : " + jeuCartes[k].type);
   				}
                k++;
                System.out.println("-------");
                System.out.println(k);
           }
       }
       System.out.println(jeuCartes);

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
			System.out.println("CarteADistribuer : " + carteADistribuer);
			carteADistribuer++;
	        return j;
	        
	    }
	    else{
	        return null;
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

}
