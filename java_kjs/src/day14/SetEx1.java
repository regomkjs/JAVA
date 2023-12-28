package day14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class SetEx1 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		
		int min = 1, max = 9 ;
		
		while(set.size() < 3) {
			Random random = new Random();
			int tmp = random.nextInt(max - min + 1) + min;
			set.add(tmp);
		}
		System.out.println(set);
		
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {
			int tmp = it.next();
			System.out.println(tmp+ " ");
		}
	}

}
