package day04;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		/* Up Down 게임 구현하기
		 * - 다음과 같은 메뉴를 가져야 합니다.
		 * 1. 새 게임
		 * 2. 최고기록 확인 
		 * 3. 프로그램 종료
		 * 
		 * - 새 게임은 업다운 게임 시작
		 * 	- 랜덤으로 생성된 수를 맞추는 게임
		 *  - 맞춘 회수를 출력, 기록하고 메뉴로 돌아감
		 * - 최고기록 확인은 가장 적은 시도 회수를 확인
		 * - 프로그램 종료는 런 종료
		 */
		
		
		/*
		// 내 풀이
		Scanner scan = new Scanner(System.in);
		int menu;
		int bestScore = -1;
		do { 
			System.out.println();
			System.out.println("메뉴");
			System.out.println("1. 새 게임");
			System.out.println("2. 최고기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			int min = 1, max = 100;
			int r = (int)(Math.random() * (max - min + 1) + min);
			int ans = 0;
			if (menu == 1) {
				int count = 0;
				for ( ; ans != r ; ) {
					++count;
					System.out.print("정답을 입력하세요 : ");
					ans = scan.nextInt();
					
					if (ans < r) {
						System.out.println("UP");
					}
					else if (ans > r) {
						System.out.println("DOWN");
					}
					else {
						if (bestScore == -1) {
							bestScore = count;
							System.out.println("시도 회수 : " + count);
							System.out.println("정답 : " + r);
						}
						else {
							System.out.println("시도 회수 : " + count);
							System.out.println("정답 : " + r);
							if (bestScore > count) {
								bestScore = count;
							}
						}
					}
				}				
			}
			else if (menu == 2) {
				if (bestScore <= 0) {
					System.out.println("아직 플레이한 기록이 없습니다.");
				}
				else {
					System.out.println("최고 기록 : " + bestScore);
				}
			}
		}
		while(menu != 3);
		System.out.println("프로그램 종료");
		scan.close();
		*/
		
		
		
		// 선생님 풀이
		Scanner scan = new Scanner(System.in);
		int min = 1, max = 100;
		int r = (int)(Math.random() * (max - min + 1) + min);
		int ans = 0;
		
		int menu;
		int bestScore = -1;
		int count = 0;
		
		do {
			System.out.println("메뉴");
			System.out.println("1. 새 게임");
			System.out.println("2. 최고 기록");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				do {
						System.out.print("정답을 입력하세요 : ");
						ans = scan.nextInt();
						++count;
						if (ans < r) {
							System.out.println("UP");
						}
						else if (ans > r) {
							System.out.println("DOWN");
						}
						else {
							System.out.println("정답 : " + r);
							System.out.println("시도 회수 : " + count);
						}
					
				}while( ans != r );
				if(bestScore == -1 || count < bestScore) {
					bestScore = count;
				}
				break;
			case 2:
				if (bestScore == -1) {
					System.out.println("아직 한번도 플레이 하지 않았습니다.");
				}
				else {
					System.out.println("최고 기록 : " + bestScore);
				}
				break;
			case 3:
				System.out.println("프로그램 종료");
				break;
			
			}
		}
		while(menu != 3);
		scan.close();
	}

}
