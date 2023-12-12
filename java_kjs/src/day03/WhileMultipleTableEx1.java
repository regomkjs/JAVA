package day03;

public class WhileMultipleTableEx1 {

	public static void main(String[] args) {
		/* 구구단 2단을 출력하는 코드를 작성하세요.
		 * 2 X 1 = 2
		 * 2 X 2 = 4
		 * ...
		 * 2 X 9 = 18
		 */
		
		/* 반복회수 	: time 1부터 9까지 1씩 증가
		 * 규칙성		: dan X time = (dan*time) 을 출력
		 * 반복문종료후	: 없음
		 */
		
		
		int dan = 2;
		int time = 1;
		
		while (time <= 9) {
			System.out.println(dan + " X " + time + " = " + (dan * time));
			time++;
		}
		
		
		
	}

}
