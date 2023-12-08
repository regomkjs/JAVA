package day01;

public class VariableEx5 {
	// String 선언 예제
	public static void main(String[] args) {
		String str1 = null;
		System.out.println(str1);
		// 기본형 변수에는 null을 저장할 수 없다.
		//int num1 = null; 
		String str2 = "Hello";
		System.out.println(str2);
		// String 클래스에 문자를 저장할 수 없다.(문자 하나로 된 문자열은 가능)
		//String str3 = 'A';
		String str4 = "a";
		System.out.println(str4);
		// String 클래스에 빈 문자열을 저장할 수 있다.
		String str5 = "";
		System.out.println(str5);
		// 문자열에 정수 또는 실수 또는 문자 또는 논리값을 더하면 문자열이 된다.
		String str6 = "" + 'A';   // 문자열 "A"가 되어 저장이 가능해 진다.
		System.out.println(str6);
	}

}
