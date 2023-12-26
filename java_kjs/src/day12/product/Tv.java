package day12.product;

public class Tv extends Product {
	
	int wide;
	
	public void print() {
		super.print();
		System.out.println("화면크기 : " + wide);
	}

	public Tv(String brand, String productName, String productCode,int wide) {
		super(brand, productName, productCode);
		this.wide = wide;
	}

}
