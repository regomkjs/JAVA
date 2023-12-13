package day04;

import java.util.Scanner;

public class TestEx1 {

	public static void main(String[] args) {
		/* Scanner를 이용하여 국어, 영어, 수학 성적을 입력받고 
		 * 총점과 평균을 구하는 코드를 작성하세요 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("국어 점수 : ");
		int korScore = scan.nextInt();
		System.out.print("영어 점수 : ");
		int engScore = scan.nextInt();
		System.out.print("수학 점수 : ");
		int mathScore = scan.nextInt();
		
		int totalScore = korScore + engScore + mathScore;
		
		double avgAll = totalScore / 3.0 ;
		
		System.out.println("점수 총합 = " + totalScore);
		System.out.println("평균 = " + avgAll);
		scan.close();
	}

}
