package day17.student;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  // 게터, 세터, 투스트링, 해시코드, 이퀄스 등등 포함
@AllArgsConstructor
public class Student implements Serializable{
	private static final long serialVersionUID = -6588474647564459241L;
	
	private int grade, classNum, num;
	private String name;
	
	
	// 해시코드, 이퀄스 (반,학년,번호)
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
	
	@Override
	public String toString() {
		return "[ "+grade + "학년 " + classNum + "반 " + num + "번 " + name + " ]";
	}
	
	
	
	
	
}
