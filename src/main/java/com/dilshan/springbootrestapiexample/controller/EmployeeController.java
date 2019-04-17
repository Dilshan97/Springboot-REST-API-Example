package com.dilshan.springbootrestapiexample.controller;

import java.util.List; 
import javax.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.dilshan.springbootrestapiexample.dao.EmployeeDAO;
import com.dilshan.springbootrestapiexample.model.Employee; 

@RestController 
@RequestMapping("/company") 
public class EmployeeController {    
	
	@Autowired  
	EmployeeDAO employeeDAO; 
 
 /* SAVE AN EMPLOYEE */  
	@PostMapping("/employees")  
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDAO.save(emp);  
	}    
	
	/* GET ALL EMPLOYEES*/  
	@GetMapping("/employees")  
	public List<Employee> getAllEmployees(){   
		return employeeDAO.findAll();  
	}    
	
	/* GET EMPLOYEE BY ID */  
	@GetMapping("/employees/{id}")  
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empId){
		Employee emp = employeeDAO.findOne(empId);      
		
		if(emp==null) {    
			return ResponseEntity.notFound().build();
		}   
		return ResponseEntity.ok().body(emp);
	}   
  
	/* UPDATE AN EMPLOYEE BY ID */  
	@PutMapping("/employees/{id}")  
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empId, @Valid @RequestBody Employee empDetails){      
		Employee emp=employeeDAO.findOne(empId);      
		
		if(emp==null) {    
			return ResponseEntity.notFound().build();   
		}   
		emp.setName(empDetails.getName());   
		emp.setDesignation(empDetails.getDesignation());   
		emp.setExpertise(empDetails.getExpertise());      
		
		Employee updaEmployee=employeeDAO.save(emp);      
		
		return ResponseEntity.ok().body(updaEmployee);  
	}    
	
	/*DELETE AN EMPLOYEE*/  
	@DeleteMapping("/employees/{id}")  
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empId){   
		Employee emp = employeeDAO.findOne(empId);   
		
		if(emp==null) {    
			return ResponseEntity.notFound().build();   
		}   
		
		employeeDAO.delete(emp);   
		return ResponseEntity.ok().build();   
		}
	} 
