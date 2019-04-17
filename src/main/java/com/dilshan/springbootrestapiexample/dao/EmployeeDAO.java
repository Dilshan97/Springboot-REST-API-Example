package com.dilshan.springbootrestapiexample.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.dilshan.springbootrestapiexample.model.Employee;
import com.dilshan.springbootrestapiexample.repository.EmployeeRepository;

@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);	
	}
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	public Employee findOne(Long empId) {
		Optional<Employee> op = employeeRepository.findById(empId);
		
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}
	
}
