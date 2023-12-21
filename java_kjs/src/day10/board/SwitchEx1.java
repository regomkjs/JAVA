package day10.board;

public class SwitchEx1 {

	public static void main(String[] args) {
		// switch문 안에 지역 변수를 선언하는 경우 발생할 수 있는 문제점
		
		for(int i = 0; i<5; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i = 0; i<5; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i = 0; i<5; i++) {
			System.out.print(i + " ");
		}
		
		int menu = 2; 
		
		switch(menu) {
		case 1:
			/* 여기서 선언된 num이 break문이 없으면 case 2까지 
			 * 갈수있기때문에 여기서 선언된 num은 이후 switch
			 * 
			 * */
			break;
		case 2:
			
			break;
		case 3:
	
			break;

		
		}
		
		
	}

}
