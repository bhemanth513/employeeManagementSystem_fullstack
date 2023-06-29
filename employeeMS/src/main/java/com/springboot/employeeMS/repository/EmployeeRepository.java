package com.springboot.employeeMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.employeeMS.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
