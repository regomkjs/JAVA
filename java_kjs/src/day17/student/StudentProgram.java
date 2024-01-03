package day17.student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;

public class StudentProgram implements Program {
	
	private String fileName = "src/day17/student/List.txt";
	private StudentManager sm = new StudentManager();
	private Scanner scan = new Scanner(System.in);
	private final int EXIT = 3;
	@Override
	public void run() {
		int menu=0;
		load(fileName);
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e){
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while (menu != EXIT);
		save(fileName);
	}
	
	@Override
	public void printMenu() {
		System.out.println("---메뉴---");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회");
		System.out.println("3. 종료");
		System.out.println("--------");
		System.out.print("메뉴 입력 : ");
	}

	@Override
	public void runMenu(int menu) {
		
		switch (menu) {
		case 1:
			Student std = insert();
			if(sm.insertStudent(std)) {
				System.out.println("학생을 추가했습니다.");
				return;
			}
			System.out.println("이미 등록된 학생입니다.");
			break;
		case 2: 
			if(sm.getList().size() == 0) {
				System.out.println("아직 등록된 학생이 없습니다.");
				return;
			}
			System.out.println("-전체 학생 조회-");
			sm.printAll();
			break;
		case 3: 
			System.out.println("프로그램 종료");
			break;
		default:
			throw new InputMismatchException();
		}

	}

	private Student insert() {
		int grade, classNum, num;
		String name;
		System.out.println("--학생 추가--");
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classNum = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		System.out.print("이름 : ");
		name = scan.next();
		Student std = new Student(grade, classNum, num, name);
		return std;
	}
	
	// 불러오기
	private void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			sm = (StudentManager)ois.readObject();
			System.out.println("불러오기 완료");
		} catch (IOException e) {
			System.out.println("파일 불러오기에 실패 했습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("잘못된 클래스 명입니다.");
		}
		
	}
	
	// 저장
	private void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(sm);
			System.out.println("저장 완료");
		} catch (IOException e) {
			System.out.println("파일 저장 중 오류가 발생했습니다.");
		}
	
	}
	
}
