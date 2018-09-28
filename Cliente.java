import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ConnectException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int port = 2020;
		String address = "localhost";
		
		try {
			Socket socket = new Socket(address, port);
			DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
			while(in.hasNext()) {
			String ler = in.nextLine();
			saida.writeUTF(ler);	
			}
			socket.close();
		}catch(ConnectException e){
			System.out.println("Não foi possível chegar ao destino");
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

}

