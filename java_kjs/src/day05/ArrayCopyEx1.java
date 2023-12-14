package day05;

public class ArrayCopyEx1 {

	public static void main(String[] args) {
		// 배열 복사 예제
		int arr1 [] = new int[] {1,2,3,4,5};
		// arr2는 arr1과 주소를 공유할 뿐, 복사된 것이 아니다.
		int arr2 [] = arr1;
		
		int arr3 [] = new int[arr1.length];
		
		int arr4 [] = new int[arr1.length];
		
		
		// 반복문을 이용하여 arr1에 있는 값들을 arr3에 복사
		for(int i = 0; i < arr1.length ; i++) {
			arr3[i] = arr1[i];
		}

		// System.arraycopy를 이용하여 arr1을 arr4에 전체 복사
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		
		// arr1의 내용이 바뀌면 arr2도 같이 바뀜
		arr1[0] = 10;
		// arr2의 0번지 내용이 10(arr1[0])으로 출력되는걸 확인
		System.out.println("arr2");
		for(int i = 0; i < 5; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		// arr3과 arr4는 arr1를 공유하지 않고 온전히 복사되었다
		System.out.println("arr3");
		for(int i = 0; i < arr1.length ; i++) {
			System.out.print(arr3[i] + " ");
		}
		System.out.println("\narr4");
		for(int i = 0; i < arr1.length ; i++) {
			System.out.print(arr4[i] + " ");
		}
		
		int arr5[] = new int[arr1.length];
		// arr1배열에 1번지부터 2개를 복사해서 arr5배열 0번지부터 덮어씀
		System.arraycopy(arr1, 1, arr5, 0, 2);
		System.out.println("\narr5");
		for(int i = 0; i < arr1.length ; i++) {
			System.out.print(arr5[i] + " ");
		}
		
	}

}
