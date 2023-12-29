package day14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoEx1 {

	public static void main(String[] args) {
		/* 랜덤으로 당첨번호를 생성하고, 사용자가 로또 번호를 입력하면 등수를 알려주는 코드를 입력하세요
		 * 단, 컬렉션을 이용
		 * 당첨번호 : 6개, 보너스 : 1개
		 * 사용자 : 6개
		 */
		int min = 1 , max = 45;
		Scanner scan = new Scanner(System.in);

		Set <Integer> lottoBall = new HashSet<Integer>();
		ArrayList <Integer> lotto = new ArrayList<Integer>();
		Random random = new Random();
		int num;
		int arr[] = new int [6];
		
		for(; lottoBall.size() < 7 ;) {
			int tmp = random.nextInt(max - min + 1) + 1;
			lottoBall.add(tmp);
		}
		
		// addAll로 한방에 가능... 예제 2번 참조
		Iterator<Integer> it = lottoBall.iterator();
		while(it.hasNext()) {
			lotto.add(it.next());
		}
		// remove에는 추출 기능도 있다.
		int bonus = lotto.remove(6);
		
		
		lotto.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}});
		
		System.out.print("번호 6개 입력 : ");
		for(int i = 0 ; i < 6; i ++) {
			num = scan.nextInt();
			arr[i] = num;
		}
		
		System.out.print("당첨번호 : " + lotto);
		System.out.println(" 보너스 : " + bonus);
		
		int count = 0;
		boolean bh = false;
		for(int i = 0 ; i < 6; i++) {
			if(lotto.contains(arr[i])) {
				count++;
			}
			if(arr[i] == bonus) {
				bh = true;
			}
		}
		
		if(count < 3) {
			System.out.println("당첨되지 않았습니다.");
		}
		else if(count == 3) {
			System.out.println("5등 당첨입니다.");
		}
		else if(count == 4) {
			System.out.println("4등 당첨입니다.");
		}
		else if(count == 5 && bh == false) {
			System.out.println("3등 당첨입니다.");
		}
		else if(count == 5 && bh == true) {
			System.out.println("2등 당첨입니다.");
		}
		else if(count == 6) {
			System.out.println("1등 당첨입니다.");
		}
		
		
	}

}
