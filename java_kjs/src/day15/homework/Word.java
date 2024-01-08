package day15.homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
// 단어 클래스
public class Word implements Serializable{
	private static final long serialVersionUID = -2534152854795595317L;
	
	// 단어
	private String word;			
	// 뜻과 품사를 포함한 리스트
	List<Means> mean = new ArrayList<Means>();
	
	
	// 뜻 수정, 삭제시 뜻마다 번호를 함께 출력
	public void printWordNum() {
		System.out.print(word + " : ");
		for(int i = 0 ; i < mean.size(); i++ ) {
			System.out.print((i+1) + ". ");
			System.out.print(mean.get(i).toString()); 			
			if((i+ 1) != mean.size()) {
				System.out.print(" / ");
			}
			else {
				System.out.println();
			}
		}
	}
	
	// 단어 출력
	public void printW() {
		System.out.print(word + " : ");
		for(int i = 0 ; i < mean.size(); i++ ) {
			if(i!=0 && mean.get(i).getWordClass().equals(mean.get(i-1).getWordClass())) {
				System.out.print(", "+mean.get(i).getMean());
			}
			else if(i!=0 && !mean.get(i).getWordClass().equals(mean.get(i-1).getWordClass())) {
				System.out.print("/ "+"("+ mean.get(i).getWordClass() +") " +mean.get(i).getMean());
			}
			else {
				System.out.print(mean.get(i).toString()); 
			}
			if((i+ 1) == mean.size()) {
				System.out.println();
			}
		}
	}
	
	
	
	
	// 생성자
	public Word(String word) {
		this.word = word;
	}
	
	
	// toString
	@Override
	public String toString() {
		return word +" " +mean.toString() ;
	}
	

	// equals와 hashCode
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

		
		

@Data
// 뜻 클래스
class Means implements Serializable{
	private static final long serialVersionUID = 2274509388447823350L;
	
	private String mean;	// 뜻 의미
	private String wordClass; 	// 뜻에 따른 품사
	

	// 생성자
	public Means(String wordClass, String mean) {
		this.wordClass = wordClass;
		this.mean = mean;
	}

	// toString (람다식 대비)
	@Override
	public String toString() {
		return "("+ wordClass + ") " + mean;
	}
	
	
	
	
	//  equals와 hashCode
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