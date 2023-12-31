package day15.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;


@Data
public class Word {
	// 내부 클래스 뜻
	
	
	// 단어
	String word;			
	// 뜻 리스트
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



class Means{
	
	String wordClass; 	// 뜻에 따른 품사
	String mean;	// 뜻 의미
	
	// 뜻 출력
	public void printMean() {
		System.out.print("("+wordClass + ") " + mean); 
	}

	// 생성자
	public Means(String wordClass, String mean) {
		this.wordClass = wordClass;
		this.mean = mean;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mean);
	}

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

	
	
	
}