package com.congthang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congthang.entity.Employee;
import com.congthang.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	public Employee findById(int id) {
		return employeeRepository.findById(id);
	}
	public void update(Employee employee) {
		employeeRepository.update(employee);
	}
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	public void delete(int id) {
		employeeRepository.delete(id);
	}
}
