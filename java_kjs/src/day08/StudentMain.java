package day08;

public class StudentMain {

	public static void main(String[] args) {
		// 학생 1명의 정보를 저장하는 인스턴스를 생성해보세요
		Student std = new Student();
		//1학년 1반 1번 홍길동
		std.grade = 1;
		std.classNum = 1;
		std.num = 1;
		std.name = "홍길동";
		std.printInfo();
		std.setKor(90);
		std.setEng(100);
		std.setMath(80);
		std.printScore();
	}

}
