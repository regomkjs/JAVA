package day18.student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import lombok.NonNull;
import program.Program;

public class StudentProgram implements Program, Serializable {
	private static final long serialVersionUID = 762242633256130056L;
	Scanner scan= new Scanner(System.in);
	List<Student> list = new ArrayList<Student>();
	String ip = "192.168.30.14";
	int port = 5001;
	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	@Override
	public void run() {
		
		int menu=0;
		// 서버로부터 리스트 받기 
		loadList();
		// 메뉴
		do {
			printMenu();
			try {
				menu = scan.nextInt(); 
				runMenu(menu);
			}
			catch(Exception e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}
		while(menu != 4);
		
		// 서버에 리스트 전송
		sendList();
		
	}


	private void loadList() {
		try (Socket socket = new Socket(ip, port)){
			ois = new ObjectInputStream(socket.getInputStream());
			//if(ois.readObject()!= null) {    // 무한루프에 빠짐...
				list = (List<Student>) ois.readObject();
			//	return;
			//}
			//System.out.println("리스트가 비어있습니다.");
		} 
		catch (Exception e) {
			System.out.println("로드 실패");
		}
	}


	private void sendList() {
		try (Socket socket = new Socket(ip, port)){
			oos = new ObjectOutputStream(socket.getOutputStream());
			if(list.equals(null)) {
				oos.writeObject(null);
				return;
			}
			oos.writeObject(list);
		}
		catch (Exception e) {
			System.out.println("세이브 실패");
		}

	}


	@Override
	public void printMenu() {
		System.out.println("===메뉴===");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 조회");
		System.out.println("3. 학생 수정");
		System.out.println("4. 종료");
		System.out.println("=========");
		System.out.print("메뉴 입력 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1: 
			insert();
			break;
		case 2: 
			printAll();
			break;
		case 3: 
			update();
			break;
		case 4: 
			System.out.println("프로그램 종료");
			break;
		default:
			throw new InputMismatchException();
		}
		
	}

	

	private void update() {
		System.out.println("==학생 수정==");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		if(!list.contains(new Student(grade, classNum, num))) {
			System.out.println("등록 되지 않은 학생 정보입니다.");
			return;
		}
		System.out.print("수정할 이름 : ");
		String name = scan.next();
		Student tmp = new Student(grade, classNum, num);
		int index = list.indexOf(tmp);
		list.get(index).setName(name);
		sort();
	}


	private void insert() {
		System.out.println("==학생 추가==");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		if(list.contains(new Student(grade, classNum, num))) {
			System.out.println("이미 등록된 학생정보입니다.");
			return;
		}
		System.out.print("이름 : ");
		String name = scan.next();
		Student tmp = new Student(grade, classNum, num);
		tmp.setName(name);
		list.add(tmp);
		sort();
	}
	
	private void sort() {
		list.sort((s1,s2)-> {
			if(s1.getGrade() != s2.getGrade()) {
				return s1.getGrade() - s2.getGrade();
			}
			if(s1.getClassNum() != s2.getClassNum()) {
				return s1.getClassNum() - s2.getClassNum();
			}
			return s1.getNum() - s2.getNum();
		});
	}
	
	
	private void printAll() {
		list.stream().forEach((s)-> System.out.println(s.toString()));
	}
}
