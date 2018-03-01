import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public Server() {
		try {
			Registry registry = LocateRegistry.createRegistry(1098);
			ServerChat server = new ServerChatImpl();
			Naming.rebind("rmi://localhost:1098/ServerChat", server);

		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}

	}

	public static void main(String args[]) {
		new Server();
	}

}