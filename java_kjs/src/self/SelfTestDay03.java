package self;

import java.util.Scanner;

public class SelfTestDay03 {
	
	/* 자습용 자료
	 * 3일차 
	 * */
	public static void main(String[] args) {
		/*
		
		// 2단부터 9단까지 출력
		int dan = 2;
		
		while (dan <= 9) {
			// time 변수는 내부 while문에 쓰이기 때문에 안에서 초기화 해주어야 적용된다.
			int time = 1;
		
			while(time <= 9) {
				System.out.println(dan + " X " + time + " = " + (dan * time));
				time++;
			}
			System.out.println(""); // 단 구분을 위한 빈 열
			dan++;
		}
		
		System.out.println('\n');
		System.out.println("==============================");
		System.out.println('\n');
		
		// 구구단 중 짝수 단만 출력
		dan = 2;
		while (dan <= 9) {
			// int time = 1;  			내부 while문 이전에만 초기화되면 되기에 위치는 신경쓰지 않아도 된다.
			if (dan % 2 == 0) {
				int time = 1;	//		내부 while문 이전에만 초기화되면 되기에 위치는 신경쓰지 않아도 된다.
				while(time <= 9) {
					System.out.println(dan + " X " + time + " = " + (dan * time));
					time++;
				}
				System.out.println(""); // 단 구분을 위한 빈 열
			
				
			}
			dan++;
		}
		
		System.out.println('\n');
		System.out.println("==============================");
		System.out.println('\n');
		
		// 1월부터 12월까지 각 월과 계절을 함께 출력하시오
		
		int month;
		String ch;
		
		for (month = 1 ; month <= 12 ; month++ ) {
			if (month < 3 || month == 12) {
				ch = "겨울";
				System.out.print(month +"월 " + ch + (month == 12 ? "\n" : ", "));
			}
			else if (month < 6) {
				ch = "봄";
				System.out.print(month +"월 " + ch + ", ");
			}
			else if (month < 9) {
				ch = "여름";
				System.out.print(month +"월 " + ch + ", ");
			}
			else {
				ch = "가을";
				System.out.print(month +"월 " + ch + ", ");
			}
		}
		
		*/
		
		/* 업 다운 복습 */
		int min = 1;
		int max = 100;
		int count = 1;
		int r = (int)(Math.random() * (max - min + 1) + min);
		Scanner scan = new Scanner(System.in);
		int num = 0;
		for ( ; num != r ; ) {
			System.out.print("정답 입력 : ");
			num = scan.nextInt();
			if (num < r) {
				System.out.println("Up!");
				count++;
			}
			else if (num > r) {
				System.out.println("Down!");
				count++;
			}
			else {
				System.out.println("시도 : " + count + "회");
				System.out.println("정답 : " + r);
			}
		}
		
		
		scan.close();
		
		
		
	}

}
