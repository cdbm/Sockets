import java.io.DataInputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidor {

	public static void main(String[] args) {
		int port = 2020;

		try {
			ServerSocket tpmsocket = new ServerSocket(port);
			System.out.println("Arguandando Cliente");
				
			
			while (true) {
				Socket socket = tpmsocket.accept();
				DataInputStream entrada = new DataInputStream(socket.getInputStream());
				long t1 = System.currentTimeMillis();
				boolean fim = false;

				while (!fim) {
					entrada = new DataInputStream(socket.getInputStream());
					long t2 = System.currentTimeMillis();
					int tempo = (int) ((t2 - t1) / 1000);
					String ent = entrada.readUTF();
					if (tempo >= 10) {
						fim = true;
					}
					System.out.println(ent);

				}
				socket.close();
			}
		
			
		
			

		} catch (BindException e) {
			System.out.println("Endereço em uso");
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}

	}

}