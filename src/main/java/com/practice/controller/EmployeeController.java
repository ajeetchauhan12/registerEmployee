package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Employee;
import com.practice.services.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	EmployeeService emService;

	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee emp) {
		return emService.createEmployee(emp);
	}
	@GetMapping("/getAllEmployees")
	public List<Employee> listAllEmployees(){
		return emService.listAllEmployees();
	} 
	@DeleteMapping("/deleteById/{id}")
	public void deleteEmployeeById(@PathVariable("id") int id ) {
		emService.deleteEmployeeById(id);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return emService.updateEmployee(emp);
	}
	
}
