package day10;

public class ThisEx1 {

	public static void main(String[] args) {
		
		Point pt1 = new Point();
		pt1.print();
		Point pt2 = new Point(1,2);
		pt2.print();
	}
}

// 점을 나타내는 Point 클래스

class Point {
	
	private int x, y;
	// getter setter
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Point(int x, int y) {
		// this(x); // this를 잘못 사용하면 객체 초기화가 완료되지 않고 무한루프에 빠질수 있다.
		this.x = x;
		this.y = y;
		System.out.println("매개변수 2개 생성자");
	}
	public Point() {
		// this()는 this생성자 이외의 다른 코드들이 오면 안된다
		this(0,0); // x, y 를 0으로 초기화 하기 위해 위에 있는 생성자를 호출
		System.out.println("기본 생성자");
	}
	public Point(int x) {
		// this(); // this를 잘못 사용하면 객체 초기화가 완료되지 않고 무한루프에 빠질수 있다.
		this.x = x;
	}
	public void print() {
		System.out.println("("+ x + "," + y + ")");
	}
	
}
