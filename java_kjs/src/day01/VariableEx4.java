package day01;

public class VariableEx4 {

	public static void main(String[] args) {

		// 논리형 변수 선언 예제
		// boolean
		
		boolean isEven = true;
		System.out.println(isEven);
		
		// 아래 코드는 논리형 변수가 이런식으로 사용된다는걸 보여주기 위한 예제

		isEven = 3 % 2 == 0;
		System.out.println("2 is Even number?  " + isEven);
	}

}
