package day15;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MapEx2 {
	static Scanner scan = new Scanner(System.in);
	static Map<String,String> map = new HashMap<String, String>();
	static String id, pw;
	
	public static void main(String[] args) {
		/* 회원을 관리하는 프로그램을 작성하라
		 * 
		 * 메뉴 
		 * 1. 회원가입
		 *   - 아이디, 비번만 입력
		 * 2. 회원검색
		 *   - 아이디를 입력해서 회원 정보를 조회
		 * 3. 종료
		 * 
		 * */
		
		int menu = 0;
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}
			catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine(); // 잘못 입력된 값을 문자열로 가져와서 버림
			}
		}
		while(menu != 4);
		
	}
	
	// 메뉴출력
	public static void printMenu() {
		System.out.println("==메뉴==");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원검색");
		System.out.println("3. 회원탈퇴");
		System.out.println("4. 종료");
		System.out.print("메뉴입력 : ");
	}
	
	// 메뉴실행
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			// 회원가입
			insertMember();
			break;
		case 2:
			// 회원검색
			searchMember();
			break;
		case 3:
			// 회원탈퇴
			deleteMember();
			break;
		case 4:
			//종료
			System.out.println("프로그램 종료");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	// 회원가입
	public static void insertMember() {
		System.out.println("=회원가입=");
		System.out.print("아이디 : ");
		id = scan.next();
		if(map.containsKey(id)) {
			System.out.println("이미 존재하는 아이디 입니다.");
			return;
		}
		System.out.print("비밀번호 : ");
		pw = scan.next();
		map.put(id, pw);
		System.out.println(id+" 회원가입 되었습니다.");
	}
	
	
	// 회원검색
	public static void searchMember() {
		System.out.println("=회원검색=");
		System.out.print("검색할 아이디 : ");
		id = scan.next();
		if(map.containsKey(id)) {
			System.out.println(id +" 회원의 정보");
			System.out.println("아이디 : " + id);
			System.out.println("비밀번호 : " + map.get(id));
			return;
		}
		System.out.println("아직 등록되지 않은 아이디 입니다.");
	}
	
	// 회원탈퇴
	public static void deleteMember() {
		System.out.println("=회원탈퇴=");
		System.out.println("탈퇴할 아이디 : ");
		id = scan.next();
		if(map.containsKey(id)) {
			System.out.println("탈퇴하시려면 비밀번호를 입력해주세요");
			System.out.print("비밀번호를 입력 : ");
			pw = scan.next();
			if(map.get(id).equals(pw)) {
				System.out.println(id+" 회원 탈퇴 되었습니다.");
				map.remove(id);
				return;
			}
		}
		System.out.println("등록되지 않은 회원 입니다.");
	}
}
