package day06;

public class ArrayExpandEx1 {

	public static void main(String[] args) {
		// 배열이 꽉 찼을 때 배열을 확장하는 예제
		int arr[] = new int[5];
		
		int count = 10;
		for(int i = 0 ; i < count ; i++) {
			if(i+1 > arr.length) {
				// arr의 길이보다 5 긴 임시 배열 생성 
				int tmp[] = new int[arr.length + 5];
				// 임시 배열에 기존 arr 값 복사
				System.arraycopy(arr, 0, tmp, 0, arr.length);
				// arr에 임시 배열을 대입
				arr = tmp;
			} 	// if문이 끝나면서 임시 배열 제거됨 
			
			// 기존 arr 길이가 5일때 들어가지 않던 값들이 이제는 들어감
			arr[i] = i+1;	
		}
		// 잘 들어갔는지 확인
		for(int tmp : arr) {
			System.out.println(tmp);
		}
	}

}
