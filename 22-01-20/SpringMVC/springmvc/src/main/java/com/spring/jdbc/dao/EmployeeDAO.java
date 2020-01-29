package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.model.Employee;

public interface EmployeeDAO {
	
	public void save(Employee employee);
	
	public List<Employee> getAll();
	
	public Employee getById(int id);
	
	public void update(Employee emp);
	
	public void deleteById(int id);
}
