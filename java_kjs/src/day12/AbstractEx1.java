package day12;

public class AbstractEx1 {

	public static void main(String[] args) {
		// 추상 클래스 예제
		// AA 추상 클래스는 추상 메서드가 없지만 추상 클래스를 이용하여 인스턴스를 생성할 수 없다.
		// AA aa1 = new AA(); // 에러 발생
		// 추상 클래스의 인스턴스를 만들려면 익명 클래스를 이용
		AA aa1 = new AA() {  // 일회용 클래스를 만든 경우
		};
		// 추상 클래스를 상속받은 일반 클래스를 생성해서 활용 (업캐스팅)
		AA aa2 = new CA();
		
		EA ea1 = new EA();
		ea1.print();
	}
}

abstract class AA {
	int num;
}

abstract class AB {
	int num;
	public abstract void print();
}

class CA extends AA {
	
}

// AB 안에 추상 메서드가 있으므로 오버라이딩으로 추상메서드를 완성한 일반 클래스로 사용하거나 추상 클래스로 정의되어야 한다.
// 추상 클래스로 정의한 경우
abstract class DA extends AB {
	
}
// 오버라이딩으로 추상메서드를 완성한 경우
class EA extends AB {
	@Override
	public void print() {
		System.out.println("num : " + num);
	}
}