package day03;

public class ForEx2 {

	public static void main(String[] args) {
		/* 1에서 10 사이에  짝수들의 합을 구하는 코드를 작성하라 */
		
		
		int sum = 0;
		int num;
		
		//1
		System.out.print("1번 : ");
		for (num = 2; num <= 10 ; num+=2 ) {
			sum += num;
		}
		System.out.println(sum);
		
		
		//2
		sum = 0;
		System.out.print("2번 : ");
		for (num = 1 ; num <=5 ; num+=1) {
			sum += num*2;
		}
		System.out.println(sum);
		
		//3 
		sum = 0;
		System.out.print("3번 : ");
		for (num = 1 ; num <= 10 ; num+=1) {
			if(num % 2 == 0) {
				sum += num;
			}
		}
		System.out.println(sum);
	}

}
