package self;

import java.util.Scanner;

public class SelfTestDay04 {

	public static void main(String[] args) {
		
		
		/* 반전 트리 만들기 */
		// 굳이 어렵게 if문으로 작성하지 않아도 된다.
	
		
		int rows1 = 10;
		
		int round1;
		int time1;
		
		for(round1 =0 ; round1 <= rows1; round1++) {
			if (round1 == 0|| round1 == rows1) {
				for (time1 = 1 ; time1 <= rows1*2-1; time1++) {
					System.out.print("*");
				}
			}
			else {
				for (time1 = 1 ; time1 <= rows1 - round1; time1++) {
					System.out.print("*");
				}
				for (time1 = 1 ; time1 < round1*2; time1++) {
					System.out.print(" ");
				}
				// 별 다음 공백을 채워주는 식, 생략가능 
				for (time1 = 1 ; time1 <= rows1 - round1; time1++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		/* 스타 예제
		 * 
		 * *****
		 *  ****
		 *   ***
		 *    **
		 *     *
		 *     *
		 *    ***
		 *   ***** 
		 *  *******  
		 * ********* 
		 *  *******
		 *   *****
		 *    ***
		 *     *
		 */
		
		int rows = 14;
		int round;
		int time;
		
		for( round =1 ; round <= rows ; round++ ) {
			if (round <= 5 ) {
				for(time =1 ; time <= round - 1 ;time++ ){
					System.out.print(" ");
				}
				for(time =1 ; time <= 5 - round + 1 ;time++ ){
					System.out.print("*");
				}
			}
			else if (round < 11) {
				for(time =1 ; time <= 10 - round  ;time++ ){
					System.out.print(" ");
				}
				for(time =1 ; time < (round - 5) *2  ; time++ ) {
					System.out.print("*");
				}
			}
			else {
				for(time =1 ; time <= round - 10 ;time++ ){
					System.out.print(" ");
				}
				for(time =1 ; time <  (15 - round )*2 ;time++ ){
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
		
		/* 가위 바위 보 */
		
		Scanner scan = new Scanner(System.in);
		
		
		int min = 1;
		int max = 3;
		
		int r = (int)Math.random()*(max-min+1) + min;
		
		
		int menu;
		do {
			System.out.println("메뉴");
			System.out.println("1. 새 게임");
			System.out.println("2. 승패 기록");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 입력 : ");
			menu = scan.nextInt();
			char user;
			char com;
			switch(menu) {
			case 1:
				
				System.out.print("무엇을 내시겠습니까 (r, s, p): ");
				user = scan.next().charAt(0);
				if (r == 1) {
					com = 'r';
				}
				else if (r == 2) {
					com = 's';
				}
				else {
					com = 'p';
				}
				
				if(user==com) {
					System.out.println("컴퓨터 : " + com);
					System.out.println("비겼습니다.");
				}
				else if(user == 'r' && com == 's' || user == 's' && com == 'p' 
						|| user == 'p' && com == 'r' ) {
					System.out.println("컴퓨터 : " + com);
					System.out.println("이겼습니다.");
				}
				else {
					System.out.println("컴퓨터 : " + com);
					System.out.println("졌습니다.");
				}
				
				
				break;
				
			case 2:
				
				
				
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
				
			
			}
			
			
		}
		while (menu != 3);
		
	}

}
