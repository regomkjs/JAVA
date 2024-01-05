package day19;

import java.util.ArrayList;
import java.util.List;

public class ListEx1 {

	public static void main(String[] args) {
		// 제네릭 인터페이스인 List의 타입을 지정하지 않았을 경우
		// 타입의 최상위 클래스인 Object가 자동으로 들어간다.
		// get()을 이용할 때 클래스 형변환을 해야한다
		List list = new ArrayList();
		list.add("abc");
		System.out.println((String)list.get(0));
		List<String> list2 = new ArrayList<String>();
		list2.add("abc");
		System.out.println(list2.get(0));
	}

}
