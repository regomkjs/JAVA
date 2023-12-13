package day04;

import java.util.Scanner;

public class RockPaperScissorsEx {

	public static void main(String[] args) {
		/* 다음 기능을 가진 가위, 바위, 보 게임 프로그램을 작성하세요
		 * 1. 새게임
		 * 2. 기록
		 * 3. 프로그램 종료
		 * 
		 * - 새 게임
		 *  - 컴퓨터가 랜덤으로 내는 가위, 바위, 보를 비교하여
		 *    이기면 승리 , 지면 패 , 비기면 무로 기록함
		 *  - 바위 : R, 보: P, 가위 : S 
		 * 
		 * - 기록
		 *  - 승 무 패를 순서대로 출력 
		 * */
		
		Scanner scan = new Scanner(System.in);
		int w = 0;
		int	d = 0;
		int l = 0;
		int menu;
		int max = 3;
		int min = 1;
		do { 
			System.out.println("------------");
			System.out.println("메뉴");
			System.out.println("1. 새 게임");
			System.out.println("2. 기록");
			System.out.println("3. 프로그램 종료");
			System.out.println("------------");
			System.out.print("메뉴 입력 : ");
			menu = scan.nextInt();
			
			char user;
			char com;
			
			switch(menu) {
			case 1:
				
					int r = (int)(Math.random() * (max - min + 1) + min);
					
					if (r == 1) {
						com = 'R';
					}
					else if (r == 2) {
						com = 'P';
					}
					else {
						com = 'S';
					}
					
					System.out.print("무엇을 내시겠습니까? (R, P, S) : ");
					user = scan.next().charAt(0);
					
					if (user == com) {
						System.out.println(com + "로 비겼습니다");
						System.out.println("비겼습니다.");
						d++;
					}
					else if((user == 'R' && com == 'S') || (user == 'S' && com == 'P') 
							|| ( user == 'P' && com == 'R')) {
						System.out.println("유저가 "+ user +"냈고 컴퓨터가"+ com + "을 냈습니다.");
						System.out.println("이겼습니다.");
						w++;
					}
					else {
						System.out.println("유저가 "+ user +"냈고 컴퓨터가"+ com + "을 냈습니다.");
						System.out.println("졌습니다.");
						l++;
					}

				break;
			case 2:
				System.out.println("현재까지 " + w + "승 "+ d + "무 " + l + "패 입니다.");
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴를 선택했습니다.");
				break;
			}
			
			
			
		}while(menu != 3);
		
	
		scan.close();
		
		
	}

}
