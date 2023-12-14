package self;

import java.util.Arrays;
import java.util.Scanner;

public class SelfTestDay05 {

	public static void main(String[] args) {
		
		// 랜덤으로 정수 5개를 생성하여 배열에 저장하고 이 배열을 버블정렬로 내림차순하는 코드를 작성하여라
		
		
		
		
		// 자동생성된 번호와 정해진 로또 추첨번호와 비교
		Scanner scan = new Scanner(System.in);
		
		
		int min = 1;
		int max = 45;
		
		int arr1[]= new int[6];
		int arr2[]= new int[6];
		
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		
		while( count1 < 6 ) {
			int r1 = (int)(Math.random()*(max-min+1)+min);
			boolean duplicated1 = false;
			for(int i = 0 ; i < count1; i++) {
				if (arr1[i] == r1 ) {
					duplicated1 = true;
					break;
				}
			}
			if (!duplicated1) {
				arr1[count1] = r1; 
				count1++;
			}
		}
		
		Arrays.sort(arr1);
		
		System.out.print("자동 생성된 번호 : ");
		for (int i =0 ; i < arr1.length ; i++ ) {
			System.out.print( arr1[i] +" ");
		}
		
		System.out.println();
			
		int menu;
		
		do {
			System.out.println(" 메뉴 ");
			System.out.println(" 메뉴 ");
			System.out.println(" 메뉴 ");
			System.out.println(" 메뉴 ");
			menu = scan.nextInt();
			switch(menu) {
			
			case 1:
			
			/* 시도할때마다 바뀔 내 번호
			while( count2 < 6 ) {
				int r2 = (int)(Math.random()*(max-min+1)+min);
				boolean duplicated2 = false;
				for(int i = 0 ; i < count2; i++) {
					if (arr2[i] == r2 ) {
						duplicated2 = true;
						break;
					}
				}
				if (!duplicated2) {
					arr2[count2] = r2; 
					count2++;
				}
			}
			
			Arrays.sort(arr2);
			
			System.out.print("자동 생성된 번호 : ");
			for (int i =0 ; i < arr2.length ; i++ ) {
				System.out.print( arr2[i] +" ");
			}
			*/
			}
		}
		while(menu != 3);
		
	}

}
