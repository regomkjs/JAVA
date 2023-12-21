package day10;

public class StringEx1 {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str3 == str2);
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str1.equals(str3));
		
	}

}
