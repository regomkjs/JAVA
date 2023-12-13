package day04;

public class MultipleTableEx1 {

	public static void main(String[] args) {
		/* 구구단 2단부터 9단까지 출력하는 코드를 작성하세요 */
		
		// 2단만
		/*
		int dan = 2;
	
		// while문
		int time = 1;
		while(time <= 9) {
			System.out.println(dan + " X " + time + " = " +(dan*time));
			time++;
		}
		
		// for문
		for(time = 1; time <= 9 ; time++) {
			System.out.println(dan + " X " + time + " = " +(dan*time));
		}
		*/
		// 9단까지
		// for 중첩문
		for(int dan = 2; dan <= 9; dan++) {
			for(int time = 1; time <=9 ; time++) {
				System.out.println(dan + " X " + time + " = " +(dan*time));
			}
			System.out.println();
		}
		
		// while 중첩문
		int dan = 2; // 초기화 주의
		while (dan<=9) {
			int time = 1; // 초기화 주의
			while (time <=9) {
				System.out.println(dan + " X " + time + " = " +(dan*time));
				time++;
			}
			dan++;
			System.out.println();
		}
		
	}

}
