package day11.homework;

import java.util.Scanner;

public class Homework3 {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 사이트에서 회원 관리(로그인, 회원가입 등)를 위한 Member 클래스를 작성하라.
		
		// 작성한 Member 클래스를 이용하여 인스턴스를 생성하고 구현힌 메서드를 테스트해보아라.
		Member mem1 = new Member();
		mem1.print();
		System.out.println(mem1.equals("abc", "def"));
		Member mem2 = new Member("abc", "def" , "abc@naver.com");
		mem2.print();
		System.out.println(mem2.equals("abc", "def"));
	}

}



class Member{
	// 필요한 멤버변수 및 메서드를 정리하고 구현하라.
	private String email;
	private String name;
	private int birthDate;
	private int socialID;
	private String address;
	private String id;
	private String password;
	private String nickname;
	
	
	
	// getter setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}
	public int getSocialID() {
		return socialID;
	}
	public void setSocialID(int socialID) {
		this.socialID = socialID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	// equals 
	public boolean equals(String id, String password) {
		if(this.id == null) {
			return false;
		}
		if(this.password == null) {
			return false;
		}
		if(this.id.equals(id) && this.password.equals(password)) {
			return true;
		}
		return false;
	}
	// 회원 정보를 출력하는 메서드
	public void print() {
		System.out.println("아이디 : " + id);
		System.out.println("이메일 : " + email);
		System.out.println("비밀번호 : " + password);
	}
	
	// 기본생성자 
	public Member() { }
	
	public Member(String id, String password, String email) {
		this.email = email;
		this.id = id;
		this.password = password;
	}
	
	public Member(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	
	// 회원가입
}