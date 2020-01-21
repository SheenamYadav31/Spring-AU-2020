package com.example.demo;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;

import java.util.*;

@Path("/apis")
public class newClass {
	
	public static final List<Employee> employee = new ArrayList<Employee>();
	
//	employee.add(new Employee(10,"Sheenam",23,"Computer"));
//	employee.add(new Employee(20,"Peacock",100,"Jungle"));
	
	//-------------------------Simply getting all current employee--------------------
	// http://localhost:9001/apis
	@GET
	@Produces("application/json")
	public List<Employee> getAllUsers() {
		
		employee.add(new Employee(10,"Sheenam",23,"Computer"));
		employee.add(new Employee(20,"Peacock",100,"Jungle"));

		return employee;
	}
	
	//----------------------------Adding New employee using '@Path'--------------------------
	// http://localhost:9001/apis/setNewUser
	// sample object -> {
//							"id": 30,
//							"name": "Accolite",
//							"age": 100,
//							"department": "Server"
//						}
	@POST
	@Path("/setNewUser")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Employee> setNewUser(Employee new_emp) {
		employee.add(new_emp);
		return employee;
	}
	
	//---------------------- Deleting the first element with the given id in employee list(array)--------
	// ---assuming we have unique employee names, if multiple same  names exist it will delete the first match.
	// http://localhost:9001/apis/deleteOne
	// sample input -> 30
	
	@DELETE
	@Path("/deleteOne")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Employee> DeleteOne(int id){
		Employee temp = new Employee();
		for(Employee e : employee) {
			if(e.id == id) {
				temp = e;
				employee.remove(e);
				return employee;
			}
		}
		return employee;  //employee with given ID is not found and hence not deleted.
	}
	
	//----------------------FINDING THE EMPLOYEE NAME using the input_str parameter which is passed in url ('@Path')--------
	// ---assuming we have unique employee names, if multiple same  names exist it will return the first match.
	
	// http://localhost:9001/apis/FindEmployee/Peacock
	@PUT
	@Path("/FindEmployee/{input_str}")
	@Produces("application/json")
	//@Consumes("application/json")
	public String FindEmployee(@PathParam("input_str") String input_str){
		Employee temp = new Employee();
		for(Employee e: employee) {
			if(e.name.equals(input_str)) {
				e.name = input_str;
				temp=e;
			}
		}
		if(temp.id==0) {
			return "Employe not Found";
		}
		else return "Employee Found :"+ temp;
	}
}
