package day04;

import java.util.Scanner;

public class GcdEx3 {

	public static void main(String[] args) {
		/* 두 정수의 최대 공약수를 구하는 코드를 작성하세요 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("최대 공약수를 구할 두 정수를 입력 (예 12 15) : ");
		int i;
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int gcd = 1;
		scan.close();
		
		// 1부터 공약수를 저장해 반복문이 끝난 뒤 출력하여 최대공약수를 구함
		for ( i = 1 ; i < num1 ; i++ ) {
			if (num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
		}
		System.out.println(num1+ "과 "+num2+"의 최대 공약수 : " + gcd);
		
		
		// num1부터 공약수를 구해서 처음 나오는 공약수가 최대공약수
		for ( i = num1 ; i >=1 ; i-- ) {
			if (num1 % i == 0 && num2 % i == 0) {
				System.out.print(i);
				break;
			}
		}
		//
		
	}

}
