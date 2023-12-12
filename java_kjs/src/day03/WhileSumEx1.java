package day03;

public class WhileSumEx1 {

	public static void main(String[] args) {
		// 최소값부터 최대값까지 정수의 합을 구하는 코드를 작성하라

		int sum = 0;
		 
		int min_num = 1;
		int max_num = 50;

		while (min_num <= max_num) {
			sum += min_num;
			min_num++;
		}
		System.out.println(sum);
		
	}

}
