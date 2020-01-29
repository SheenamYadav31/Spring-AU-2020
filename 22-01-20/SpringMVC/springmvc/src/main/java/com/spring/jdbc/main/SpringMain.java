package com.spring.jdbc.main;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.EmployeeDAO;
import com.spring.jdbc.model.Employee;

public class SpringMain {
	
	public static void main(String[] args) {
		
		//Get the Spring Context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		//Get the EmployeeDAO Bean
		EmployeeDAO employeeDAO = context.getBean("employeeDAO", EmployeeDAO.class);
		
		//JDBC CRUD operations
		Employee emp = new Employee();
		emp.setId(8);
		emp.setFname("Chandan");
		emp.setLname("Yadav");
		emp.setRole("Developer Intern");
		
		
		employeeDAO.save(emp);
		
		System.out.println("GET EMP BY ID:");
		Employee emp1 = employeeDAO.getById(10);
		System.out.println("Employee Retrieved::"+emp1);
		
		System.out.println("UPDATE EMP BY ID:");
		emp.setRole("CEO");
		employeeDAO.update(emp);
		
		System.out.println("GET ALL EMPLOYEES:");
		List<Employee> empList = employeeDAO.getAll();
		System.out.println(empList);
		
		System.out.println("DELETE EMP BY ID:");
		employeeDAO.deleteById(2);
		
		//Close Spring Context
		context.close();
		
		System.out.println("DONE");

	}
}
