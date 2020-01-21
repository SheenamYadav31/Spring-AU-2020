package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


/*

@Path("/apis")
class classA{
	@Path("/users")
	class classB
	{
		@POST
		@PATH("/create")
		@Proceduces("application/json")
		public method1(){}
		
		@POST
		@PATH("/delete")
		@Proceduces("application/json")
		public method1(){}
	}
}

ANOTHER METHOD

@Path("/apis/users")
class classA{
	
		@POST
		@PATH("/create")
		@Proceduces("application/json")
		public method1(){}
		
		@POST
		@PATH("/delete")
		@Proceduces("application/json")
		public method1(){}
}


*/