package day15.homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class WordManager implements Serializable{
	private static final long serialVersionUID = -4046937641465220290L;
	List<Word> wordList = new ArrayList<Word>();
	List<Word> failList = new ArrayList<Word>();
	
	
	
	// 사전식 정렬 메서드
	public void sortWordList() {
		wordList.sort((w1,w2) -> {
			return w1.getWord().compareTo(w2.getWord());
		});
	}
	// 단어별 품사 정렬 메서드
	public void sortMean() {
		wordList.stream().forEach(w->{
			w.getMean().sort((m1,m2) -> {
				return m1.getWordClass().compareTo(m2.getWordClass());
			});
		});
	}
	// 오답노트 정렬 메서드
	public void sortFailList() {
		failList.sort((w1,w2) -> {
			return w1.getWord().compareTo(w2.getWord());
		});
	}
	
	
	
	
	// 단어 추가 메서드 
	public boolean insert(String word,String mean, String wordClass) {
		Word tmpWord = new Word(word);
		if(wordList.contains(tmpWord)) {
			return false;
		}
		Means tmpMean = new Means(wordClass, mean);
		tmpWord.mean.add(tmpMean);
		wordList.add(tmpWord);
		sortWordList();
		return true;
	}
	
	// 단어 수정 메서드 // 바꿀 단어를 다시 입력받아야 해서 비효율적
	/*
	public boolean update(String word) {
		Word tmpWord = new Word(word);
		if(!wordList.contains(tmpWord)) {
			return false;
		}
		return true;
	}
	*/
	
	// 단어 삭제 메서드
	public boolean delete(String word) {
		Word tmpWord = new Word(word);
		if(wordList.contains(tmpWord)) {
			wordList.remove(tmpWord);
			return true;
		}
		return false;
	}
	
}
