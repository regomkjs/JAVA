package day18.socket1;

import java.net.Socket;

public class ClientEx1 {

	public static void main(String[] args) {
		int port = 5001;
		String ip = "192.168.30.14";
		
		try {
			Socket socket = new Socket(ip, port);
			Client client = new Client(socket);
			client.receive();
			client.send();
		}catch(Exception e) {
			System.out.println("예외가 발생하여 종료합니다.");
		}
	}

}
