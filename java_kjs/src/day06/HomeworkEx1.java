package day06;

import java.util.Scanner;

public class HomeworkEx1 {

	public static void main(String[] args) {
		/* 야구 게임을 구현하세요
		 * - 1 ~ 9 사이의 겹치지 않은 3개의 수를 랜덤으로 선택해서 해당 숫자를 맞추는 게임
		 * - 판별
		 * - S : 숫자와 위치를 모두 맞춘 경우
		 * - B : 숫자가 있지만 위치가 다른 경우
		 * - O : 일치하는 수가 하나도 없는 경우
		 */
		
		Scanner scan = new Scanner(System.in);
		int menu;
		String playerName;
		String highScorePlayer[] = new String[6];
		int highScore [] = new int [6];
		do {
			System.out.println("메뉴");
			System.out.println("1. 새 게임");
			System.out.println("2. 기록 확인");
			System.out.println("3. 게임 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				int com[] = new int[3];
				int user[] = new int[3] ;
				int count = 0;
				int playCount =0;
				int min = 1, max = 9;
		
				int s = 0; // 스트라이크
				int b = 0; // 볼
				
				
				while( count < 3 ) {
					int r = (int)(Math.random()*(max-min+1)+min);
					boolean duplicated = false;
					for(int i = 0 ; i < count; i++) {
						if (com[i] == r ) {
							duplicated = true;
							break;
						}
					}
					if (!duplicated) {
						com[count] = r; 
						count++;
					}
				}
				for (int i = 0 ; i< com.length ;i++) {
					System.out.print(com[i]+" ");
				}
				System.out.println("야구 게임");
				System.out.println("곂치지 않는 1 ~ 9 숫자 3개를 맞춰라");
				
				do {
					System.out.print("정수 입력 :");
					for(int i = 0 ; i < user.length; i++) {
						user[i] = scan.nextInt();
					}
					playCount++;
					for(int i = 0; i < user.length; i++) {
						for (int j = 0;j < user.length; j++) {
							if ( i==j && com[i] == user[j]) {
								s++;
							}
							else if(com[i] == user[j]) {
								b++;
							}
						}
					}
					if( s==0 & b==0) {
						System.out.println("Out");
					}
					else if (s == 3) {
						System.out.println("3S 유저 승");
						System.out.println("도전 횟수 : " + playCount);
					}
					else {
						System.out.println(s+ "S "+ b + "B");
						s = 0;
						b = 0;
					}
				} while(s != 3);
				
				if(highScore[5] == 0) {
					System.out.println("현재 1등입니다. 이름을 기록하세요");
					System.out.print("이름 : ");
					playerName = scan.next();
					highScore[5] = playCount;
					highScorePlayer[5] = playerName;
				}
				else {
					for(int i = 0; i < highScore.length ; i++) {
						if(highScore[i] > playCount && highScore[i] != 0) {
							System.out.print("현재 1등입니다. ");
							break;
						}
					}
					System.out.println("이름을 기록하세요");
					System.out.print("이름 : ");
					playerName = scan.next();
					highScorePlayer[0] = playerName;
					highScore[0] = playCount;
					for(int i = 0 ; i < highScore.length - 1 ; i++) {
						for(int j = 0 ; j < highScore.length - 1; j++) {
							if (highScore[j] > highScore[j+1]) {
								int tmp = highScore[j];
								String tmpName = highScorePlayer[j];
								highScore[j] =highScore[j+1];
								highScorePlayer[j] = highScorePlayer[j+1];
								highScore[j+1] = tmp;
								highScorePlayer[j+1] = tmpName;
							}
						}
					}
				}
				for(int i =0 ;i< highScore.length; i++) {
					System.out.print(highScore[i]+" ");
				}
				break;
			case 2:
				if(highScore[0] == 0 && highScore[1] == 0 && highScore[2] == 0 
				&& highScore[3] == 0 && highScore[4] == 0 && highScore[5] == 0 ) {
					System.out.println("아직 플레이 하지 않았습니다.");
				}
				else {
					System.out.println("--기록--");
					int tmpNum = 1;
					for(int i = 0 ; i < 5; i++) {
						if (highScorePlayer[i+1] != null) {
							System.out.println(tmpNum + ". " + highScorePlayer[i+1] + " : " + highScore[i+1] + "회");
							tmpNum++;
						}
					}
				}
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				break;
			default:
			}
		} 
		while(menu != 3);
		scan.close();
		
	}

}
