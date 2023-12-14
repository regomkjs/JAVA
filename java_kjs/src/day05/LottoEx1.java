package day05;

import java.util.Arrays;

public class LottoEx1 {

	public static void main(String[] args) {
		/* 1~45사이의 랜덤한 수 6개를 생성하여 출력하는 예제
		 * 단, 정렬이 되도록
		 * */
		

		int min = 1;
		int max = 45;
		
		int arr1[]= new int[6];
		
		int count = 0;
		
		while( count < 6 ) {
			int r = (int)(Math.random()*(max-min+1)+min);
			boolean duplicated = false;
			// 처음 반복문 실행시 count == 0 이기 때문에 아래 for문을 건너 뛰고 if문으로 간다
			for(int i = 0 ; i < count; i++) {
				if (arr1[i] == r ) {
					duplicated = true;
					break;
				}
			}
			if (!duplicated) {
				arr1[count] = r; 
				count++;
			}
		}
		
		Arrays.sort(arr1);
		
		System.out.print("자동 생성된 번호 : ");
		for (int i =0 ; i < arr1.length ; i++ ) {
			System.out.print( arr1[i] +" ");
		}
		
	}

}
