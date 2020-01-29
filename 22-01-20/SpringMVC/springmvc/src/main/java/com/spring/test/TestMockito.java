package com.spring.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.spring.jdbc.dao.EmployeeDAO;
import com.spring.jdbc.model.Employee;

public class TestMockito {
	
	@Test
	public void testId() throws ClassNotFoundException {
		EmployeeDAO employeeDAO = mock(EmployeeDAO.class);
		Employee  employee=new Employee();
		employee.setId(1);
		employee.setFname("sheenam");
		employee.setLname("Yadav");
		employee.setRole("Developer Intern");
		
		when(employeeDAO.getById(1)).thenReturn(employee);
		
		System.out.println(employeeDAO.getById(1));
		assertEquals(1, employeeDAO.getById(1).getId());
		
	}
	
	@Test
	public void testRole() throws ClassNotFoundException, NoSuchFieldException, SecurityException{
		
		EmployeeDAO employeeDAO = mock(EmployeeDAO.class);
		Employee  employee=new Employee();
		employee.setId(1);
		employee.setFname("sheenam");
		employee.setLname("Yadav");
		employee.setRole("Developer Intern");
		
		when(employeeDAO.getById(1)).thenReturn(employee);
		
		assertEquals("Developer Intern", employeeDAO.getById(1).getRole());
	}
}
