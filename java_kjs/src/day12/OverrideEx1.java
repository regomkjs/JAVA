package day12;

public class OverrideEx1 {

	public static void main(String[] args) {
		D d = new D();
		d.print1();
		System.out.println("=====");
		d.print2();
		System.out.println("=====");
		d.print1(20);
	}
}

class C {
	protected int num1 = 1, num2 = 2;
	
	protected void print1() {
		System.out.println(num1);
		System.out.println(num2);
	}
	public void print2() {
		System.out.println(num1);
		System.out.println(num2);
	}
}

class D extends C {
	
	@Override
	/*
	// 1. 매개변수(int num1)가 부모 클래스에는 없음
	// 2. 부모 클래스에서는 접근제어자가 protected 였는데 여기선 default
	void print1(int num1) {
		
	}
	*/
	protected void print1() {
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
	}
	// 메서드 오버 로드에 의해 print1 메서드를 추가
	public void print1(int num1) {
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
	}
	
	public void print2() {
		super.print2();
		System.out.println("B 클래스의 메서드입니다." );
	}
}