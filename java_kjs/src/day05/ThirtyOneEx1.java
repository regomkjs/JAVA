package day05;

import java.util.Scanner;

public class ThirtyOneEx1 {

	public static void main(String[] args) {
		/* 사용자와 컴퓨터가 돌아가면서 최대 3개의 숫자를 부르고
		 * 31을 입력한 쪽이 패배하는 게임 
		 * 예
		 * com : 1 2 3
		 * 정수 : 2 
		 * user : 4 5
		 * com : 6
		 * 정수 : 3
		 * user : 7 8 9
		 * ....
		 * com : 31
		 * 컴퓨터 패배!, 유저 승!
		 * */
		Scanner scan = new Scanner(System.in);
		// 유저와 컴퓨터가 돌아가면서 선언하여 31까지 높아질 변수
		int nowCount = 0;
		do {
			// 컴퓨터 턴
			if(nowCount <= 30 ) {
				// 컴퓨터가 선언할 정수의 개수를 정할 변수
				int min = 1, max = 3;
				int comCount = (int)(Math.random() * (max - min +1 ) + min);
				System.out.println("컴퓨터 턴");
				for (int i = 0; i < comCount; i++) {
					System.out.print((nowCount + i+1) + " ");
					if(nowCount + i +1 == 31) {
						break;
					}
				}
				nowCount += comCount;
			}
			System.out.println();
			if(nowCount >= 31) {
				System.out.println("컴퓨터 패, 유저 승");
				break;
			}
			// 유저 턴
			if(nowCount <= 30) {
				System.out.println("유저 턴");
				// 유저가 선언할 정수의 개수
				System.out.print("입력할 정수 개수 : ");
				int userCount = scan.nextInt(); 
				for (int i = 0; i < userCount; i++) {
					System.out.print((nowCount + i + 1) + " ");
					if(nowCount + i +1 == 31) {
						break;
					}
				}
				nowCount += userCount;
			}
			System.out.println();
			if(nowCount >= 31) {
				System.out.println("컴퓨터 승, 유저 패");
				break;
			}	
		} 
		while( nowCount <= 30 );
		nowCount = 31;
		scan.close();
		
	}

}
