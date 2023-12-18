package self;

import java.util.Scanner;

public class SelfTestDay07 {

	public static void main(String[] args) {
		// 학생 5명 성적 관리 프로그램 (국어 영어 수학)
		// 국 영 수 평균 60점 이상 pass 미만 fail
		Scanner scan = new Scanner(System.in);
		
		int menu;
		int []studentID = {1, 2, 3, 4, 5};
		int []korScore = new int[5];
		int []engScore = new int[5];
		int []mathScore = new int[5];
		
		do { 
			printMenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("성적 입력");
				System.out.println("1. 국어");
				System.out.println("2. 영어");
				System.out.println("3. 수학");
				System.out.print("메뉴 선택 : ");
				menu = scan.nextInt();
				switch(menu) {
				case 1:
					break;
				}
				
				break;
			case 2:

				break;
			case 3:
				
				break;
			default:
					
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
	// 성적 입력 상위 메뉴
	
	
	// 성적 확인 과목별
	
	// 성적 확인 학생별
	
}
