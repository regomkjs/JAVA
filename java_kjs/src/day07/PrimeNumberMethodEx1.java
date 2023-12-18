package day07;

public class PrimeNumberMethodEx1 {

	public static void main(String[] args) {
		// 주어진 num가 소수인지 아닌지 판별하는 코드를 작성하라 (메서드를 이용)
		
		/* 기능 : 
		 * 매개변수 : int num
		 * 리턴타입 : boolean
		 * 메서드명 : isPrimeNumber
		 * 
		 * 리턴타입 메서드명 (매개변수) {
		 * 		구현;
		 * 		return 값;
		 * }
		 */
		
		int num = 17;
		if(isPrimeNumber(num)) {
			System.out.println(num+"는 소수입니다");
		}
		else {
			System.out.println(num+"는 소수가 아닙니다");
		}
		
		if(isPrimeNumber2(num)) {
			System.out.println(num+"는 소수입니다");
		}
		else {
			System.out.println(num+"는 소수가 아닙니다");
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
