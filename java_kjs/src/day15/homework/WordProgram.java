package day15.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/* 1월 4일 목 스터디 
 * 퀴즈 정리와 오답노트 파일 연동(오답노트 정리) 
 * 조회와 출력에 람다와 투스트링을 활용 (객체지향적 수정)
 * */


public class WordProgram implements Program {
	private List<Integer> quizList = new ArrayList<Integer>();
	// 스캐너
	Scanner scan = new Scanner(System.in);
	// 단어장 저장 파일
	String fileName = "src/day15/homework/wm.wordList.txt";
	// 단어,오답 리스트
	WordManager wm = new WordManager();
	// EXIT
	final int EXIT = 5;
	// 메인 실행
	@Override
	public void run() {
		int menu =0;
		
		loadList();
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}
			catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}
		while (menu != EXIT);
		saveList();
	}
	
	// 단어장 불러오기
	private void loadList() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			wm = (WordManager) ois.readObject();
		} catch (Exception e) {
			System.out.println("단어장 파일이 없거나 불러오기에 실패했습니다.");
		}
	}
		
		
	// 단어장 저장하기	
	private void saveList() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(wm);
			System.out.println("단어장이 저장되었습니다.");
		} catch (IOException e) {
			System.out.println("단어장 저장 중 오류가 발생했습니다.");
		}
	}
	// 메뉴 츌력
	@Override
	public void printMenu() {
		System.out.println("===영어 단어장===");
		System.out.println("1. 영단어 관리");
		System.out.println("2. 영단어 뜻 관리");
		System.out.println("3. 영단어 조회");
		System.out.println("4. 영단어 퀴즈");
		System.out.println("5. 종료");
		System.out.println("=============");
		System.out.print("메뉴 입력 : ");
	}
	// 메뉴 실행 
	@Override
	public void runMenu(int menu) {
		int submenu;
		switch(menu) {
		case 1: 
			printWordMenu();
			submenu = scan.nextInt();
			runWordMenu(submenu);
			break;
		case 2: 
			if(wm.wordList.size() == 0) {
				System.out.println("아직 등록된 단어가 없습니다.");
				return;
			}
			printMeanMenu();
			submenu = scan.nextInt();
			runMeanMenu(submenu);
			break;
		case 3: 
			if(wm.wordList.size() == 0) {
				System.out.println("아직 등록된 단어가 없습니다.");
				return;
			}
			printSearchMenu();
			submenu = scan.nextInt();
			runSearchMenu(submenu);
			break;
		case 4:
			wordQuiz();
			break;
		case 5:
			System.out.println("프로그램 종료");
			break;
		default:
			throw new InputMismatchException();
		}
	}



	

	// 단어 메뉴
	private void printWordMenu() {
		System.out.println("===영단어 관리===");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("=============");
		System.out.print("메뉴 입력 : ");
	}

	private void runWordMenu(int submenu) {
		switch(submenu) {
		case 1:
			insertWord();
			break;
		case 2: 
			updateWord();
			break;
		case 3: 
			deleteWord();
			break;
		default:
			throw new InputMismatchException();
		}
		
	}

	/* 단어 기능 */ 
	// 단어 추가
	private void insertWord() {
		List<Means> means = new ArrayList<Means>();
		System.out.print("추가할 단어 : ");
		String word = scan.next();
		scan.nextLine();
		System.out.print(word+" 뜻 : ");
		String tmpMean = scan.nextLine();
		System.out.print(word+" 품사 : ");
		String tmpClass = scan.next(); 
		if(wm.insert(word, tmpMean, tmpClass)) {
			System.out.println(word+" 단어가 추가되었습니다.");
			return;
		}
		System.out.println("이미 등록된 단어입니다.");
		
	}
	// 단어 수정
	private void updateWord() {
		int index = -1;
		Word tmpWord = new Word(null);
		if(wm.wordList.size() == 0) {
			System.out.println("아직 등록된 단어가 없습니다.");
			return;
		}
		System.out.print("수정할 단어 : ");
		String word = scan.next();
		tmpWord.setWord(word);
		if(wm.wordList.contains(tmpWord)) {
			index = wm.wordList.indexOf(tmpWord);
		}
		else {
			System.out.println("등록 되지 않은 단어입니다.");
			return;
		}
		System.out.print(word + " 수정 : ");
		word = scan.next();
		wm.wordList.get(index).setWord(word);
		System.out.println(wm.wordList.get(index).toString());
	}
	// 단어 삭제
	private void deleteWord() {
		if(wm.wordList.size() == 0) {
			System.out.println("아직 등록된 단어가 없습니다.");
			return;
		}
		System.out.print("삭제할 단어 : ");
		String word = scan.next();
		if(wm.delete(word)) {
			System.out.println(word+" 단어가 삭제되었습니다.");
			return;
		}
		System.out.println("단어장에 등록 되지 않은 단어입니다.");
	}

	
	// 뜻 메뉴
	private void printMeanMenu() {
		System.out.println("===단어 뜻 관리===");
		System.out.println("1. 뜻 추가");
		System.out.println("2. 뜻 수정");
		System.out.println("3. 뜻 삭제");
		System.out.println("=============");
		System.out.print("메뉴 입력 : ");
		
	}
	
	private void runMeanMenu(int submenu) {
		switch(submenu) {
		case 1:
			insertMean();
			break;
		case 2: 
			updateMean();
			break;
		case 3: 
			deleteMean();
			break;
		default:
			throw new InputMismatchException();
		}
		
	}

	/* 뜻 기능 */ 
	// 뜻 추가
	private void insertMean() {
		int index = -1;
		System.out.print("뜻 추가할 단어 : ");
		String word = scan.next();
		Word tmpWord = new Word(word);
		if(!wm.wordList.contains(tmpWord)) {
			System.out.println("등록 되지 않은 단어입니다.");
			return;
		}
		else {
			index = wm.wordList.indexOf(tmpWord);
		}
		wm.wordList.get(index).printW();
		
		scan.nextLine();
		System.out.print("추가할 뜻 : ");
		String mean = scan.nextLine();
		System.out.print("추가할 뜻 품사 : ");
		String wordClass = scan.next();
		Means tmpMean = new Means(wordClass, mean);
		wm.wordList.get(index).mean.add(tmpMean);
		wm.sortMean();
		System.out.println(wm.wordList.get(index).toString());
	}
	// 뜻 수정
	private void updateMean() {
		int index = -1;
		System.out.print("뜻 수정할 단어 : ");
		String word = scan.next();
		Word tmpWord = new Word(word);
		if(!wm.wordList.contains(tmpWord)) {
			System.out.println("등록 되지 않은 단어입니다.");
			return;
		}
		else {
			index = wm.wordList.indexOf(tmpWord);
		}
		wm.wordList.get(index).printWordNum();
		System.out.print("수정할 뜻 번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		System.out.print("뜻 수정 : ");
		String mean = scan.nextLine();
		System.out.print("수정된 뜻 품사 : ");
		String wordClass = scan.next();
		wm.wordList.get(index).mean.remove(num-1);
		Means tmpMean = new Means(wordClass, mean);
		wm.wordList.get(index).mean.add(tmpMean);
		System.out.println(wm.wordList.get(index).toString());
	}
	// 뜻 삭제
	private void deleteMean() {
		int index = -1;
		System.out.print("뜻 삭제할 단어 : ");
		String word = scan.next();
		Word tmpWord = new Word(word);
		if(!wm.wordList.contains(tmpWord)) {
			System.out.println("등록 되지 않은 단어입니다.");
			return;
		}
		else {
			index = wm.wordList.indexOf(tmpWord);
		}
		wm.wordList.get(index).printWordNum();
		System.out.print("삭제할 뜻 번호 : ");
		int num = scan.nextInt();
		wm.wordList.get(index).mean.remove(num-1);
		System.out.println(wm.wordList.get(index).toString());
	}
	
	
	
	// 조회 메뉴
	private void printSearchMenu() {
		System.out.println("===단어 조회===");
		System.out.println("1. 전체 단어");
		System.out.println("2. 단어 검색");
		System.out.println("3. 뜻 검색");
		System.out.println("4. 품사 검색");
		System.out.println("5. 첫 스펠링 검색");
		System.out.println("6. 오답 노트");
		System.out.println("=============");
		System.out.print("메뉴 입력 : ");
	}

	private void runSearchMenu(int submenu) {
		switch(submenu) {
		case 1:
			searchAll();
			break;
		case 2: 
			searchWord();
			break;
		case 3: 
			searchMean();
			break;
		case 4: 	
			searchWordClass();
			break;
		case 5: 	
			searchFirstSpell();
			break;
		case 6: 	
			searchFailList();
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	
	

	
	
	/* 조회 기능 */ 
	// 전체 단어
	private void searchAll() {
		System.out.println("===전체 단어===");
		wm.wordList.stream().forEach(w-> w.printW());
	}
	// 단어 검색
	private void searchWord() {
		System.out.println("===단어 검색===");
		System.out.print("검색할 단어 : "); 
		String word = scan.next();
		wm.getWordList().forEach(w->{
			if(w.getWord().contains(word)) {
				w.printW();
			}
		});
	}
	// 뜻 검색
	private void searchMean() {
		System.out.println("====뜻 검색====");
		scan.nextLine();
		System.out.print("검색할 뜻 : "); 
		String mean = scan.nextLine();
		Means means = new Means("", mean);
		wm.getWordList().forEach(w -> {
			if(w.mean.contains(means)) {
				w.printW();
			}
		});
	}
	
	// 첫 스펠링 검색
	private void searchFirstSpell() {
		System.out.println("=첫 알파벳으로 검색=");
		System.out.print("검색할 알파벳 : ");
		char ch = scan.next().charAt(0);
		wm.getWordList().forEach(s-> {
			if(s.getWord().charAt(0) == ch ) {
				s.printW();
			}
		});
	}
	
	// 품사 검색
	private void searchWordClass() {
		System.out.println("===품사 검색===");
		System.out.print("검색할 품사 : ");
		String wordClass = scan.next();
		wm.getWordList().forEach(s-> s.getMean().forEach(m -> {
			if(m.getWordClass().contains(wordClass)) {
				s.printW();
			}
		}));
	}
	
	// 오답노트 조회
	private void searchFailList() {
		if(wm.failList.size() != 0) {
			wm.sortFailList();
			System.out.println("===오답 노트===");
			wm.failList.stream().forEach(w->w.printW());
			return;
		}
		System.out.println("오답노트가 비어있습니다.");
	}

	
	
	
	// 단어 반복 퀴즈
	public void wordQuiz() {
		scan.nextLine();
		String user;
		System.out.println("단어 퀴즈(나가기 입력시 메뉴로)");
		if(wm.wordList.size() == 0) {
			System.out.println("아직 등록된 단어가 없습니다.");
			return;
		}
		for (int i=0; i<wm.wordList.size();i++) {
			quizList.add(i);
		}
		do {
			if (quizList.size()==0) {
				return;
			}
			int min1 =0, max1 = quizList.size()-1;	// 최대값을 do while문 안으로 넣어 변경되게 수정
			// System.out.println(quizList); // 퀴즈 확인용 
			int r1 = (int)(Math.random()*(max1-min1+1)+min1);
			int r2 = quizList.remove(r1);
			List<Means> answer= wm.wordList.get(r2).getMean();
			String quiz = wm.wordList.get(r2).getWord();
			System.out.println("문제 : "+quiz);
			System.out.print("뜻을 입력하세요 : ");
			user = scan.nextLine();
			Means tmpMean = new Means("", user);
			if (answer.contains(tmpMean)) {
				System.out.println("정답입니다.");
			}
			else if(user.equals("나가기")) {
				break;
			}
			else {
				System.out.println("틀렸습니다.");
				if(!wm.failList.contains(wm.wordList.get(r2))) {
					wm.failList.add(wm.wordList.get(r2));
					wm.sortFailList();
				}
			}
			
		}while(!user.equals("종료"));
	}
	
}
