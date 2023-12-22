package day11.product;

// 일일 정산 기록
public class ProductList {
	
	private int day;			// 일일정산 기록
	private int salesProduct;	// 총 판매량
	private int saveSales;		// 매출 기록
	private int eventPrice;		// 발생한 비용 기록
	private int benefit;		// 수익율 기록
	private int saveSeedMoney;	// 자본금 기록
	
	
	// getter setter
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getSalesProduct() {
		return salesProduct;
	}
	public void setSalesProduct(int salesProduct) {
		this.salesProduct = salesProduct;
	}
	public int getSaveSales() {
		return saveSales;
	}
	public void setSaveSales(int saveSales) {
		this.saveSales = saveSales;
	}
	public int getSaveSeedMoney() {
		return saveSeedMoney;
	}
	public void setSaveSeedMoney(int saveSeedMoney) {
		this.saveSeedMoney = saveSeedMoney;
	}
	public int getEventPrice() {
		return eventPrice;
	}
	public void setEventPrice(int eventPrice) {
		this.eventPrice = eventPrice;
	}
	public int getBenefit() {
		return benefit;
	}
	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}
	
	// 일일정산 기록 출력
	public void printList() {
		System.out.println("====================");
		System.out.println("영업일 "+ day + "일자 일일정산");
		System.out.println("총 판매량	: " + salesProduct);
		System.out.println("매출	: " + saveSales);
		System.out.println("영업비용	: " + eventPrice);
		System.out.println("수익율	: 약 " + benefit +"%");
		System.out.println("정산 후 자본금: " + saveSeedMoney);
	}
	
	public ProductList (int day , int salesProduct , int saveSales
			, int eventPrice , int benefit , int saveSeedMoney) {
		this.day = day;
		this.salesProduct = salesProduct;
		this.saveSales = saveSales;
		this.eventPrice =  eventPrice;
		this.benefit = benefit;
		this.saveSeedMoney = saveSeedMoney;
	}
	
}
