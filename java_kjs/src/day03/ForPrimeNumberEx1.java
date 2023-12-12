package day03;

import java.util.Scanner;

public class ForPrimeNumberEx1 {

	public static void main(String[] args) {
		/* 소수 판별 예제
		 * 입력한 정수가 소수인지 아닌지 판별해보아라
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		
		int num = scan.nextInt();
		int i;
		int count = 0;
		scan.close();
		for ( i = 1 ; i <= num ; i++) {
			if (num % i == 0) {
				System.out.println(num + "의 약수는 " + i);
				count++ ;
			}
		}
		
		System.out.println(num + "의 약수는 " + count + "개다.");
		
		if (count > 2) {
			System.out.println(num + "은 소수가 아닙니다.");
		}
		else { 
			System.out.println(num + "은 소수입니다.");
		}
		
		
		
	
		
		
	}

}
