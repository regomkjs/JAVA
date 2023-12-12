package day03;

public class ContinueEx1 {

	public static void main(String[] args) {
		// continue를 이용하여 짝수 출력 예제
		// 홀수이면 건너뛰기
		// 짝수이면 출력
		
		int i;
		
		for ( i=1 ; i <= 10 ; i++ ) {
			if ( i % 2 == 1) {
				continue;
			}
			System.out.println(i);
		}
		
		
	}

}
