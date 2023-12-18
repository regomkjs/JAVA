package day07;

import java.util.Scanner;

public class OddEvenGameEx1 {

	public static void main(String[] args) {
		/* 다음 기능을 가진 프로그램을 작성하세요(메서드 이용)
		 * 메뉴
		 * 1. 새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 1
		 * -----------
		 * 선택 (홀 짝) :
		 * 3 홀입니다
		 * 성공!
		 * -----------
		 * 메뉴
		 * 1. 새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * ----------- 
		 * 결과 : 1승 0패
		 * ----------- 
		 * 메뉴
		 * 1. 새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 3
		 * ----------- 
		 * 프로그램 종료
		 * */
		Scanner scan = new Scanner(System.in);
		
		int menu;
		int win = 0;
		int lose = 0;
		do {
			printMenu(); 			// 메뉴 출력
			menu = scan.nextInt();
			System.out.println("---------------");
			switch (menu) {
			case 1:
				boolean result = newGame();
				if(result) {
					win++;
				}
				else {
					lose++;
				}
				System.out.println("---------------");
				break;
			case 2:
				data(win,lose); 	// 기록 확인
				System.out.println("---------------");
				break;
			case 3:
				System.out.println("프로그램 종료");
				break;
			default:	
				System.out.println("잘못된 메뉴 선택");
			}
		}
		while(menu != 3);
		scan.close();
	}
	/* 기능 : 메뉴 출력
	 * 매개변수 : 없음
	 * 리턴타입 : void
	 * 메서드명 : printMenu
	 * */
	public static void printMenu ( ) {
		System.out.println("메뉴");
		System.out.println("1. 새 게임");
		System.out.println("2. 기록 확인");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	/* 기능 : 새 게임
	 * 매개변수 : int user
	 * 리턴타입 : boolean
	 * 메서드명 : newGame
	 * */
	public static boolean newGame() {
		Scanner scan = new Scanner(System.in);
		int min = 1 , max = 100;
		int r = (int)(Math.random()*(max -min + 1) + min);
		System.out.print("홀(1), 짝(0) 입력 : ");
		int user = scan.nextInt();
		if(r % 2 == user) {
			System.out.println( r +" " + (r%2==0?"짝":"홀") +" 정답입니다." );
			return true;
		}
		System.out.println( r +" " + (r%2==0?"짝":"홀") +" 오답입니다." );
		return false;
	}
	
	/* 기능 : 기록 확인
	 * 매개변수 : int win , int lose
	 * 리턴타입 : void
	 * 메서드명 : data
	 * */
	public static void data (int win, int lose) {
		System.out.println("기록 : " + win + "승 "+ lose + "패");
	}
	
}
