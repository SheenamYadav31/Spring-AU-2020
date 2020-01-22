package src.springau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springau.main.Employee;
import com.springau.model.ID;
import com.springau.model.Person;

@Configuration
@ComponentScan(basePackages = "com.*")
public class AppConfig {
	
	@Bean(name = "employee")
	public Employee getEmployee() {
		ID id = getID();
		Person p = getPerson();
		return(new Employee(id,p));
	}
	
	private ID getID(){
		ID newID = new ID();
		newID.setId(30);
		return newID;
	}
	
	private Person getPerson() {
		Person p =new Person();
		p.setName("NewName");
		p.setPhone(555555);
		p.setCity("CITY");
		return p;
	}
}
