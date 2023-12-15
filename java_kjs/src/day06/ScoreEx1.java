package day06;

import java.util.Scanner;

public class ScoreEx1 {

	public static void main(String[] args) {
		/* 다음 기능을 가진 성적 관리 프로그램을 작성하세요.
		 * - 1반의 성적을 관리
		 * - 최대 30명
		 * - 성적은 번호순으로 관리
		 * - 성적은 국어, 영어, 수학 성적을 관리
		 * 메뉴
		 * 1. 성적 수정
		 * 2. 성적 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 :
		 * 
		 * =성적수정=
		 * 1. 국어
		 * 2. 영어
		 * 3. 수학
		 * 과목 선택 : 1 (국어)
		 * 
		 * 학생 선택 : 3 번호 선택
		 * 성적 입력 : 100
		 * 
		 * =성적조회=
		 * 1. 과목별조회
		 * 2. 학생별조회
		 * 선택 : 1
		 * 
		 * =과목별조회=
		 * 1. 국어
		 * 2. 영어
		 * 3. 수학
		 * 과목 선택 :
		 * 
		 * 1번 : 0점
		 * 2번 : 0점
		 * 3번 : 100점
		 * ...
		 * 30번 : 0점
		 * 
		 * =성적조회=
		 * 1. 과목별조회
		 * 2. 학생별조회
		 * 선택 : 2
		 * 학생 선택 : 3
		 * 국어 : 100점
		 * 영어 : 0점
		 * 수학 : 0점
		 * 
		 * */
		
		Scanner scan = new Scanner(System.in);
		int maxStudent = 30;
		int kor [] = new int [maxStudent];
		int eng [] = new int [maxStudent];
		int math [] = new int [maxStudent];
		int topMenu = 0;
		int subject;
		String type [] = new String [] {"국어", "영어", "수학"} ;
		int sel = 0;
		do {
			int studentNum;
			int score;
			System.out.println("=메뉴=");
			System.out.println("1. 성적 수정");
			System.out.println("2. 성적 조회");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			topMenu = scan.nextInt();
			System.out.println();
			if (topMenu == 1) {
				System.out.println("=성적 수정=");
				System.out.println("1. 국어");
				System.out.println("2. 영어");
				System.out.println("3. 수학");
				System.out.print("과목 선택 : ");
				subject = scan.nextInt();
				System.out.println();
				if(subject <= 3 && 0 < subject) {
					System.out.println("=" + type[subject-1] +" 성적 입력=");
					System.out.print("학생 번호 : ");
					studentNum = scan.nextInt();
					System.out.print(studentNum + "번 "+type[subject-1] +"점수 입력 : ");
					score = scan.nextInt();
					switch (subject) {
					case 1: 
						kor[studentNum-1] = score;
						break;
					case 2: 
						eng[studentNum-1] = score;
						break;
					case 3: 
						math[studentNum-1] = score;
						break;
					}
				}
				else { 
					System.out.println("잘못 입력하였습니다.");
					subject = 0;
					System.out.println();
				}
			}
			else if (topMenu == 2) {
				System.out.println("=성적 조회=");
				System.out.println("1. 과목별조회");
				System.out.println("2. 학생별조회");
				System.out.print("선택 : ");
				sel = scan.nextInt();
				switch(sel) {
				case 1:
					System.out.println("=과목별조회=");
					System.out.println("1. 국어");
					System.out.println("2. 영어");
					System.out.println("3. 수학");
					System.out.print("과목 선택 : ");
					subject = scan.nextInt();
					System.out.println();
					System.out.println("=" + type[subject-1] +" 성적 조회=");
					// 임시 배열을 만들고 선택지에 따라 다른 과목의 배열을 불러오게 설정
					int sel_subject[] = new int [maxStudent];
					switch (subject) { 
					case 1:
						sel_subject = kor;
						break;
					case 2:
						sel_subject = eng;
						break;
					case 3:
						sel_subject = math;
						break;	
					default:
						System.out.println("잘못 입력하였습니다.");
					}
					// 불러온 배열을 출력
					for(int i =0 ; i< sel_subject.length; i++) {
						System.out.println((i+1)+"번 : " + sel_subject[i]);
					}
					break;
				case 2:
					System.out.println("=학생별조회=");
					System.out.print("학생 번호 입력 : ");
					studentNum = scan.nextInt();
					System.out.println(studentNum +"번의 성적");
					System.out.println("국어 : " + kor[studentNum-1]);
					System.out.println("영어 : " + eng[studentNum-1]);
					System.out.println("수학 : " + math[studentNum-1]);
					studentNum = 0;
					break;
				default:
					System.out.println("잘못 입력하였습니다.");
					System.out.println();	
				}
			}
			else if (topMenu == 3) {
				System.out.println("프로그램을 종료합니다.");
			}
			else {
				System.out.println("잘못 입력하였습니다.");
				System.out.println();
			}
		}
		while (topMenu != 3);
		scan.close();
	}

}
