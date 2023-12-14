package day05;

import java.util.Arrays;
import java.util.Scanner;

public class LottoEx2 {

	public static void main(String[] args) {
		/* 로또 당첨 번호를 랜덤으로 생성한 후(당첨번호 6자리 + 보너스 번호) 
		 * 사용자가 로또번호를 입력하면(로또번호 6자리) 당첨등수를 출력하는 코드를 작성하세요*/
		
		// 7개 짜리 배열을 만들어 로또 당첨 번호를 랜덤으로 생성 - 1번 배열
		
		// 위에 생성한 배열 중 0번지부터 6개를 새로운 배열에 복사하여 저장 - 2번 배열
		
		// 1번 배열 6번지에 있는 값을 보너스숫자로 지정 - 보너스 번호 생성
		
		// 2번 배열 정렬 후 출력 후 보너스 출력
		
		// 사용자 번호를 입력해서 배열에 저장 - 3번 배열
		
		// 당첨 개수 확인 (이중 반복문)
		
		// 당첨 개수에 따른 등수를 출력
		Scanner scan = new Scanner(System.in);
		
		int min = 1;
		int max = 45;
		int tmp[] = new int[7]; // 서로 곂치지 않는 랜덤 변수 7개
		int lotto[] = new int[6]; // 그 중 앞에 나온 6개를 오름차순으로 배열
		int user[] = new int[6]; // 입력받아 당첨번호, 보너스와 곂치는지 비교할 번호 6개 
		int count = 0;
		int bonus;
		int b_corr = 0;
		int corr = 0;
	
		System.out.println("로또번호 6자리를 입력해 주세요. (예 : 1 2 3 4 5 6 )");
		System.out.print("입력 : ");
		for(int i = 0; i < user.length; i++) {
			int ans = scan.nextInt();
			user[i] = ans;
		}
		System.out.println("입력하신 번호");
		for(int i = 0; i < user.length; i++) {
			System.out.print(user[i] + " ");
		}
		System.out.println();
		while(count < 7) {
			int r = (int)(Math.random()*(max-min+1)+min);
			boolean duplicated = false;
			for(int i = 0; i < count; i++) {
				if (tmp[i] == r ) {
					duplicated = true;
					break;
				}
			}
			if (!duplicated) {
				tmp[count] = r; 
				count++;
			}
		}

		System.arraycopy(tmp, 0, lotto, 0, 6); // 정렬 전 랜덤 변수 7개 중  6개를 뽑아 당첨번호 배열에 넣는다 
		Arrays.sort(lotto); // 당첨번호 배열 오름차순
		bonus = tmp[6];  // 마지막 랜덤변수를 보너스로
		
		System.out.println("당첨 번호 6자리와 보너스");
		
		for (int i =0; i < lotto.length; i++) {
			System.out.print( lotto[i] +" ");
		}
		System.out.println("보너스 : " + bonus );
		
		// 당첨번호와 입력번호 확인
		for(int i = 0; i < lotto.length; i++) {
			
			for(int j = 0; j < user.length; j++) {
				
				if(user[i] == lotto[j]) {
					corr++;
					break; // 중복됐을때 카운트하지 않게끔
				}
			}
		}
		// 보너스와 입력번호 확인
		for(int i = 0; i < user.length; i++) {
			
			if(user[i] == bonus) {
				b_corr++;
			}
		}
		System.out.println("맞춘 번호의 개수 :" + corr);
		System.out.println("============================");
		// 선생님은 switch문을 이용했다
		if (corr == 3) {
			System.out.println(" 5등 당첨 ");
		}
		else if (corr == 4) {
			System.out.println(" 4등 당첨! ");
		}
		else if (corr == 5 && b_corr == 0) {
			System.out.println(" 3등 당첨!! ");
		}
		else if (corr == 5 && b_corr == 1) {
			System.out.println(" 2등 당첨입니다!! ");
		}
		else if (corr == 6) {
			System.out.println(" 1등 당첨입니다!!! ");
		}
		else {
			System.out.println("아쉽게도 꽝입니다.");
		}

		System.out.println("============================");
		System.out.println();
		
		scan.close();
	}

}
