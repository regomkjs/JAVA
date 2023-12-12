package day03;

import java.util.Scanner;

public class SwitchEx4 {

	public static void main(String[] args) {
		/* day02/TestEx5 참고
		 * 산술연산자와 두 정수를 입력받아
		 * 산술연산자에 맞는 연산 결과를 출력하는 코드를 작성하세요
		 * 
		 * 예 1
		 * 1 + 2 = 3
		 * 
		 * 예 2
		 * 1 / 2 = 0.5
		 * 
		 * 예 3 
		 * 1 ? 2 
		 * ?는 산술 연산자가 아닙니다.
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("예와 같이 수식을 입력하세요 (예: 1 + 2): ");
		int l_num = scan.nextInt();
		char oper = scan.next().charAt(0);
		int r_num = scan.nextInt();
		
		switch (oper) {
		case '+':
			System.out.println(l_num + " " + oper + " " + r_num + " = " + (l_num + r_num));
			break;
		case '-':
			System.out.println(l_num + " " + oper + " " + r_num + " = " + (l_num - r_num));
			break;
		case 'X','*':
			System.out.println(l_num + " " + oper + " " + r_num + " = " + (l_num * r_num));
			break;
		case '%':
			System.out.println(l_num + " " + oper + " " + r_num + " = " + (l_num % r_num));
			break;
		case '/':
			System.out.println(l_num + " " + oper + " " + r_num + " = " + (l_num / (double)r_num));
			break;
		default:
			System.out.println("잘못된 연산자 입니다.");
		}
		// 상황에 따라 if문보다 switch문으로 작성할 겅우 가독성이 높아진다.
		scan.close();
	}

}
