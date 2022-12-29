package edu.kh.collection.model.vo;

public class Client {

	private String name; 
	private int age; 
	private String region; 
	private char gender;
	
	public Client() {}

	public Client(String name, int age, String region, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.region = region;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", age=" + age + ", region=" + region + ", gender=" + gender + "]";
	}
	
}
