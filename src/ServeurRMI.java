import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


@SuppressWarnings("deprecation")

/**
 * ServeurRmi est la classe qui lance le serveur du casino.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public class ServeurRMI {
	
	/**
	 * Lancement du serveur.
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		try {
			// Création du rmiregistry
			LocateRegistry.createRegistry(1099);
			
			// Vérification sécurité
			System.out.println("Security Manager");
			if (System.getSecurityManager() == null) 
				System.setSecurityManager(new RMISecurityManager());
				
			// Mise à disposition de l'objet distant RMI
		    Naming.rebind("Croupier", new CroupierImpl("Croupier"));

		    System.out.println("Serveur lancé");
		  } catch (RemoteException e) {
		    e.printStackTrace();
		  } catch (MalformedURLException e) {
		    e.printStackTrace();
		  }
	}
}
