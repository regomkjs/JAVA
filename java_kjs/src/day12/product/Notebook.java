package day12.product;

public class Notebook extends Product {
	
	String cpu;
	String ram;
	
	public void print() {
		super.print();
		System.out.println("CPU : " + cpu);
		System.out.println("램 : " + ram);
	}
	
	public Notebook(String brand, String productName, String productCode,String cpu, String ram) {
		super(brand, productName, productCode);
		this.cpu = cpu;
		this.ram = ram;
	}

}
