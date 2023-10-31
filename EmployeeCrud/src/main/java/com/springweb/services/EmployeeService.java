package com.springweb.services;

import java.util.List;
import java.util.Optional;

import com.springweb.model.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Optional<Employee> getEmployee(int id);
	Employee updateEmployee(int id,Employee employee);
	void deleteEmployee(int id);
}
