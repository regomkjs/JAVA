package day11.student;

public class Subject {
	private int studentID;
	private String subjectName;
	private String studentName;
	private int midterm;
	private int finals;
	private int assessment;
	private int totalScore;
	
	
	

	
	// getter setter
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getMidterm() {
		return midterm;
	}
	public void setMidterm(int midterm) {
		this.midterm = midterm;
	}
	public int getFinals() {
		return finals;
	}
	public void setFinals(int finals) {
		this.finals = finals;
	}
	public int getAssessment() {
		return assessment;
	}
	public void setAssessment(int assessment) {
		this.assessment = assessment;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	// 한 학기 총점내기
	public void totalScore( ) {
		totalScore = (int)((midterm*40/100) + (finals*40/100) + (assessment*20/100));
	}

	// 과목 생성자
	public Subject (int studentID, String subjectName ) {
		this.studentID = studentID;
		this.subjectName = subjectName;
	}
	
}
