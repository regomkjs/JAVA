package day04;

public class PrimeNumberEx1 {

	public static void main(String[] args) {
		/* 2 부터 100사이의 모든 소수를 출력하는 코드를 작성하세요 */
		int max_num = 100;
		int num = 2;
		int i = 1;
		for (num = 2 ; num <= max_num ; num++) {
			int count = 0; // count를 반복문 안에 넣어 초기화 해주어야 한다.
			for (i = 1 ; i <= num; i++) {
				if (num % i == 0) {
					count++;
				}
			}
			if(count == 2) {
				System.out.print((num == 2 ?"" : ", ")+num);
			}
			
		}
		
	}

}
