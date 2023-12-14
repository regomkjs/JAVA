package day05;

import java.util.Arrays;

public class ArraySortEx1 {

	public static void main(String[] args) {
		// 배열 정렬 방법
		int arr1[] = new int[] {1,3,5,7,2,4,6,8};
		
		// 버블정렬
		/* 옆에 인접한 값들을 비교하여 정렬
		 * 1 3 5 7 2 4 6 8
		 * 1 3 5 2 4 6 7 [8]
		 * 1 3 2 4 5 6 [7 8]
		 * 1 2 3 4 5 [6 7 8]
		 * */
		for(int i = 0 ; i < arr1.length - 1 ; i++) {
			// 두 값을 묶어서 비교하기 때문에 반복 회수는 배열크기보다 한번 덜 발생한다 
			for(int j = 0 ; j < arr1.length - 1; j++) {
				// j번이 j+1번 보다 크면 자리변경 == 오름차순 (arr[j] > arr[j+1])
				// j번이 j+1번 보다 작으면 자리변경 == 내림차순 (arr[j] < arr[j+1])
				if (arr1[j] > arr1[j+1]) {
					// j 와 j+1의 값을 교환할때 잠시 j값을 저장해줄 tmp를 선언한다.
					int tmp = arr1[j];
					arr1[j] = arr1[j+1];
					arr1[j+1] = tmp;
				}
			}
		}
		for(int i = 0 ; i < arr1.length; i++ ) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		
		int arr2[] = {1,3,5,7,9,2,4,6,8};
		// 오름차순으로 정렬 (Quicksort로 정렬)
		Arrays.sort(arr2);
		
		for(int i = 0 ; i < arr2.length; i++ ) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		
	}

}
