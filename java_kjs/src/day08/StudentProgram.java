package day08;

import java.util.Scanner;

public class StudentProgram {
	/* 다음 기능을 가진 성적 관리 프로그램을 작성하세요.
	 * - 1반의 성적을 관리
	 * - 최대 5명
	 * - 성적은 번호순으로 관리
	 * - 성적은 국어, 영어, 수학 성적을 관리
	 * 메뉴
	 * 1. 성적 수정
	 * 2. 성적 조회
	 * 3. 프로그램 종료
	 * 메뉴 선택 :
	 * 
	 * =성적수정=
	 * 1. 국어
	 * 2. 영어
	 * 3. 수학
	 * 과목 선택 : 1 (국어)
	 * 
	 * 학생 선택 : 3 번호 선택
	 * 성적 입력 : 100
	 * 
	 * =성적조회=
	 * 1. 과목별조회
	 * 2. 학생별조회
	 * 선택 : 1
	 * 
	 * =과목별조회=
	 * 1. 국어
	 * 2. 영어
	 * 3. 수학
	 * 과목 선택 :
	 * 
	 * 1번 : 0점
	 * 2번 : 0점
	 * 3번 : 100점
	 * ...
	 * 30번 : 0점
	 * 
	 * =성적조회=
	 * 1. 과목별조회
	 * 2. 학생별조회
	 * 선택 : 2
	 * 학생 선택 : 3
	 * 국어 : 100점
	 * 영어 : 0점
	 * 수학 : 0점
	 * 
	 * */
	public static void main(String[] args) {
		Student stds[] = new Student[5];
		for(int i = 0 ; i < stds.length; i++) {
			stds[i] = new Student();
			stds[i].grade = 1;
			stds[i].classNum = 1;
			stds[i].num = i+1;
		}
		Scanner scan = new Scanner(System.in);
		int menu;
		do {
			int num;
			printMainMenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				
				/*
				print1Menu();
				num = scan.nextInt();
				setScore(num);
				stds[num-1].setKor(scan.nextInt());
				stds[num-1].setEng(scan.nextInt());
				stds[num-1].setMath(scan.nextInt()); 
				*/
				
				updateScore(stds);
				
				break;
			case 2:
				print2Menu();
				menu = scan.nextInt();
				switch(menu) {
				case 1:
					printSubjectScoreMenu();
					menu = scan.nextInt();
					printSubjectByScore(stds);
					break;
				case 2:
					num = printStudentScore();
					System.out.print("국어 : "+stds[num-1].kor +" 영어 : "+stds[num-1].eng+" 수학 : "+stds[num-1].math);
					break;
				default:
					menu = 0;
					System.out.println("잘못된 메뉴입니다.");
				}
				break;
			case 3:
				System.out.println("프로그램 종료");
				break;
			default:
				menu = 0;
				System.out.println("잘못된 메뉴입니다.");
			}
			System.out.println();
		}
		while(menu !=3 );
		scan.close();
	}
	
	// 메인 메뉴 출력
	public static void printMainMenu() {
		System.out.println("--------------");
		System.out.println("메뉴");
		System.out.println("1. 성적 수정");
		System.out.println("2. 성적 확인");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 입력 : ");
	}
	
	// 1번 메뉴 출력
	public static void print1Menu() {
		System.out.println("--------------");
		System.out.println("성적 수정");
		System.out.print("수정할 학생 번호 입력 : ");
	}
	
	// 1번 성적수정 출력
	public static void setScore(int num) {
		System.out.println("--------------");
		System.out.println(num + "번 성적 수정");
		System.out.print("국 영 수 순으로 점수 입력 : ");
	}
	
	// 2번 메뉴 출력
	public static void print2Menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("--------------");
		System.out.println("성적 확인");
		System.out.println("1. 과목별 성적 확인");
		System.out.println("2. 학생별 성적 확인");
		System.out.print("메뉴 입력 : ");
	}
	
	// 성적 출력할 과목 메뉴
	public static void printSubjectScoreMenu() {
		System.out.println("과목별 성적 확인");
		System.out.println("1. 국어");
		System.out.println("2. 영어");
		System.out.println("3. 수학");
		System.out.print("확인할 과목 : ");
	}
	
	// 선택한 과목 성적 출력
	public static void printSubjectScore (int [] subjectScore) {
		for (int i =0; i < subjectScore.length; i++) {
			System.out.println((i + 1) +"번 : " + subjectScore[i]);
		}
	}
	
	
	//
	public static void printSubjectByScore (Student[] stds) {
		System.out.println("과목(국어 : 1, 영어 : 2, 수학 : 3) : ");
		Scanner scan = new Scanner(System.in);
		int subject = scan.nextInt();
		for(Student std : stds) {
			switch(subject) {
			case 1: 
				System.out.println("번호 : " + std.num + "국어 : " + std.kor);
				break;
			case 2: 
				System.out.println("번호 : " + std.num + "영어 : " + std.eng);
				break;
			case 3: 
				System.out.println("번호 : " + std.num + "수학 : " + std.math);
				break;
			default:	
			}
		}
	}
	
	// 학생별 성적 출력
	public static int printStudentScore() {
		Scanner scan = new Scanner(System.in);
		System.out.println("학생별 성적 확인");
		System.out.print("성적을 확인할 학생 번호 : ");
		int num = scan.nextInt();
		System.out.println(num +"번의 성적");
		return num;
	}
	
	/* 기능 : 학생들 정보가 주어지고 추가정보를 입력하면 학생 성적을 수정하는 메서드
	 * 매개변수 : 학생들 정보 => Student[] stds
	 * 리턴타입 : 없음 => void
	 * 메서드명 : updateScore
	 * */
	// 선생님 방식으로 구현해본 메서드
	public static void updateScore(Student[] stds) {
		Scanner scan = new Scanner(System.in);
		System.out.println("과목을 선택하세요");
		System.out.println("국어 : 1, 영어 : 2, 수학 : 3");
		System.out.print("입력 : ");
		int subject = scan.nextInt();
		System.out.println("학생 번호를 선택하세요");
		System.out.print("번호 : ");
		int studentNum = scan.nextInt();
		int score;
		switch(subject) {
		case 1: 
			System.out.println(studentNum+"번 학생 국어 점수를 입력하세요");
			System.out.print("점수 : ");
			score = scan.nextInt();
			stds[studentNum - 1].kor = score;
			break;
		case 2: 
			System.out.println(studentNum+"번 학생 영어 점수를 입력하세요");
			System.out.print("점수 : ");
			score = scan.nextInt();
			stds[studentNum - 1].eng = score;
			break;
		case 3: 
			System.out.println(studentNum+"번 학생 수학 점수를 입력하세요");
			System.out.print("점수 : ");
			score = scan.nextInt();
			stds[studentNum - 1].math = score;
			break;
		default:	
			System.out.println("잘못된 메뉴 입니다.");
		}
		
	}
	
}
