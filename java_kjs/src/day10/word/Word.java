package day10.word;

public class Word {
	private int num = 0; // 한 단어의 뜻 개수
	private String word;
	private String mean;
	
	// getter setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	
	// 단어 출력
	public void print() {
		System.out.println(word + " : " + mean);
	}
	
	// 주어진 단어와 내 단어가 같은지 비교
	public boolean equals(String word) {
		return this.word.equals(word);
	}
	
	
	
	// 생성자
	public Word(String word , String mean) {
		this.word = word;
		this.mean = mean;
	}
	
}
