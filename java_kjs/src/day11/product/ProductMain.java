package day11.product;

import java.util.Scanner;

public class ProductMain {

	/* 제품을 관리하는 프로그램 구현
	 * 
	 * 
	 * 메뉴
	 * 1. 제품 입고
	 * 	1) 새 제품 등록
	 *  2) 기존 제품 입고 = 자금을 입고에 사용한 금액만큼 차감
	 *  3) 뒤로가기
	 * 2. 제품 판매 
	 * 	- 제품 , 수량
	 * 3. 제품 조회
	 *  1) 제품 정보
	 * 	2) 제품 가격 수정
	 * 	3) 브랜드 행사
	 *  4) 뒤로가기
	 * 4. 매출 내역 조회
	 *  1) 현재 매출액 조회
	 *  2) 남은 자금 확인
	 *  3) 일일정산
	 *  4) 영업일별 정산 기록 조회
	 *  5) 뒤로가기
	 * 5. 종료
	 * 
	 * */
	
	static Scanner scan = new Scanner(System.in);
	static Product productToday[] = new Product [5];
	static ProductList ProductsSaleList[] = new ProductList [5];
	static int productCount = 0;			// 등록된 제품의 수
	static int seedMoney = 50000000;  		// 자본금 
	static int restMoney = 50000000;		// 남은 자금
	static int sales = 0;					// 매출액
	static int workingDate = 1;				// 영업일 
	static int dateSaleCount = 0;			// 일일 누적 판매량 집계
	static int benefit = 0;					// 영업일의 수익율 기록
	// 메인
	public static void main(String[] args) {
		int mainMenu;
		do {
			printMainMenu();
			mainMenu = scan.nextInt();
			runMainMenu(mainMenu);
		}
		while(mainMenu != 5);
	}

	// 메인메뉴 출력
	public static void printMainMenu() {
		System.out.println("======메뉴======");
		System.out.println("1. 제품 입고");
		System.out.println("2. 제품 판매");
		System.out.println("3. 제품 수정");
		System.out.println("4. 매출 조회");
		System.out.println("5. 종료");
		System.out.println("===============");
		System.out.print("메뉴 입력 : ");
	}

	// 메인메뉴 실행
	public static void runMainMenu(int mainMenu) {
		switch(mainMenu) {
		case 1:
			incomeProduct();
			break;
		case 2:
			saleProduct();
			break;
		case 3:
			joinProduct();
			break;
		case 4:
			joinSalesList();
			break;
		case 5:
			System.out.println("프로그램 종료");
			break;
		default:
			
		}
		
	}
	
	/* 메인메뉴 하위 모음
	 * */
	// 제품 입고
	public static void incomeProduct () {
		int submenu;
		do {
			System.out.println("====제품 입고====");
			System.out.println("1) 새 제품 등록");
			System.out.println("2) 기존 제품 입고");
			System.out.println("3) 뒤로가기");
			System.out.println("===============");
			System.out.print("메뉴 입력 : ");
			submenu = scan.nextInt();
			switch(submenu) {
			case 1:
				newProduct();
				break;
			case 2:
				addingProduct();
				break;
			case 3:
				return;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}
		while(submenu != 3);
	}
	
	// 제품 판매
	public static void saleProduct() {
		String saleProduct;
		int saleCount;
		scan.nextLine();
		if (productCount == 0) {
			System.out.println("아직 등록된 제품이 없습니다.");
			return;
		}
		System.out.println("==판매 중인 제품===");
		for(int i = 0 ; i<productCount; i++) {
			if(productToday[i].getCount() != 0) {
				System.out.println("브랜드: "+productToday[i].getBrand()+ "/ 제품명: "+ productToday[i].getName()
						+ "/ 가격: " + productToday[i].getPrice() + "/ 남은 수량: " + productToday[i].getCount());
			}
		}
		System.out.println("====제품 판매====");
		System.out.print("판매할 제품명:");
		saleProduct = scan.nextLine();
		System.out.print("판매할 수량	:");
		saleCount = scan.nextInt();
		for(int i = 0 ;i < productCount; i++) {
			if(productToday[i].getName().equals(saleProduct) 
					&& productToday[i].getCount() >= saleCount ) {
				// 재고 계산
				productToday[i].setCount(productToday[i].getCount() - saleCount);
				// 누적 판매량 계산
				productToday[i].setSaleNum(productToday[i].getSaleNum() + saleCount);
				// 일일 총 판매량 누적
				dateSaleCount = dateSaleCount + saleCount;
				// 매출 계산
				sales = sales + (productToday[i].getPrice() * saleCount);
				System.out.println("판매 후 "+saleProduct + " 재고 정보");
				System.out.println(productToday[i].getName()+ " 재고 : " + productToday[i].getCount());
				return;
			}
		}
		System.out.println("없는 제품이거나 재고가 부족합니다.");
	}
	
	// 제품 조회
	public static void joinProduct() {
		int submenu;
		if(productCount == 0) {
			System.out.println("아직 등록된 제품이 없습니다.");
			return;
		}
		do {
			System.out.println("====제품 조회====");
			System.out.println("1) 제품 정보");
			System.out.println("2) 제품 가격 수정");
			System.out.println("3) 브랜드 행사");
			System.out.println("4) 뒤로가기");
			System.out.println("==============");
			System.out.print("메뉴 입력 : ");
			submenu = scan.nextInt();
			switch(submenu) {
			case 1:
				infoProduct();
				break;
			case 2:
				remarkPrice();
				break;
			case 3:
				brandSale();
				break;
			case 4:
				return;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}
		while(submenu != 4);
	}
	
	// 매출 조회
	public static void joinSalesList() {
		int submenu;
		do {
			System.out.println("===매출 내역 조회===");
			System.out.println("1) 현재 매출액 조회");
			System.out.println("2) 남은 자금 조회");
			System.out.println("3) 일일정산");
			System.out.println("4) 영업일별 정산 기록 조회");
			System.out.println("5) 뒤로가기");
			System.out.println("================");
			System.out.print("메뉴 입력 : ");
			submenu = scan.nextInt();
			switch(submenu) {
			case 1:
				System.out.println("==현재 매출액 조회==");
				System.out.println("매출액 : " + sales);
				break;
			case 2:
				System.out.println("==남은 자금 조회==");
				System.out.println("자금 : " + restMoney);
				break;
			case 3:
				cleanSales();
				break;
			case 4:
				dateSalesList();
				return;
			case 5:
				break;	
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}
		while(submenu != 5);
	}
	
	
	
	/* 서브메뉴 하위 모음
	 * */ 
	// 새 제품 등록
	public static void newProduct() {
		String brand;
		String name;
		int ftPrice; 
		int price;
		scan.nextLine();
		System.out.println("===새 제품 등록===");
		System.out.print("등록할 제품의 브랜드 : ");
		brand = scan.nextLine();
		System.out.print("등록할 제품의 이름  : ");
		name = scan.nextLine();
		for(int i = 0 ; i < productCount; i++) {
			if(productToday[i].getName() == name) {
				System.out.println("이미 등록된 제품입니다.");
				return;
			}
		}
		System.out.print("등록할 제품의 입고가 : ");
		ftPrice = scan.nextInt();
		System.out.print("등록할 제품의 판매가 : ");
		price = scan.nextInt();
		Product newProduct = new Product(brand, name ,ftPrice, price);
		productToday[productCount] = newProduct;
		System.out.println("==============");
		System.out.println("새로 등록된 제품 정보");
		productToday[productCount].printProduct(productToday[productCount].getName());
		productCount++;
		// 배열이 가득 차면 늘려준다
		if(productCount == productToday.length) {
			Product tmpList[] = new Product[productToday.length + 5];
			System.arraycopy(productToday, 0, tmpList, 0, productCount);
			productToday = tmpList;
		}
	}
	
	// 기존 상품 입고
	public static void addingProduct() {
		if(productCount == 0 ) {
			System.out.println("아직 등록된 제품이 없습니다.");
			return;
		}
		String name;
		int addCount;
		scan.nextLine();
		System.out.println("==기존 제품 입고==");
		System.out.print("제품명	: ");
		name = scan.nextLine();
		System.out.print("입고 수량: ");
		addCount = scan.nextInt();
		for(int i = 0 ; i < productCount; i++) {
			if(productToday[i].getName().equals(name)) {
				restMoney = restMoney - (productToday[i].getFtPrice() * addCount);
				productToday[i].addProduct(addCount);
				System.out.println(productToday[i].getName() + "의 정보");
				productToday[i].printProduct(productToday[i].getName());
				return;
			}
		}
		System.out.println("등록되지 않은 제품입니다.");
	}
	
	// 제품 정보
	public static void infoProduct() {
		String product;
		scan.nextLine();
		System.out.println("====제품 정보====");
		System.out.print("정보를 볼 제품명 : ");
		product = scan.nextLine();
		for(int i = 0 ; i < productCount; i++) {
			if(productToday[i].getName().equals(product)) {
				System.out.println(product + " 정보");
				productToday[i].printProduct(productToday[i].getName());
				return;
			}
		}
		System.out.println("등록되지 않은 제품입니다.");
	}

	// 제품 가격 수정
	public static void remarkPrice() {
		String product;
		int newPrice;
		scan.nextLine();
		System.out.println("==제품 가격 수정==");
		System.out.print("가격을 수정할 제품 : ");
		product = scan.nextLine();
		for(int i = 0 ; i < productCount; i++) {
			if(productToday[i].getName().equals(product)) {
				System.out.print(product + "의 바뀔 가격 : ");
				newPrice = scan.nextInt();
				productToday[i].setPrice(newPrice);
				return;
			}
		}
		System.out.println("등록되지 않은 제품입니다.");
	}
	
	// 브랜드 행사
	public static void brandSale() {
		scan.nextLine();
		String brand;
		int discount;
		System.out.println("===브랜드 행사===");
		System.out.print("행사 중인 브랜드 :");
		brand = scan.nextLine();
		System.out.print("할인율 (% 생략) : ");
		discount = scan.nextInt();
		for(int i = 0 ; i < productCount; i++) {
			if(productToday[i].getBrand().equals(brand)) {
				productToday[i].setPrice((int)(productToday[i].getPrice()*((100 - discount)/100.0)));
			}
		}
		for(int i = 0 ; i < productCount; i++) {
			if(productToday[i].getBrand().equals(brand)) {
				System.out.println(brand + "의 모든 제품에 " + discount+ "% 할인을 적용했습니다.");
				return;
			}
		}
		System.out.println("등록되지 않은 브랜드 입니다.");
	}

	// 일일정산
	public static void cleanSales() {
		int submenu;
		System.out.println("====================");
		System.out.println("제품별 누적 판매량");
		for(int i = 0 ; i< productCount; i++ ) {
			System.out.println(productToday[i].getName() + " : "+ productToday[i].getSaleNum());
		}
		System.out.println("====일일정산====");
		System.out.println("현재 남은 자본 : " + restMoney + "원");
		System.out.println("현재매출 : " + sales + "원");
		System.out.println("영업비용 : " + (seedMoney - restMoney) + "원");
		System.out.println("영업이익 : " + (sales- (seedMoney-restMoney)) + "원");
		if(seedMoney - restMoney == 0) {
			System.out.println("수익율 : 0%");
			benefit = 0;
		}
		else {
			System.out.println("수익율 : 약 " + (int)(sales/(seedMoney - restMoney)*100 - 100)+"%");
			benefit = (int)(sales/(seedMoney - restMoney)*100 - 100);
		}
		System.out.println("일일정산을 완료하시면 자본금에 판매매출을 포함하게 되며 매출이 초기화 됩니다.");
		System.out.print("완료 하시겠습니까? (예: 1 , 아니오: 2) : ");
		submenu = scan.nextInt();
		switch(submenu) {
		case 1: 
			// 일일정산시 기록 저장
			saveSalesList();
			return;
		case 2:
			System.out.println("정산하지 않았습니다.");
			return;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}
	
	// 일일정산시 기록 저장
	public static void saveSalesList() {
		ProductList dayList = new ProductList(workingDate, dateSaleCount, sales
				, seedMoney - restMoney, benefit, restMoney + sales );
		ProductsSaleList[workingDate-1] = dayList;
		workingDate++;
		seedMoney = restMoney + sales;
		sales = 0;
		restMoney = seedMoney;
		dateSaleCount = 0;
		System.out.println("일일정산 후 자본금 : " + seedMoney +"원");
		if(workingDate - 1 == ProductsSaleList.length) {
			ProductList tmpList[] = new ProductList[ProductsSaleList.length+5];
			System.arraycopy(ProductsSaleList, 0, tmpList, 0, ProductsSaleList.length);
			ProductsSaleList = tmpList;
		}
	}
	
	// 영업일별 정산 기록 조회
	public static void dateSalesList() {
		int searchDate;
		System.out.println("====================");
		System.out.println("현재 영업일 " + workingDate +"일차");
		System.out.print("조회할 영업일 입력 : ");
		searchDate = scan.nextInt();
		if(searchDate >= workingDate) {
			System.out.println("아직 " + searchDate + "일차는 정산되지 않았습니다.");
			return;
		}
		ProductsSaleList[searchDate-1].printList();
	}
	
	
}
