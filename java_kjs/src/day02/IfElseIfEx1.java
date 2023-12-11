package day02;

public class IfElseIfEx1 {

	// if else if 문 예제
	public static void main(String[] args) {
		int num = 3;
		
		if (num == 0) {
			System.out.println(num + "입니다.");
		}
		else if(num < 0) {
			System.out.println(num + "은(는) 음수 입니다.");
		}
		else {
			System.out.println(num + "은(는) 양수 입니다.");
		}
	}

}
