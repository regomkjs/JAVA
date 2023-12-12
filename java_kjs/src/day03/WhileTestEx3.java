package day03;

public class WhileTestEx3 {

	public static void main(String[] args) {
		// 1에서 10 사이의 모든 짝수를 순서대로 출력하는 코드를 작성하라
		
		// 1
		int num = 1;
		while(num <= 10) {
			if(num % 2 == 0) {
				System.out.println(num);
			}
				num++;
		}
		System.out.println("============");
		
		// 2
		int num2 = 2;
		while(num2 <= 10) {
			System.out.println(num2);
			num2+=2;
		}
		System.out.println("============");
		
		// 3
		int num3 = 1;
		while(num3 <= 5) {
				System.out.println(num3*2);
			num3++;
		}
		
	}

}
