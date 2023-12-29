package day15.student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;


class StudentProgram implements Program {
	Scanner scan = new Scanner(System.in);
	List<Student> list = new ArrayList<Student>();
	
	
	// 메인 실행
	@Override
	public void run() {
		int menu = 0;
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}
			catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}
		while(menu != 4);
	}

	
	// 메인 메뉴
	@Override
	public void printMenu() {
		System.out.println("---------");
		System.out.println("1. 학생 관리");
		System.out.println("2. 성적 관리 ");
		System.out.println("3. 조회");
		System.out.println("4. 종료");
		System.out.println("---------");
		System.out.print("메뉴 입력 : ");
	}
	
	// 메뉴 실행
	@Override
	public void runMenu(int menu) {
		int submenu;
		switch(menu) {
		case 1:
			printStudentMenu();
			submenu = scan.nextInt();
			runStudentMenu(submenu);
			break;
		case 2:
			printScoreMenu();
			submenu = scan.nextInt();
			runScoreMenu(submenu);
			break;
		case 3:
			printSearchMenu();
			submenu = scan.nextInt();
			runSearchMenu(submenu);
			break;
		case 4:
			System.out.println("프로그램 종료!");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	/*------학생------*/
	
	// 학생 메뉴
	private void printStudentMenu() {
		System.out.println("---------");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("---------");
		System.out.print("메뉴 입력 : ");
	}
	
	private void runStudentMenu(int submenu) {
		switch(submenu) {
		case 1:
			// 학생 추가
			insertStudent();
			sort();
			break;
		case 2:
			// 학생 수정
			if(list.size() == 0) {
				System.out.println("아직 등록된 학생이 없습니다.");
				return;
			}
			changeInfoStudent();
			break;
		case 3:
			// 학생 삭제
			if(list.size() == 0) {
				System.out.println("아직 등록된 학생이 없습니다.");
				return;
			}
			deleteStudent();
			break;
		default:
			throw new InputMismatchException();
		}
	}
	

	/*------성적------*/
	
	// 성적 메뉴
	private void printScoreMenu() {
		System.out.println("---------");
		System.out.println("1. 성적 수정");
		System.out.println("---------");
		System.out.print("메뉴 입력 : ");
	}
	
	private void runScoreMenu(int submenu) {
		if(list.size() == 0) {
			System.out.println("아직 등록된 학생이 없습니다.");
			return;
		}
		switch(submenu) {
		case 1:
			insertScore();
			break;
		default:
			throw new InputMismatchException();
		}
	}


	/*-----조회------*/
	
	// 조회 메뉴
	private void printSearchMenu() {
		System.out.println("---------");
		System.out.println("1. 학생 조회");
		System.out.println("2. 성적 조회");
		System.out.println("---------");
		System.out.print("메뉴 입력 : ");
	}
	
	private void runSearchMenu(int submenu) {
		int menu;
		if(list.size() == 0) {
			System.out.println("아직 등록된 학생이 없습니다.");
			return;
		}
		switch(submenu) {
		case 1:
			// 학생 조회
			printStudentSearch();
			menu = scan.nextInt();
			runStudentSearch(menu);
			break;
		case 2:
			// 성적 조회
			printSubjectSearch();
			menu = scan.nextInt();
			runSubjectSearch(menu);
			break;
		default:
			throw new InputMismatchException();
		}
	}

	// 학생 조회
	private void printStudentSearch() {
		System.out.println("---------");
		System.out.println("1. 전체");
		System.out.println("2. 학년");
		System.out.println("3. 반");
		System.out.println("4. 학생");
		System.out.println("---------");
		System.out.print("메뉴 입력 : ");
	}
	
	private void runStudentSearch(int menu) {
		int grade, classNum, num;
		if(list.size() == 0) {
			System.out.println("아직 등록된 학생이 없습니다.");
			return;
		}
		switch(menu) {
		case 1:
			// 전체
			System.out.println("학생 전체 정보");
			printStudents(list, s -> true); // 나의 답 : s.grade > 0 / 선생님의 답 : true 
			break;
		case 2:
			// 학년
			System.out.println("성적을 조회할 학년을 입력하세요");
			System.out.print("학년 : ");
			grade = scan.nextInt();
			printStudents(list, s -> s.grade==grade);
			break;
		case 3:
			// 반
			System.out.println("성적을 조회할 학년과 반을 입력하세요");
			System.out.print("학년 : ");
			grade = scan.nextInt();
			System.out.print("반 : ");
			classNum = scan.nextInt();
			printStudents(list, s -> s.grade == grade && s.classNum == classNum);
			break;
		case 4:
			// 학생
			System.out.println("성적을 조회할 학년과 반, 번호을 입력하세요");
			System.out.print("학년 : ");
			grade = scan.nextInt();
			System.out.print("반 : ");
			classNum = scan.nextInt();
			System.out.print("번호 : ");
			num = scan.nextInt();
			printStudents(list, s -> s.grade == grade && s.classNum == classNum && s.num == num);
			break;
		default:
			throw new InputMismatchException();		
		}
	}
	
	// 과목 조회
	private void printSubjectSearch() {
		System.out.println("---------");
		System.out.println("1. 국어");
		System.out.println("2. 영어");
		System.out.println("3. 수학");
		System.out.println("---------");
		System.out.print("메뉴 입력 : ");
	}
	
	private void runSubjectSearch(int menu) {
		if(list.size() == 0) {
			System.out.println("아직 등록된 학생이 없습니다.");
			return;
		}
		switch(menu) {
		case 1:
			// 국어
			printSubject(list, s -> {
				System.out.println(s.getGrade() + "학년 " + s.getClassNum() 
				+ "반 " + s.getNum() + "번 " + s.getName() + " : " + s.getKor());
			});
			break;
		case 2:
			// 영어
			printSubject(list, s -> {
				System.out.println(s.getGrade() + "학년 " + s.getClassNum() 
				+ "반 " + s.getNum() + "번 " + s.getName() + " : " + s.getEng());
			});
			break;
		case 3:
			// 수학
			printSubject(list, s -> {
				System.out.println(s.getGrade() + "학년 " + s.getClassNum() 
				+ "반 " + s.getNum() + "번 " + s.getName() + " : " + s.getMath());
			});
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	
	/* ----기능------*/
	// 학생 추가
	private void insertStudent() {
		int grade, classNum, num;
		String name;
		System.out.println("등록할 학생 정보를 입력");
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classNum = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		Student tmp = new Student(grade, classNum, num);
		if(list.contains(tmp)) {
			System.out.println("이미 등록된 학생 정보 입니다.");
			return;
		}
		System.out.print("이름 : ");
		name = scan.next();
		tmp.addName(name);
		list.add(tmp);
		tmp.printInfo();
		System.out.println(" 학생 정보가 추가 되었습니다.");
	}
	
	// 학생 수정
	private void changeInfoStudent() {
		int index = -1;
		int grade, classNum, num;
		System.out.println("수정할 학생 정보 입력");
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classNum = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		Student tmp = new Student(grade, classNum, num);
		for(int i = 0 ; i< list.size() ; i++) {
				if(list.get(i).isSame(tmp)) {
					index = i;
					list.get(i).printInfo();
					System.out.println(" 학생의 정보 수정");
					runChangeInfoStudent(index);
					return;
			}
		}
		System.out.println("등록되지 않은 학생입니다.");
		
	}
	
	// 학생 수정 실행
	private void runChangeInfoStudent(int index) {
		int grade, classNum, num;
		String name;
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classNum = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		Student tmp = new Student(grade, classNum, num);
		for(int i = 0 ; i< list.size() ; i++) {
			if(list.get(i).isSame(tmp)) {
				System.out.println("이미 있는 학생 정보이기 때문에 수정 불가능 합니다.");
				return;
			}
		}
		System.out.print("이름 : ");
		name = scan.next();
		tmp.addName(name);
		/* ---------------- //
		// 성적 유지를 위해 추가 */
		tmp.setKor(list.get(index).getKor());
		tmp.setEng(list.get(index).getEng());
		tmp.setMath(list.get(index).getMath());
		/*-----------------*/
		list.remove(index);
		list.add(tmp);
		
		// 정렬 (선생님 답 학년, 반, 번호 순 오름차순)
		sort();
		
		System.out.println("학생 정보가 수정 되었습니다.");
	}
	
	// 학생 삭제
	private void deleteStudent() {
		int grade, classNum, num;
		System.out.println("삭제할 학생 정보 입력");
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classNum = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		Student tmp = new Student(grade, classNum, num);
		for(int i = 0 ; i< list.size() ; i++) {
			if(list.get(i).isSame(tmp)) {
				list.get(i).printInfo();
				System.out.println(" 학생 정보를 삭제했습니다.");
				list.remove(i);
				return;
			}
		}
		System.out.println("등록되지 않은 학생입니다.");
	}
	
	// 성적 수정
	private void insertScore() {
		int index = -1;
		int grade, classNum, num;
		System.out.println("성적 수정할 학생 정보 입력");
		System.out.print("학년 : ");
		grade = scan.nextInt();
		System.out.print("반 : ");
		classNum = scan.nextInt();
		System.out.print("번호 : ");
		num = scan.nextInt();
		Student tmp = new Student(grade, classNum, num);
		for(int i = 0 ; i< list.size() ; i++) {
			if(list.get(i).isSame(tmp)) {
				index = i;
				list.get(i).printInfo();
				System.out.println(" 학생의 성적 수정");
				changeScore(index);
			}
		}
	}

	// 성적 수정 실행
	private void changeScore(int index) {
		int kor, eng, math;
		System.out.print("변경 전 국어 성적 : ");
		list.get(index).getKor();
		System.out.print("변경할 국어 성적 : ");
		kor = scan.nextInt();
		list.get(index).setKor(kor);
		
		System.out.print("변경 전 영어 성적 : ");
		list.get(index).getEng();
		System.out.print("변경할 영어 성적 : ");
		eng = scan.nextInt();
		list.get(index).setEng(eng);
		
		System.out.print("변경 전 수학 성적 : ");
		list.get(index).getMath();
		System.out.print("변경할 수학 성적 : ");
		math = scan.nextInt();
		list.get(index).setMath(math);
		
		list.get(index).printScoreInfo();
	}
	
	// 학생리스트 학년, 반, 번호 순 오름차순정렬 (선생님 코드)   
	private void sort() {
		list.sort((o1,o2) -> {
			if(o1.getGrade() != o2.getGrade()) {
				return o1.getGrade() - o2.getGrade();
			}
			if(o1.getClassNum() != o2.getClassNum()) {
				return o1.getClassNum() - o2.getClassNum();
			}
			return o1.getNum() - o2.getNum();
		});
	}
	
	
	// 과목별 조회 활용
	private void printSubject(List<Student> list , Consumer<Student> s) {
		for(Student student : list) {
			s.accept(student);
		}
	}
	
	// 학생별 조회 활용
	private void printStudents(List<Student> list , Predicate<Student> s) {
		for(Student std : list) {
			if(s.test(std)) {
				System.out.println(std);
			}
		}
	}

}




