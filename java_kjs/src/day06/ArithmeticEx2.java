package day06;

import java.util.Scanner;

public class ArithmeticEx2 {

	public static void main(String[] args) {
		/* 랜덤으로 산수 (+, -, *) 문제를 생성하여 맞추는 게임
		 * 1 + 2 = 3
		 * 정답입니다.
		 * 단, 숫자 범위는 1 ~ 99
		 */
		Scanner scan = new Scanner(System.in);
		
		int min = 1, max = 99;
		int user, answer = 0;
		int num1 = (int)(Math.random() * (max - min + 1) + min);
		int s = (int)(Math.random() * 3); // 연산자 랜덤변수
		int num2 = (int)(Math.random() * (max - min + 1) + min);
		String str = "+-*";
		char op = str.charAt(s);
		System.out.print(num1 + " " + op + " " + num2 + " = ");
		user = scan.nextInt();
		switch(op) {
		case '+':	answer = num1 + num2;	break;
		case '-':	answer = num1 - num2;	break;
		case '*':	answer = num1 * num2;	break;
		default:
			System.out.println("잘못된 연산자 입니다.");
		}
		
		if (answer == user) {
			System.out.println("정답입니다!");
		}
		else {
			System.out.println("오답입니다!");
		}
		
		scan.close();
	
	}

}
