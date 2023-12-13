package day04;

public class StarEx2 {

	public static void main(String[] args) {
		/* *
		 * **
		 * ***
		 * ****
		 * *****
		 */
		
		int round;
		int time;
		
		for (round = 1 ; round <= 10 ; round++ ) {
			for (time = 1  ; time <= round ; time++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
