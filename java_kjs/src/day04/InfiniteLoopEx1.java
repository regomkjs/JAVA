package day04;

import java.util.Scanner;

public class InfiniteLoopEx1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 무한 루프 예제1 : 조건식을 참으로 만들어서 무한루프 발생 
		while(true) {
			System.out.println("정수 입력 : ");
			int num = scan.nextInt();
			System.out.println("정수 출력 : " + num);
		}
		/*
		for ( ; ; ) {
			System.out.print("정수 입력 : ");
			int num = scan.nextInt();
			System.out.println("정수 출력 : " + num);
		}
		*/
	}

}
