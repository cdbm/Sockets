import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ConnectException;

public class Cliente {

	public static void main(String[] args) {
		int port = 3001;
		String address = "localhost";
		
		try {
			Socket socket = new Socket(address, port);
			DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
			saida.write(15);
			
			socket.close();
		}catch(ConnectException e){
			System.out.println("Não foi possível chegar ao destino");
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

}


