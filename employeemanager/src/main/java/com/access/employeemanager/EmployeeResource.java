package com.access.employeemanager;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.access.employeemanager.model.Employee;
import com.access.employeemanager.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EmployeeResource {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmplooyee(){
		List<Employee> employees=employeeService.getallEmployee();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmplooyeeById(@PathVariable("id")Long id){
		Employee employee=employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee newEmployee=employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(newEmployee,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee updateEmployee=employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(updateEmployee,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id")Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	 
	
	
}
 