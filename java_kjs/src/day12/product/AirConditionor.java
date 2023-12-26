package day12.product;

public class AirConditionor extends Product {
	
	int area;
	
	public void print() {
		super.print();
		System.out.println("냉방면적 : " + area);
	}
	
	public AirConditionor(String brand, String productName, String productCode, int area) {
		super(brand, productName, productCode);
		this.area = area;
	}

}
