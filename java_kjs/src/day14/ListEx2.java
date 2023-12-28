package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx2 {

	public static void main(String[] args) {
		// 정수를 5개 입력받아 입력받은 정수를 리스트에 저장하고 출력하는 코드를 작성.
		// 정수 여러개를 저장하기 위해 ArrayList 인스턴스를 생성
		// Integer가 오는 이유 : 제네릭은 클래스만 올 수 있음
		ArrayList<Integer> list = new ArrayList<Integer> (); 
		// 콘솔창에서 입력받아야 하기 떄문에 표준 입력인 System.in 인스턴스를 전달
		Scanner scan = new Scanner(System.in);  // 스캐너
		
		int num; // 차례대로 스캔받을 정수
		int count = 0; // 리스트의 번지수 기억
		// System에 있는 out 인스턴스에서 제공하는 print 메서드를 이용하여 콘솔창에 문자열을 출력
		System.out.print("저장할 정수 5개를 입력 해 주세요 : "); // 입력 안내문구 출력
		
		for(int i = 0 ; i< 5; i++) { // 5번 반복
			// scan.nextInt()를 통해 입력 버퍼에 있는 값 중 정수 값을 가져옴
			// 만약 입력 버퍼에 정수가 아닌 문자나 문자열이 있으면 예외가 발생
			num = scan.nextInt(); // 정수 스캔
			// Collection에서 제공하는 add 메서드를 이용하여 리스트에 정수값을 추가
			// int인 num이 Integer로 박싱이 되면서 리스트에 추가
			list.add(num); // 리스트에 저장
			count++; // 저장된 정수 개수 기억
		}
		System.out.print("저장된 정수 : "); // 출력 안내문구 출력
		
		
		// 가져온 Integer 인스턴스를 int형으로 언박싱을 함
		for(int i = 0 ; i < count ; i++) { // 저장된 정수 만큼 반복
			System.out.print(list.get(i)+" "); // 리스트 0번지부터 저장된 모든 정수 순서대로 출력
		}
		
	}

}
