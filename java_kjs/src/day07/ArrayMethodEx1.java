package day07;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayMethodEx1 {

	public static void main(String[] args) {
		// 1 ~ 45 사이의 중복되지 않은 랜덤한 수 6개를 입력하는 코드를 작성하라 (메서드를 이용해서)
		Scanner scan = new Scanner(System.in);
		
		int arr[] = new int [6];
		int min = 1, max = 45;
		if(createRandomArray(arr, min, max)) {
			System.out.println("배열 생성 성공");
			for(int tmp : arr) {
				System.out.print(tmp + " ");
			}
			System.out.println();
		}
		else {
			System.out.println("배열 생성 실패");
		}

		
		
		int [] user = new int [6];
		int count = 0;
		System.out.print("정수 6개 입력(중복 X, 1~45) : ");	
		while(count < user.length) {
			int num = scan.nextInt();
			if (!contains(user, count, num) && (num >= min && num <=max)) {
				user[count] = num;
				count++;
			}
		}
		
		
	}
	
	//
	public static boolean createRandomArray(int arr[] , int min, int max) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		if (max < min) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(max-min+1 < arr.length) {
			return false;
		}
		int count = 0;
		while(count < arr.length) {
			int r = random(min, max);
			if(!contains(arr, count, r)) {
				arr[count] = r;
				count++;
			}
		}
		return true;
	}
	
	// 
	public static boolean contains(int[] arr, int n, int num) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		if(arr.length < n) {
			n = arr.length;
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] == num) {
				return true;
			}
		}
		return false; 
	}
	
	// 랜덤변수
	public static int random(int min, int max) {
		if (max < min) {
			int tmp = max ;
			max = min;
			min = tmp;
		}
		int num = (int)(Math.random()*(max-min+1)+min);
		return num;
	}
	

}
