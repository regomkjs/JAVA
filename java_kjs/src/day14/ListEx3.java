package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {

	public static void main(String[] args) {
		// 속담을 입력받아 저장하고, 출력하는 코드를 작성하세요
		// 입력받기위한 Scanner 클래스의 인스턴스 scan을 생성
		Scanner scan = new Scanner(System.in);
		
		// 저장된 속담의 개수 
		int count = 0;
		
		// 속담을 저장할 문자열 list 생성
		ArrayList<String> list = new ArrayList<String>();
		// 속담 입력 안내문구 출력
		System.out.println("저장할 속담을 입력하세요");
		System.out.print("입력 : ");
		// 입력받은 속담을 스트링 line에 덮어 쓴 뒤 list에 저장
		String line = scan.nextLine();
		list.add(line);
		// 저장된 속담 개수 증가
		count++;
		// 마지막으로 저장된 속담 출력
		System.out.println(list.get(count-1));
		
	}

}
