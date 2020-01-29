package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.jdbc.dao.EmployeeDAO;
import com.spring.jdbc.dao.EmployeeDAOTemplateImpl;
import com.spring.jdbc.model.Employee;

@Controller
public class MainController {
	
	@Autowired
	private EmployeeDAO empDAO = new EmployeeDAOTemplateImpl();
	//private EmployeeDAOTemplateImpl empDAO;
	
	
	@RequestMapping(value="/home")
	public ModelAndView listEmployees() {
		ModelAndView model = new ModelAndView("home");
		List<Employee> emplist = empDAO.getAll();
		System.out.println(emplist.get(1));
		model.addObject("emplist",emplist);
//		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/employeeForm", method = RequestMethod.GET)
	public ModelAndView newEmployee(Employee emp) {
		ModelAndView model = new ModelAndView();
	    model.setViewName("employeeForm");
	    return model;
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		empDAO.save(employee);
		ModelAndView model = new ModelAndView();
		model.addObject(employee);
	    model.setViewName("employeeForm");
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee() {
		ModelAndView model = new ModelAndView("deleteEmployee");
	    return model;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(int id) {
	    empDAO.deleteById(id);
	    System.out.println(id+"delete is called");
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editForm", method = RequestMethod.GET)
	public ModelAndView editEmployee(Employee employee) {
		ModelAndView model = new ModelAndView("editForm");
		return model;
	}
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute Employee employee) {
		ModelAndView model = new ModelAndView("editForm");
		empDAO.update(employee);
		model.addObject(employee);
		return new ModelAndView("redirect:/");
	}

}

