package day05;

import java.util.Scanner;

public class CountEx1 {

	public static void main(String[] args) {
		/* 1에서 9사이의 정수 5개를 입력받아 
		 * 각 숫자가 몇개씩 입력됐는지 출력하는 코드를 작성하세요*/
		Scanner scan = new Scanner(System.in);
		// 입력받을 정수의 개수
		int round = 5;
		// 1 ~ 9 사이의 정수들이 몇번 입력됐는지 저장할 배열
		int count[] = new int[9];
		// 입력받은 정수를 저장할 배열
		int input []= new int[round];
		// 입력 안내 문구 출력
		System.out.println("1에서 9사이의 정수 "+ round + "개를 입력해주세요");
		System.out.print("입력 : ");
		/* 선생님 답안
		
		for(int i = 0 ; i < input.length; i++) {
			input[i] =scan.nextInt();
			count[input[i]-1]++;
		}
		*/
		// 입력받은 정수 5개를 배열
		for (int i = 0 ; i < round ; i++) {
			input[i] = scan.nextInt();
		}
		// 정수 배열에 저장된 각 정수가 몇번 입력 됐는지 카운트
		for (int i = 0; i < round; i++) {
			switch(input[i]) {
			case 1:
				count[0]++;
				break;
			case 2:
				count[1]++;
				break;	
			case 3:
				count[2]++;
				break;	
			case 4:
				count[3]++;
				break;	
			case 5:
				count[4]++;
				break;	
			case 6:
				count[5]++;
				break;	
			case 7:
				count[6]++;
				break;	
			case 8:
				count[7]++;
				break;	
			case 9:
				count[8]++;
				break;	
			}
		}
		for (int i = 0 ; i < count.length; i++) {
			System.out.println((i+1)+" : "+count[i]);
		}
		scan.close();
	}

}
