package day08.access2;

import day08.access1.Student;

public class AccessModifierEx1 {

	public static void main(String[] args) {
		Student std = new Student();
		std.setGrade(1); // grade의 접근제어자가 private이기 때문에 다른 클래스에서 사용 불가능
		std.setClassNum(2); // classNum의 접근제어자가 default여서 다른 패키지에 있는 클래스에서는 사용 불가능
		std.num = 3; // num의 접근제어자가 public이어서 사용 가능
		
		// getter와 setter를 이용해 접근 수정 가능하다.
	}

}
