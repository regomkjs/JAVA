package day18.student;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class Student implements Serializable {
	private static final long serialVersionUID = 156772285613350799L;
	int grade, classNum, num;
	String name;
	
	
	// toString
	@Override
	public String toString() {
		return  "[ "+grade + "학년 " + classNum + "반 " + num + "번 " + name + " ]";
	}
	
	
	// equals and hashCode (학년, 반, 번호)
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
		return Objects.hash(classNum, grade, num);
	}
	
	// 생성자(학년, 반, 번호) 
	public Student(int grade, int classNum, int num) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
	}
	




	
}
