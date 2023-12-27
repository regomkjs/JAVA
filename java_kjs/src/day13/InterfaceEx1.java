package day13;

public class InterfaceEx1 {

	public static void main(String[] args) {
		// static 변수는 인스턴스 생성없이 호출 가능
		System.out.println(KiaCar.brand);
		
		// static이 들어가있는 메서드는 인터페이스라 할지라도 구현 되어있어야 한다.
		Printer.print();
	}

}


class KiaCar{
	public static String brand = "기아";
}

interface Printer{
	// static이 붙은 정적 메서드는 반드시 구현해야 함
	static void print() {
		System.out.println("프린터입니다.");
	}
	// static이 안붙은 메서드는 추상메서드로 만들어서 구현하지 않거나
	void test();
	// default 메서드로 만들어 구현
	default void test2() {}
}