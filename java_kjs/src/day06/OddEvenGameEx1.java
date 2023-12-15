package day06;

import java.util.Scanner;

public class OddEvenGameEx1 {

	public static void main(String[] args) {
		
		// 정수 num가 주어졌을 때 홀수인지 짝수인지 판별하는 예제
		Scanner scan = new Scanner(System.in);
		
		int min = 1, max = 100;
		int totalMoney = 10000;
		char say;
		int sayNum = -1;
		int coin =0;
		
		do {
			System.out.println("===============================");
			int num = (int)(Math.random()*(max - min + 1) + 1);
			
			boolean ok1 = false;
			while(ok1 == false) {
				System.out.println("투입할 금액을 입력해주세요" + "1 ~ " + totalMoney);
				System.out.print("투입 금액 : ");
				coin = scan.nextInt();
				if (totalMoney < coin || coin <= 0) {
					System.out.println("잘못 입력하였습니다.");
				}
				else {
					totalMoney -= coin; 
					ok1 = true;
				}
				
			}
			
			boolean ok2 = false;
			for (;ok2 != true;) {
				System.out.println("홀 또는 짝을 입력");
				System.out.print("홀 or 짝 : ");
				say = scan.next().charAt(0);
				switch (say) {
				case '홀':
					sayNum = 1;
					ok2 = true;
					break;
				case '짝':
					sayNum = 0;
					ok2 = true;
					break;
				default:
					System.out.println("잘못 입력하였습니다.");
				}
			}
			System.out.println("===============================");
			if (num % 2 == sayNum && sayNum == 0) {
				System.out.println("정답 "+num+": 짝수");
				totalMoney += coin*2;
				System.out.println("현재 총액 : " + totalMoney);
			}
			else if (num % 2 == sayNum && sayNum == 1) {
				System.out.println("정답 "+num+": 홀수");
				totalMoney += coin*2;
				System.out.println("현재 총액 : " + totalMoney);
			}
			else if (sayNum == 1) {
				System.out.println("틀렸습니다. 코인이 차감됩니다.");
				System.out.println(num+": 짝수");
				coin = 0;
				System.out.println("현재 총액 : " + totalMoney);
			}
			else {
				System.out.println("틀렸습니다. 코인이 차감됩니다.");
				System.out.println(num+": 홀수");
				coin = 0;
				System.out.println("현재 총액 : " + totalMoney);
			}
		}
		while(totalMoney > 0);
		System.out.println("게임 오버");
		scan.close();
	}

}
