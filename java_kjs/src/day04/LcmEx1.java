package day04;

import java.util.Scanner;

public class LcmEx1 {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("최소 공배수를 구할 두 정수 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		// i가 1부터 1씩 증가
		for (int i = 1 ; i <= num1 * num2 ; i++) {
			if (i % num1 == 0 && i % num2 == 0) {
				System.out.println(num1+"과 "+num2+"의 최소 공배수 : "+ i );
				break;
			}
		}
		
		scan.close();
		
		// i가 num1 부터 num1씩 증가 => 반복 회수를 줄일 수 있다.
		for (int i = num1 ; i <= num1 * num2 ; i+=num1 ) {
			if (i % num2 == 0) {
				System.out.println(num1+"과 "+num2+"의 최소 공배수 : "+ i );
				break;
			}
		}
		
		
	}

}
