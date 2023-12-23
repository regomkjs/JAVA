package day11.homework;

import java.util.Scanner;

public class Homework3 {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 사이트에서 회원 관리(로그인, 회원가입 등)를 위한 Member 클래스를 작성하라.
		
		// 작성한 Member 클래스를 이용하여 인스턴스를 생성하고 구현힌 메서드를 테스트해보아라.
		
		
	}

}



class Member{
	// 필요한 멤버변수 및 메서드를 정리하고 구현하라.
	private static int memberCount = 0;
	private String name;
	private int birthDate;
	private int socialID;
	private String address;
	private String id;
	private String password;
	private String nickname;
	
	
	
	// getter setter
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
	
	
	// 회원가입
}