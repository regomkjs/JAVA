package day11.product;

public class Product {
	
	private String brand;	// 브랜드
	private String name;	// 제품명
	private int ftPrice;	// 입고가
	private int price;		// 판매가
	private int count;		// 재고
	private int saleNum;	// 누적판매량
	
	
	// getter setter
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFtPrice() {
		return ftPrice;
	}
	public void setFtPrice(int ftPrice) {
		this.ftPrice = ftPrice;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	} 
	public int getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}
	// 새 제품 등록 메서드
	/*
	public void newProduct(String brand, String name , int ftPrice, int price) {
		this.brand = brand;
		this.name = name;
		this.ftPrice = ftPrice;
		this.price = price;
		count = 0;
	}
	*/
	
	// 제품 정보 출력 메서드
	public void printProduct(String name) {
		if(name == this.name) {
			System.out.println("브랜드	: " + brand);
			System.out.println("제품명	: " + this.name);
			System.out.println("원가	: " + ftPrice);
			System.out.println("판매가	: " + price);
			System.out.println("재고	: " + count);
			System.out.println("누적판매량 : " + saleNum);
			return;
		}
		System.out.println("등록되지 않은 제품입니다.");
	}
	
	// 제품 입고 메서드
	public void addProduct(int count) {
		this.count = this.count + count;
	}
	
	
	// 생성자
	public Product(String brand, String name , int ftPrice, int price) {
		this.brand = brand;
		this.name = name;
		this.ftPrice = ftPrice;
		this.price = price;
		count = 0;
		saleNum = 0;
	}
}
