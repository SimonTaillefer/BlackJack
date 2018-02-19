import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


@SuppressWarnings("deprecation")
public class ServeurRMI {
	
	public static void main(String[] args){
		
		CroupierImpl croupier1;
		try {
			LocateRegistry.createRegistry(1099);
			
			System.out.println("Security Manager");
			if (System.getSecurityManager() == null) 
				System.setSecurityManager(new RMISecurityManager());
				
			croupier1 = new CroupierImpl("Croupier");
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/RMI";
		    System.out.println("Enregistrement de l'objet avec l'url : " + url);
		    Naming.rebind(url, croupier1);

		    System.out.println("Serveur lancé");
		  } catch (RemoteException e) {
		    e.printStackTrace();
		  } catch (MalformedURLException e) {
		    e.printStackTrace();
		  } catch (UnknownHostException e) {
		    e.printStackTrace();
		}
	}
}
