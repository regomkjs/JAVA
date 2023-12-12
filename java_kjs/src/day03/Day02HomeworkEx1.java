package day03;

import java.util.Scanner;

public class Day02HomeworkEx1 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("성적 입력(0~100) : ");
		
		int score = scan.nextInt();
		
		//
		if(score <= 100 && score >=90) {
			System.out.println(score + "점은 A");
		}
		else if(score < 60 && score >= 0) {
			System.out.println(score + "점은 F");
		}
		else if(score < 70) {
			System.out.println(score + "점은 D");
		}
		else if(score < 80) {
			System.out.println(score + "점은 C");
		}
		else if(score < 90) {
			System.out.println(score + "점은 B");
		}
		else {
			System.out.println(score + "점은 잘못된 점수입니다.");
		}
		
		scan.close();
	}

}
