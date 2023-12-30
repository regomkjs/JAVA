package day15.homework;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class WordProgram implements Program {
	
	Scanner scan = new Scanner(System.in);
	List<Word> wordList = new ArrayList<Word>();
	// 메인 실행
	@Override
	public void run() {
		int menu =0;
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}
			catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
			}
		}
		while (menu != 4);
	}
	
	// 메뉴 츌력
	@Override
	public void printMenu() {
		System.out.println("===영어 단어장===");
		System.out.println("1. 영단어 관리");
		System.out.println("2. 영단어 뜻 관리");
		System.out.println("3. 영단어 조회");
		System.out.println("4. 종료");
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
			printMeanMenu();
			submenu = scan.nextInt();
			runMeanMenu(submenu);
			break;
		case 3: 
			break;
		case 4:
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

	// 단어 기능
	private void insertWord() {
		List<Means> means = new ArrayList<Means>();
		System.out.print("추가할 단어 : ");
		String word = scan.next();
		Word tmpWord = new Word(word);
		if(wordList.contains(tmpWord)) {
			System.out.println("이미 등록된 단어입니다.");
			return;
		}
		scan.nextLine();
		System.out.print(word+" 뜻 : ");
		String tmpMean = scan.nextLine();
		System.out.print(word+" 품사 : ");
		String tmpClass = scan.next(); 
		Means tmp = new Means(word, tmpClass, tmpMean);
		means.add(tmp);
		Word tmpword = new Word(word);
		tmpword.setMean(means);
		wordList.add(tmpword);
		tmpword.printWord();
	}

	private void updateWord() {
		int index = -1;
		Word tmpWord = new Word(null);
		if(wordList.size() == 0) {
			System.out.println("아직 등록된 단어가 없습니다.");
			return;
		}
		System.out.print("수정할 단어 : ");
		String word = scan.next();
		tmpWord.setWord(word);
		if(wordList.contains(tmpWord)) {
			index = wordList.indexOf(tmpWord);
		}
		else {
			System.out.println("등록 되지 않은 단어입니다.");
			return;
		}
		System.out.print(word + " 수정 : ");
		word = scan.next();
		wordList.get(index).setWord(word);
		wordList.get(index).printWord();
	}

	private void deleteWord() {
		int index = -1;
		Word tmpWord = new Word(null);
		if(wordList.size() == 0) {
			System.out.println("아직 등록된 단어가 없습니다.");
			return;
		}
		System.out.print("삭제할 단어 : ");
		String word = scan.next();
		tmpWord.setWord(word);
		if(wordList.contains(tmpWord)) {
			index = wordList.indexOf(tmpWord);
		}
		else {
			System.out.println("등록 되지 않은 단어입니다.");
			return;
		}
		System.out.print("삭제 되었습니다 : ");
		wordList.get(index).printWord();
		wordList.remove(index);
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

	
	private void insertMean() {
		int index = -1;
		System.out.print("뜻 추가할 단어 : ");
		String word = scan.next();
		Word tmpWord = new Word(word);
		if(!wordList.contains(tmpWord)) {
			System.out.println("등록 되지 않은 단어입니다.");
			return;
		}
		else {
			index = wordList.indexOf(tmpWord);
		}
		wordList.get(index).printWord();
		
		scan.nextLine();
		System.out.print("추가할 뜻 : ");
		String mean = scan.nextLine();
		System.out.print("추가할 뜻 품사 : ");
		String wordClass = scan.next();
		Means tmpMean = new Means(word, wordClass, mean);
		wordList.get(index).mean.add(tmpMean);
		wordList.get(index).printWord();
	}

	private void updateMean() {
		
	}

	private void deleteMean() {
		
	}
	
	
	
	
	
}
