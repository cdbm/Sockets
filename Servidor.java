import java.io.DataInputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;



public class Servidor {

	public static void main(String[] args) {
		int port = 3001;
		
		try {
		 ServerSocket tpmsocket = new ServerSocket(port);
		 System.out.println("Arguandando Cliente");
		 Socket socket = tpmsocket.accept();
		 DataInputStream entrada= new DataInputStream(socket.getInputStream());
		 int num = entrada.read();
		 
		 System.out.println(num+2);
		 socket.close();
		}catch(BindException e){
			System.out.println("Endereço em uso");
		}catch(Exception e) {
			System.out.println("Erro: " + e);
		}

	}

}