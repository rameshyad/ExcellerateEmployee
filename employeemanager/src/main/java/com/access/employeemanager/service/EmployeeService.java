package com.access.employeemanager.service;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;

import com.access.employeemanager.exception.UserNotFoundException;
import com.access.employeemanager.model.Employee;
import com.access.employeemanager.repo.EmployeeRepo;

public class EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);	
	}
	public List<Employee> getallEmployee(){
		return employeeRepo.findAll();
	}
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(()-> new UserNotFoundException("User by id" + id+ "was not found")  );
	}
	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}
	
}
