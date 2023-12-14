package day05;

import java.util.Scanner;

public class ReverseNumberEx1 {

	public static void main(String[] args) {
		/* 정수를 입력받아 입력받은 정수를 거꾸로 출력하는 코드를 작성하세요.
		 */
		
		Scanner scan = new Scanner(System.in);
		// 입력받을 정수
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		// 정수를 역으로 저장할 배열
		int r_num [] = new int[10];
		// 임시 저장 변수
		int tmp;
		// 몇자리인지 확인할 카운트
		int count = 0;
		
		/* 
		tmp = num; 
		while(tmp != 0) {
			r_num[count++] = tmp % 10;	// r_num[count] = tmp % 10; 
			 							// count++;
		 	tmp /= 10  // tmp = tmp / 10;
		 	
		 	
		 */
		
		do {
			for(int i = 0; i < r_num.length; i++) {
				tmp = num;
				r_num[i] = tmp % 10;
				count++;
				num = tmp/10;
				if(num == 0) {
					break;
				}
			}
		}
		while(num!=0);
		
		for(int i = 0; i < count; i++) {
			if (i == count) {
				break;
			}
			for(i = 0; i < count; i++) {
				System.out.print(r_num[i]);
			}
		}
		scan.close();
	}

}
