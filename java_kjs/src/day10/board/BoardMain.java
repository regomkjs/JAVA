package day10.board;

import java.util.Scanner;

public class BoardMain {
		/* 게시판에서 게시글 관리를 위한 콘솔 프로그램 작성하라
		 * 제한사항 정리
		 * 	- 게시판은 1개
		 * 	- 로그인 없이 닉네임만으로 작성 수정 삭제
		 * 	- 게시글 제목과 내용은 한 줄만 가능
		 *  - 작성일을 입력
		 *  
		 * 1. 필요한 기능을 정리해서 메뉴로 출력
		 * -----------
		 * =메뉴=
		 * 1. 게시글 목록 조회
		 * 2. 게시글 등록
		 * 3. 프로그램 종료
		 * 메뉴 선택 :
		 * -----------
		 * =게시글 목록 조회=
		 * 2. 가입인사 2023-12-20 asd 1
		 * 1. 공지  2023-12-19 admin 3
		 * -----------
		 * =메뉴=
		 * 1. 게시글 상세 조회
		 * 2. 게시글 수정
		 * 3. 게시글 삭제
		 * 4. 뒤로가기
		 * 메뉴 선택 : 1
		 * 조회할 게시글 번호 : 2
		 * 번호 : 2
		 * 제목 : 가입인사
		 * 내용 : 안녕하세요.
		 * 일자 : 2023-12-20
		 * 작성자: asd
		 * 조회수: 2
		 * -----------
		 * =게시글 목록 조회=
		 * 2. 가입인사 2023-12-20 asd 1
		 * 1. 공지  2023-12-19 admin 3
		 * =메뉴=
		 * 1. 게시글 상세 조회
		 * 2. 게시글 수정
		 * 3. 게시글 삭제
		 * 4. 뒤로가기
		 * 메뉴 선택 : 2
		 * 수정할 게시글 번호 : 2
		 * 제목 : 가입인사입니다.
		 * 내용 : 만나서 반갑습니다.
		 * 수정이 완료됐습니다.
		 * -----------
		 * =게시글 목록 조회=
		 * 2. 가입인사입니다. 2023-12-20 asd 1
		 * 1. 공지  2023-12-19 admin 3
		 *  =메뉴=
		 * 1. 게시글 상세 조회
		 * 2. 게시글 수정
		 * 3. 게시글 삭제
		 * 4. 뒤로가기
		 * 메뉴 선택 : 3
		 * 삭제할 게시글 번호 : 1
		 * 게시글이 삭제됐습니다.
		 * -----------
		 * =게시글 목록 조회=
		 * 1. 가입인사입니다. 2023-12-20 asd 1
		 *  =메뉴=
		 * 1. 게시글 상세 조회
		 * 2. 게시글 수정
		 * 3. 게시글 삭제
		 * 4. 뒤로가기
		 * 메뉴 선택 : 4
		 * -----------
		 * =메뉴=
		 * 1. 게시글 목록 조회
		 * 2. 게시글 등록
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * 제목 : 테스트
		 * 내용 : 테스트 
		 * 일자 : 2023-12-20
		 * 아이디 : qwe
		 * 등록이 완료됐습니다.
		 * -----------
		 * =메뉴=
		 * 1. 게시글 상세 조회
		 * 2. 게시글 수정
		 * 3. 게시글 삭제
		 * 4. 뒤로가기
		 * 메뉴 선택 : 1
		 * 조회할 게시글 번호 : 2
		 * 번호 : 2
		 * 제목 : 가입인사
		 * 내용 : 안녕하세요.
		 * 일자 : 2023-12-20
		 * 작성자: asd
		 * 조회수: 2
		 * 2. 기능을 구현
		 * */
	
	static Scanner scan = new Scanner(System.in);
	private static Board[] boardList = new Board[5]; // 게시글 목록
	private static int count = 0; // 현재 등록된 게시글의 개수
	
	public static void main(String[] args) {
		int mainMenu;
		do {
			// 메인메뉴 출력
			printMainMenu();
			mainMenu = scan.nextInt();
			// 선택한 기능 실행
			runMainMenu(mainMenu,boardList);
		}
		while(mainMenu != 3);
	}
	
	/**
	 * mainMenu가 주어지면 mainMenu에 맞는 기능을 실행하는 메서드
	 * @param mainMenu 실행할 메뉴의 번호
	 */
	// 메인메뉴 출력
	private static void printMainMenu() {
		System.out.println("------------");
		System.out.println("=메뉴=");
		System.out.println("1. 게시글 목록 조회");
		System.out.println("2. 게시글 등록");
		System.out.println("3. 프로그램 종료");
		System.out.println("------------");
		System.out.print("메뉴 입력 : ");
	}
	
	// 메인메뉴 실행
	private static void  runMainMenu (int mainMenu, Board boardList[]) {
		switch(mainMenu) {
		case 1:
			printboardListInfo();
			break;
		case 2:
			insertBoard();
			break;
		case 3:
			break;
		default:
		}
	}
	
	// 게시글 목록 조회
	private static void printboardListInfo () {
		int submenu;
		do {
			for(int i = count - 1; i >= 0; i--) {
					boardList[i].printInfo();
			}
			printSubmenu();
			submenu = scan.nextInt();
			runSubmenu(submenu);
		}
		while(submenu != 4);
	}
	
	// 서브메뉴 출력
	private static void printSubmenu() {
		System.out.println("---서브메뉴---");
		System.out.println("1. 게시글 상세 조회");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 뒤로가기");
		System.out.println("------------");
		System.out.print("메뉴 선택 : ");
	}
	
	// 서브메뉴 입력
	private static void runSubmenu(int submenu) {
		switch(submenu) {
		case 1:
			searchList();
			System.out.println("------------");
			break;
		case 2:
			scan.nextLine();
			updateBoard();
			System.out.println("------------");
			break;
		case 3:
			delList();
			System.out.println("------------");
			break;
		case 4:
			System.out.println("------------");
			System.out.println("뒤로가기");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	// 게시글 조회
	private static void searchList() {
		System.out.print("조회할 게시글 번호 : ");
		int num = scan.nextInt();
		for (int i = 0 ; i < count ; i++) {
			if(boardList[i].getNum() == num) {
				boardList[i].setViews(boardList[i].getViews() + 1);
				boardList[i].printInfoDetail();
				return;
			}
		}
		System.out.println("등록되지 않았거나 삭제된 게시글 입니다.");
	}
	
	// 게시글 수정
	private static void updateBoard () {
		System.out.print("수정할 게시글 번호 : ");
		int num = scan.nextInt();
		for (int i = 0 ; i < count ; i++) {
			if(boardList[i].getNum() == num) {
				System.out.print("수정할 제목 : ");
				scan.nextLine();
				String title = scan.nextLine();
				System.out.print("수정할 내용 : ");
				String contents = scan.nextLine();
				boardList[i].update(title, contents);
				return;
			}
		}
		System.out.println("등록되지 않았거나 삭제된 게시글 입니다.");
	}
	
	// 게시글 삭제
	private static void delList () {
		System.out.print("삭제할 게시글 번호 : ");
		int num = scan.nextInt();
		for (int i = 0 ; i < count ; i++) {
			if(boardList[i].getNum() == num) {
				boardList[i] = null;
				for(int j = 0 ; j < count ; j++)	{
					if (boardList[j] == null && boardList[j+1] != null) {
						boardList[j] = boardList[j+1];
						boardList[j+1] = null;
					}
				}
				System.out.println(num + "번 게시글이 삭제되었습니다.");
				count--;
				return;
			}
		}
		System.out.println("등록되지 않았거나 삭제된 게시글 입니다.");
	}
	
	// 게시글 등록
	private static void insertBoard() {
		scan.nextLine(); // 입력 버퍼에 남아있는 엔터 처리
		System.out.println("------------");
		System.out.println("게시글 등록");
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();
		System.out.print("일자 : ");
		String date = scan.next();
		System.out.print("작성자: ");
		String writer = scan.next();
		Board board = new Board(title, contents, writer, date);
		boardList[count] = board;
		count++;
		// 배열 크기를 안늘려도 되면 종료
		if(count < boardList.length) {
			return;
		}
		Board[] tmpList = new Board[boardList.length + 5];
		System.arraycopy(boardList, 0, tmpList, 0, count);
		boardList = tmpList;
	}

}
