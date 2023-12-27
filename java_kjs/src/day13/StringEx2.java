package day13;

import java.util.Scanner;

public class StringEx2 {
	
	static Scanner scan = new Scanner(System.in);
	
	 /* 문장들을 입력받아 배열에 저장하고, 
	 * 특정 단어가 들어가 있는 문장들을 출력하는 프로그램을 작성하라
	 * 
	 * 메뉴
	 * 1. 문장 추가
	 * 2. 검색
	 * 3. 종료
	 * */
	static String lines[] = new String[10];
	static int count = 0;
	static String line;
	static String searchLine;
	static boolean ok = false;
	
	public static void main(String[] args) {
		
		int menu;
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
		}
		while(menu != 3);
	}


	public static void printMenu() {
		System.out.println("---------");
		System.out.println("메뉴");
		System.out.println("1. 문장 추가");
		System.out.println("2. 검색");
		System.out.println("3. 종료");
		System.out.println("---------");
		System.out.print("메뉴 입력 : ");
	}
	
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			runAddLine();
			break;
		case 2:
			runSearch();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:	
			System.out.println("잘못된 메뉴입니다.");
		}
	}


	public static void runAddLine() {
		scan.nextLine();
		System.out.println("---------");
		System.out.println("추가할 문장을 입력해주세요");
		System.out.print("입력 : ");
		line = scan.nextLine();
		System.out.println("새로 '"+line+"' 추가되었습니다.");
		lines[count++] = line;
	}
	
	public static void runSearch() {
		scan.nextLine();
		System.out.println("검색할 문자열을 입력해주세요");
		System.out.print("입력 : ");
		searchLine = scan.nextLine();
		System.out.println("찾을 문자열 : " + searchLine );
		for(int i = 0 ; i< count; i++) {
			if(lines[i].contains(searchLine)) {
				System.out.println(lines[i]);
				ok = true;
			}
		}
		if (!ok) {
			System.out.println("없는 문자열입니다.");
		}
	}
}
