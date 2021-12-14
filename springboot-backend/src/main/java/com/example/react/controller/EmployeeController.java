package com.example.react.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.example.react.exception.ResourceNotFoundException;
import com.example.react.model.Employee;
import com.example.react.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepo.save(employee);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		Employee employee = employeeRepo.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id" + id));
		return ResponseEntity.ok(employee);
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id, @RequestBody Employee employeeDetails){
		Employee employee = employeeRepo.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		Employee updateEmployee = employeeRepo.save(employee);
		
		return ResponseEntity.ok(updateEmployee);
		
	}
}
