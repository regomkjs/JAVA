package day18.student;

import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import day18.socket2.Client;

// 소켓 통신 구현부
public class StudentServer implements Serializable{
	private static final long serialVersionUID = -4513231431666653147L;

	public static void main(String[] args) {
		int port = 5001;
		try{
			ServerSocket serverSocket = new ServerSocket(port);
			while(true) {
				Socket socket = serverSocket.accept();
				Server server = new Server(socket);
				server.serverReceive();
				server.serverSend();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
