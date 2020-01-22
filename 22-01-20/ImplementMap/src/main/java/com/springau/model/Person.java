package com.springau.model;

public class Person {
	
	private String name;
	private int phone;
	private String city;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Name: "+this.name+" ,City: "+this.city+" ,Phone: "+this.phone;
	}
}
