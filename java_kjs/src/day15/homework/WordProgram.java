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
	String fileName = "src/day15/homework/WordList.txt";
	// 단어 리스트
	List<Word> wordList = new ArrayList<Word>();
	// 오답 리스트
	List<Word> failList = new ArrayList<Word>();
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
		while (menu != 5);
		saveList();
		
	}
	
	// 단어장 불러오기
	private void loadList() {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			wordList = (ArrayList<Word>)ois.readObject();
		} catch (Exception e) {
			System.out.println("단어장 파일이 없거나 불러오기에 실패했습니다.");
		}
	}
		
		
	// 단어장 저장하기	
	private void saveList() {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(wordList);
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
			if(wordList.size() == 0) {
				System.out.println("아직 등록된 단어가 없습니다.");
				return;
			}
			printMeanMenu();
			submenu = scan.nextInt();
			runMeanMenu(submenu);
			break;
		case 3: 
			if(wordList.size() == 0) {
				System.out.println("아직 등록된 단어가 없습니다.");
				return;
			}
			printSearchMenu();
			submenu = scan.nextInt();
			runSearchMenu(submenu);
			break;
		case 4:
			printWordQuiz();
			submenu = scan.nextInt();
			runWordQuiz(submenu);
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
		Means tmp = new Means(tmpClass, tmpMean);
		means.add(tmp);
		// Word tmpword = new Word(word); // tmpword << 표기 오타 (tmpWord)
		tmpWord.setMean(means); // tmpWord 로 수정
		wordList.add(tmpWord); // tmpWord 로 수정
		tmpWord.printWord(); // tmpWord 로 수정
	}
	// 단어 수정
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
	// 단어 삭제
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

	/* 뜻 기능 */ 
	// 뜻 추가
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
		Means tmpMean = new Means(wordClass, mean);
		wordList.get(index).mean.add(tmpMean);
		wordList.get(index).printWord();
	}
	// 뜻 수정
	private void updateMean() {
		int index = -1;
		System.out.print("뜻 수정할 단어 : ");
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
		System.out.print("수정할 뜻 번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		System.out.print("뜻 수정 : ");
		String mean = scan.nextLine();
		System.out.print("수정된 뜻 품사 : ");
		String wordClass = scan.next();
		wordList.get(index).mean.remove(num-1);
		Means tmpMean = new Means(wordClass, mean);
		wordList.get(index).mean.add(tmpMean);
		wordList.get(index).printWord();
	}
	// 뜻 삭제
	private void deleteMean() {
		int index = -1;
		System.out.print("뜻 삭제할 단어 : ");
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
		System.out.print("삭제할 뜻 번호 : ");
		int num = scan.nextInt();
		wordList.get(index).mean.remove(num-1);
		wordList.get(index).printWord();
	}
	
	
	
	// 조회 메뉴
	private void printSearchMenu() {
		System.out.println("===단어 조회===");
		System.out.println("1. 전체 단어");
		System.out.println("2. 단어 검색");
		System.out.println("3. 뜻 검색");
		System.out.println("4. 품사 검색");
		System.out.println("5. 첫 스펠링 검색");
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
		default:
			throw new InputMismatchException();
		}
	}
	
	
	

	
	/* 조회 기능 */ 
	// 전체 단어
	private void searchAll() {
		System.out.println("===전체 단어===");
		for(Word tmp : wordList) {
			tmp.printWord();
		}
	}
	// 단어 검색
	private void searchWord() {
		int index = -1;
		System.out.println("===단어 검색===");
		System.out.print("검색할 단어 : "); 
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
	}
	// 뜻 검색
	private void searchMean() {
		System.out.println("====뜻 검색====");
		scan.nextLine();
		System.out.print("검색할 뜻 : "); 
		String mean = scan.nextLine();
		Means means = new Means("", mean);
		for(int i = 0 ; i < wordList.size(); i++) {
			if(wordList.get(i).mean.contains(means)) {
				wordList.get(i).printWord();
				return;
			}
		}
		System.out.println("등록 되지 않은 뜻입니다.");
	}
	
	// 첫 스펠링 검색
	private void searchFirstSpell() {
		System.out.println("=첫 알파벳으로 검색=");
		System.out.print("검색할 알파벳 : ");
		char ch = scan.next().charAt(0);
		boolean ok = false;
		for(int i = 0 ; i < wordList.size(); i++ ) {
			if(wordList.get(i).getWord().charAt(0) == ch ) {
				wordList.get(i).printWord();
				ok = true;
			}
		}
		if(!ok) {
			System.out.println(ch+"로 시작하는 단어가 등록되지 않았습니다.");
		}
		
	}
	
	// 품사 검색
	private void searchWordClass() {
		boolean ok = false;
		System.out.println("===품사 검색===");
		System.out.print("검색할 품사 : ");
		String wordClass = scan.next();
		for(int i = 0 ; i < wordList.size(); i++) {
			for(int j = 0 ; j < wordList.get(i).mean.size(); j++)
			if(wordList.get(i).mean.get(j).getWordClass().equals(wordClass)) {
				wordList.get(i).printWord();
				ok = true;
			}
		}
		if(!ok) {
			System.out.println(wordClass+"로 등록된 단어가 없습니다.");
		}
	}
	
	
	// 퀴즈 메뉴 출력
	private void printWordQuiz() {
		System.out.println("===단어 퀴즈===");
		System.out.println("1. 뜻 맞추기");
		System.out.println("2. 단어 맞추기");
		System.out.println("============");
		System.out.print("메뉴 입력 : ");
		
	}
	// 퀴즈 메뉴 실행
	private void runWordQuiz(int submenu) {
		
		switch(submenu) {
		case 1: meanQuiz(); break;
		case 2: wordQuiz(); break;
		default:
			throw new InputMismatchException();
		}
	}
	
	// 뜻 퀴즈 (반복, 안겹치게 수정 예정)
	private void meanQuiz() {
		if(wordList.size() == 0) {
			System.out.println("아직 등록된 단어가 없습니다.");
			return;
		}
		System.out.println("===뜻 퀴즈===");
		int min = 1 , max = wordList.size();
		int r = (int)(Math.random()*(max+min-1)+ min);
		max = wordList.get(r-1).mean.size();
		int s = (int)(Math.random()*(max+min-1)+ min);
		wordList.get(r-1).mean.get(s-1).toString();
		System.out.print(" : ");
		String word = scan.next();
		Word tmpWord = new Word(word);
		if(!wordList.get(r-1).equals(tmpWord)) {
			System.out.println("오답입니다.");
			if(failList.size() == 0) {
				failList.add(wordList.get(r-1));
			}
			else {
				for(int i = 0 ; i < failList.size(); i++) {
					if(failList.get(i).equals(wordList.get(r-1))) {
						failList.add(wordList.get(r-1));
					}
				}
			}
			return;
		}
		System.out.println("정답입니다.");
	}
	
	// 단어 반복 퀴즈
	public void wordQuiz() {
		if(wordList.size() == 0) {
			System.out.println("아직 등록된 단어가 없습니다.");
			return;
		}
		System.out.println("===단어 퀴즈===");
		for (int i=0; i<wordList.size();i++) {
			quizList.add(i);
		}
		String user="";
		do {
			if (quizList.size()==0) {
				return;
			}
			int min1 =0, max1 = quizList.size()-1;	// 최대값을 do while문 안으로 넣어 변경되게 수정
			System.out.println(quizList);
			int r1 = (int)(Math.random()*(max1-min1+1)+min1);
			int r2 = quizList.remove(r1);
			List<Means> answer= wordList.get(r2).getMean();
			String quiz = wordList.get(r2).getWord();
			System.out.println("문제 : "+quiz);
			System.out.print("뜻을 입력하세요 : ");
			user = scan.next();
			Means tmpMean = new Means("", user);
			if (answer.contains(tmpMean)) {
				System.out.println("정답입니다.");
			}else {
				System.out.println("틀렸습니다.");
				Word tmp = new Word(user,answer);
				failList.add(tmp);
			}
			
		}while(!user.equals("종료"));
	}

}
