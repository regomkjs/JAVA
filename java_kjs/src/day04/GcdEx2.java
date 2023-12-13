package day04;

import java.util.Scanner;

public class GcdEx2 {

	public static void main(String[] args) {
		/* 두 정수의 공약수를 출력하는 코드를 작성하세요. 
		 * 약수: 나누어 떨어지는 수
		 * 공약수 : 공통으로 있는 약수 
		 * */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("공약수를 비교할 두 수를 입력 (예 8 12 ) : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int i;
		int i1;
		int i2;
		
		System.out.print(num1 + "의 약수 : ");
		for (i1 = 1 ; i1 <= num1 ; i1++) {
			if (num1 % i1 == 0) {
				System.out.print(i1 + (i1<num1 ? ", " : "\n"));
			}
		}
		System.out.print(num2 + "의 약수 : ");
		for (i2 = 1 ; i2 <= num2 ; i2++) {
			if (num2 % i2 == 0) {
				System.out.print(i2 + (i2<num1 ? ", " : "\n"));
			}
		}
		System.out.print(num1 + "와 " + num2 + "의 공약수 : ");
		for (i = 1 ; i <= num1 ; i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				System.out.print((i == 1 ?  ""  :", ") + i); // 콤마 위치를 바꿔주는 것으로 해결
			}
		}
		
		
		
		scan.close();
		
	}

}
