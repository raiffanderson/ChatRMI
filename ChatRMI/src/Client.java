import java.rmi.*;
import javax.swing.*;
import java.util.Scanner;
import java.lang.Thread.*;
import java.util.ArrayList;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Client {

	public static void main(String args[]) {
		try {
			final ServerChat chat = (ServerChat) Naming.lookup("rmi://localhost:1098/ServerChat");

			String nome;
			String msg = "";
			Scanner scanner = new Scanner(System.in);

			System.out.println("Digite seu nome:");

			nome = scanner.nextLine();

			Thread thread = new Thread(new Runnable() {
				int cont = chat.lerMensagem().size();

				@Override
				public void run() {
					try {
						while (true) {
							if (chat.lerMensagem().size() > cont) {
								System.out.println(chat.lerMensagem().get(chat.lerMensagem().size() - 1));
								cont++;
							}
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();

			while (msg != "exit") {

				System.out.println(nome + ": ");

				msg = scanner.nextLine();

				chat.enviarMensagem(nome + ": " + msg);
				// System.out.println(chat.lerMensagem().get(cont));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}