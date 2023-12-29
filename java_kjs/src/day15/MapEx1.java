package day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapEx1 {

	public static void main(String[] args) {
		// key, value 
		Map<String, String> map = new HashMap<String, String>(); 
		
		map.put("abc123", "abc123!");
		map.put("def456", "abc123!"); // value 중복 가능
		map.put("abc123", "qwe123!"); // key값이 중복되면 value 수정으로 입력된다.
		map.put("admin", "admin");
		map.put("def", "def");
		System.out.println(map.remove("abc123"));
		System.out.println(map);

		
		// keySet을 이용한 반복문 예제
		Set<String> keySet = map.keySet();
		System.out.println(keySet);
		for(String tmp: keySet) {
			String value = map.get(tmp);
			System.out.println("[" + tmp  + " , "+ value + "]");
		}
		
		// EntrySet을 이용한 반복문 예제
		// Map.Entry 는 내부 클래스이다.
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		for(Map.Entry<String, String> tmp : entrySet) {
			System.out.println("[" + tmp.getKey() + " , " + tmp.getValue() + "]");
		}
		
		// 내부 클래스의 인스턴스를 생성하는 예제
		A a = new A();
		A.B b = a.new B();
	}

}
// EntrySet의 예를 들면
class Entry1<K,V>{
	K key;
	V value;
}

// 내부 클래스 예제
class A{
	public class B{
		int num;
	}
}


