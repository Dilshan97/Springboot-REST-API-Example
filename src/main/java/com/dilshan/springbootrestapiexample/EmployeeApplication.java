package com.dilshan.springbootrestapiexample;

import java.util.ArrayList; import java.util.List; 

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.dilshan.springbootrestapiexample.controller.EmployeeController; 
import com.dilshan.springbootrestapiexample.dao.EmployeeDAO; 
import com.dilshan.springbootrestapiexample.model.Employee; 

@SpringBootApplication 
@EnableJpaAuditing 
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args); 
	}

}
