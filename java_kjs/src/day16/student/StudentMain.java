package day16.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StudentMain {
	
	static Scanner scan = new Scanner(System.in);
	static List<Student> studentList = new ArrayList<Student>();
	public static void main(String[] args) {
		
		/* 다음 기능을 가진 프로그램을 만드세요.
		 *  - 학생 관리 프로그램
		 *  - 기능
		 *   1. 학생 추가
		 *   2. 학생 조회
		 *   3. 종료 - 종료시 저장
		 *  - 학생은 학년,반,번호,이름 을 가진다.
		 *  - 저장 기능과 불러오기 기능을 통해 학생 정보를 유지
		 *   
		 * */
		int menu=0;
		String fileName = "src/day16/student/Students.txt";
		// 불러오기
		load(fileName);
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}
			catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}
		while( menu != 3);
		// 저장
		save(fileName);
	}
	
	
	
	
	
	// 불러오기
	private static void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			studentList = (ArrayList<Student>)ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일 작업 중에 오류가 발생했습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("잘못된 클래스 명입니다.");
		}
		
	}
	
	// 저장
	private static void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(studentList);
		} catch (IOException e) {
			System.out.println("파일 저장 중 오류가 발생했습니다.");
		}
	
	}

	// 메뉴출력
	private static void printMenu() {
		System.out.println("---메뉴---");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회");
		System.out.println("3. 종료");
		System.out.println("--------");
		System.out.print("메뉴 입력 : ");
	}
	
	// 메뉴실행
	private static void runMenu(int menu) {
		switch(menu) {
		case 1: insertStudent(); break;
		case 2: searchStudent(); break;
		case 3: 
			System.out.println("저장 후 프로그램 종료합니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	// 학생 추가
	private static void insertStudent() {
		int  grade, classNum, num;
		String name;
		System.out.println("--학생 추가--");
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classNum = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		Student tmp = new Student(grade, classNum, num, "");
		if(studentList.contains(tmp)) {
			System.out.println("이미 등록된 학생 정보입니다.");
			return;
		}
		System.out.print("이름 : ");
		name = scan.next();
		tmp.setName(name);
		studentList.add(tmp);
		tmp.print();
		System.out.println(" 학생 추가 되었습니다.");
	}
	
	// 전체 학생 조회
	private static void searchStudent() {
		System.out.println("-전체 학생 조회-");
		for(Student tmp : studentList) {
			tmp.print();
		}
	}

	

}

@Data
@AllArgsConstructor
class Student implements Serializable{
	private static final long serialVersionUID = 5559941038179236087L;
	private int grade, classNum, num;
	private String name;
	
	// 학생정보 출력
	public void print() {
		System.out.print(grade + "학년 " + classNum + "반 " + num + "번 " + name);
		System.out.println();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}
}