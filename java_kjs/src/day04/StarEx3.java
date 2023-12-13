package day04;

public class StarEx3 {

	public static void main(String[] args) {
		/*     *
		 *    **
		 *   ***
		 *  ****
		 * *****     
		 */
		
		int round;
		int time;

		for (round = 1 ; round <= 5 ; round++ ) {
			for(time = 1 ; time <= 5 ; time++) {
				if (round <= 5 - time) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		/* int rows = 5;
		 * for(int i = 1; i <= rows; i++) {
		 * 		for(int j = 1 ; j <= rows - i ; j++) {
		 * 			System.out.print(' ');
		 * 		}
		 * 		for(int j = 1 ; j <= i ; j++) {
		 * 			System.out.print("*");
		 * 		}
		 * 		System.out.println();
		 * }
		 */
		
		
		
		
		
	}

}
