package day01;

public class TypeCastingEx2 {

	// 강제(명시적)자료 형변환 예제 
	public static void main(String[] args) {
		int num1 = (int)3.14; // 3.14는 실수 double형(8byte)이기 때문에 정수 int(4byte)로 강제형변환 해주어야 한다. 이때 소수점 아래는 탈락된다.
		System.out.println(num1);
		
		byte num2 = (byte)num1; // num1의 타입은 int형이기 때문에 byte로 표현하기 위해선 강제형변환 해주어야 한다.
		System.out.println(num2);
		// byte num3 = 3;
		
		byte num4 = (byte)128;
		System.out.println(num4);
		
		// 에러가 발생하지 않았지만 필요에 의해 형변환 하는 경우
		System.out.println(1/2);
		System.out.println(1/2F);
		System.out.println((double)1/2);
		
		// 같은 타입의 변수를 여러개 선언하는 방법
		int num5 = 1 , num6 = 2 , num7 = 3 ;
		
	}

}
