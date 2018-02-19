import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Croupier extends Remote {
	
	public void gererGagnant() throws RemoteException;
	
	public boolean IACroupier() throws RemoteException;
	
	public boolean finManche() throws RemoteException;
	
	public boolean finPartie() throws RemoteException;
	
	public String gererJeu() throws RemoteException;
}
