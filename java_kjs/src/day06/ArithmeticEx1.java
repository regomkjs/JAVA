package day06;

import java.util.Scanner;

public class ArithmeticEx1 {

	public static void main(String[] args) {
		/* 랜덤으로 산수 (+, -, *) 문제를 생성하여 맞추는 게임
		 * 1 + 2 = 3
		 * 정답입니다.
		 * 단, 숫자 범위는 1 ~ 99
		 */
		Scanner scan = new Scanner(System.in);
		
		int min = 1, max = 99;
		int s_min = 1, s_max = 3; 
		
		boolean cor = false;
		do {
			char ch =' ';
			int r = (int)(Math.random() * (max - min + 1) + min);
			int s = (int)(Math.random() * (s_max - s_min + 1) + s_min); // 연산자 랜덤변수
			int t = (int)(Math.random() * (max - min + 1) + min);
			switch(s) {
			case 1:		ch = '+';	break;
			case 2:		ch = '-';	break;
			case 3:		ch = 'x';	break;
			}
			System.out.println("정답을 입력하세요.");
			System.out.print(r + " " + ch + " " + t + " = ");
			int ans = scan.nextInt();
			if(s == 1 && ans == r + t) {
				System.out.println("정답!!");
				cor = true;
			}
			else if(s == 2 && ans == r - t) {
				System.out.println("정답!!");
				cor = true;
			}
			else if(s == 3 && ans == r * t) {
				System.out.println("정답!!");
				cor = true;
			}
			else {
				System.out.println("틀렸습니다.");
			}
		}
		while(cor != true);
		
		scan.close();
	
	}

}
