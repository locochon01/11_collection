package edu.kh.collection.model.vo;

import java.util.Objects;

public class Member {

	public Member(){}
	
	private String id;
	private String password;
	private int age;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public Member(String id, String password, int age) {
		super();
		this.id = id;
		this.password = password;
		this.age = age;
		
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(id, other.id) && Objects.equals(password, other.password);
	}
	
	
	/*
	// Object.equals() 오버라이딩
	// 현재 객체와 매개변수로 전달 받은 객체의 필드가 같은지 비교하는 형태로 오버라이딩
	
	public boolean equals(Object obj) {
		Member other = (Member)obj; //다운캐스팅
		
		return this.id.equals(other.id) 
				&& this.password.equals(other.password) 
				&& this.age == other.age;
		// alt + shift + s -> generate hashcode and equals 
		 equals hashcode 오버라이딩 필수
	}
	*/
	
	// Object.hasCode() 오버라이딩
}
