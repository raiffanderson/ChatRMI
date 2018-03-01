import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerChat extends Remote {
	public void enviarMensagem(String mensagem) throws RemoteException;

	public ArrayList<String> lerMensagem() throws RemoteException;
}