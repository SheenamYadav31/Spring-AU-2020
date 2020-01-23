package com.au.models;

public class Employee {
	private Integer empId;
	private String employeeName;
	private String pos;
	
	public Employee(Integer id, String name, String pos) {
		this.empId = id;
		this.employeeName = name;
		this.pos = pos;
	}
	
	public Integer getEmpId() {
		return this.empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPos() {
		return pos;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", employeeName=" + employeeName + ", pos=" + pos + "]";
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

}
