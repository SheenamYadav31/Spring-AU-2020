package com.example.demo;

public class Employee {
	
	public int id;
	public String name;
	public int age;
	public String department;
	
	public Employee() {
		this.id=0;
	}
	
	public Employee(int id, String name, int age, String dept) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = dept;
	}
	
	@Override
	public String toString() {
		return "Employee: ID "+this.id+ "; Name: "+this.name+"; Age:"+this.age+";  Department: "+this.department;
	}
}
