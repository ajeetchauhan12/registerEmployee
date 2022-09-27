package com.practice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Employee;
import com.practice.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
EmployeeRepository emRepository;

	public Employee createEmployee(Employee emp) {
		return emRepository.save(emp);
	}
	
	public List<Employee> listAllEmployees(){
		return emRepository.findAll();
	}
	
	public void deleteEmployeeById(int id) {
	emRepository.deleteById(id);
	}
	
	public Employee updateEmployee(Employee emp) {
		if(emRepository.findById(emp.getId()).isPresent()) {
			Employee newEmployee=emRepository.findById(emp.getId()).get();
			newEmployee.setName(emp.getName());
			newEmployee.setAge(emp.getAge());
		return	emRepository.save(newEmployee);
		}
		else
		{
			return null;
		}
		
	}
}
