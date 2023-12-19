package day08;

public class StudentMain2 {

	public static void main(String[] args) {
		// 5명의 학생을 저장하기 위한 배열을 생성하세요.
		Student [] stds = new Student[5];
		for (int i=0 ; i < stds.length; i++) {
			stds[i] = new Student();
		}
		
		// 학생 5명의 학생 정보를 출력하는 코드를 작성하라.
		for (int i = 0 ; i < stds.length ; i++) {
			stds[i].grade = 1;
			stds[i].classNum = 1;
			stds[i].num = i+1;
		}
		
		stds[0].name = "영희";
		stds[1].name = "철수";
		stds[2].name = "민수";
		stds[3].name = "길동";
		stds[4].name = "둘리";
		
		
		
		
		
		for (int i=0 ; i < stds.length; i++) {
			stds[i].printInfo();
		}
	}

}
