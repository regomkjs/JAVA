package day06;

import java.util.Scanner;

public class AlphabetCountEx1 {

	public static void main(String[] args) {
		/* 단어를 입력받아 단어에 각 알파벳이 몇번 나왔는지 출력하는 코드
		 * 입력 : apple
		 * a : 1
		 * e : 1
		 * l : 1
		 * p : 2
		 * (char) 97 == 'a'
		 * */
		Scanner scan = new Scanner(System.in);
		int count [] = new int [26];
		System.out.print("단어를 입력 : ");
		String type = scan.next();
		
		for (int i = 0 ; i < type.length() ; i++) {
			/* 노가다성
			switch(type.charAt(i)) {
			case 'a':	count[0]++;		break;
			case 'b':	count[1]++;		break;
			case 'c':	count[2]++;		break;
			case 'd':	count[3]++;		break;
			case 'e':	count[4]++;		break;
			case 'f':	count[5]++;		break;
			case 'g':	count[6]++;		break;
			case 'h':	count[7]++;		break;
			case 'i':	count[8]++;		break;
			case 'j':	count[9]++;		break;
			case 'k':	count[10]++;	break;
			case 'l':	count[11]++;	break;
			case 'm':	count[12]++;	break;
			case 'n':	count[13]++;	break;
			case 'o':	count[14]++;	break;
			case 'p':	count[15]++;	break;
			case 'q':	count[16]++;	break;
			case 'r':	count[17]++;	break;
			case 's':	count[18]++;	break;
			case 't':	count[19]++;	break;
			case 'u':	count[20]++;	break;
			case 'v':	count[21]++;	break;
			case 'w':	count[22]++;	break;
			case 'x':	count[23]++;	break;
			case 'y':	count[24]++;	break;
			case 'z':	count[25]++;	break;
			}
			 */
			char ch = type.charAt(i); 		// 문자열을 굳이 배열에 저장할 필요 없음
			for (int j = 0; j < count.length ; j++) {
				if(ch == (char)(97+j)) {
					count[j]++;
				}
			}
		}
		for (int i = 0 ; i < count.length; i++)	{
			if(count[i] != 0) {
				System.out.println((char)(97+i) + " : " + count[i]);
			}
		}

		
		scan.close();
		
	}

}
