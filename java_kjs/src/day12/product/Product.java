package day12.product;

public class Product {
	protected String brand;
	protected String productName;
	protected String ProductCode;
	
	
	//메서드
	// 제품 정보 출력
	public void print() {
		System.out.println("브랜드 : " + brand);
		System.out.println("제품코드 : " + ProductCode);
		System.out.println("제품명 : " + productName);
	}
	
	//생성자
	public Product(String brand, String productName, String productCode) {
		this.brand = brand;
		this.productName = productName;
		this.ProductCode = productCode;
	}
}
