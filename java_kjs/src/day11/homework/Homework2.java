package day11.homework;

import java.util.Scanner;

public class Homework2 {
	
	/* 두 정수와 산술 연산자를 입력받아 계산하고 결과를 콘솔에 출력하는 코드를 작성
	 * 메서드를 생성
	 */
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
	}
	
	public static void computing() {
		int num1; 
		char ch; 
		int num2;
		System.out.println("수식을 입력 해주세요(예: 1 + 2 )");
		System.out.print("입력 : ");
		num1 = scan.nextInt();
		ch = scan.next().charAt(0);
		num2 = scan.nextInt();
		switch (ch) {
		case '+':
			System.out.println(num1 +" + "+ num2 + " = " + (num1+num2) );
			break;
		case '-':
			System.out.println(num1 +" - "+ num2 + " = " + (num1-num2) );
			break;
		case '*':
			System.out.println(num1 +" * "+ num2 + " = " + (num1*num2) );
			break;
		case 'x':
			System.out.println(num1 +" x "+ num2 + " = " + (num1*num2) );
			break;
		case '%':
			System.out.println(num1 +" % "+ num2 + " = " + (num1%num2) );
			break;
		case '/':
			System.out.println(num1 +" / "+ num2 + " = " + (num1/(double)num2) );
			break;
		default:
			System.out.println("잘못된 수식입니다.");
		}
	}
	
}
