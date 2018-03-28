import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * AffichageClientImpl est la classe contenant les méthodes RMI
 * 
 * @author Alexis PION, Simon TAILLEFER, Bastien VOIRIN
 *
 */
public class AffichageClientImpl extends UnicastRemoteObject implements AffichageClient {

	/**
	 * 	Version de la classe.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur AffichageClientImpl.
	 * 
	 * @throws RemoteException
	 * 			Exception RMI.
	 */
	protected AffichageClientImpl() throws RemoteException {
		super();
	}

	/**
	 * Affiche le message du serveur sur l'écran du client.
	 * 
	 */
	public void notification(String message) throws RemoteException {
		System.out.println(message);		
	}
}
