package day14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticExceptionEx1 {

	
	public static void main(String[] args) {
		// 두 정수와 산술 연산자를 입력받아 산술 연산하는 코드를 작성하라
		// 단, 0으로 나눌때 예외 처리를 적용
		
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		char ch;
		System.out.print("수식을 입력해주세요(예: 1 + 2) : ");
		try {
		num1 = scan.nextInt();
		ch = scan.next().charAt(0);
		num2 = scan.nextInt();
			switch(ch) {
			case '+':
				System.out.println(num1 + " "+ ch +" "+ num2 + " = " + (num1+num2));
				break;
			case '-':
				System.out.println(num1 + " "+ ch +" "+ num2 + " = " + (num1-num2));
				break;
			case '*':
				System.out.println(num1 + " "+ ch +" "+ num2 + " = " + (num1*num2));
				break;
			case '%':
				System.out.println(num1 + " "+ ch +" "+ num2 + " = " + (num1%num2));
				break;
			case '/':
				try {
					 System.out.println(num1 + " "+ ch +" "+ num2 + " = " + (num1/(double)num2));
				}
				catch(ArithmeticException e) {
					System.out.println("0으로 나눌 수 없습니다.");
				}
			default:
				System.out.println("잘못된 연산자입니다.");
			}
		}
		catch(InputMismatchException e) {
			System.out.println("잘못 입력했습니다.");
		}
		scan.close();
	}

}
