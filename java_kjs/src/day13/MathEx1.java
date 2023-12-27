package day13;

public class MathEx1 {

	public static void main(String[] args) {
		System.out.println("123.4567 올림 : " + Math.ceil(123.4567));
		System.out.println("123.4567 내림 : " + Math.floor(123.4567));
		// 반올림의 경우 정수로 반환된다. 주의
		System.out.println("123.4567 반올림: " + Math.round(123.4567));
		System.out.println("123.567 반올림 : " + Math.round(123.567));
		System.out.println("-1의 절대값 : " + Math.abs(-1));
		System.out.println("2의 3제곱 : " + Math.pow(2, 3));
		System.out.println("121의 제곱근 : " + Math.sqrt(121));
		
		
	}

}
