package day05;

import java.util.Scanner;

public class ArrayScoreEx1 {

	public static void main(String[] args) {
		/* 학생 5명의 국어 성적을 입력받고, 총점과 평균을 구하는 코드를 입력하세요 */
		
		Scanner scan = new Scanner(System.in);
		
		int totalScore = 0;
		double avg;
		int [] korScores = new int[5];  
		for (int i = 0; i < 5; i++) {
			System.out.print("학생"+ (i+1)+" 점수 : ");
			korScores[i] = scan.nextInt();
			totalScore += korScores[i]; 
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			System.out.println("학생"+ (i+1)+" 점수 : " + korScores[i]);
		}
		avg = totalScore /5.0;
		System.out.println();
		System.out.println("총점 : "+ totalScore);
		System.out.println();
		System.out.println("평균 : "+ avg);
		scan.close();
	}

}
