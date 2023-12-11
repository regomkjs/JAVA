package day02;

public class TestEx1 {
	
	// 연산자 예제
	public static void main(String[] args) {
		/* 다음 코드를 이용하여 국어, 영어, 수학의 평균을 구하여 콘설에 출력하는 코드를 작성하라 */
		int kor_score = 100, eng_score = 50, math_score = 92;
		
		int total_score;
		total_score = kor_score + eng_score + math_score;
		double avg;
		avg = total_score / 3.0;
		System.out.println("국영수 과목의 총점은 " + total_score + " 이고 평균은 " + avg + " 입니다.");
		
		
		
	}

}
