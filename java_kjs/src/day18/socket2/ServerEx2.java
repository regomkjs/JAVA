package day18.socket2;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx2 {

	public static void main(String[] args) {
		int port = 5001;
		try(ServerSocket serverSocket = new ServerSocket(port)){
			while(true) { // while문을 추가 하는 것으로 여러 클라이언트의 정보를 받을수 있다.
				Socket socket = serverSocket.accept();
				Client client = new Client(socket);
				client.receive();
				client.send();
			}
		} catch (Exception e) {
			System.out.println("서버 소켓에 예외가 발생하여 서버가 종료됩니다.");
		}
	}

}
