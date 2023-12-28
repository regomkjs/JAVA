package day14;

import java.text.MessageFormat;
import java.util.Scanner;

public class ArithmeticExceptionEx2 {
	
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		// 두 정수와 산술 연산자를 입력받아 결과를 출력하는 메서드 구현
		// 단 메서드를 이용, throw throws를 이용
		int num1, num2;
		char op;
		System.out.print("수식을 입력하세요 예(1 + 2) : ");
		try {
			num1 = scan.nextInt();
			op = scan.next().charAt(0);
			num2 = scan.nextInt();
			
			printC(num1, op, num2);
		}
		catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	
	
	public static void  printC(int num1 , char op, int num2) throws RuntimeException {
		double res = 0;
		switch(op) {
		case '+': res = num1 + num2;
			break;
		case '-': res = num1 - num2;
			break;
		case '*': res = num1 * num2;
			break;
		case '%': res = num1 % num2;
			break;
		case '/': 
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌수 없습니다.");
			}
			else {
				res = num1 / (double)num2;
			}
			break;
		default:
			throw new RuntimeException(op + "는 산술 연산자가 아닙니다.");
		}
		String pattern = "{0} {1} {2} = {3}";
		System.out.println(MessageFormat.format(pattern, num1,op , num2 , res));
		
		
	}
}
