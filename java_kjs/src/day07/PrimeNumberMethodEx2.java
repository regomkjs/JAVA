package day07;

public class PrimeNumberMethodEx2 {

	public static void main(String[] args) {
		// 1~ 100 사이의 소수를 출력하는 코드를 작성하라
		for (int i=1 ; i <=100; i++) {
			if (isPrimeNumber(i) == true) {
				System.out.print(i+" ");
			}
		}
		
		System.out.println();
		
		for (int i=1 ; i <=100; i++) {
			if (isPrimeNumber2(i) == true) {
				System.out.print(i+" ");
			}
		}
	}
	
	
	
	public static boolean isPrimeNumber(int num) {
		boolean primeNum = false;
		int count = 0;
		for(int i = 1 ; i <= num ; i ++) {
			if (isDivisor(num,i)) {
				count++;
			}
		}
		if (count == 2) {
			primeNum = true;
		}
		return primeNum;
	}
	public static boolean isDivisor(int num1 , int num2) {
		return num1 % num2 == 0;
	}
	
	
	
	
	public static boolean isPrimeNumber2(int num) {
		
		for(int i = 2 ; i <num; i++ ) {
			if(num % i == 0) {
				return false;
			}
		}
		return num != 1;
	}
	
	
	
	
}
