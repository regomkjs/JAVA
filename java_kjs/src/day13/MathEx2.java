package day13;

public class MathEx2 {

	public static void main(String[] args) {
		// 주어진 실수의 소수점 3자리에서 올림한 값을 출력하는 코드를 작성하시오
		double num = 1.234567;
		System.out.println(Math.ceil(num*100)/100);
		
		
		// 주어진 실수의 소수점 n자리에서 올림한 값을 출력하는 코드를 작성하라
		int n = 3;
		double num2 = 1.234567;
		System.out.println(Math.ceil(num2 * Math.pow(10, n-1)) / Math.pow(10, n-1));
		
	}

}
