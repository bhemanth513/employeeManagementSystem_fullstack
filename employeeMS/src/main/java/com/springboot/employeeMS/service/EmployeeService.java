package com.springboot.employeeMS.service;

import com.springboot.employeeMS.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);
	Employee getEmployee(long id) throws Exception;
	Employee updateEmployee(Employee employee,long id);
	void deleteById(long id);
}
