package day15.student;

import java.util.Objects;

import lombok.Data;

@Data
class Student {
	int grade, classNum, num;
	String name;
	int kor, eng, math;
	
	public void printInfo() {
		System.out.print(grade + "학년 " + classNum + "반 " + num + "번호 "  + name);
	}
	
	public void addName(String name) {
		this.name = name;
	}
	
	// 성적이나 이름과 상관없게 구분 가능
	public boolean isSame(Student tmp) {
		if(grade == tmp.getGrade() && classNum == tmp.getClassNum() && num == tmp.getNum()){
			return true;
		}
		return false;
	}
	
	public void printScoreInfo() {
		System.out.println(name +" 학생 성적");
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
	}
	
	// equals를 오버라이드 하지 않으면 Objects.equals(a,b)를 호출해서 사용한다.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(grade, classNum, num);
	}
	
	
	// 생성자
	public Student(int grade, int classNum, int num) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		kor = 0;
		eng = 0;
		math = 0;
	}
	
}