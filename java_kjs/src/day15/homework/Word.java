package day15.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
// 단어 클래스
public class Word {
	// 단어
	String word;			
	// 뜻과 품사를 포함한 리스트
	List<Means> mean = new ArrayList<Means>();
	
	
	// 단어 출력
	public void printWord() {
		System.out.print(word + " : ");
		for(int i = 0 ; i < mean.size(); i++ ) {
			System.out.print((i+1) + ". ");
			mean.get(i).printMean();
			if((i+ 1) != mean.size()) {
				System.out.print(" / ");
			}
			else {
				System.out.println();
			}
		}
	}
	
	
	// 생성자
	public Word(String word) {
		this.word = word;
	}

	// equals 와 hashCode
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}

	@Override
	public int hashCode() {
		return Objects.hash(word);
	}
	
	
	
}


// 뜻 클래스
class Means{
	
	String mean;	// 뜻 의미
	String wordClass; 	// 뜻에 따른 품사
	
	// 뜻 출력
	public void printMean() {
		System.out.print("("+wordClass + ") " + mean); 
	}

	// 생성자
	public Means(String wordClass, String mean) {
		this.wordClass = wordClass;
		this.mean = mean;
	}

	
	//  equals 와 hashCode
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Means other = (Means) obj;
		return Objects.equals(mean, other.mean);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(mean);
	}


	
	
	
}