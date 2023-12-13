package day04;

import java.util.Scanner;

public class InfiniteLoopEx2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		for(int i = 10; i>0 ; ) {
			System.out.print("정수 입력 : ");
			num = scan.nextInt();
			System.out.println("정수 출력 : " + num);
		}
		
		System.out.println("프로그램 종료 ");
		
		
		// 이 코드는 위와는 다르게 무수히 많이 실행 
		// i가 증가하다 int 양수 표현범위를 넘어가면 오버플로우가 발생하고
		// 음수가 되면서 반복문이 종료
		for(int i = 10; i>0 ; i++) {
			System.out.print("정수 입력 : ");
			num = scan.nextInt();
			System.out.println("정수 출력 : " + num);
		}
	
	}

}
