package day03;

import java.util.Scanner;

public class SwitchEx2 {
	
	// switch문 예제
	public static void main(String[] args) {
		// 홀짝 판별 예제를 switch문을 이용하여 작성하라	
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("홀짝을 판별할 정수 입력 : ");
		int num = scan.nextInt();
		int m_num = num % 2; 
		
		switch (m_num){			// m_num 변수를 지정하지 않고 num % 2를 바로 넣어도 된다.
		case 0:
			System.out.println(num + "은 짝수");
			break;
		default:
			System.out.println(num + "은 홀수");
		}
			
		scan.close();
		
	}

}
