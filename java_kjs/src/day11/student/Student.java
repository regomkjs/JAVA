package day11.student;

public class Student {
	private String name;
	private int studentID; //  학년, 반, 번호
	
	// getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	// studentID 만들기
	public void newStudentID(int grade, int classCount, int num) {
		if((0 < grade&& grade <= 3) && (0 < classCount && classCount < 100)
				&&(0 < num && num < 100)) {
			studentID = (grade * 10000) + (classCount * 100) + num;
			return;
		}
		System.out.println("잘못된 학생 정보입니다.");
	}
	
	// 학생 생성자
	public Student () {
		
	}

}
