package day10.word;

import java.util.Scanner;

public class WordMain {

	/* 영어 단어장 프로그램을 만드세요
	 * 
	 * 1. 기능 정리
	 * 제한 사항
	 * - 단어는 영어 단어와 한글 뜻으로 구성
	 * - 영어 단어는 영어이고, 공백이 없음
	 * - 한글 뜻은 한글이고, 한 문장으로 되어있음
	 * - 한 단어에 뜻이 한개만 있다고 가정
	 *  기능
	 *  - 단어 검색
	 *  - 단어 등록
	 *  - 단어 수정
	 *  - 단어 삭제
	 *  - 단어장 종료
	 */
	
	// 2. 틀 작성
	
	static Scanner scan = new Scanner(System.in);
	private static Word wordList[] = new Word [5];
	private static int count = 0 ;
	
	// 메인
	public static void main(String[] args) {
		int mainMenu;
		do {
			// 메인메뉴 출력
			printMainMenu();
			mainMenu = scan.nextInt();
			// 메인메뉴 실행
			runMainMenu(mainMenu);
		}
		while(mainMenu != 6);
	}
	
	// 메인메뉴 출력
	public static void printMainMenu() {
		System.out.println("----메뉴----");
		System.out.println("1. 단어 검색");
		System.out.println("2. 단어 등록");
		System.out.println("3. 단어 수정");
		System.out.println("4. 단어 삭제");
		System.out.println("5. 단어 퀴즈");
		System.out.println("6. 단어장 종료");
		System.out.println("-----------");
		System.out.print("메뉴 선택 : ");
		
	}
	
	// 메인메뉴 실행
	public static void runMainMenu(int mainMenu) {
		System.out.println("-----------");
		switch(mainMenu) {
		case 1: 
			// 단어 검색
			runSearchWord();
			break;
		case 2: 
			// 단어 등록
			runNewWord();
			break;
		case 3: 
			// 단어 수정
			runUpdateWord();
			break;
		case 4: 
			// 단어 삭제
			runDelWord();
			break;
		case 5: 
			// 단어 퀴즈
			runWordQuiz();
			break;
		case 6: 
			// 단어장 종료
			System.out.println("단어장 종료");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	
	// 3. 필요한 메서드 구현
	
	// 단어 검색
	public static void runSearchWord() {
		if(count == 0) {
			System.out.println("아직 등록된 단어가 없습니다.");
			return;
		}
		scan.nextLine();  // 콘솔 클리어
		System.out.print("검색할 단어 입력 : ");
		String typeWord = scan.nextLine();
		for(int i =0 ; i < count; i++) {
			if(wordList[i].getWord().equals(typeWord)) {
				wordList[i].print(); // 단어와 뜻 출력
				return;
			}
		}
		System.out.println(typeWord+ "은(는) 등록되지 않은 단어입니다.");
	}

	// 단어 등록
	public static void runNewWord() {
		scan.nextLine(); // 콘솔 클리어
		System.out.print("등록할 단어 : ");
		String newWord = scan.nextLine();
		System.out.print(newWord +" 설명 : ");
		String wordMean = scan.nextLine();
		// 이미 등록된 단어 판별기
		for(int i = 0 ; i < count; i++) {
			if(wordList[i].getWord().equals(newWord)) {
				System.out.println(wordList[i].getWord() + "는(은) 이미 등록된 단어 입니다.");
				return;
			}
		}
		// word를 선언한뒤 wordList[count] = word; 로 간단하게 정리 가능하다. 
		// 이 경우 count++;을 코드 뒤쪽에 넣어줘야 한다.
		// 복잡하게 구성한 이유 : 처음 구상할 때 삭제한 뒤 재정렬할 것을 고려 안했기 때문
		count++;
		for(int i = 0; i < count ; i++ ) {
			if(wordList[i] == null) {
				Word word = new Word(newWord, wordMean);
				wordList[i] = word;
				///////////////////////////////////////
				if(count < wordList.length) {
					return;
				}
				Word tmpWordList[] = new Word [wordList.length +5];
				System.arraycopy(wordList, 0, tmpWordList, 0, wordList.length);
				wordList = tmpWordList;
			}
		}
	}
	
	// 단어 수정
	public static void runUpdateWord() {
		if(count == 0) {
			System.out.println("아직 등록된 단어가 없습니다.");
			return;
		}
		scan.nextLine();// 콘솔 클리어
		System.out.print("수정할 단어 입력 : ");
		String updateWord = scan.nextLine();
		for(int i=0; i < count ; i++) {
			if(wordList[i].getWord().equals(updateWord)) {
				System.out.print("뜻 수정 : ");
				String updateMean = scan.nextLine();
				wordList[i].setMean(updateMean);
				System.out.println(updateWord + "이(가) 수정되었습니다.");
				wordList[i].print(); // 단어와 뜻 출력
				return;
			}
		}
		System.out.println(updateWord+ "은(는) 등록되지 않은 단어입니다.");
	} 
	
	// 단어 삭제
	public static void runDelWord() {
		if(count == 0) {
			System.out.println("아직 등록된 단어가 없습니다.");
			return;
		}
		scan.nextLine();// 콘솔 클리어
		System.out.print("삭제할 단어 입력 : ");
		String delWord = scan.nextLine();
		// 계속해서 조건문 안으로 들어가는 코드는 지양해야 한다.
		for(int i = 0; i < count; i++) {
			if(wordList[i].getWord().equals(delWord)) {
				wordList[i] = null;
				for(int j = 0 ; j< count ; j++) {
					if(wordList[j] == null && wordList[j+1] != null) {
						wordList[j] = wordList[j+1];
						wordList[j+1] = null;
					}
				}
				count--;
				System.out.println(delWord + "이(가) 단어장에서 삭제되었습니다.");
				return;
			}
		}
		System.out.println(delWord+ "은(는) 등록되지 않은 단어입니다.");
	}
	
	// 단어 퀴즈
	public static void runWordQuiz() {
		scan.nextLine();
		String ans;
		int min = 1;
		int max = count;
		int r = (int)(Math.random()*(max-min+1) + min);
		if(count==0) {
			System.out.println("아직 단어를 등록하지 않았습니다.");
			return;
		}
		System.out.println("다음 내용을 보고 어떤 영단어인지 맞추어라.");
		System.out.println(wordList[r-1].getMean());
		System.out.print("답 : ");
		ans = scan.nextLine();
		if(wordList[r-1].getWord().equals(ans)) {
			System.out.println("정답입니다.");
			return;
		}
		System.out.println("오답입니다.");
	}
	
	
	
}





