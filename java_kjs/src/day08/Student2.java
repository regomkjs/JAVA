package day08;

import java.util.Scanner;

/* 학생의 국어, 영어, 수학 성적을 관리하기 위한 프로그램 작성하려고 한다.
 * 이때 필요한 학생 클래스를 생성해보세요
 * */
public class Student2 {
	// 멤버변수 :
	// 국어 성적, 영어 성적, 수학 성적 , 학년, 반, 학생번호, 이름
	int kor, eng, math;
	int grade, classNum, num;
	String name;
	// 메서드 : 학생 정보 확인, 학생 성적 확인, 국어성적 수정, 수학성적 수정, 영어성적 수정 
	/* 기능 : 학생 정보(학년, 반, 번호, 이름)을 콘솔에 출력하는 메서드
	 * 매개변수 :
	 * 리턴타입 :
	 * 메서드명 : printInfo
	 * */
	public void printInfo() {
		System.out.println("----------------------------");
		System.out.println(grade+ "학년 " + classNum + "반 " + num + "번 " + name);
	}
	
	/* 기능 : 학생 성적(학년, 반, 번호, 이름, 국어, 영어 ,수학)을 콘솔에 출력하는 메서드
	 * 
	 *  
	 * 메서드명 : printScore 
	 * */
	public void printScore() {
		printInfo();
		System.out.println("국어 : " + kor + " 영어 : " + eng + " 수학 : " + math);
	}
	
	/* 기능 : 국어 성적을 수정하는 메서드
	 * 매개변수 : 점수
	 * 리턴타입 : 없음 
	 * 메서드명 : setKor
	 * */
	public void setKor (int score) {
		kor = score;
	}
	
	/* 기능 : 영어 성적을 수정하는 메서드
	 * 매개변수 : 점수
	 * 리턴타입 : 없음 
	 * 메서드명 : setEng
	 * */
	public void setEng (int score) {
		eng = score;
	}
	
	/* 기능 : 수학 성적을 수정하는 메서드
	 * 매개변수 : 점수
	 * 리턴타입 : 없음 
	 * 메서드명 : setMath
	 * */
	public void setMath (int score) {
		math = score;
	}

	public Student2(int grade1, int classNum1, int num1, String name1) {
		grade = grade1;
		classNum = classNum1;
		num = num1;
		name = name1;
	}
	
	
	
}
