import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;

@SuppressWarnings("deprecation")

public class ClientRMI {

	public static void main(String[] args) {
		System.out.println("Lancement du client");
	    if (System.getSecurityManager() == null) {
	      System.setSecurityManager(new RMISecurityManager());
	    }
	    try {
	      Remote r = Naming.lookup("rmi://127.0.1.1/RMI");
	      System.out.println(r);
	      if (r instanceof Croupier) {
	    	  System.out.println("HELLO");
	        String s = ((Croupier) r).gererJeu();
	        System.out.println(s);
	      }
	    } catch (MalformedURLException e) {
	      e.printStackTrace();
	    } catch (RemoteException e) {
	      e.printStackTrace();
	    } catch (NotBoundException e) {
	      e.printStackTrace();
	    }
	    System.out.println("Fin du client");
	}
}
