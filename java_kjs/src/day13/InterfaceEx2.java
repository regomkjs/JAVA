package day13;

public class InterfaceEx2 {

	// 인터페이스 이해를 위한 예제
	
	public static void main(String[] args) {
		print(new Product());
		print(new Student());
		
	}
	
	public static void print(Print p) {
		/*
		  if(obj instanceof Product) {
			
		}
		 */
		p.print();
		
	}
	
}

/*
class Obj {
	
}
class Product extends Obj{
	
}
class Student extends Obj{
	
}
*/

interface Print{
	void print();
}

class Product implements Print{
	String name = "TV";
	String code = "TV0123";
	@Override
	public void print() {
		System.out.println("제품명	: " + name);
		System.out.println("제품코드	: " + code);
	}
	
}

class Student implements Print{
	int grade = 1;
	int classNum = 1;
	int num = 1;
	String name = "김철수";
	@Override
	public void print() {
		System.out.println(grade + "학년 "+ classNum + "반 " + num + "번 " + name);
	}
	
}

