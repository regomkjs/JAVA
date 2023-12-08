package day01;

public class VariableEx2 {
	// 정수형 변수 선언 예제
	public static void main(String[] args) {

		/* bit: 1 or 0을 저장하는 공간
		 * 1bit = 2
		 * 2bit = 4
		 * 3bit = 8
		 * ...
		 * 1byte = 8bit = 256가지 = -128(-2의 7제곱) ~ 127(2의 7제곱 -1)
		 * 1short = 2byte = 2의 16제곱 = -2의 15제곱 ~ 2의 15제곱 -1
		 * 1int = 4byte = 2의 32제곱 = -2의 31제곱 ~ 2의 31제곱 -1
		 * 1long = 8byte = 2의 64제곱 = -2의 63제곱 ~ 2의 63제곱 -1
		 */
		
		// 정수형 변수 선언 예제
		byte num1 = 1;
		System.out.println(num1);
		
		//byte num2 = 128; 
		// byte는 -128에서 127까지만 표현 가능하기 때문에 128을 저장할 수 없다.
		
		byte num3 = (byte)(127 + 1) ; // byte의 양수 표현 범위를 넘어서 오버플로우가 발생하여 -128이 됨.
		System.out.println(num3);
		
		byte num4 = (byte)(-128 - 1); // byte의 음수 표현 범위를 넘어서 언더플로우가 발생하여 127이 됨.
		System.out.println(num4);
		
		int num5 = 128;
		System.out.println(num5);
		
		//int num6 = 123456789123; // int의 양수 표현 범위를 넘어서 저장할 수 없다.
		
		int num7 = 010; // 8진수 10 = 10진수 8
		System.out.println(num7);
		int num8 = 0x10; // 16진수 10 = 10진수 16
		System.out.println(num8);
		int num9 = 0b10; // 2진수 10 = 10진수 2
		System.out.println(num9);
		
		long num10 = 1234567891234L; // 큰수로 초기화를 하는 경우 기본타입이 int이기 때문에 접미사 L을 뒤에 붙여줘야 한다.
		System.out.println(num10);
	}

}
