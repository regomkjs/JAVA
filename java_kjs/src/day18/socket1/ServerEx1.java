package day18.socket1;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx1 {

	public static void main(String[] args) {
		int port = 5001;
		try(ServerSocket serverSocket = new ServerSocket(port)){
			Socket socket = serverSocket.accept();
			Client client = new Client(socket);
			client.receive();
			client.send();
		} catch (Exception e) {
			System.out.println("서버 소켓에 예외가 발생하여 서버가 종료됩니다.");
		}
	}

}
