package self;

import java.util.Scanner;

public class SelfTestDay08 {

	public static void main(String[] args) {
		// 학생 5명 성적 관리 프로그램 (국어 영어 수학)
		// 국 영 수 평균 60점 이상 pass 미만 fail
		// 클래스와 메서드를 이용하여 구현
		Scanner scan = new Scanner(System.in);
		
		int menu;
		int []studentID = {1, 2, 3, 4, 5};
		int []korScore = new int[5];
		int []engScore = new int[5];
		int []mathScore = new int[5];
		
		do { 
			printMenu();
			menu = scan.nextInt();
			int innerMenu = 0;
			int checkMenu = 0;
			switch(menu) {
			case 1:
				printInnerMenu();
				innerMenu = scan.nextInt();
				switch(innerMenu) {
				case 1:
					System.out.println("국어 성적 입력");
					korScore = inputScore(korScore);
					break;
				case 2:
					System.out.println("영어 성적 입력");
					engScore = inputScore(engScore);
					break;
				case 3:
					System.out.println("수학 성적 입력");
					mathScore = inputScore(mathScore);
					break;
				default:
					System.out.println("잘못된 메뉴 입니다.");
				}
				
				break;
			case 2:
				printCheckMenu();
				checkMenu = scan.nextInt();
				switch (checkMenu) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				
				
				}
				
				
				
				
				break;
			case 3:
				
				break;
			default:
				System.out.println("잘못된 메뉴 입니다.");
			}
			
			
			
			
		}
		while(menu != 3);
		
		
		scan.close();
	}
	
	
	// 메뉴 설정
	public static void printMenu( ) {
		System.out.println("메뉴");
		System.out.println("1. 성적 입력");
		System.out.println("2. 성적 조회");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	// 성적 입력 내부 메뉴
	public static void printInnerMenu( ) {
		System.out.println("성적 입력");
		System.out.println("1. 국어");
		System.out.println("2. 영어");
		System.out.println("3. 수학");
		System.out.print("메뉴 선택 : ");
	}
	// 성적 입력
	public static int[] inputScore(int arr[]) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.print((i+1) + "번 성적입력 : ");
			arr[i] = scan.nextInt();
		}
		return arr;
	}
	// 성적 확인 내부 메뉴
	public static void printCheckMenu( ) {
		System.out.println("성적 확인");
		System.out.println("1. 과목별 성적 확인");
		System.out.println("2. 학생별 성적 확인");
		System.out.println("3. 패스 여부");
		System.out.print("메뉴 선택 : ");
	}
	// 성적 확인 과목별
	public static void subjectScore(int arr[]) {
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.println((i+1) + "번 : " + arr[i]);
		}
	}
	// 성적 확인 학생별
	
	// 패스 여부
	
}
