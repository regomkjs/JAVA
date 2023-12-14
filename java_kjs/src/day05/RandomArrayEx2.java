package day05;

public class RandomArrayEx2 {

	public static void main(String[] args) {
		/* 1~9사이의 중복되지 않은 랜덤한 수 3개를 저장하는 예제
		 */
		
		int min = 1;
		int max = 9;
		
		int arr[]= new int[3];
		
		int count = 0;
		
		while( count < 3 ) {
			int r = (int)(Math.random()*(max-min+1)+min);
			boolean duplicated = false; // 중복 여부를 알려주는 변수, true면 중복, false면 중복이 아니다.
			for(int i = 0 ; i < count; i++) {
				if (arr[i] == r ) {
					duplicated = true;
					break;
				}
			}
			if (!duplicated) {
				arr[count] = r; 
				count++;
			}
		}
		for(int i= 0 ; i < arr.length ; i++ ) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
