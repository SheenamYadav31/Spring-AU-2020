package com.au.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.au.models.Employee;
import com.au.services.EmployeeManager;

/**
 * Hello world!
 *
 */
@ComponentScan(basePackages = "com.au")
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello from Sheenam!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //EmployeeManager manager = (EmployeeManager)context.getBean("EmployeeManager");
        EmployeeManager manager = context.getBean(EmployeeManager.class);
        
        manager.createEmployee(new Employee(1,"Sheenam","SDE"));
        manager.createEmployee(new Employee(2,"Sheenam Yadav","AU Student"));
        manager.createEmployee(new Employee(3,"Peacock","Developer"));
        
        System.out.println(manager.getEmployeeById(3));
        
        manager.getAllEmployee();
        
       
    }
}
