package com.springboot.employeeMS.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.employeeMS.dto.EmployeeDto;
import com.springboot.employeeMS.exception.ResourceNotFoundException;
import com.springboot.employeeMS.model.Employee;
import com.springboot.employeeMS.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee getEmployee(long id) throws Exception {
		Employee emp = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee not found with id: "+id));
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee emp = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee not found with id: "+id));
		emp.setEmailId(employee.getEmailId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		return employeeRepository.save(emp);
		
	}

	@Override
	public void deleteById(long id) {
		Employee emp = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee not found with id: "+id));
		employeeRepository.delete(emp);
	}
	
}
