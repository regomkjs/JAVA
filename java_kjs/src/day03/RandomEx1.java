package day03;

public class RandomEx1 {

	public static void main(String[] args) {
		// min ~ max 사이 랜덤한 수를 생성하는 예제
		// Math.random()은 0 이상 1미만의 랜덤 실수를 만들어준다.
		int min = 1, max = 100 ;
		int r = (int)(Math.random() * (max - min + 1) + min);
		
		System.out.println("랜덤 : " + r);
	}

}
