package day03;

import java.util.Scanner;

public class ForUpDownEx1 {

	public static void main(String[] args) {
		/* 숫자 업 다운 게임을작성하세요
		 * 랜덤으로 생성된 숫자를 맞추는 게임.
		 */
		Scanner scan = new Scanner(System.in);
		
		int min = 1, max = 100;
		int r = (int)(Math.random() * (max - min + 1) + min);
		int ans = 0;
		int count = 1;
		for ( ; ans != r ; ) {
			
			System.out.print("정답을 입력하세요 : ");
			ans = scan.nextInt();
			
			if (ans < r) {
				System.out.println("UP");
				count++;
			}
			else if (ans > r) {
				System.out.println("DOWN");
				count++;
			}
			else {
				System.out.println("시도 회수 : " + count);
				System.out.println("정답 : " + r);
			}
			
			
		}
		scan.close();
		
	}

}
