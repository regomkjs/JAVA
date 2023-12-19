package day08;

public class StudentMain3 {

	public static void main(String[] args) {
		// Student2클래스의 생성자를 이용한 예제
		//Student2 std = new Student2();
		
		Student2 std1 = new Student2(1, 1, 1, "홍길동");
		std1.printScore();
		
		Student2 std2 = new Student2(1, 1, 2, "김철수");
		std2.printScore();
	}

}
