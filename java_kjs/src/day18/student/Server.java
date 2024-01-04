package day18.student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Data;


@Data
//소켓통신 쓰레드 만들기
public class Server implements Serializable{
	private static final long serialVersionUID = 1453216683055102116L;
	private Socket socket;
	List<Student> list = new ArrayList<Student>();
	String fileName = "src/day18/student/studentList.txt";
	Scanner scan = new Scanner(System.in);
	ObjectInputStream ois;
	ObjectOutputStream oos;
	// 서버가 받은 정보를 파일에 저장
	public void serverReceive() {
		Thread t = new Thread(() -> {
			try {
				ois =  new ObjectInputStream(socket.getInputStream());
				list = (ArrayList<Student>) ois.readObject();
				save(list);
				System.out.println("수신 기능 종료");
			}
			catch(Exception e) {
				System.out.println("아직 받은 정보가 없습니다.");
			} 
		});
		t.start();
	}
	
	
	private void save(List<Student> list) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(list);
		}
		catch(Exception e) {
			System.out.println("학생 정보를 저장하는 도중 오류 발생");
		}	
	}

	// 서버가 파일 정보를 입력받아 클라이언트에 전송
	public void serverSend() {
		Thread t = new Thread(()-> {
			list = load();
			
			try {
				while(true) {
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(list);
					oos.flush();
					String menu = scan.next();
					if(menu.equals("3")) {
						break;
					}
				}
				System.out.println("전송 기능 종료");
			}
			catch(Exception e) {
				System.out.println("통신 전송 실패");
			}	
		});
		t.start();
	}

	private List<Student> load() {
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
			list = (List<Student>) ois.readObject();
			return list;
		}
		catch(Exception e) {
			
			return null;
		}	
	}


	// 생성자
	public Server(Socket socket) {
		this.socket = socket;
	}
	
	
	
}
