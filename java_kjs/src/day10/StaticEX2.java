package day10;

public class StaticEX2 {

	public static void main(String[] args) {
		
		System.out.println(sum1(1,2));
		
		//System.out.println(sum2(1,2)); // 에러발생
		
		// 해결 방법: 인스턴스를 생성하고 인스턴스를 이용해 호출
		StaticEX2 ex = new StaticEX2();
		System.out.println(ex.sum2(1,2)); // 에러발생
	
		ex.test();
	}
	public static int sum1(int num1, int num2) {
		return num1 + num2;
	}
	
	public int sum2(int num1, int num2) {
		return num1 + num2;
	}
	
	// 인스턴스 (객체) 메서드 : static이 안붙어서
	public void test() {
		System.out.println(sum1(2,4));
		System.out.println(sum2(2,4));
	}
	
}
