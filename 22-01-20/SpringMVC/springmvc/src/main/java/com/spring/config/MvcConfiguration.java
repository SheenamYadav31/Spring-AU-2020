package com.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spring.jdbc.dao.EmployeeDAO;
import com.spring.jdbc.dao.EmployeeDAOTemplateImpl;

@Configuration
@ComponentScan(basePackages="net.codejava.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

   @Bean
   public ViewResolver getViewResolver(){
       InternalResourceViewResolver resolver = new InternalResourceViewResolver();
       resolver.setPrefix("/WEB-INF/views/");
       resolver.setSuffix(".jsp");
       return resolver;
   }
    
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
   }

   @Bean
   public DataSource getDataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName("com.mysql.jdbc.Driver");//com.mysql.jdbc.Driver
       dataSource.setUrl("jdbc:mysql://localhost:3306/springmvc?useSSL=false&allowPublicKeyRetrieval=true");
       dataSource.setUsername("root");
       dataSource.setPassword("sheenam");
       System.out.println(dataSource);
       return dataSource;
   }
    
   @Bean
   public EmployeeDAO getEmployeeDAO() {
       return new EmployeeDAOTemplateImpl(getDataSource());
   }
}
