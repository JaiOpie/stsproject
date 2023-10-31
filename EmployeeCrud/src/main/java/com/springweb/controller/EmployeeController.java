package com.springweb.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springweb.model.Employee;
import com.springweb.repository.EmployeeRepo;
import com.springweb.services.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/empdata")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmployeeRepo employeeRepo;
	//to create employee details
	@PostMapping("/create")
	Employee createEmployee(@RequestBody Employee employee)
	{
		return employeeService.createEmployee(employee);
	}
	//to get all the employee details
	@GetMapping("/getall")
	public List<Employee> getAllEmployees()
	{
		List<Employee> empList = employeeService.getAllEmployee();
		if(empList !=null && !empList.isEmpty())
		{
			return empList;
		}
		else
		{
			return Collections.emptyList();
		}
	}
	//to detail the employee details
	@DeleteMapping("/delete")
	public String delete(@RequestParam("id") int id)
	{
		employeeService.deleteEmployee(id);
		return "ok";
	}

	//to get the employee details
	@GetMapping("/get")
	public Optional<Employee> getEmployee(@RequestParam("id") int id)
	{
		return employeeRepo.findById(id);
	}
	//to update the employee details
	@PutMapping("/update")
	Employee updateEmployee(@RequestParam("id") int id,@RequestBody Employee employee)
	{
		Employee empup = employeeRepo.findById(id).get();
		
		empup.setName(employee.getName());
		empup.setSalary(employee.getSalary());
		return employeeRepo.save(empup);
		
	}
			
}


