package day08;

public class Car {
	// 정보 : 멤버변수
	// 무게 : 단위는 톤으로,브랜드, 분류, 가격, 색상, 차명, 연식
	double weight;
	String brand;
	String category;
	int price;
	String color;
	String [] tire;
	String carName;
	int year;
	boolean power; // 시동
	int speed; // 현재 속력
	boolean leftLight;
	boolean rightLight;
	
	// 기능 : 메서드
	// 가속, 감속, 시동, 조향, 방향지시등

	// 시동 켜기/끄기
	// 시동이 꺼져있으면 켜짐, 켜져있으면 꺼짐
	public void turn() {
		power = !power;
		if(power) {
			System.out.println("시동이 켜졌습니다.");
		}
		else {
			System.out.println("시동이 꺼졌습니다.");
		}
	}
	// 가속
	public void speedUp() {
		speed++;
	}
	
	// 감속
	public void speedDown() {
		speed--;
	}
	// 방향지시등 켜기/끄기, 위(우측) 1 가운데 0 아래(좌측) -1
	public void turnLight(int direction) {
		switch(direction) {
		case 1: rightLight = true; leftLight = false;
			break;
		case -1: rightLight = false; leftLight = true;
			break;
		case 0:	rightLight = false; leftLight = false;
			break;
		default:
		}
	}
	// 자동차 현재상태를 출력하는 메서드
	public void print() {
		System.out.println("-----------------------");
		System.out.println("시동 : " + power);
		System.out.println("속력 : " + speed);
		System.out.println("좌깜 : " + leftLight);
		System.out.println("우깜 : " + rightLight);
		System.out.println("-----------------------");
	}
	
	
	
}
