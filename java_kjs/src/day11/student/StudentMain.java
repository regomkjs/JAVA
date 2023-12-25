package day11.student;

import java.util.Scanner;

public class StudentMain {
	
	/* 고등학생 성적을 관리하는 프로그램을 작성하세요.
	 * 메뉴
	 * 1. 학생관리 - 학생 정보 - 학년, 반, 번호, 이름
	 *  1) 학생 추가 (학년, 반, 번호가 겹치는 학생은 추가 불가능)
	 *  2) 학생 수정
	 *  3) 학생 삭제
	 * 2. 성적관리 - 성적 확인 - 1. 과목별 성적 - 학년과 반별 성적,  2. 학생별 성적 - 과목들의 성적 
	 *  1) 성적 추가
	 *  2) 성적 수정
	 *  3) 성적 삭제
	 * 3. 성적확인
	 *  1) 1. 과목별 성적 - 과목에 대한 학년과 반별 성적
	 *  2) 2. 학생별 성적
	 * - Student 클래스
	 *  
	 * - Subject 클래스
	 *  - 과목명, 성적(중간/기말/수행/총점)
	 * */
	
	static Scanner scan = new Scanner(System.in);
	
	static Student students[] = new Student[5];
	static Subject subjects[] = new Subject[10];
	
	static int studentCount = 0;
	static int subjectCount = 0;
	
	public static void main(String[] args) {
		
		int menu;
		do {
			// 메뉴 출력
			printMenu();
			menu = scan.nextInt();
			// 메뉴 실행
			
		}
		while (menu != 4);
	}

	// 메뉴 출력
	public static void printMenu() {
		System.out.println("====메뉴====");
		System.out.println("1. 학생관리");
		System.out.println("2. 성적관리");
		System.out.println("3. 프로그램 종료");
		System.out.println("===========");
		System.out.print("메뉴 입력 :");
	}
	
	// 메뉴 실행
	public static void runMenu(int menu) {
		int submenu;
		switch (menu) {
		case 1:
			printStudentMenu();
			submenu = scan.nextInt();
			runStudentMenu(submenu);
			break;
		case 2:
			printSubjectMenu();
			submenu = scan.nextInt();
			runSubjectMenu(submenu);
			break;

		case 3:
			printSearchScore();
			submenu = scan.nextInt();
			runSearchScore(submenu);
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			return;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	
	/* 1. 학생관리 */
	// 학생관리 메뉴 출력
	public static void printStudentMenu() {
		System.out.println("===학생관리===");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("===========");
		System.out.print("메뉴 입력 :");
	}
	
	// 학생관리 메뉴 실행
	public static void runStudentMenu(int submenu) {
		switch (submenu) {
		case 1:
			addStudentInfo();
			break;
		case 2:
			changeStudentInfo();
			break;
		case 3:
			deleteStudentInfo();
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	// 학생 추가
	public static void addStudentInfo() {
		Student tmpStudent = new Student();
		String name;
		int grade, classCount, num; 
		System.out.println("학생 정보 입력");
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 :");
		classCount = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		tmpStudent.newStudentID(grade, classCount, num);
		for(int i = 0 ; i< studentCount; i++ ) {
			if(students[i].getStudentID() == tmpStudent.getStudentID()) {
				System.out.println("이미 존재하는 학생정보입니다.");
				return;
			}
		}
		students[studentCount] = tmpStudent;
		System.out.print("이름 : ");
		name = scan.next();
		students[studentCount].setName(name);
		studentCount++;
		if(studentCount == students.length) {
			Student tmpArr[] = new Student[students.length+5];
			System.arraycopy(students, 0, tmpArr, 0, studentCount);
			students = tmpArr;
		}
	}
	
	// 학생 수정
	public static void changeStudentInfo() {
		if (studentCount==0) {
			System.out.println("아직 등록된 학생이 없습니다.");
			return;
		}
		int menu;
		String name;
		int grade, classCount, num; 
		Student tmpStudent1 = new Student();
		Student tmpStudent2 = new Student();
		System.out.println("===학생 수정===");
		System.out.println("수정할 학생의 정보를 입력해주세요");
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classCount = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		tmpStudent1.newStudentID(grade, classCount, num);
		for (int i = 0 ; i < studentCount; i++) {
			if(students[i].getStudentID() == tmpStudent1.getStudentID()) {
				System.out.println("학생 이름 : " + students[i].getName());
				System.out.println("수정할 정보를 선택하세요");
				System.out.println(" 1) 학년 반 번호");
				System.out.println(" 2) 이름");
				System.out.print("메뉴 입력 : ");
				menu = scan.nextInt();
				switch(menu) {
				case 1:
					System.out.println("수정할 정보 입력");
					System.out.print("학년 : ");
					grade = scan.nextInt();
					System.out.print("반 :");
					classCount = scan.nextInt();
					System.out.print("번호 : ");
					num = scan.nextInt();
					tmpStudent2.newStudentID(grade, classCount, num);
					for(int j = 0 ; j< studentCount; j++ ) {
						if(students[j].getStudentID() == tmpStudent2.getStudentID()) {
							System.out.println("이미 존재하는 학생 정보입니다.");
							return;
						}
					}
					students[i].setStudentID(tmpStudent2.getStudentID());
					System.out.println(students[i].getName()+"학생 수정 완료");
					break;
					
				case 2:
					System.out.println("수정할 이름 입력");
					System.out.print("이름 입력 : ");
					name = scan.next();
					students[i].setName(name);
					System.out.println(students[i].getName()+"으로 수정 완료");
					break;
				default:
					System.out.println("잘못된 메뉴입니다.");
				}
			return;
			}
		}
		System.out.println("일치하는 학생이 없습니다.");
	}
	
	// 학생 삭제
	public static void deleteStudentInfo() {
		if (studentCount==0) {
			System.out.println("아직 등록된 학생이 없습니다.");
			return;
		}
		Student tmpStudent = new Student();
		int grade, classCount, num; 
		System.out.println("삭제할 학생의 정보를 입력해주세요");
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classCount = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		tmpStudent.newStudentID(grade, classCount, num);
		for(int i = 0; i < studentCount; i++) {
			if(students[i].getStudentID() == tmpStudent.getStudentID()) {
				System.out.println(grade+"학년 "+ classCount+ "반 " + num+ "번 " +students[i].getName() + "학생 정보가 삭제되었습니다.");
				students[i] = null;
				for(int j = 0 ; j < studentCount ; j++)	{
					if (students[j] == null && students[j+1] != null) {
						students[j] = students[j+1];
						students[j+1] = null;
					}
				}
				studentCount--;
			}
		}
	}
	
	
	
	/* 2. 성적관리 */
	// 성적관리 메뉴 츌력
	public static void printSubjectMenu() {
		System.out.println("===성적관리===");
		System.out.println("1. 성적 추가");
		System.out.println("2. 성적 수정");
		System.out.println("3. 성적 삭제");
		System.out.println("===========");
		System.out.print("메뉴 입력 :");
	}
	// 성적관리 메뉴 실행
	public static void runSubjectMenu(int submenu) {
		switch(submenu) {
		case 1:
			addSubjectInfo();
			break;
		case 2:
			changeSubjectInfo();
			break;
		case 3:
			deleteSubjectInfo();
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	// 성적 추가
	public static void addSubjectInfo() {
		if (studentCount==0) {
			System.out.println("아직 등록된 학생이 없습니다.");
			return;
		}
		String subjectName;
		int grade, classCount, num; 
		int midterm , finals , assessment;
		Student tmpStudent = new Student();
		System.out.println("===성적 추가===");
		System.out.println("성적을 추가할 학생");
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classCount = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		tmpStudent.newStudentID(grade, classCount, num);
		for (int i = 0 ; i < studentCount; i++) {
			if(tmpStudent.getStudentID() == students[i].getStudentID()) {
				System.out.println(students[i].getName()+ "학생의 성적 추가");
				System.out.println("추가할 과목을 적어주세요");
				System.out.print("과목 이름 : ");
				subjectName = scan.next();
				Subject tmpsubject = new Subject(tmpStudent.getStudentID(), subjectName);
				subjects[subjectCount] = tmpsubject;
				subjects[subjectCount].setStudentName(students[i].getName());
				System.out.print(students[i].getName()+" 학생의 "+subjectName+" 중간고사 점수 : ");
				midterm = scan.nextInt();
				subjects[subjectCount].setMidterm(midterm);
				System.out.print(students[i].getName()+" 학생의 "+subjectName+" 기말고사 점수 : ");
				finals = scan.nextInt();
				subjects[subjectCount].setFinals(finals);
				System.out.print(students[i].getName()+" 학생의 "+subjectName+" 수행평가 점수 : ");
				assessment = scan.nextInt();
				subjects[subjectCount].setAssessment(assessment);
				subjectCount++;
				if(subjectCount == subjects.length) {
					Subject tmpArr[] = new Subject[subjects.length+10];
					System.arraycopy(subjects, 0, tmpArr, 0, subjectCount);
					subjects = tmpArr;
				}
			}
		}
	}
	
	// 성적 수정
	public static void changeSubjectInfo() {
		if (studentCount==0) {
			System.out.println("아직 등록된 학생이 없습니다.");
			return;
		}
		if (subjectCount == 0) {
			System.out.println("아직 등록된 과목이 없습니다.");
			return;
		}
		String subjectName;
		Student tmpStudent = new Student();
		int grade, classCount, num; 
		int midterm , finals , assessment;
		System.out.println("===성적 수정===");
		System.out.println("성적 수정할 학생의 정보를 입력해주세요");
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classCount = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		tmpStudent.newStudentID(grade, classCount, num);
		for(int i = 0 ; i<subjectCount ; i++) {
			if(subjects[i].getStudentID() == tmpStudent.getStudentID()) {
				System.out.println(grade+"학년 "+ classCount+ "반 " + num+ "번 " +students[i].getName() + "학생의 성적 수정");
				System.out.print("수정할 과목을 입력 : ");
				subjectName = scan.next();
				for(int j = 0 ; j < subjectCount; j++) {
					if (subjects[j].getStudentID() == tmpStudent.getStudentID() 
							&& subjects[j].getSubjectName().equals(subjectName) ) {
						System.out.println(subjects[j].getStudentName()+" 학생의 점수");
						System.out.println("중간고사 : "+subjects[j].getMidterm()+"점");
						System.out.println("기말고사 : "+subjects[j].getFinals()+"점");
						System.out.println("수행평가 : "+subjects[j].getAssessment()+"점");
						System.out.println("==============");
						System.out.print("수정할 중간고사 점수 : ");
						midterm = scan.nextInt();
						subjects[j].setMidterm(midterm);
						System.out.print("수정할 기말고사 점수 : ");
						finals = scan.nextInt();
						subjects[j].setFinals(finals);
						System.out.print("수정할 수행평가 점수 : ");
						assessment = scan.nextInt();
						subjects[j].setAssessment(assessment);
						System.out.println("수정된 " + subjects[j].getStudentName() + " 학생의 점수");
						System.out.println("중간고사 : "+subjects[j].getMidterm()+"점");
						System.out.println("기말고사 : "+subjects[j].getFinals()+"점");
						System.out.println("수행평가 : "+subjects[j].getAssessment()+"점");
						System.out.println("==============");
						return;
					}
				}
			System.out.println("아직 등록되지 않은 과목입니다.");	
			return;
			}
			System.out.println("등록되지 않은 학생정보입니다.");
		}
	}
	
	// 성적 삭제
	public static void deleteSubjectInfo() {
		if (studentCount==0) {
			System.out.println("아직 등록된 학생이 없습니다.");
			return;
		}
		if (subjectCount == 0) {
			System.out.println("아직 등록된 과목이 없습니다.");
			return;
		}
		String subjectName;
		Student tmpStudent = new Student();
		int submenu;
		int grade, classCount, num; 
		System.out.println("===성적 삭제===");
		System.out.println("성적 삭제할 학생의 정보를 입력해주세요");
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classCount = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		tmpStudent.newStudentID(grade, classCount, num);
		for(int i = 0 ; i<subjectCount ; i++) {
			if(subjects[i].getStudentID() == tmpStudent.getStudentID()) {
				System.out.println(grade+"학년 "+ classCount+ "반 " + num+ "번 " +students[i].getName() + "학생의 성적 삭제");
				System.out.print("삭제할 과목을 입력 : ");
				subjectName = scan.next();
				for(int j = 0 ; j < subjectCount; j++) {
					if (subjects[j].getStudentID() == tmpStudent.getStudentID() 
							&& subjects[j].getSubjectName().equals(subjectName) ) {
						System.out.println(subjects[j].getStudentName()+" 학생의 점수");
						System.out.println("중간고사 : "+subjects[j].getMidterm()+"점");
						System.out.println("기말고사 : "+subjects[j].getFinals()+"점");
						System.out.println("수행평가 : "+subjects[j].getAssessment()+"점");
						System.out.println("==============");
						System.out.print("삭제할 점수 (1.중간고사 2.기말고사 3.수행평가 4.삭제 취소) : ");
						submenu = scan.nextInt();
						switch (submenu) {
						case 1:
							subjects[j].setMidterm(0);
							System.out.println(subjects[j].getStudentName()+" 학생의 중간고사 점수가 삭제되었습니다.");
							break;
						case 2:
							subjects[j].setFinals(0);
							System.out.println(subjects[j].getStudentName()+" 학생의 기말고사 점수가 삭제되었습니다.");
							break;
						case 3:
							subjects[j].setAssessment(0);
							System.out.println(subjects[j].getStudentName()+" 학생의 수행평가 점수가 삭제되었습니다.");
							break;
						case 4:
							return;
							
						}
					}
					
				}
				System.out.println("아직 등록되지 않은 과목입니다.");	
				return;
			}
		}
		System.out.println("등록되지 않은 학생정보입니다.");
	}
	
	
	
	/* 3. 성적확인 */
	// 성적확인 메뉴 출력
	public static void printSearchScore() {
		System.out.println("===성적확인===");
		System.out.println("1. 과목별 성적");
		System.out.println("2. 학생별 성적");
		System.out.println("===========");
		System.out.print("메뉴 입력 :");
	}
	
	// 성적확인 메뉴 실행
	public static void runSearchScore(int submenu) {
		
		switch(submenu) {
		case 1:
			subjectScore();
			break;
			
		case 2:
			studentScore();
			break;
			
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	// 과목별 성적
	public static void subjectScore() {
		if (studentCount==0) {
			System.out.println("아직 등록된 학생이 없습니다.");
			return;
		}
		if (subjectCount == 0) {
			System.out.println("아직 등록된 과목이 없습니다.");
			return;
		}
		
		boolean ok = false;
		String subject;
		System.out.println("성적 확인할 과목을 입력해 주세요");
		System.out.print("입력 : ");
		subject = scan.next();
		for(int i = 0; i < subjectCount; i++) {
			if(subjects[i].getSubjectName().equals(subject)) {
				subjects[i].totalScore();
				System.out.println(((int)(subjects[i].getStudentID()/10000.0)) +"학년 " 
						+ (((int)(subjects[i].getStudentID()/100.0)) - ((int)(subjects[i].getStudentID()/10000.0))*100 ) +"반 "
						+ (subjects[i].getStudentID() - ((int)(subjects[i].getStudentID()/100.0))*100)+"번 " 
						+ subjects[i].getStudentName() + " 학생의 " + subjects[i].getSubjectName() + " 성적" );
				System.out.println("중간고사 : " +subjects[i].getMidterm() + "점");
				System.out.println("기말고사 : " +subjects[i].getFinals() + "점");
				System.out.println("수행평가 : " +subjects[i].getAssessment() + "점");
				System.out.println("총점 (중간 40, 기말 40, 수행 20) : " + subjects[i].getTotalScore());
				ok = true;
			}	
		}
		if (!ok) {
			System.out.println("등록되지 않은 과목입니다.");
		}
	}
	
	
	
	// 학생별 성적
	public static void studentScore() {
		if (studentCount==0) {
			System.out.println("아직 등록된 학생이 없습니다.");
			return;
		}
		if (subjectCount == 0) {
			System.out.println("아직 등록된 과목이 없습니다.");
			return;
		}
		boolean ok = false;
		Student tmpStudent = new Student();
		int grade, classCount, num; 
		System.out.println("성적 확인할 학생 정보를 입력해 주세요");
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classCount = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		tmpStudent.newStudentID(grade, classCount, num);
		for(int i = 0 ; i < subjectCount; i++ ) {
			if(subjects[i].getStudentID() == tmpStudent.getStudentID()) {
				subjects[i].totalScore();
				System.out.println(subjects[i].getSubjectName()+" 점수");
				System.out.println("중간고사 : " +subjects[i].getMidterm() + "점");
				System.out.println("기말고사 : " +subjects[i].getFinals() + "점");
				System.out.println("수행평가 : " +subjects[i].getAssessment() + "점");
				System.out.println("총점 (중간 40, 기말 40, 수행 20) : " + subjects[i].getTotalScore());
				ok = true;
			}	
		}
		if (!ok) {
			System.out.println("등록되지 않은 학생이거나 과목입니다.");
			return;
		}	
			
		
	}
	
}
