package day12.product;

import java.util.Scanner;

public class ProductMain {

	/* 제품을 추가하는 프로그램을 작성하세요
	 * 제품은 TV, 에어컨, 컴퓨터만 추가 가능
	 * 공통 : 브랜드, 제품코드, 제품명
	 * TV : 화면크기
	 * 에어컨 : 냉방면적
	 * 노트북 : CPU, 램
	 * 
	 * TV , 에어컨, 노트북 클래스
	 * Product 클래스
	 * 
	 * 메뉴
	 * 1. 제품 추가 
	 * 2. 제품 확인
	 * 3. 종료
	 * 메뉴 선택 : 1
	 * ------------
	 * 추가할 제품
	 * 1. TV
	 * 2. 에어컨
	 * 3. 노트북
	 * 제품 선택 : 1
	 * 브랜드 : 삼성
	 * 제품코드 : 
	 * 제품명 : 
	 * 화면크기(cm) : 
	 * 등록이 완료됐습니다. 
	 * -------------
	 * 메뉴
	 * 1. 제품 추가 
	 * 2. 제품 확인
	 * 3. 종료
	 * 메뉴 선택 : 1
	 * ------------
	 * 추가할 제품
	 * 1. TV
	 * 2. 에어컨
	 * 3. 노트북
	 * 제품 선택 : 2
	 * 브랜드 : 삼성
	 * 제품코드 : 
	 * 제품명 : 
	 * 냉방면적 :
	 * 등록이 완료됐습니다. 
	 * ------------- 
	 * */
	static Product products[] = new Product[10];
	static int productCount = 0;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		int menu;
		do {
			// 메인메뉴출력
			printMainMenu();
			menu = scan.nextInt();
			// 메인메뉴실행
			runMainMenu(menu);
		}
		while(menu != 3);
	}
	
	
	// 메인메뉴출력
	public static void printMainMenu() {
		System.out.println("====메뉴====");
		System.out.println("1. 제품 추가");
		System.out.println("2. 제품 확인");
		System.out.println("3. 종료");
		System.out.print("메뉴 입력 : ");
	}
	
	// 메인메뉴실행
	public static void runMainMenu(int menu) {
		int submenu;
		switch(menu) {
		case 1:
			// 제품 추가 메뉴출력
			printAddMenu();
			submenu = scan.nextInt();
			// 제품 추가 실행
			runAddMenu(submenu);
			break;
		case 2:
			checkProduct();
			break;	
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;	
		default:	
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	
	// 제품 추가 메뉴출력
	public static void printAddMenu() {
		System.out.println("===제품 추가===");
		System.out.println("1. TV");
		System.out.println("2. 에어컨");
		System.out.println("3. 노트북");
		System.out.print("메뉴 입력 : ");
	}
	
	// 제품 추가 실행
	public static void runAddMenu(int submenu) {
		String brand, productName, ProductCode, cpu, ram;
		int wide, area;
		scan.nextLine();
		System.out.print("브랜드 : ");
		brand = scan.nextLine();
		System.out.print("제품코드 : ");
		ProductCode = scan.nextLine();
		System.out.print("제품명 : ");
		productName = scan.nextLine();
		switch(submenu) {
		case 1:
			System.out.print("화면크기 : ");
			wide = scan.nextInt();
			products[productCount++] = new Tv(brand, productName, ProductCode, wide);
			break;
		case 2:
			System.out.print("냉방면적 : ");
			area = scan.nextInt();
			products[productCount++] = new AirConditionor(brand, productName, ProductCode, area);
			break;
		case 3:
			System.out.print("CPU : ");
			cpu = scan.nextLine();
			System.out.print("램 : ");
			ram = scan.nextLine();
			products[productCount++] = new Notebook(brand, productName, ProductCode, cpu, ram);
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	
	// 모든 제품 확인
	public static void checkProduct() {
		System.out.println("==등록된 제품==");
		for(int i = 0; i< productCount; i++) {
			products[i].print();
			System.out.println("===========");
		}
	}

}

	


