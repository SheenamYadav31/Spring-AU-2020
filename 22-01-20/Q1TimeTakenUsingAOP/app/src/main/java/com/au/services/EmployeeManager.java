package com.au.services;

import java.util.*;

import com.au.models.Employee;

public class EmployeeManager {
	
	private static List<Employee> empList = new ArrayList<Employee>();
	
	public Employee getEmployeeById(Integer employeeId) {
		System.out.println("Method getEmployeeById called");
		for(Employee e: empList) {
			if(e.getEmpId() == employeeId) return e;
		}
		return null;
	}
	
	public List<Employee> getAllEmployee(){
		return this.empList;
	}
	
	public void createEmployee(Employee employee)
	{
		System.out.println("Method CreateEmployee() called");
		this.empList.add(employee);
	}
}
