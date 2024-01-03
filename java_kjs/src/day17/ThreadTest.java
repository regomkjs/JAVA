package day17;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.print("로딩 중");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println("완료");
	}

}


