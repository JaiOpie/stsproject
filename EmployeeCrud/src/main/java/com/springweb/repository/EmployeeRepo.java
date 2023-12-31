package com.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springweb.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	
	
}
