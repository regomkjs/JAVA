package day13;

public class StringEx1 {

	public static void main(String[] args) {
		String str = "abcde";
		
		System.out.println("1.-----------");
		// 0번지에 있는 문자를 반환
		System.out.println(str.charAt(0));
		// 두 문자열이 같은지를 반환
		System.out.println(str.equals("abc"));
		System.out.println(str.equals("abcde"));
		

		System.out.println("2.-----------");
		// 있으면 시작번지를 반환
		System.out.println(str.indexOf("cd"));
		// 없으면 -1을 반환
		System.out.println(str.indexOf("f"));
		// 있으면 true, 없으면 false를 반환
		System.out.println(str.contains("bc"));
		

		System.out.println("3.-----------");
		// 문자열의 길이를 반환
		System.out.println(str.length());
		

		System.out.println("4.-----------");
		// 문자열을 바꿔서 새 문자열을 반환
		String str2 = str.replace("cd", "aa");
		// 기존 문자열은 안 바뀜
		System.out.println(str);
		System.out.println(str2);
		

		System.out.println("5.-----------");
		// 부분 문자열을 반환
		String str3 = str.substring(1);
		System.out.println(str);
		System.out.println(str3);
		// 1번지부터 4번지 앞(=문자열 3번지)까지 부분 반환
		String str4 = str.substring(1, 4);
		System.out.println(str4);
		

		System.out.println("6.-----------");
		// 소문자를 전부 대문자로
		String str5 = str.toUpperCase();
		System.out.println(str5);
		// 대문자를 전부 소문자로
		String str6 = str5.toLowerCase();
		System.out.println(str6);
		

		System.out.println("7.-----------");
		String str7 = "\n\nabc\tdef\t\t";
		System.out.println(str7);
		// 시작문자 앞의 공백, 마지막 문자 뒤의 공백을 모두 제거
		String str8 = str7.trim();
		System.out.println(str8);
		
		System.out.println("8.-----------");
		String fruits = "사과,배,오렌지";
		String []fruitArray = fruits.split(",");
		System.out.println(fruits);
		for(String tmp: fruitArray) {
			System.out.println(tmp);
		}
		
	}

}
