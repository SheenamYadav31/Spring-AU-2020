package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.model.Employee;

public class EmployeeDAOTemplateImpl implements EmployeeDAO {
	
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	
	public static final RowMapper<Employee> myRowMapperLambda = (rs, rownum) -> {
		Employee emp = new Employee();
		emp.setId(rs.getInt("id"));
		emp.setFname(rs.getString("fname"));
		emp.setLname(rs.getString("lname"));
		emp.setRole(rs.getString("role"));
		return emp;
	};

	
	public EmployeeDAOTemplateImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public EmployeeDAOTemplateImpl()
	{
		
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Employee employee) {
		String query = "insert into employee (id, fname, lname, role) values (?,?,?,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		int out = jdbcTemplate.update(query, employee.getId(), employee.getFname(), employee.getLname(), employee.getRole());
		
		if(out !=0){
			System.out.println("Employee saved with id="+employee.getId());
		}else System.out.println("Employee save failed with id="+employee.getId());
	}
	

	@Override
	public Employee getById(int id) {
		String query = "select id, fname, lname, role from employee where id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Employee emp;
		//using RowMapper anonymous class, we can create a separate RowMapper for reuse
		try {
			emp = jdbcTemplate.queryForObject(query,myRowMapperLambda);
			
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
		return emp;
	}
	
	@Override
	public List<Employee> getAll() {
		String query = "select id, fname, lname, role from employee";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> empList = new ArrayList<Employee>();
		empList = jdbcTemplate.query(query, myRowMapperLambda);
		return empList;
	}

	@Override
	public void update(Employee employee) {
		String query = "update employee set fname=?, lname=?, role=? where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		int out = jdbcTemplate.update(query, employee.getFname(), employee.getLname(), employee.getRole(), employee.getId());
		if(out !=0){
			System.out.println("Employee updated with id="+employee.getId());
		}else System.out.println("No Employee found with id="+employee.getId());
	}

	@Override
	public void deleteById(int id) {
		System.out.println(" Delete is called ");
		String query = "delete from employee where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int out = jdbcTemplate.update(query, id);
		
		if(out !=0){
			System.out.println("Employee deleted with id="+id);
		}else System.out.println("No Employee found with id="+id);
	}

}
