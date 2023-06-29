package com.springboot.employeeMS.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeeMS.model.Employee;
import com.springboot.employeeMS.repository.EmployeeRepository;
import com.springboot.employeeMS.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	public EmployeeRepository employeeRepo;
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeRepo.findAll();
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employeeDto){
			return new  ResponseEntity<>(empService.createEmployee(employeeDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/employees/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long empId) throws Exception {
		return new ResponseEntity<>(empService.getEmployee(empId),HttpStatus.OK);
	}
	
	@PutMapping("/employees/{empId}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employeeDto, @PathVariable Long empId) throws Exception {
		return new ResponseEntity<>(empService.updateEmployee(employeeDto, empId),HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long empId) throws Exception {
		empService.deleteById(empId);
		Map<String,Boolean> map = new HashMap<>();
		map.put("deleted", Boolean.TRUE);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
