package day04;

public class StarEx4 {

	public static void main(String[] args) {
		/*      *    
		 *     ***
		 *    *****
		 *   *******
		 *  ********* 
		 */
		
		int rows = 10;
		
		int round;
		int time;
		
		for(round =1 ; round <= rows; round++) {
			for (time = 1 ; time <= rows - round; time++) {
				System.out.print(" ");
			}
			for (time = 1 ; time < round*2; time++) {
				System.out.print("*");
			}
			for (time = 1 ; time <= rows - round; time++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println("==========================");
		
		for(round =1; round <= rows ; round++) {
			for (time = 1 ; time <= rows - round; time++) {
				System.out.print(" ");
			}
			for (time = 1 ; time <= round; time++) {
				System.out.print("*");
			}
			for (time = 1 ; time <= round; time++) {
				if(time == 1) {
					continue;
				}
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("==========================");
		
		for(round =1; round <= rows ; round++) {
			for (time = 1 ; time <= rows - round; time++) {
				System.out.print(" ");
			}
			for (time = 1 ; time <= round; time++) {
				System.out.print("*");
			}
			for (time = 1 ; time <= round-1; time++) {
				System.out.print("*");
			}
			System.out.println();
		}


	}

}
