package com.congthang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.congthang.entity.Employee;
import com.congthang.repository.EmployeeRepository;
import com.congthang.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> listAllUsers() {
		List<Employee> list = employeeService.findAll();
		if (list.isEmpty()) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/{empNo}", //
			method = RequestMethod.GET)

	public Employee getEmployee(@PathVariable("empNo") int empNo) {
		return employeeService.findById(empNo);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteUser(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting User with id " + id);

		Employee employee = employeeService.findById(id);
		if (employee == null) {
			System.out.println("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

		employeeService.delete(id);
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateUser(@PathVariable("id") int id, @RequestBody Employee employee) {
		System.out.println("Updating User " + id);
		
		Employee currentEmployee = employeeService.findById(id);
		
		if (currentEmployee==null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

		currentEmployee.setEmpName(employee.getEmpName());
		currentEmployee.setEmpNo(employee.getEmpNo());
		currentEmployee.setPosition(employee.getPosition());
		
		employeeService.update(currentEmployee);
		return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
	}
}
