package com.springau.main;

import java.util.*;
import com.springau.model.ID;
import com.springau.model.Person;

import src.springau.config.AppConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employee {
	
	private ID id;
	private Person p;
	
	private static Map<ID, Person> empMap = new HashMap<ID, Person>();
	
	public Employee(ID id, Person p) {
		this.id=id;
		this.p=p;
		empMap.put(id, p);
	}
	
	public Map<ID, Person> getAllEmployees(){
		return this.empMap;
	}
	
	public static void main(String[] args) {
		
		//---------------------------METHOD 1----------------------------------------
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		Person p1  = (Person) context.getBean("person1");
		Person p2  = (Person) context.getBean("person2");
		Person p3  = (Person) context.getBean("person3");
		
		System.out.println("----------------PERSONS-----------------");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		Employee e1 = (Employee) context.getBean("e1");
		Employee e2 = (Employee) context.getBean("e2");
		Employee e3 = (Employee) context.getBean("e3");
		
		Map<ID, Person> temp = e3.getAllEmployees();
		System.out.println("----------------EMPLOYEES-----------------");
		for(Map.Entry<ID, Person> i: temp.entrySet()) {
			System.out.println("Emp Id: "+i.getKey()+" ,Emp Details: "+i.getValue());
		}
		
		//---------------------------METHOD 2-------------------------------
		
//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		
//		Employee e = context.getBean(Employee.class);
//		System.out.println("Emp Id: "+e.id+" ,Emp Details: "+e.p);
		
	}

}
