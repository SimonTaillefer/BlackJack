import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * AffichageClient est l'interface de notification RMI.
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 */
public interface AffichageClient extends Remote {

	/**
	 * 
	 * 
	 * @param message 
	 * 			Variable de notification.
	 * @throws RemoteException 
	 * 			Exception RMI.
	 */
	public void notification(String message) throws RemoteException;
}
