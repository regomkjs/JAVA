package day17.socket1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientEx1 {
	
	public static void main(String[] args) {
		// 서버의 IP, port 번호 설정
		String ip = "192.168.30.14";
		int port = 5001;
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = null;
		
		// 1. IP와 port를 이용해 소켓 생성 및 대기
		try(Socket socket = new Socket(ip, port)){
			// 2. 작업
			System.out.println("연결 성공!!");
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			// 채팅 내역을 받아옴
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			list = (ArrayList<String>) ois.readObject();
			// 채팅 내역 조회
			System.out.println(list);
			while(true) {
				System.out.print("내용 [종료 : -1] : ");
				String str = scan.nextLine();
				oos.writeUTF(str);
				oos.flush();
				if(str.equals("-1")) {
					break;
				}
				list.add(str);
			}
			oos.close();
			
		} catch (UnknownHostException e) {
			System.out.println("연결할 수 없습니다");
		} catch (IOException e) {
			System.out.println("예외 발생");
		} catch (ClassNotFoundException e) {
			System.out.println("채팅 불러오기 실패");
		}
	}

}
