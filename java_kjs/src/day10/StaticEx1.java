package day10;

public class StaticEx1 {

	public static void main(String[] args) {
		KiaCar c1;
		c1 = new KiaCar("모닝");
		KiaCar c2 = new KiaCar("레이");
		KiaCar c3 = new KiaCar("K3");
		c1.brand = "기아";
		c1.print();
		c2.print();
		c3.print();
		
		System.out.println("---------------");
		
		KiaCar2 c4; 
		System.out.println(KiaCar2.brand2);
		System.out.println("---------------");
		
		c4 = new KiaCar2("모닝");
		KiaCar2 c5 = new KiaCar2("레이");
		KiaCar2 c6 = new KiaCar2("K3");
		// static을 이용하면 멤버변수를 공유하는 매개변수 하나를 바꾸는 것으로 모두 바꿀수 있다
		// 인스턴스를 통해 접근 가능하지만 클래스 명을 통해 접근해야한다.
		c4.brand2 = "기아";
		KiaCar2.brand2 = "기아";
		c4.print();
		c5.print();
		c6.print();
		
		// Math. 은 인스턴스 생성 없이 호출 가능 
		System.out.println("대표적인 static변수 Math.PI : " + Math.PI);
	}

}


class KiaCar {
	public String brand = "KIA";
	public String name; // 차명
	
	public KiaCar (String name){
		this.name = name;
	}
	public void print() {
		System.out.println(brand);
		System.out.println("차명 : " + name);
	}
	
	
}


class KiaCar2 {
	public static String brand2 = "KIA";
	public String name; // 차명
	
	public KiaCar2 (String name){
		this.name = name;
	}
	public void print() {
		System.out.println(brand2);
		System.out.println("차명 : " + name);
	}
	
	
}