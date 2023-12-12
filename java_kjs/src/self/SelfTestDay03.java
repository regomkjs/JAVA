package self;

public class SelfTestDay03 {
	
	/* 자습용 자료
	 * 3일차 
	 * */
	public static void main(String[] args) {
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
		
		
		
		
		
		
		
	}

}
